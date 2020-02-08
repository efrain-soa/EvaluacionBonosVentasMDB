package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Component;



@Component
@SuppressWarnings("unchecked")
public class UtilEAI {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@SuppressWarnings("rawtypes")
	private static HashMap<Class, JAXBContext> objMapaContexto = new HashMap<Class, JAXBContext>();

	public Object deserializeBytes(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bytesIn = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bytesIn);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	public static byte[] serializeObject(Object obj) throws IOException {
		ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bytesOut);
		oos.writeObject(obj);
		oos.flush();
		byte[] bytes = bytesOut.toByteArray();
		bytesOut.close();
		oos.close();
		return bytes;

	}

	/**
	 * getJAXBContextFromClass
	 * 
	 * @param objClase
	 * @return JAXBContext
	 */
	@SuppressWarnings("rawtypes")
	private JAXBContext obtenerContextoJaxBFromClass(String mensajeTransaccion, Class objClase) {

		JAXBContext objContexto = null;
		objContexto = objMapaContexto.get(objClase);

		if (objContexto == null) {
			try {
				this.logger.info(mensajeTransaccion + "INICIALIZANDO: [JaxContext...]");

				objContexto = JAXBContext.newInstance(objClase);
				objMapaContexto.put(objClase, objContexto);
			} catch (Exception e) {
				this.logger.error(mensajeTransaccion + "ERROR creando 'JAXBContext': ", e);
			}
		}

		return objContexto;
	}

	/**
	 * transformarXmlTextFromJaxB
	 * 
	 * @param mensajeTransaccion
	 * @param objJaxB
	 * @return String
	 */
	public String transformarXmlTextFromJaxB(String mensajeTransaccion, Object objJaxB) {

		String commandoRequestEnXml = null;
		JAXBContext objContexto = null;
		XmlObject objXML = null;

		try {
			objContexto = this.obtenerContextoJaxBFromClass(mensajeTransaccion, objJaxB.getClass());

			Marshaller objMarshaller = objContexto.createMarshaller();
			StringWriter objStringWritter = new StringWriter();

			objMarshaller.marshal(objJaxB, objStringWritter);

			objXML = XmlObject.Factory.parse(objStringWritter.toString());
			commandoRequestEnXml = objXML.toString();
		} catch (Exception e) {
			this.logger.error(mensajeTransaccion + "ERROR parseando object to 'XML': ", e);
		}

		return commandoRequestEnXml;
	}

	/**
	 * transfromarAnyObjectToXmlText
	 * 
	 * @param objJaxB
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public String transformarAnyObjectToXmlText(String mensajeTransaccion, Object objJaxB) {

		String commandoRequestEnXml = null;
		JAXBContext objContexto = null;
		XmlObject objXML = null;

		try {
			objContexto = this.obtenerContextoJaxBFromClass(mensajeTransaccion, objJaxB.getClass());

			Marshaller objMarshaller = objContexto.createMarshaller();
			StringWriter objStringWritter = new StringWriter();

			objMarshaller.marshal(
					new JAXBElement(new QName("", objJaxB.getClass().getName()), objJaxB.getClass(), objJaxB),
					objStringWritter);
			objXML = XmlObject.Factory.parse(objStringWritter.toString());

			commandoRequestEnXml = objXML.toString();
		} catch (Exception e) {
			this.logger.error(mensajeTransaccion + " ERROR parseando object to 'XML': ", e);
		}

		return commandoRequestEnXml;
	}

	/**
	 * EndpointURL
	 * 
	 * @param objBinding
	 * @return String
	 */
	public String getEndpointURL(Object objBinding) {
		Map<String, Object> contextoRequest = ((javax.xml.ws.BindingProvider) objBinding).getRequestContext();
		return (String) contextoRequest.get(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
	}

	/**
	 * setEndpointURL
	 * 
	 * @param URL
	 * @param objBinding
	 * @return String
	 */
	public String setEndpointURL(String URL, Object objBinding) {
		Map<String, Object> contextoRequest = ((javax.xml.ws.BindingProvider) objBinding).getRequestContext();
		return (String) contextoRequest.put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL);
	}

	/**
	 * validaUrl valida la existencia de la 'URL'.
	 * 
	 * @param mensajeTransaccion
	 * @param cadenaUrl
	 */
	public int validaUrl(String mensajeTransaccion, String cadenaUrl) {

		int respuestaURL = 0;

		URL url = null;
		URLConnection urlConexion = null;

		try {
			url = new URL(cadenaUrl);
			urlConexion = url.openConnection();

			urlConexion.setReadTimeout(2000); // 2 SEGUNDOS ...

			urlConexion.setDoOutput(true);
			urlConexion.setDoInput(true);

			if (urlConexion instanceof HttpURLConnection) {

				this.logger.info(mensajeTransaccion + "");
				this.logger.info(mensajeTransaccion + "====> URL:            " + urlConexion.getURL());
				this.logger.info(mensajeTransaccion + "====> TIPO CONTENIDO: " + urlConexion.getContentType());
				this.logger.info(mensajeTransaccion + "");

				HttpURLConnection httpConexion = (HttpURLConnection) urlConexion;
				httpConexion.setReadTimeout(2000); // 2 SEGUNDOS ...
				httpConexion.connect();

				respuestaURL = httpConexion.getResponseCode(); // 200 = OK
				this.logger.info(mensajeTransaccion + "Respuesta 'URL': [" + respuestaURL + "]");

				if (respuestaURL == 200) {
					this.logger.info(mensajeTransaccion + "Conexion Exitosa con la 'URL': [" + url + "]");
					this.logger.info(mensajeTransaccion + urlConexion.getInputStream() + "");
				}
			}
		} catch (Exception e) {
			this.logger.error(mensajeTransaccion + "ERROR 'Exception': " + e.getMessage());
		}

		return respuestaURL;
	}

	public static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	public static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {

		MessageFactory factory = MessageFactory.newInstance();

		MimeHeaders hd = new MimeHeaders();
		hd.addHeader("Content-Type", "text/xml;charset=UTF-8");

		SOAPMessage message = factory.createMessage(hd,
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF8"))));

		return message;
	}

	public static BigDecimal getBigDecimalToString(String strDecimal) {
		try {
			BigDecimal bigDecimal = new BigDecimal(strDecimal);
			return bigDecimal;
		} catch (Exception e) {
			return new BigDecimal(0);
		}
	}

	public static int getIntegerToString(String strInteger) {
		try {
			Integer integer = Integer.parseInt(strInteger);
			return integer;
			
			
		} catch (Exception e) {
			return new Integer(0);
		}
	}
	
//	public static String retornarPrefijo51(String strTelefono){
//		String fija = "";
//		//51966025699  515110184
//		//USSD HUAWEI//MICLARO
//		try {
//			if(strTelefono.length() <= Constantes.CANTIDAD_FIJO_MOVIL){
//				int intCantidadTotal = strTelefono.length();
//				if(intCantidadTotal <= Constantes.CANTIDAD_FIJO_SIN_51){
//					//TELEFONO EJ: 5110184/510184
//					fija = Constantes.PREFIJO_51.concat(strTelefono);
//				}else{
//					//TELEFONO EJ: 515110184/966025699
//					if(strTelefono.startsWith(Constantes.PREFIJO_51)){
//						fija = strTelefono;
//					}else{
//						fija = Constantes.PREFIJO_51.concat(strTelefono);
//					}
//				}
//			}else{
//				fija = strTelefono;
//			}
//		} catch (Exception e) {
//			return fija;
//		}		
//		return fija;
//	}
	
}

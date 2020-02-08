package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gmendez.
 * @clase: JAXBUtilitarios.java
 * @descripcion Utilitario creado para parsear objetos a XML y viceversa
 *              utilizando la API y los marshallers de JAXB.
 * @author_company: CLARO.
 * @fecha_de_creacion: 01-01-2014.
 * @fecha_de_ultima_actualizacion: 01-01-2014.
 * @version 1.0
 */
public class JAXBUtilitarios {

	private static final Logger wlLogger = LoggerFactory.getLogger(JAXBUtilitarios.class.getName());
	@SuppressWarnings("rawtypes")
	private static HashMap<Class, JAXBContext> mapContexts = new HashMap<Class, JAXBContext>();

	@SuppressWarnings("rawtypes")
	private static JAXBContext obtainJaxBContextFromClass(Class clas) {
		JAXBContext context;
		context = mapContexts.get(clas);
		if (context == null) {
			try {
				wlLogger.info("Inicializando jaxcontext... para la clase " + clas.getName());
				context = JAXBContext.newInstance(clas);
				mapContexts.put(clas, context);
			} catch (Exception e) {
				wlLogger.error("Error creando JAXBContext:", e);
			}
		}
		return context;
	}

	public String getXmlTextFromJaxB(Object objJaxB) {
		String commandoRequestEnXml = null;
		JAXBContext context;
		try {
			context = obtainJaxBContextFromClass(objJaxB.getClass());
			Marshaller marshaller = context.createMarshaller();
			StringWriter xmlWriter = new StringWriter();
			marshaller.marshal(objJaxB, xmlWriter);
			XmlObject xmlObj = XmlObject.Factory.parse(xmlWriter.toString());
			commandoRequestEnXml = xmlObj.toString();
		} catch (Exception e) {
			wlLogger.error("Error parseando object to xml:", e);
		}
		return commandoRequestEnXml;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String anyObjectToXmlText(Object objJaxB) {
		String commandoRequestEnXml = null;
		JAXBContext context;
		try {
			context = obtainJaxBContextFromClass(objJaxB.getClass());
			Marshaller marshaller = context.createMarshaller();
			StringWriter xmlWriter = new StringWriter();
			marshaller.marshal(
					new JAXBElement(new QName("", objJaxB.getClass().getName()), objJaxB.getClass(), objJaxB),
					xmlWriter);
			XmlObject xmlObj = XmlObject.Factory.parse(xmlWriter.toString());
			commandoRequestEnXml = xmlObj.toString();
		} catch (Exception e) {
			wlLogger.error("Error parseando object to xml:", e);
		}
		return commandoRequestEnXml;
	}

	public static TreeMap<String, String> obtenerMapReemplazos(String cadenaValores, String delimitadorRegistros,
			String delimitadorCampos) {
		TreeMap<String, String> mapReemplazo = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		try {
			String strReemplazo = cadenaValores;
			if (strReemplazo != null && !strReemplazo.isEmpty()) {
				String[] arrayReemplazoBolsas = strReemplazo.split(delimitadorRegistros);
				String strNombre;
				String strNombreReemplazo;
				for (int i = 0; i < arrayReemplazoBolsas.length; i++) {
					strNombre = arrayReemplazoBolsas[i].split(delimitadorCampos)[0];
					strNombreReemplazo = arrayReemplazoBolsas[i].split(delimitadorCampos)[1];
					mapReemplazo.put(strNombre, strNombreReemplazo);
				}

			}
		} catch (Exception e) {
			wlLogger.error("Error al obtener el Map de Reemplazos: [" + cadenaValores + "]", e);
		}
		return mapReemplazo;
	}
}

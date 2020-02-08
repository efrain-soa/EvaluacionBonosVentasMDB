package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.StringWriter;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.springframework.jdbc.core.SqlParameter;
import java.net.UnknownHostException;


public class Util{

	private final static Logger	LOGGER		= LoggerFactory.getLogger( Util.class.getName() );
	public final static String	SALTOLINEA	= "\n";

	public Util(){
		super();
	}

	public static int leerInteger( String cadena ){
		int numero = 0;
		try{
			numero = Integer.parseInt( cadena );
		}
		catch( NumberFormatException e ){
			numero = 0;
		}
		return numero;
	}

	public static Date cadenaAFecha( String fecha ){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		String cadenaFecha = fecha;
		Date fechaDate = null;
		try{
			fechaDate = (Date)formatter.parse( cadenaFecha );
		}
		catch( ParseException e ){
			fechaDate = null;
		}
		return fechaDate;
	}

	public static double leerDouble( String cadena ){
		double numero = 0;
		try{
			numero = Double.parseDouble( cadena );
		}
		catch( NumberFormatException e ){
			numero = 0;
		}
		return numero;
	}

	public static float leerFloat( String cadena ){
		float numero = 0;
		try{
			numero = Float.parseFloat( cadena );
		}
		catch( NumberFormatException e ){
			numero = 0;
		}
		return numero;
	}

	public static String generarIdTransaccion(){
		return new Date().getTime() + "";
	}



	public static String getCurrentDateWithFormat( String formatPattern ){
		Locale locale = Locale.getDefault();
		Calendar now = new GregorianCalendar( locale );
		return getDateWithFormat( now, formatPattern );
	}

	public static String getDateWithFormat( Calendar date, String formatPattern ){
		SimpleDateFormat dateFormat = new SimpleDateFormat( formatPattern, Locale.getDefault() );
		return dateFormat.format( date.getTime() );
	}

	public static String[] getArregloPalabrasSegunSeparador( String texto, String separador ){
		String[] rpta = new String[0];
		try{
			rpta = texto.split( "\\" + separador );
		}
		catch( Exception e ){
			rpta = new String[0];
		}

		return rpta;
	}

	public static Object[] getArregloObjetosSegunHashMap( LinkedHashMap<String, SqlParameter> hashmap ){
		SqlParameter[] arreglo_respuesta = null;
		if( hashmap != null ){
			arreglo_respuesta = new SqlParameter[hashmap.size()];
			List<String> keys = new ArrayList<String>( hashmap.keySet() );
			for( int i = 0; i < keys.size(); i++ ){
				String key = keys.get( i ) + "";
				arreglo_respuesta[i] = hashmap.get( key );
			}
		}
		else{
			arreglo_respuesta = new SqlParameter[0];
		}

		return arreglo_respuesta;
	}	
	
	
   private static HashMap<Class, JAXBContext> mapContexts = new HashMap<Class, JAXBContext>();
	
    private static JAXBContext obtainJaxBContextFromClass(Class clas) {

        JAXBContext context;
        context = mapContexts.get(clas);

        if (context == null) {

            try {
                context = JAXBContext.newInstance(clas);
                mapContexts.put(clas, context);
            }
            catch (Exception e) {
            	LOGGER.error("Error creando JAXBContext:", e);
            }
        }
        return context;
    }
	
	
    public static String anyObjectToXmlText(Object anyObject) {
        String commandoRequestEnXml = null;

        JAXBContext context;

        try {
            context = obtainJaxBContextFromClass(anyObject.getClass()); //se hace esto para mejorar performance.
            Marshaller marshaller = context.createMarshaller();

            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(new JAXBElement(new QName("", anyObject.getClass().getSimpleName()), anyObject.getClass(), anyObject), xmlWriter);

            XmlObject xmlObj = XmlObject.Factory.parse(xmlWriter.toString());

            commandoRequestEnXml = xmlObj.toString();
        }
        catch (Exception e) {
        	LOGGER.error("Error parseando object to xml:", e);
        }

        return commandoRequestEnXml;
    }
	
	public static String getIp(){
		String ip = null;
		try{
			ip = InetAddress.getLocalHost().getHostAddress();
		}
		catch( UnknownHostException e ){
			LOGGER.error( e.getMessage(), e );
		}
		return ip;
	}
	
	
	public static String getDate( String formato ){

		String resultado = null;

		try{
			Timestamp fecha = new Timestamp( new Date().getTime() );
			SimpleDateFormat sdf = new SimpleDateFormat( formato, new Locale( "es", "pe" ) );
			resultado = sdf.format( fecha );
		}
		catch( Exception e ){
			LOGGER.error( e.getMessage(), e );
		}

		return resultado;
	}
	
	public static XMLGregorianCalendar getXmlGregorianCalnedar() {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return xgcal;

	}
}



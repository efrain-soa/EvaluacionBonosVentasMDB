package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class Utilitarios {

	public static XMLGregorianCalendar convertDateToGregorianCalendar(Date fecha) {
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTime(fecha);

		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
	
	public static ARRAY objectToARRAY(String arrayDescriptorName, Connection connectionBd, Object object) throws SQLException {

		ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor(arrayDescriptorName, connectionBd);

//		Object[] listaRespuesta = new Object[1];

//		Object[] detPregunta = new Object[2];
//		detPregunta[0] = new BigDecimal(pregunta.getNroPregunta());
//		detPregunta[1] = pregunta.getNroRespuesta();

		ARRAY sqlArrays = new ARRAY(arrayDescriptor, connectionBd, object);

		return sqlArrays;
	}
	
	public static Object[] listToArray(List<Object> listObject) throws SQLException {

		Object[] list = new Object[listObject.size()];

		int i = 0;
		for (Object object : listObject) {	
			list[i] = object;
			i++;
		}
		
		return list;
	}
	
	public static String convertGregorianCalendarToString(XMLGregorianCalendar fecha) {
		
		String dateString  = "";
		if(fecha != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			GregorianCalendar gCalendar = fecha.toGregorianCalendar();
			Date date = gCalendar.getTime();
			dateString = df.format(date);
		}
		
		return dateString;
	}
}

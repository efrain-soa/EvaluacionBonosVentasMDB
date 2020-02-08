package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.ws.rs.core.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.*;

public class ClaroUtil {
	
	private static final Logger log = LoggerFactory.getLogger(ClaroUtil.class);

	public static String getAllHttpHeaders(HttpHeaders httpHeaders) {
		StringBuffer data = new StringBuffer();
		
		Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		for(String header : headerKeys) {
			data.append(header + ":" + httpHeaders.getRequestHeader(header).get(Constantes.CERO) + "\n");
		}
		return data.toString().trim();
	}

	public static String getHttpHeadersNoNull(HttpHeaders httpHeaders) {
		
		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0) : "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0) : "";
		String timestamp = "";
		Calendar a = ClaroUtil.toCalendar(httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0).toString() : Constantes.VACIO);
		if (a != null)
			timestamp = a.getTime().toString();
		String userId = httpHeaders.getRequestHeader(Constantes.USERID) != null
				? httpHeaders.getRequestHeader(Constantes.USERID).get(0) : "";
		String accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(0) : "";
		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USERID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(accept);
		data.append(Constantes.CORCHETE);
		return data.toString();
	}
	
	public static String getHttpHeaders(HttpHeaders httpHeaders) {

		if (httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) == null)
			return null;
		if (httpHeaders.getRequestHeader(Constantes.MSGID) == null)
			return null;
		if (httpHeaders.getRequestHeader(Constantes.TIMESTAMP) == null)
			return null;
		if (httpHeaders.getRequestHeader(Constantes.USERID) == null)
			return null;

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0) : "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0) : "";
		String timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0) : "";
		String userId = httpHeaders.getRequestHeader(Constantes.USERID) != null
				? httpHeaders.getRequestHeader(Constantes.USERID).get(0) : "";

		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USERID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(httpHeaders.getMediaType());
		data.append(Constantes.CORCHETE);
		return data.toString();
	}

	public static String getExceptionToMensaje(Exception e){
    	String msg = Constantes.VACIO;
    	if (e.getCause() != null) {
			msg = e.getCause().toString();
		} else {
			msg = e.toString();
		}
    	return msg;
    }
	
	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}
	
	public static String convertProperties(Object object){
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.defaulEncodingProperties), Constantes.defaulEncodingApi);
			} catch (Exception e) {
				log.error("Error getProperties Encoding Failed, trayendo Encoding por defecto",e );
			}
		}
		return a;
	}
	
	
	public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
				.writeValueAsString(o);
	}

	public static String printJSONString(Object o) {
		try {
			return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return Constantes.VACIO;
		}
	}

	/**
	 * Genera un String a partir de un Date, si fecha es NULL retorna ""
	 * (vacio).
	 *
	 * @param fecha
	 *            tipo Date
	 * @return String de la forma dd/MM/yyyy
	 */
	public static String dateAString(Date fecha) {
		if (fecha == null) {
			return null;
		}
		return dateAString(fecha, Constantes.FORMATOFECHACABECERA);
	}

	/**
	 * Genera un String a partir de un Date de acuerdo al fomrato enviado, si
	 * fecha es NULL toma la fecha actual.
	 *
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static String dateAString(Date fecha, String formato) {
		if (fecha == null) {
			return null;
		}
		SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.ROOT);
		return formatoDF.format(fecha);
	}

	public static Calendar toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		String s = iso8601string.replace("Z", "+00:00");
		try {
			s = s.substring(0, 22) + s.substring(23); // to get rid of the ":"
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ROOT).parse(s);
			calendar.setTime(date);
		} catch (IndexOutOfBoundsException e) {
			log.error("Ocurrio un error al recorrer la cadena de Fecha", e);
			calendar = null;
		} catch (ParseException e) {
			log.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);
			calendar = null;
		}
		return calendar;
	}

	public static Date stringADate(String fecha, String formatoFecha) {
		Date fechaGenerada = null;
		if (fecha != null) {
			try {
				SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
				fechaGenerada = formato.parse(fecha);
			} catch (Exception e) {
				log.error("Error al formatear fecha :" + fecha, e);
			}
		}

		return fechaGenerada;
	}
	
	public static String getIp(){
		String ip = null;
		try{
			ip = InetAddress.getLocalHost().getHostAddress();
		}
		catch( UnknownHostException e ){
			log.error( e.getMessage(), e );
		}
		return ip;
	}

	public static String getIdTransaccion(HttpHeaders httpHeaders) {
		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0) : "";
		StringBuffer data = new StringBuffer();
		data.append("[");
		data.append(Constantes.IDTRANSACCION);
		data.append("=");
		data.append(idTransaccion);
		data.append("]");
		return data.toString();
	}
}

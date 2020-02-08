package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

@Repository
public class ConvertUtilitarios {

	public XMLGregorianCalendar XMLGregorianCalendarConvertFormatDate(Date date) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar date2 = null;

		try {
			gregorianCalendar.setTime(date);
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}

	public static XMLGregorianCalendar XMLGregorianCalendarConvertFormatStringDate(String date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date2;
		XMLGregorianCalendar xmlGregCal = null;
		try {
			date2 = format.parse(date);

			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date2);

			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xmlGregCal;
	}

	public static Date StringToDate(String coActivated) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date convertedCurrentDate = null;
		try {
			convertedCurrentDate = sdf.parse(coActivated);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedCurrentDate;

	}

	public static String DateToStringFormatv1(Date j, String format) {

		DateFormat dateFormat = new SimpleDateFormat(format);
		String datestring = dateFormat.format(j);

		return datestring;
	}

	static final String EMPTY = "";
	static final String POINT = ".";
	static final String COMMA = ",";
	static final String POINT_AS_STRING = ".";
	static final String COMMA_AS_STRING = ",";

	/**
	 * Converts a String to a BigDecimal. if there is more than 1 '.', the
	 * points are interpreted as thousand-separator and will be removed for
	 * conversion if there is more than 1 ',', the commas are interpreted as
	 * thousand-separator and will be removed for conversion the last '.' or ','
	 * will be interpreted as the separator for the decimal places () or - in
	 * front or in the end will be interpreted as negative number
	 *
	 * @param value
	 * @return The BigDecimal expression of the given string
	 */
	public static BigDecimal toBigDecimal(final String value) {
		if (value != null) {
			boolean negativeNumber = false;

			if (value.contains("(") && value.contains(")"))
				negativeNumber = true;
			if (value.endsWith("-") || value.startsWith("-"))
				negativeNumber = true;

			String parsedValue = value.replaceAll("[^0-9\\,\\.]", EMPTY);

			if (negativeNumber)
				parsedValue = "-" + parsedValue;

			int lastPointPosition = parsedValue.lastIndexOf(POINT);
			int lastCommaPosition = parsedValue.lastIndexOf(COMMA);

			// handle '1423' case, just a simple number
			if (lastPointPosition == -1 && lastCommaPosition == -1)
				return new BigDecimal(parsedValue);
			// handle '45.3' and '4.550.000' case, only points are in the given
			// String
			if (lastPointPosition > -1 && lastCommaPosition == -1) {
				int firstPointPosition = parsedValue.indexOf(POINT);
				if (firstPointPosition != lastPointPosition)
					return new BigDecimal(parsedValue.replace(POINT_AS_STRING, EMPTY));
				else
					return new BigDecimal(parsedValue);
			}
			// handle '45,3' and '4,550,000' case, only commas are in the given
			// String
			if (lastPointPosition == -1 && lastCommaPosition > -1) {
				int firstCommaPosition = parsedValue.indexOf(COMMA);
				if (firstCommaPosition != lastCommaPosition)
					return new BigDecimal(parsedValue.replace(COMMA_AS_STRING, EMPTY));
				else
					return new BigDecimal(parsedValue.replace(COMMA, POINT));
			}
			// handle '2.345,04' case, points are in front of commas
			if (lastPointPosition < lastCommaPosition) {
				parsedValue = parsedValue.replace(POINT_AS_STRING, EMPTY);
				return new BigDecimal(parsedValue.replace(COMMA, POINT));
			}
			// handle '2,345.04' case, commas are in front of points
			if (lastCommaPosition < lastPointPosition) {
				parsedValue = parsedValue.replace(COMMA_AS_STRING, EMPTY);
				return new BigDecimal(parsedValue);
			}
			throw new NumberFormatException("Unexpected number format. Cannot convert '" + value + "' to BigDecimal.");
		}
		return null;
	}

	public static String StringDatetimeToStringDateLocalYYYY_MM_DD(String StringDatetime) {
		// String string = "20010704T12:08:56-0000";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ssZ", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(StringDatetime, formatter);

		return date.toString();
	}

	public static String clobStringConversion(Clob clb) throws IOException, SQLException {
		if (clb == null)
			return "";

		StringBuffer str = new StringBuffer();
		String strng;

		BufferedReader bufferRead = new BufferedReader(clb.getCharacterStream());

		while ((strng = bufferRead.readLine()) != null)
			str.append(strng);

		return str.toString();
	}

	public static String formatXML(String unformattedXml) {
		try {
			Document document = parseXmlFile(unformattedXml);
			OutputFormat format = new OutputFormat(document);
			format.setIndenting(true);
			format.setIndent(3);
			format.setOmitXMLDeclaration(true);
			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);
			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

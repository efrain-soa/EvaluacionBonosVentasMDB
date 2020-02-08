package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.datatype.XMLGregorianCalendar;

public class HeaderRequestType implements Serializable {

	private static final long serialVersionUID = 1L;
	private String channel;
	private String idApplication;
	private String userApplication;
	private String userSession;
	private String idESBTransaction;
	private String idBusinessTransaction;
	private XMLGregorianCalendar startDate;
	private Object additionalNode;
	
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getIdApplication() {
		return idApplication;
	}
	public void setIdApplication(String idApplication) {
		this.idApplication = idApplication;
	}
	public String getUserApplication() {
		return userApplication;
	}
	public void setUserApplication(String userApplication) {
		this.userApplication = userApplication;
	}
	public String getUserSession() {
		return userSession;
	}
	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}
	public String getIdESBTransaction() {
		return idESBTransaction;
	}
	public void setIdESBTransaction(String idESBTransaction) {
		this.idESBTransaction = idESBTransaction;
	}
	public String getIdBusinessTransaction() {
		return idBusinessTransaction;
	}
	public void setIdBusinessTransaction(String idBusinessTransaction) {
		this.idBusinessTransaction = idBusinessTransaction;
	}
	public XMLGregorianCalendar getStartDate() {
		return startDate;
	}
	public void setStartDate(XMLGregorianCalendar startDate) {
		this.startDate = startDate;
	}
	public Object getAdditionalNode() {
		return additionalNode;
	}
	public void setAdditionalNode(Object additionalNode) {
		this.additionalNode = additionalNode;
	}
	
	
	
}

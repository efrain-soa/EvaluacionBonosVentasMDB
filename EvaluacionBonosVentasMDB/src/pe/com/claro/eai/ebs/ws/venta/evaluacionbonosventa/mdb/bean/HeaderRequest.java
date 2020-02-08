package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;


import javax.ws.rs.core.HttpHeaders;

import com.sun.istack.internal.NotNull;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;


//@Entity
public class HeaderRequest {

	@NotNull
	private String idTransaccion;
	
	@NotNull
	private String msgid;
	
	@NotNull
	private String timestamp;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String accept;
	
	@NotNull
	private String channel;
	
	@NotNull
	private String idApplication;
	
	public HeaderRequest() {
		super();
	}

	public HeaderRequest(HttpHeaders httpHeaders) {
		super();
		this.idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(Constantes.CERO) : null;
		this.msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null? httpHeaders.getRequestHeader(Constantes.MSGID).get(Constantes.CERO) : null;
		this.timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(Constantes.CERO) : null;
		this.userId = httpHeaders.getRequestHeader(Constantes.USERID) != null? httpHeaders.getRequestHeader(Constantes.USERID).get(Constantes.CERO) : null;
		this.accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(Constantes.CERO) : null;
		this.channel = httpHeaders.getRequestHeader(Constantes.CHANNEL) != null? httpHeaders.getRequestHeader(Constantes.CHANNEL).get(Constantes.CERO) : null;
		this.idApplication = httpHeaders.getRequestHeader(Constantes.IDAPPLICATION) != null? httpHeaders.getRequestHeader(Constantes.IDAPPLICATION).get(Constantes.CERO) : null;
	}



	public HeaderRequest(String idTransaccion, String msgid, String timestamp, String userId, String accept,	String nombreAplicacion, String ipAplicacion, String channel, String idApplication) {
		super();
		this.idTransaccion = idTransaccion;
		this.msgid = msgid;
		this.timestamp = timestamp;
		this.userId = userId;
		this.accept = accept;
		this.channel = channel;
		this.idApplication  = idApplication;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "HeaderRequestBean [idTransaccion=" + idTransaccion + ", msgid=" + msgid + ", timestamp=" + timestamp
				+ ", userId=" + userId + ", accept=" + accept + ", channel=" +channel+ ", idApplication="+idApplication+ "]";
	}

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

}

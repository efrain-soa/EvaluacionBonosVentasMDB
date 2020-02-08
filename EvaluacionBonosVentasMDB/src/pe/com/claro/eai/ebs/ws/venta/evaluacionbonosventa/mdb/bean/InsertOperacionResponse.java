package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.io.Serializable;

public class InsertOperacionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158047059602134002L;
	private String codError;
	private String msgError;
	
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getMsgError() {
		return msgError;
	}
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
	
}

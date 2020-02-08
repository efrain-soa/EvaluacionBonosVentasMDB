package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;

public class ListaServiciosAdicionalesRequestType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String poID;
	private String tipoPO;
	public String getPoID() {
		return poID;
	}
	public void setPoID(String poID) {
		this.poID = poID;
	}
	public String getTipoPO() {
		return tipoPO;
	}
	public void setTipoPO(String tipoPO) {
		this.tipoPO = tipoPO;
	}
	
	

}

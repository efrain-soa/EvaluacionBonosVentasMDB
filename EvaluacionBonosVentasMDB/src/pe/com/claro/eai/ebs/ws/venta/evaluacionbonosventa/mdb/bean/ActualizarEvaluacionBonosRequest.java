package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.io.Serializable;
import java.util.Date;

public class ActualizarEvaluacionBonosRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;
	private String accionId;
	private String estadoOm;
	private Date fecCreaOm;
	private Date fecIniProcOm;
	private Date fecFinProcOm;
	private String shoppingCartId;
	public String getPi_order_id() {
		return orderId;
	}
	public void setPi_order_id(String pi_order_id) {
		this.orderId = pi_order_id;
	}
	public String getPi_accion_id() {
		return accionId;
	}
	public void setPi_accion_id(String pi_accion_id) {
		this.accionId = pi_accion_id;
	}
	public String getPi_estado_om() {
		return estadoOm;
	}
	public void setPi_estado_om(String pi_estado_om) {
		this.estadoOm = pi_estado_om;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAccionId() {
		return accionId;
	}
	public void setAccionId(String accionId) {
		this.accionId = accionId;
	}
	public String getEstadoOm() {
		return estadoOm;
	}
	public void setEstadoOm(String estadoOm) {
		this.estadoOm = estadoOm;
	}
	public Date getFecCreaOm() {
		return fecCreaOm;
	}
	public void setFecCreaOm(Date fecCreaOm) {
		this.fecCreaOm = fecCreaOm;
	}
	public Date getFecIniProcOm() {
		return fecIniProcOm;
	}
	public void setFecIniProcOm(Date fecIniProcOm) {
		this.fecIniProcOm = fecIniProcOm;
	}
	public Date getFecFinProcOm() {
		return fecFinProcOm;
	}
	public void setFecFinProcOm(Date fecFinProcOm) {
		this.fecFinProcOm = fecFinProcOm;
	}
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getPi_shopping_cart_id() {
		return shoppingCartId;
	}
	public void setPi_shopping_cart_id(String pi_shopping_cart_id) {
		this.shoppingCartId = pi_shopping_cart_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
}

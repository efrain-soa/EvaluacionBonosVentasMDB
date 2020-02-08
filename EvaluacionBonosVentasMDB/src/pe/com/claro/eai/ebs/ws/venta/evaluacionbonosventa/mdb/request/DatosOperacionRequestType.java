package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

public class DatosOperacionRequestType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String shoppingCartID;
	protected String FlagActivacionDirecta;
	protected String appOrigen;
	protected String canal;
	protected String tipoOperacion;
	protected XMLGregorianCalendar fechaTransaccion;
	protected String modalidadVenta;
	protected String codigoPuntoVenta;
	protected String codDepartamentoPV;
	protected String codProvinciaPV;
	protected String codDistritoPV;
	protected String codDepartamentoFac;
	protected String codProvinciaFac;
	protected String codDistritoFac;
	public String getShoppingCartID() {
		return shoppingCartID;
	}
	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}
	public String getAppOrigen() {
		return appOrigen;
	}
	public void setAppOrigen(String appOrigen) {
		this.appOrigen = appOrigen;
	}
	public String getCanal() {
		return canal;
	}
	public String getFlagActivacionDirecta() {
		return FlagActivacionDirecta;
	}
	public void setFlagActivacionDirecta(String flagActivacionDirecta) {
		FlagActivacionDirecta = flagActivacionDirecta;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public XMLGregorianCalendar getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(XMLGregorianCalendar fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	public String getModalidadVenta() {
		return modalidadVenta;
	}
	public void setModalidadVenta(String modalidadVenta) {
		this.modalidadVenta = modalidadVenta;
	}
	public String getCodigoPuntoVenta() {
		return codigoPuntoVenta;
	}
	public void setCodigoPuntoVenta(String codigoPuntoVenta) {
		this.codigoPuntoVenta = codigoPuntoVenta;
	}
	public String getCodDepartamentoPV() {
		return codDepartamentoPV;
	}
	public void setCodDepartamentoPV(String codDepartamentoPV) {
		this.codDepartamentoPV = codDepartamentoPV;
	}
	public String getCodProvinciaPV() {
		return codProvinciaPV;
	}
	public void setCodProvinciaPV(String codProvinciaPV) {
		this.codProvinciaPV = codProvinciaPV;
	}
	public String getCodDistritoPV() {
		return codDistritoPV;
	}
	public void setCodDistritoPV(String codDistritoPV) {
		this.codDistritoPV = codDistritoPV;
	}
	public String getCodDepartamentoFac() {
		return codDepartamentoFac;
	}
	public void setCodDepartamentoFac(String codDepartamentoFac) {
		this.codDepartamentoFac = codDepartamentoFac;
	}
	public String getCodProvinciaFac() {
		return codProvinciaFac;
	}
	public void setCodProvinciaFac(String codProvinciaFac) {
		this.codProvinciaFac = codProvinciaFac;
	}
	public String getCodDistritoFac() {
		return codDistritoFac;
	}
	public void setCodDistritoFac(String codDistritoFac) {
		this.codDistritoFac = codDistritoFac;
	}
	
	

}

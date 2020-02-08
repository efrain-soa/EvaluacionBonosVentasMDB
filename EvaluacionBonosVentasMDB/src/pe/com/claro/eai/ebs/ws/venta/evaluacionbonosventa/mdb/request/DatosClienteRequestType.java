package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

public class DatosClienteRequestType implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String customerID;
	protected String customerIDPub;
	protected String billingAccount;
	protected String cicloFacturacion;
	protected String segmentoCliente;
	protected String tipoDocumento;
	protected String numeroDocumento;
	protected XMLGregorianCalendar fechaNacimiento;
	protected String genero;
	protected XMLGregorianCalendar fechaAltaCliente;
	protected String comportamientoPago;

	public String getCustomerID() {
		return customerID;
	}
	
	

	public String getCustomerIDPub() {
		return customerIDPub;
	}



	public void setCustomerIDPub(String customerIDPub) {
		this.customerIDPub = customerIDPub;
	}



	public String getNumeroDocumento() {
		return numeroDocumento;
	}



	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getBillingAccount() {
		return billingAccount;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	public String getCicloFacturacion() {
		return cicloFacturacion;
	}

	public void setCicloFacturacion(String cicloFacturacion) {
		this.cicloFacturacion = cicloFacturacion;
	}

	public String getSegmentoCliente() {
		return segmentoCliente;
	}

	public void setSegmentoCliente(String segmentoCliente) {
		this.segmentoCliente = segmentoCliente;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public XMLGregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(XMLGregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public XMLGregorianCalendar getFechaAltaCliente() {
		return fechaAltaCliente;
	}

	public void setFechaAltaCliente(XMLGregorianCalendar fechaAltaCliente) {
		this.fechaAltaCliente = fechaAltaCliente;
	}

	public String getComportamientoPago() {
		return comportamientoPago;
	}

	public void setComportamientoPago(String comportamientoPago) {
		this.comportamientoPago = comportamientoPago;
	}

}

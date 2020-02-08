package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.Date;

public class DatosClienteBean {
	private String customerIdExt;
	private String billingAccount;
	private String cicloFact;
	private String segmentoCliente;
	private String tipoDocumento;
	private String numeroDocumento;
	private Date fecNacimiento;
	private String genero;
	private Date fechaAltaCliente;
	private Integer comportamientoPago;
	private String scoreInterconex;
	private String pago_puntual;
	private String ingPromMovilFija;
	private String ingPromLineaFag;
	
	private Double cantLineaPrepago;
	private Double cantLineaPostpago;
	private Double cantLineaServFijo;
	private Double cantLineaServFijoTot;
	private Double cantPortaMovil;
	private Double cantPortaFijo;	
	private Integer customerIdInt;
	
	public String getCustomerIdExt() {
		return customerIdExt;
	}
	public void setCustomerIdExt(String customerIdExt) {
		this.customerIdExt = customerIdExt;
	}
	public String getBillingAccount() {
		return billingAccount;
	}
	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}
	public String getCicloFact() {
		return cicloFact;
	}
	public void setCicloFact(String cicloFact) {
		this.cicloFact = cicloFact;
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
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public Date getFechaAltaCliente() {
		return fechaAltaCliente;
	}
	public void setFechaAltaCliente(Date fechaAltaCliente) {
		this.fechaAltaCliente = fechaAltaCliente;
	}
	public Integer getCustomerIdInt() {
		return customerIdInt;
	}
	public void setCustomerIdInt(Integer customerIdInt) {
		this.customerIdInt = customerIdInt;
	}
	public Integer getComportamientoPago() {
		return comportamientoPago;
	}
	public void setComportamientoPago(Integer comportamientoPago) {
		this.comportamientoPago = comportamientoPago;
	}
	public String getScoreInterconex() {
		return scoreInterconex;
	}
	public void setScoreInterconex(String scoreInterconex) {
		this.scoreInterconex = scoreInterconex;
	}
	public String getPago_puntual() {
		return pago_puntual;
	}
	public void setPago_puntual(String pago_puntual) {
		this.pago_puntual = pago_puntual;
	}
	public String getIngPromMovilFija() {
		return ingPromMovilFija;
	}
	public void setIngPromMovilFija(String ingPromMovilFija) {
		this.ingPromMovilFija = ingPromMovilFija;
	}
	public String getIngPromLineaFag() {
		return ingPromLineaFag;
	}
	public void setIngPromLineaFag(String ingPromLineaFag) {
		this.ingPromLineaFag = ingPromLineaFag;
	}
	public Double getCantLineaPrepago() {
		return cantLineaPrepago;
	}
	public void setCantLineaPrepago(Double cantLineaPrepago) {
		this.cantLineaPrepago = cantLineaPrepago;
	}
	public Double getCantLineaPostpago() {
		return cantLineaPostpago;
	}
	public void setCantLineaPostpago(Double cantLineaPostpago) {
		this.cantLineaPostpago = cantLineaPostpago;
	}
	public Double getCantLineaServFijo() {
		return cantLineaServFijo;
	}
	public void setCantLineaServFijo(Double cantLineaServFijo) {
		this.cantLineaServFijo = cantLineaServFijo;
	}
	public Double getCantLineaServFijoTot() {
		return cantLineaServFijoTot;
	}
	public void setCantLineaServFijoTot(Double cantLineaServFijoTot) {
		this.cantLineaServFijoTot = cantLineaServFijoTot;
	}
	public Double getCantPortaMovil() {
		return cantPortaMovil;
	}
	public void setCantPortaMovil(Double cantPortaMovil) {
		this.cantPortaMovil = cantPortaMovil;
	}
	public Double getCantPortaFijo() {
		return cantPortaFijo;
	}
	public void setCantPortaFijo(Double cantPortaFijo) {
		this.cantPortaFijo = cantPortaFijo;
	}

	
}

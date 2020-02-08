package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class Suscripciones {

	private String tipoProducto;
	private String tipoTecnologia;
	private String tipoSuscripcion;
	private String bundleID;
	private String modalidadPago;
	private double cargoFijoPlan;
	private String plazoContrato;
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getTipoTecnologia() {
		return tipoTecnologia;
	}
	public void setTipoTecnologia(String tipoTecnologia) {
		this.tipoTecnologia = tipoTecnologia;
	}
	public String getTipoSuscripcion() {
		return tipoSuscripcion;
	}
	public void setTipoSuscripcion(String tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}
	public String getBundleID() {
		return bundleID;
	}
	public void setBundleID(String bundleID) {
		this.bundleID = bundleID;
	}
	public String getModalidadPago() {
		return modalidadPago;
	}
	public void setModalidadPago(String modalidadPago) {
		this.modalidadPago = modalidadPago;
	}
	public double getCargoFijoPlan() {
		return cargoFijoPlan;
	}
	public void setCargoFijoPlan(double cargoFijoPlan) {
		this.cargoFijoPlan = cargoFijoPlan;
	}
	public String getPlazoContrato() {
		return plazoContrato;
	}
	public void setPlazoContrato(String plazoContrato) {
		this.plazoContrato = plazoContrato;
	}
	
}

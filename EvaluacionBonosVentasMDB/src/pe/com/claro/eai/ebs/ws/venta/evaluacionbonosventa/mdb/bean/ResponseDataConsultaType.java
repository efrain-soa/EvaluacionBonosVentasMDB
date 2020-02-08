package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class ResponseDataConsultaType {

	private String razonSocial;
	private String nombres;
	private String apellidos;
	private List<CustomerConsultaType> customer;
	private String cantPlanes;
	private String cantPlanesActivos;
	private String cantPlanesBloquedos;
	private String cantPlanesSuspendidos;
	private String nro7;
	private String nro30;
	private String nro90;
	private String nro90mas;
	private String nro180;
	private String nro180mas;
	private String cargoFijo;
	private List<ListaOpcionalType> listaOpcional;

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<CustomerConsultaType> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerConsultaType> customer) {
		this.customer = customer;
	}

	public String getCantPlanes() {
		return cantPlanes;
	}

	public void setCantPlanes(String cantPlanes) {
		this.cantPlanes = cantPlanes;
	}

	public String getCantPlanesActivos() {
		return cantPlanesActivos;
	}

	public void setCantPlanesActivos(String cantPlanesActivos) {
		this.cantPlanesActivos = cantPlanesActivos;
	}

	public String getCantPlanesBloquedos() {
		return cantPlanesBloquedos;
	}

	public void setCantPlanesBloquedos(String cantPlanesBloquedos) {
		this.cantPlanesBloquedos = cantPlanesBloquedos;
	}

	public String getCantPlanesSuspendidos() {
		return cantPlanesSuspendidos;
	}

	public void setCantPlanesSuspendidos(String cantPlanesSuspendidos) {
		this.cantPlanesSuspendidos = cantPlanesSuspendidos;
	}

	public String getNro7() {
		return nro7;
	}

	public void setNro7(String nro7) {
		this.nro7 = nro7;
	}

	public String getNro30() {
		return nro30;
	}

	public void setNro30(String nro30) {
		this.nro30 = nro30;
	}

	public String getNro90() {
		return nro90;
	}

	public void setNro90(String nro90) {
		this.nro90 = nro90;
	}

	public String getNro90mas() {
		return nro90mas;
	}

	public void setNro90mas(String nro90mas) {
		this.nro90mas = nro90mas;
	}

	public String getNro180() {
		return nro180;
	}

	public void setNro180(String nro180) {
		this.nro180 = nro180;
	}

	public String getNro180mas() {
		return nro180mas;
	}

	public void setNro180mas(String nro180mas) {
		this.nro180mas = nro180mas;
	}

	public String getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(String cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public List<ListaOpcionalType> getListaOpcional() {
		return listaOpcional;
	}

	public void setListaOpcional(List<ListaOpcionalType> listaOpcional) {
		this.listaOpcional = listaOpcional;
	}

}
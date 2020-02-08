package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;
import java.util.List;

public class ListaDatosLineaRequestType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String linea;
	private String contractID;
	private String contractIdPub;
	private String poID;
	private String poName;
	private String iccid;
	private String cantidadDecos;
	private String casoEspecial;
	private String campana;
	private String tope;
	private String suscripcionCorreo;
	private String lineaReferente;
	private String codDepartamentoIns;
	private String codProvinciaIns;
	private String codDistritoIns;
	private String marcaEquipo;
	private String modeloEquipo;
	private String precioVentaEquipo;
	
	private List<ListaSuscripcionesRequestType> suscripciones;
	private List<ListaServiciosAdicionalesRequestType> serviciosAdicionales;
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getPoID() {
		return poID;
	}
	
	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public void setPoID(String poID) {
		this.poID = poID;
	}
	public String getPoName() {
		return poName;
	}
	public String getContractIdPub() {
		return contractIdPub;
	}
	public void setContractIdPub(String contractIdPub) {
		this.contractIdPub = contractIdPub;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getCantidadDecos() {
		return cantidadDecos;
	}
	public void setCantidadDecos(String cantidadDecos) {
		this.cantidadDecos = cantidadDecos;
	}
	public String getCasoEspecial() {
		return casoEspecial;
	}
	public void setCasoEspecial(String casoEspecial) {
		this.casoEspecial = casoEspecial;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public String getTope() {
		return tope;
	}
	public void setTope(String tope) {
		this.tope = tope;
	}
	public String getSuscripcionCorreo() {
		return suscripcionCorreo;
	}
	public void setSuscripcionCorreo(String suscripcionCorreo) {
		this.suscripcionCorreo = suscripcionCorreo;
	}
	public String getLineaReferente() {
		return lineaReferente;
	}
	public void setLineaReferente(String lineaReferente) {
		this.lineaReferente = lineaReferente;
	}
	public String getCodDepartamentoIns() {
		return codDepartamentoIns;
	}
	public void setCodDepartamentoIns(String codDepartamentoIns) {
		this.codDepartamentoIns = codDepartamentoIns;
	}
	public String getCodProvinciaIns() {
		return codProvinciaIns;
	}
	public void setCodProvinciaIns(String codProvinciaIns) {
		this.codProvinciaIns = codProvinciaIns;
	}
	public String getCodDistritoIns() {
		return codDistritoIns;
	}
	public void setCodDistritoIns(String codDistritoIns) {
		this.codDistritoIns = codDistritoIns;
	}
	public String getMarcaEquipo() {
		return marcaEquipo;
	}
	public void setMarcaEquipo(String marcaEquipo) {
		this.marcaEquipo = marcaEquipo;
	}
	public String getModeloEquipo() {
		return modeloEquipo;
	}
	public void setModeloEquipo(String modeloEquipo) {
		this.modeloEquipo = modeloEquipo;
	}
	public String getPrecioVentaEquipo() {
		return precioVentaEquipo;
	}
	public void setPrecioVentaEquipo(String precioVentaEquipo) {
		this.precioVentaEquipo = precioVentaEquipo;
	}
	public List<ListaSuscripcionesRequestType> getSuscripciones() {
		return suscripciones;
	}
	public void setSuscripciones(List<ListaSuscripcionesRequestType> suscripciones) {
		this.suscripciones = suscripciones;
	}
	public List<ListaServiciosAdicionalesRequestType> getServiciosAdicionales() {
		return serviciosAdicionales;
	}
	public void setServiciosAdicionales(List<ListaServiciosAdicionalesRequestType> serviciosAdicionales) {
		this.serviciosAdicionales = serviciosAdicionales;
	}
	
	
	
}

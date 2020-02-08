package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.Date;
import java.util.List;

public class LineaBean {

	private String linea;
	private String poId;
	private String poName;
	private String iccid;
	private Integer cantDecos;
	private String casoEspecial;
	private String campania;
	private String tope;
	private String suscripcionCorreo;
	private String lineaReferente;
	private String codDeptIns;
	private String codProvIns;
	private String codDistIns;
	private String marcaEquipo;
	private String modeloEquipo;
	private double precioVentaEquipo;
	private String clasiCharlotte;

	private String operCedente;
	private Date fecActOperCedente;
	private String contractId;
	private String contractIdbscs;

	private Object[] suscripciones;
	private Object[] serviciosAdicionales;
	private Object[] bonos;

	private List<Suscripciones> listaSuscripciones;
	private List<ServiciosAdicionales> listaServiciosAdicionales;
	private List<Bonos> listaBonos;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getPoId() {
		return poId;
	}

	public String getContractIdbscs() {
		return contractIdbscs;
	}

	public void setContractIdbscs(String contractIdbscs) {
		this.contractIdbscs = contractIdbscs;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getPoName() {
		return poName;
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

	public Integer getCantDecos() {
		return cantDecos;
	}

	public void setCantDecos(Integer cantDecos) {
		this.cantDecos = cantDecos;
	}

	public String getCasoEspecial() {
		return casoEspecial;
	}

	public void setCasoEspecial(String casoEspecial) {
		this.casoEspecial = casoEspecial;
	}

	public String getCampania() {
		return campania;
	}

	public void setCampania(String campania) {
		this.campania = campania;
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

	public String getCodDeptIns() {
		return codDeptIns;
	}

	public void setCodDeptIns(String codDeptIns) {
		this.codDeptIns = codDeptIns;
	}

	public String getCodProvIns() {
		return codProvIns;
	}

	public void setCodProvIns(String codProvIns) {
		this.codProvIns = codProvIns;
	}

	public String getCodDistIns() {
		return codDistIns;
	}

	public void setCodDistIns(String codDistIns) {
		this.codDistIns = codDistIns;
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

	public double getPrecioVentaEquipo() {
		return precioVentaEquipo;
	}

	public void setPrecioVentaEquipo(double precioVentaEquipo) {
		this.precioVentaEquipo = precioVentaEquipo;
	}

	public String getClasiCharlotte() {
		return clasiCharlotte;
	}

	public void setClasiCharlotte(String clasiCharlotte) {
		this.clasiCharlotte = clasiCharlotte;
	}

	public Object[] getSuscripciones() {
		return suscripciones;
	}

	public void setSuscripciones(Object[] suscripciones) {
		this.suscripciones = suscripciones;
	}

	public Object[] getServiciosAdicionales() {
		return serviciosAdicionales;
	}

	public void setServiciosAdicionales(Object[] serviciosAdicionales) {
		this.serviciosAdicionales = serviciosAdicionales;
	}

	public Object[] getBonos() {
		return bonos;
	}

	public void setBonos(Object[] bonos) {
		this.bonos = bonos;
	}

	public List<Suscripciones> getListaSuscripciones() {
		return listaSuscripciones;
	}

	public void setListaSuscripciones(List<Suscripciones> listaSuscripciones) {
		this.listaSuscripciones = listaSuscripciones;
	}

	public List<ServiciosAdicionales> getListaServiciosAdicionales() {
		return listaServiciosAdicionales;
	}

	public void setListaServiciosAdicionales(List<ServiciosAdicionales> listaServiciosAdicionales) {
		this.listaServiciosAdicionales = listaServiciosAdicionales;
	}

	public List<Bonos> getListaBonos() {
		return listaBonos;
	}

	public void setListaBonos(List<Bonos> listaBonos) {
		this.listaBonos = listaBonos;
	}

	public String getOperCedente() {
		return operCedente;
	}

	public void setOperCedente(String operCedente) {
		this.operCedente = operCedente;
	}

	public Date getFecActOperCedente() {
		return fecActOperCedente;
	}

	public void setFecActOperCedente(Date fecActOperCedente) {
		this.fecActOperCedente = fecActOperCedente;
	}

}

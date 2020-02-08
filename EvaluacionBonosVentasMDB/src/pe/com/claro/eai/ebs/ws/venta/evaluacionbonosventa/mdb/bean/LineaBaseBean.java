package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.Date;
import java.util.List;

public class LineaBaseBean {

	private String contractIdBase;
	private String lineaBase;
	private String poIdBase;
	private String poNameBase;
	private String customerIdExtBase;
	private Integer customerIdIntBase;
	
	private String billingAccountBase;
	private String cicloFactBase;
	private Double cargoFijoPlanBase;
	private String tipoProductoBase;
	private String tipoSuscripcionBase;
	private Date fecActivacionBase;
	private String estadoLineaBase;
	
	private String bundleId;
	private String statusBilling;
	private String email;
	private String tecnologia;
	private String tipoTelefono;
	private Date fecModSuscription;		
	
	private Object[] hisBloqueo;
	private String indLineaPortaBase;
	private Object[] hisCambPlanBase;
	private Object[] hisRenovacionBase;
	private Object[] bolsaLineaBase;
	
	private List<HisBloq> listaHisBloqueo;
	private List<HisCambPlanBase> listaHisCambPlanBase;
	private List<HisRenovacionBase> listHisRenovacionBase;
	private List<BolsaLineaBase> listaBolsaLineaBase;
	
	
	public String getContractIdBase() {
		return contractIdBase;
	}
	
	
	public Date getFecActivacionBase() {
		return fecActivacionBase;
	}


	public void setFecActivacionBase(Date fecActivacionBase) {
		this.fecActivacionBase = fecActivacionBase;
	}


	public Date getFecModSuscription() {
		return fecModSuscription;
	}


	public void setFecModSuscription(Date fecModSuscription) {
		this.fecModSuscription = fecModSuscription;
	}


	public void setContractIdBase(String contractIdBase) {
		this.contractIdBase = contractIdBase;
	}
	public String getLineaBase() {
		return lineaBase;
	}
	public void setLineaBase(String lineaBase) {
		this.lineaBase = lineaBase;
	}
	public String getPoIdBase() {
		return poIdBase;
	}
	public void setPoIdBase(String poIdBase) {
		this.poIdBase = poIdBase;
	}
	public String getPoNameBase() {
		return poNameBase;
	}
	public void setPoNameBase(String poNameBase) {
		this.poNameBase = poNameBase;
	}
	public String getCustomerIdExtBase() {
		return customerIdExtBase;
	}
	public void setCustomerIdExtBase(String customerIdExtBase) {
		this.customerIdExtBase = customerIdExtBase;
	}
	public Integer getCustomerIdIntBase() {
		return customerIdIntBase;
	}


	public void setCustomerIdIntBase(Integer customerIdIntBase) {
		this.customerIdIntBase = customerIdIntBase;
	}


	public String getBillingAccountBase() {
		return billingAccountBase;
	}
	public void setBillingAccountBase(String billingAccountBase) {
		this.billingAccountBase = billingAccountBase;
	}
	public String getCicloFactBase() {
		return cicloFactBase;
	}
	public void setCicloFactBase(String cicloFactBase) {
		this.cicloFactBase = cicloFactBase;
	}
	public Double getCargoFijoPlanBase() {
		return cargoFijoPlanBase;
	}
	public void setCargoFijoPlanBase(Double cargoFijoPlanBase) {
		this.cargoFijoPlanBase = cargoFijoPlanBase;
	}
	public String getTipoProductoBase() {
		return tipoProductoBase;
	}
	public void setTipoProductoBase(String tipoProductoBase) {
		this.tipoProductoBase = tipoProductoBase;
	}
	public String getTipoSuscripcionBase() {
		return tipoSuscripcionBase;
	}
	public void setTipoSuscripcionBase(String tipoSuscripcionBase) {
		this.tipoSuscripcionBase = tipoSuscripcionBase;
	}

	public String getEstadoLineaBase() {
		return estadoLineaBase;
	}
	public void setEstadoLineaBase(String estadoLineaBase) {
		this.estadoLineaBase = estadoLineaBase;
	}

	public List<HisBloq> getListaHisBloqueo() {
		return listaHisBloqueo;
	}
	public void setListaHisBloqueo(List<HisBloq> listaHisBloqueo) {
		this.listaHisBloqueo = listaHisBloqueo;
	}
	
	public String getIndLineaPortaBase() {
		return indLineaPortaBase;
	}
	public void setIndLineaPortaBase(String indLineaPortaBase) {
		this.indLineaPortaBase = indLineaPortaBase;
	}
	public Object[] getHisBloqueo() {
		return hisBloqueo;
	}
	public void setHisBloqueo(Object[] hisBloqueo) {
		this.hisBloqueo = hisBloqueo;
	}
	public Object[] getHisCambPlanBase() {
		return hisCambPlanBase;
	}
	public void setHisCambPlanBase(Object[] hisCambPlanBase) {
		this.hisCambPlanBase = hisCambPlanBase;
	}
	public Object[] getHisRenovacionBase() {
		return hisRenovacionBase;
	}
	public void setHisRenovacionBase(Object[] hisRenovacionBase) {
		this.hisRenovacionBase = hisRenovacionBase;
	}
	public Object[] getBolsaLineaBase() {
		return bolsaLineaBase;
	}
	public void setBolsaLineaBase(Object[] bolsaLineaBase) {
		this.bolsaLineaBase = bolsaLineaBase;
	}
	public List<HisCambPlanBase> getListaHisCambPlanBase() {
		return listaHisCambPlanBase;
	}
	public void setListaHisCambPlanBase(List<HisCambPlanBase> listaHisCambPlanBase) {
		this.listaHisCambPlanBase = listaHisCambPlanBase;
	}
	public List<HisRenovacionBase> getListHisRenovacionBase() {
		return listHisRenovacionBase;
	}
	public void setListHisRenovacionBase(List<HisRenovacionBase> listHisRenovacionBase) {
		this.listHisRenovacionBase = listHisRenovacionBase;
	}
	public List<BolsaLineaBase> getListaBolsaLineaBase() {
		return listaBolsaLineaBase;
	}
	public void setListaBolsaLineaBase(List<BolsaLineaBase> listaBolsaLineaBase) {
		this.listaBolsaLineaBase = listaBolsaLineaBase;
	}
	public String getBundleId() {
		return bundleId;
	}
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}
	public String getStatusBilling() {
		return statusBilling;
	}
	public void setStatusBilling(String statusBilling) {
		this.statusBilling = statusBilling;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
	
}

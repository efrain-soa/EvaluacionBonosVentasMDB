package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.ArrayList;
import java.util.List;

public class ObtenerBonosRequest {

	private DatosClienteBean datosClientes;	
	private DatosOperacionBean datosOperacion;
	private List<LineaBaseBean> listaLineaBase;
	private List<LineaBean> listaLinea;

	public DatosClienteBean getDatosClientes() {
		return datosClientes;
	}

	public void setDatosClientes(DatosClienteBean datosClientes) {
		this.datosClientes = datosClientes;
	}

	public DatosOperacionBean getDatosOperacion() {
		return datosOperacion;
	}

	public void setDatosOperacion(DatosOperacionBean datosOperacion) {
		this.datosOperacion = datosOperacion;
	}

	public List<LineaBean> getListaLinea() {
		return listaLinea;
	}

	public void setListaLinea(List<LineaBean> listaLinea) {
		this.listaLinea = listaLinea;
	}
	
	public List<LineaBaseBean> getListaLineaBase() {
		return listaLineaBase;
	}

	public void setListaLineaBase(List<LineaBaseBean> listaLineaBase) {
		this.listaLineaBase = listaLineaBase;
	}

	public List<Object> obtenerListaLineaToObject() {
		List<Object> obj = new ArrayList<Object>();

		for (LineaBean bean : this.listaLinea) {
			Object[] objectArray = new Object[23];
			objectArray[0] = bean.getLinea();
			objectArray[1] = bean.getPoId();
			objectArray[2] = bean.getPoName();
			objectArray[3] = bean.getIccid();
			objectArray[4] = bean.getCantDecos();
			objectArray[5] = bean.getCasoEspecial();
			objectArray[6] = bean.getCampania();
			objectArray[7] = bean.getTope();
			objectArray[8] = bean.getSuscripcionCorreo();
			objectArray[9] = bean.getLineaReferente();
			objectArray[10] = bean.getCodDeptIns();
			objectArray[11] = bean.getCodProvIns();
			objectArray[12] = bean.getCodDistIns();
			objectArray[13] = bean.getMarcaEquipo();
			objectArray[14] = bean.getModeloEquipo();
			objectArray[15] = bean.getPrecioVentaEquipo();
			objectArray[16] = bean.getClasiCharlotte();
			objectArray[17] = bean.getOperCedente();
			objectArray[18] = bean.getFecActOperCedente();
			objectArray[19] = bean.getContractId();
			objectArray[20] = bean.getContractIdbscs();
			objectArray[21] = bean.getSuscripciones();
			objectArray[22] = bean.getServiciosAdicionales();
			objectArray[23] = bean.getBonos();

			obj.add(objectArray);
		}
		return obj;
	}
	
	public List<Object> obtenerListaLineaBaseToObject(){
		List<Object> obj = new ArrayList<Object>();
		for (LineaBaseBean bean : this.listaLineaBase) {
			Object[] objectArray = new Object[23];
			objectArray[0] = bean.getContractIdBase();
			objectArray[1] = bean.getLineaBase();
			objectArray[2] = bean.getPoIdBase();
			objectArray[3] = bean.getPoNameBase();
			objectArray[4] = bean.getCustomerIdExtBase();
			objectArray[5] = bean.getCustomerIdIntBase();
			objectArray[6] = bean.getBillingAccountBase();
			objectArray[7] = bean.getCicloFactBase();
			objectArray[8] = bean.getCargoFijoPlanBase();
			objectArray[9] = bean.getTipoProductoBase();
			objectArray[10] = bean.getTipoSuscripcionBase();
			objectArray[11] = bean.getFecActivacionBase();
			objectArray[12] = bean.getEstadoLineaBase();
			objectArray[13] = bean.getBundleId();
			objectArray[14] = bean.getStatusBilling();
			objectArray[15] = bean.getEmail();
			objectArray[16] = bean.getTecnologia();
			objectArray[17] = bean.getTipoTelefono();
			objectArray[18] = bean.getFecModSuscription();
			objectArray[19] = bean.getHisBloqueo();
			objectArray[20] = bean.getIndLineaPortaBase();
			objectArray[21] = bean.getHisCambPlanBase();
			objectArray[22] = bean.getHisRenovacionBase();
			objectArray[23] = bean.getBolsaLineaBase();
			
			obj.add(objectArray);
		}
		return obj;
	}

}

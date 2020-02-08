package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class GetStatusReasonsResponse {

	private String status;
	private List<GetStatusReasonsBean> listaGetStatusReasons;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<GetStatusReasonsBean> getListaGetStatusReasons() {
		return listaGetStatusReasons;
	}
	public void setListaGetStatusReasons(List<GetStatusReasonsBean> listaGetStatusReasons) {
		this.listaGetStatusReasons = listaGetStatusReasons;
	}
	
	
}

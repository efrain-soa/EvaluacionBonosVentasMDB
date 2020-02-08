package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class ObtenerDatosClienteColivingResponse {

	private String status;
	private List<ObtenerDatosClienteColivingBean> listaLineasPostPago;
	private List<ObtenerDatosClienteColivingBean> listaLineasPrePago;
	
	public List<ObtenerDatosClienteColivingBean> getListaLineasPostPago() {
		return listaLineasPostPago;
	}
	public void setListaLineasPostPago(List<ObtenerDatosClienteColivingBean> listaLineasPostPago) {
		this.listaLineasPostPago = listaLineasPostPago;
	}
	public List<ObtenerDatosClienteColivingBean> getListaLineasPrePago() {
		return listaLineasPrePago;
	}
	public void setListaLineasPrePago(List<ObtenerDatosClienteColivingBean> listaLineasPrePago) {
		this.listaLineasPrePago = listaLineasPrePago;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}

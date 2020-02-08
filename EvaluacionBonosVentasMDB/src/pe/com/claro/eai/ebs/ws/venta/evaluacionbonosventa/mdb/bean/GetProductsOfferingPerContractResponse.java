package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class GetProductsOfferingPerContractResponse {

	private String status;
	private List<GetProductsOfferingPerContractBean> listaProductsOffering;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<GetProductsOfferingPerContractBean> getListaProductsOffering() {
		return listaProductsOffering;
	}
	public void setListaProductsOffering(List<GetProductsOfferingPerContractBean> listaProductsOffering) {
		this.listaProductsOffering = listaProductsOffering;
	}
	
	
}

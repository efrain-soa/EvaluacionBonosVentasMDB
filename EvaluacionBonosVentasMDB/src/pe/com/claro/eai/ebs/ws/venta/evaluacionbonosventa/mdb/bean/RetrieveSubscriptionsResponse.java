package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class RetrieveSubscriptionsResponse {
	
	private String status;
	private List<RetrieveSubscriptionsBean> ListaSubscriptions;

	public List<RetrieveSubscriptionsBean> getListaSubscriptions() {
		return ListaSubscriptions;
	}

	public void setListaSubscriptions(List<RetrieveSubscriptionsBean> listaSubscriptions) {
		ListaSubscriptions = listaSubscriptions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

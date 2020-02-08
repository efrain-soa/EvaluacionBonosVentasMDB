package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class GetBalanceConsumptionResponseBeanListado {

	private List<GetBalanceConsumptionResponseBean> listadoGetBalanceConsumptionResponseBean;
	private String resultado;

	


	public List<GetBalanceConsumptionResponseBean> getListadoGetBalanceConsumptionResponseBean() {
		return listadoGetBalanceConsumptionResponseBean;
	}

	public void setListadoGetBalanceConsumptionResponseBean(
			List<GetBalanceConsumptionResponseBean> listadoGetBalanceConsumptionResponseBean) {
		this.listadoGetBalanceConsumptionResponseBean = listadoGetBalanceConsumptionResponseBean;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
}

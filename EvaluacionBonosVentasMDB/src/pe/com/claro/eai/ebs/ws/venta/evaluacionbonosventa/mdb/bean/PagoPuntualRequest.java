package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class PagoPuntualRequest {

	private String customerId;
	private Integer cantidadMeses;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getCantidadMeses() {
		return cantidadMeses;
	}
	public void setCantidadMeses(Integer cantidadMeses) {
		this.cantidadMeses = cantidadMeses;
	}
	
	
}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class ProductosConsultaType {

	private String productId;
	private String productOfferingId;
	private String productOfferingType;
	private String productStatus;
	private String effectiveDate;
	private String cargoFijo;
	private String cargoFijoCalculado;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductOfferingId() {
		return productOfferingId;
	}

	public void setProductOfferingId(String productOfferingId) {
		this.productOfferingId = productOfferingId;
	}

	public String getProductOfferingType() {
		return productOfferingType;
	}

	public void setProductOfferingType(String productOfferingType) {
		this.productOfferingType = productOfferingType;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(String cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public String getCargoFijoCalculado() {
		return cargoFijoCalculado;
	}

	public void setCargoFijoCalculado(String cargoFijoCalculado) {
		this.cargoFijoCalculado = cargoFijoCalculado;
	}

}

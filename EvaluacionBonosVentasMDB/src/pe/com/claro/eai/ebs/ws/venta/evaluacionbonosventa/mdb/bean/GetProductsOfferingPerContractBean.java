package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class GetProductsOfferingPerContractBean {

	private String contractID;
	private String productOfferingType;
	private String amount;
	
	public String getProductOfferingType() {
		return productOfferingType;
	}
	public void setProductOfferingType(String productOfferingType) {
		this.productOfferingType = productOfferingType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
}

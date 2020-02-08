package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class GetBalanceConsumptionResponseBean {

	private String contractId;
	private String serviceName;
	private String unit;
	private String freeUnitsIncluded;
	private String consumption;
	
	public GetBalanceConsumptionResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFreeUnitsIncluded() {
		return freeUnitsIncluded;
	}

	public void setFreeUnitsIncluded(String freeUnitsIncluded) {
		this.freeUnitsIncluded = freeUnitsIncluded;
	}
	
	public String getConsumption() {
		return consumption;
	}
	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}


	
}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class CustomerConsultaType {

	private String customerId;
	private String custCode;
	private String customerIdPub;
	private String status;
	private String adrSeq;
	private List<ContratoConsultaType> contratos;
	private String cargoFijo;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustomerIdPub() {
		return customerIdPub;
	}

	public void setCustomerIdPub(String customerIdPub) {
		this.customerIdPub = customerIdPub;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ContratoConsultaType> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoConsultaType> contratos) {
		this.contratos = contratos;
	}

	public String getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(String cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public String getAdrSeq() {
		return adrSeq;
	}

	public void setAdrSeq(String adrSeq) {
		this.adrSeq = adrSeq;
	}

}

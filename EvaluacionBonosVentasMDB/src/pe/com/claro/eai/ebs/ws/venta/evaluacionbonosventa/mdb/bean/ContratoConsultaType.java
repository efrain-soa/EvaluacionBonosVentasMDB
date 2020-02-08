package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class ContratoConsultaType {

	private String coId;
	private String coIdPub;
	private String coStatus;
	private String coActivated;
	private String coLastReason;
	private String billingAccountId;
	private String billingAccountCode;

	private String dirNum;
	private String coLastStatusChangeDate;
	private String cargoFijo;
	private List<TicklersConsultaType> ticklers;
	private List<ProductosConsultaType> productos;

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getBillingAccountId() {
		return billingAccountId;
	}

	public void setBillingAccountId(String billingAccountId) {
		this.billingAccountId = billingAccountId;
	}

	public String getBillingAccountCode() {
		return billingAccountCode;
	}

	public void setBillingAccountCode(String billingAccountCode) {
		this.billingAccountCode = billingAccountCode;
	}

	public String getCoIdPub() {
		return coIdPub;
	}

	public void setCoIdPub(String coIdPub) {
		this.coIdPub = coIdPub;
	}

	public String getCoStatus() {
		return coStatus;
	}

	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}

	public String getCoActivated() {
		return coActivated;
	}

	public void setCoActivated(String coActivated) {
		this.coActivated = coActivated;
	}

	public String getCoLastReason() {
		return coLastReason;
	}

	public void setCoLastReason(String coLastReason) {
		this.coLastReason = coLastReason;
	}

	public String getDirNum() {
		return dirNum;
	}

	public void setDirNum(String dirNum) {
		this.dirNum = dirNum;
	}

	public String getCoLastStatusChangeDate() {
		return coLastStatusChangeDate;
	}

	public void setCoLastStatusChangeDate(String coLastStatusChangeDate) {
		this.coLastStatusChangeDate = coLastStatusChangeDate;
	}

	public String getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(String cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public List<TicklersConsultaType> getTicklers() {
		return ticklers;
	}

	public void setTicklers(List<TicklersConsultaType> ticklers) {
		this.ticklers = ticklers;
	}

	public List<ProductosConsultaType> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosConsultaType> productos) {
		this.productos = productos;
	}

}

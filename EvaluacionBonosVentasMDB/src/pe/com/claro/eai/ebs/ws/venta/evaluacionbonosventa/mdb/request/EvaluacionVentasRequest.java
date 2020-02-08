package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;
import java.util.List;


public class EvaluacionVentasRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private HeaderRequestType headerRequestType;
	
	private DatosClienteRequestType datosCliente;
	private DatosOperacionRequestType datosOperacion;
	private List<ListaDatosLineaRequestType> datosLinea;

	public EvaluacionVentasRequest() {
	}

	public HeaderRequestType getHeaderRequestType() {
		return headerRequestType;
	}

	public void setHeaderRequestType(HeaderRequestType headerRequestType) {
		this.headerRequestType = headerRequestType;
	}

	public DatosClienteRequestType getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosClienteRequestType datosCliente) {
		this.datosCliente = datosCliente;
	}

	public DatosOperacionRequestType getDatosOperacion() {
		return datosOperacion;
	}

	public void setDatosOperacion(DatosOperacionRequestType datosOperacion) {
		this.datosOperacion = datosOperacion;
	}

	public List<ListaDatosLineaRequestType> getDatosLinea() {
		return datosLinea;
	}

	public void setDatosLinea(List<ListaDatosLineaRequestType> datosLinea) {
		this.datosLinea = datosLinea;
	}

	
}

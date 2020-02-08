package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class ObtenerOperadorCedenteResponse {

	private List<ListaOperador> listaOperador;
	private String codError;
	private String desError;
	
	public List<ListaOperador> getListaOperador() {
		return listaOperador;
	}
	public void setListaOperador(List<ListaOperador> listaOperador) {
		this.listaOperador = listaOperador;
	}
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getDesError() {
		return desError;
	}
	public void setDesError(String desError) {
		this.desError = desError;
	}
	
	
}

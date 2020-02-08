package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.util.List;

public class ConsultarDatosRequestType {

	private String tipoDocumento;
	private String numeroDocumento;
	private List<ListaOpcionalType> listaOpcional;

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public List<ListaOpcionalType> getListaOpcional() {
		return listaOpcional;
	}

	public void setListaOpcional(List<ListaOpcionalType> listaOpcional) {
		this.listaOpcional = listaOpcional;
	}
	
}

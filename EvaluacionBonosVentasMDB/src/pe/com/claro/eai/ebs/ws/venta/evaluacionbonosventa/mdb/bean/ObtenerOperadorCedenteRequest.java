package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class ObtenerOperadorCedenteRequest {

	private String tipoDocumento;
	private String numeroDocumento;
	private String numeroAPortar;
	
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
	public String getNumeroAPortar() {
		return numeroAPortar;
	}
	public void setNumeroAPortar(String numeroAPortar) {
		this.numeroAPortar = numeroAPortar;
	}
	
	
}

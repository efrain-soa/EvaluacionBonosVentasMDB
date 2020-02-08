package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class Linea {

	private String linea;
	private String poID;
	private String poName;
	private String mensaje;
	private ListaBonos listaBonos;
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getPoID() {
		return poID;
	}
	public void setPoID(String poID) {
		this.poID = poID;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ListaBonos getListaBonos() {
		return listaBonos;
	}
	public void setListaBonos(ListaBonos listaBonos) {
		this.listaBonos = listaBonos;
	}
	

}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request;

import java.io.Serializable;

public class Security implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String contrasena;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}

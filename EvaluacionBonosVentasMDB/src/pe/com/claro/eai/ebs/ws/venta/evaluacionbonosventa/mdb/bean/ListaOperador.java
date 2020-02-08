package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class ListaOperador {

	private Integer IdPortabilidad;
	private String TipoDocumento;
	private String numeroDocumento;
	private String numeroAPortar;
	private Timestamp fechaRegistro;
	private String cedente;
	private Date fechaActivaCedente;
	private String linea;
	
	public Integer getIdPortabilidad() {
		return IdPortabilidad;
	}
	public void setIdPortabilidad(Integer idPortabilidad) {
		IdPortabilidad = idPortabilidad;
	}
	public String getTipoDocumento() {
		return TipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
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
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getCedente() {
		return cedente;
	}
	public void setCedente(String cedente) {
		this.cedente = cedente;
	}
	public Date getFechaActivaCedente() {
		return fechaActivaCedente;
	}
	public void setFechaActivaCedente(Date fechaActivaCedente) {
		this.fechaActivaCedente = fechaActivaCedente;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}

	
}

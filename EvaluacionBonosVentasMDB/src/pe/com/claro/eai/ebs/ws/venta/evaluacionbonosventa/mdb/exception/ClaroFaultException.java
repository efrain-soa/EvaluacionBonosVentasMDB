package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception;

import java.util.Date;

public class ClaroFaultException extends Exception{

	private static final long	serialVersionUID	= 3186105543822592034L;
	
	private Exception			objException;
	private String				idAuditoria;
	private String				codigoError;
	private String				descripcionError;
	private String				ubicacionError;
	private Date				fecha;
	private String				errorOrigen;
	
	
	public ClaroFaultException(String codigoError, String descripcionError) {
		super();
		this.codigoError = codigoError;
		this.descripcionError = descripcionError;
	}
	
	public ClaroFaultException(){
		super();
	}
	 
	public ClaroFaultException(Exception objException) {
		super();
		this.objException = objException;
	}
	
	public ClaroFaultException(Exception objException, String codigoError, String descripcionError, String ubicacionError) {
		super();
		this.objException = objException;		 
		this.codigoError = codigoError;
		this.descripcionError = descripcionError;
		this.ubicacionError = ubicacionError;		
	}
 
	public Exception getObjException() {
		return objException;
	}
	public void setObjException(Exception objException) {
		this.objException = objException;
	}
	public String getIdAuditoria() {
		return idAuditoria;
	}
	public void setIdAuditoria(String idAuditoria) {
		this.idAuditoria = idAuditoria;
	}
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	public String getUbicacionError() {
		return ubicacionError;
	}
	public void setUbicacionError(String ubicacionError) {
		this.ubicacionError = ubicacionError;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getErrorOrigen() {
		return errorOrigen;
	}
	public void setErrorOrigen(String errorOrigen) {
		this.errorOrigen = errorOrigen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

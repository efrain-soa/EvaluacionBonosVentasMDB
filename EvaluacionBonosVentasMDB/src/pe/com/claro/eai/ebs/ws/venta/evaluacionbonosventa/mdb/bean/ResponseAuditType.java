package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;


import com.sun.istack.internal.NotNull;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ConstantesValidacion;

public class ResponseAuditType {

	//@NotNull(message ConstantesValidacion.NOT_NULL)
	private String idTransaccion;

	//@NotNull(message = ConstantesValidacion.NOT_NULL)
	private String codigoRespuesta;

	//@NotNull(message = ConstantesValidacion.NOT_NULL)
	private String mensajeRespuesta;
	
	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
}

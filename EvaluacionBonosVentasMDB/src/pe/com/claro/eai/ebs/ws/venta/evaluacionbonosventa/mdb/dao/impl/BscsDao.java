package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import java.sql.SQLException;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;

public interface BscsDao {

	public ExtraePlataformasResponse extraePlataformas(String mensajeTransaccion,
			ExtraePlataformasRequest extraePlataformasRequest) throws DBException;

	ObtenerBonosResponse obtenerBonos(String mensajeTransaccion, ObtenerBonosRequest obtenerBonosRequest)
			throws DBException, SQLException;

	public ActualizarEvaluacionBonosResponse actualizarEvaluacionBonos(String mensajeTransaccion,
			ActualizarEvaluacionBonosRequest actualizarEvaluacionBonosRequest) throws DBException, SQLException;

}

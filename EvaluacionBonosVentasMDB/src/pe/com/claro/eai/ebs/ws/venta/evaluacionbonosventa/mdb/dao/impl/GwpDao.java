package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;

public interface GwpDao {

	public ObtenerOperadorCedenteResponse obtenerOperadorCedente(String mensajeTransaccion,ObtenerOperadorCedenteRequest request)throws DBException;
}

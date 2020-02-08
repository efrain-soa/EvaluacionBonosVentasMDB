package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;

public interface OacDAO {

	public PagoPuntualResponse pagoPuntual(String mensajeTransaccion, PagoPuntualRequest request)
			throws DBException;
}

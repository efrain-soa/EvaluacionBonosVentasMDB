package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;

public interface TimeaiDAO {

	public InsertOperacionResponse insertOperacion(String mensajeTransaccion,InsertOperacionRequest insertOperacionRequest) throws DBException;
	
}

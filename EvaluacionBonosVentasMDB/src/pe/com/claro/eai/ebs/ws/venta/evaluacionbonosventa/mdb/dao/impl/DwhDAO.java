package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;

public interface DwhDAO {
	
	public IndicCharltResponse indicCharlt(String mensajeTransaccion,IndicCharltRequest indicCharltRequest) throws DBException; 
	
	
}

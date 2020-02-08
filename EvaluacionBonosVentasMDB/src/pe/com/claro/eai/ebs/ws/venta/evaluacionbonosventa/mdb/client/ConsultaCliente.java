package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HeaderRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.HeaderRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;

public interface  ConsultaCliente {
	
	public ConsultarDatosResponse consultarDatos(String msjTx, ConsultarDatosRequest request, HeaderRequest header,
			ExternalProperties prop) throws WSException;
	
}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarContratosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarContratosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HeaderRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;

public interface  ConsultarContrato {
	
	public ConsultarContratosResponse consultarContrato(String msjTx, ConsultarContratosRequest request, HeaderRequest header,
			ExternalProperties prop) throws WSException;
	
}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasRequest;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasResponse;

public interface ValidarLineasClienteWS {
	
	public ContarLineasResponse validarLineasClienteWS(ContarLineasRequest request, ExternalProperties p, String msgTransaction) throws WSException;
}

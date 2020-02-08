package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.service;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.EvaluacionVentasRequest;

public interface EvaluacionBonosVentaMDBService {

	void iniciarService(String msjTxIn, EvaluacionVentasRequest request, String messageID);
}

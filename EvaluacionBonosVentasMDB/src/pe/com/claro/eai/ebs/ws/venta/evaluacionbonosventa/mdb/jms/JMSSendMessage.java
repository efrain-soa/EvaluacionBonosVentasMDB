package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.jms;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.EvaluacionVentasRequest;

public interface JMSSendMessage {
  
  void sendTextMessageErrorEvaluacionVentaBonoMDBxIDT(String mensaje, EvaluacionVentasRequest evaluacionVentasRequest);
  
  
  void sendTextMessageErrorEvaluacionVentaBonoMDBxIDF(String mensaje, EvaluacionVentasRequest evaluacionVentasRequest);
  
}

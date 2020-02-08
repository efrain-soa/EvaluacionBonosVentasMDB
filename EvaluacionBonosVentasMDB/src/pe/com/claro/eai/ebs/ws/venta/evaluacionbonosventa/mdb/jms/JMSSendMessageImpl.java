package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.EvaluacionVentasRequest;

@Service
public class JMSSendMessageImpl implements JMSSendMessage {

	private final static Logger LOGGER = Logger.getLogger(JMSSendMessageImpl.class);
	private final static Logger LOGGER_ERROR = Logger
			.getLogger(Constantes.MENSAJE_ERROR + JMSSendMessageImpl.class.getCanonicalName());

	@Autowired
	private ExternalProperties propertiesExternos;

	@Autowired
	@Qualifier("jmsTemplateEvaluacionVentasBonosVentaError")
	private JmsTemplate jmsTemplateActivaDesactivaBonosVentaError;

	@Override
	public void sendTextMessageErrorEvaluacionVentaBonoMDBxIDT(String mensaje, final EvaluacionVentasRequest evaluacionVentasRequest) {
		LOGGER.info(mensaje + "=== Inicio del metodo sendTextMessageErrorEvaluacionVentasBonosVenta");
		try {
			LOGGER.info(mensaje + "JMS-ConnectionFactory=" + propertiesExternos.jmsCF);
			LOGGER.info(mensaje + "JMS-Queue=" + propertiesExternos.jmsQueueActualizaEstadoBonoError);
			LOGGER.info(mensaje + "JMS-providerUrl=" + propertiesExternos.jmsProviderUrl);
			
			String strActivaDesactivaBonosVentaMDBType = JAXBUtilitarios.anyObjectToXmlText(evaluacionVentasRequest);
			LOGGER.info(mensaje + "Se procede a enviar textMessage:" + strActivaDesactivaBonosVentaMDBType);
			
			jmsTemplateActivaDesactivaBonosVentaError.send(new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage();
					message.setText(strActivaDesactivaBonosVentaMDBType);
					return message;
				}
			});
			LOGGER.info(mensaje + "Mensaje enviado con Exito");
		} catch (Exception e) {
			LOGGER.error(mensaje + "Error enviando message:", e);
			LOGGER_ERROR.error(JAXBUtilitarios.anyObjectToXmlText(evaluacionVentasRequest));
		} finally {
			LOGGER.info(mensaje + "=== Fin del metodo sendTextMessageErrorEvaluacionVentasBonosVenta");
		}
	}

	

	@Override
	public void sendTextMessageErrorEvaluacionVentaBonoMDBxIDF(String mensaje,
			EvaluacionVentasRequest evaluacionVentasRequest) {
		// TODO Auto-generated method stub
		LOGGER.info(mensaje + "=== Inicio del metodo sendTextMessageErrorEvaluacionVentasBonosVenta");
		try {
			LOGGER.info(mensaje + "JMS-ConnectionFactory=" + propertiesExternos.jmsCF);
			LOGGER.info(mensaje + "JMS-Queue=" + propertiesExternos.jmsQueueActualizaEstadoBonoError);
			LOGGER.info(mensaje + "JMS-providerUrl=" + propertiesExternos.jmsProviderUrl);
			
			String strActivaDesactivaBonosVentaMDBType = JAXBUtilitarios.anyObjectToXmlText(evaluacionVentasRequest);
			LOGGER.info(mensaje + "Se procede a enviar textMessage:" + strActivaDesactivaBonosVentaMDBType);
			
			jmsTemplateActivaDesactivaBonosVentaError.send(new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage();
					message.setText(strActivaDesactivaBonosVentaMDBType);
					return message;
				}
			});
			LOGGER.info(mensaje + "Mensaje enviado con Exito");
		} catch (Exception e) {
			LOGGER.error(mensaje + "Error enviando message:", e);
			LOGGER_ERROR.error(JAXBUtilitarios.anyObjectToXmlText(evaluacionVentasRequest));
		} finally {
			LOGGER.info(mensaje + "=== Fin del metodo sendTextMessageErrorEvaluacionVentasBonosVenta");
		}
	}

}

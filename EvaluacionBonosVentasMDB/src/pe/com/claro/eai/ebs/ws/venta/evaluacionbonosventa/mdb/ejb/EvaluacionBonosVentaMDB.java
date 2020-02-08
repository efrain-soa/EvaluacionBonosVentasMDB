package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.ejb;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.interceptor.Interceptors;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.EvaluacionVentasRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.service.EvaluacionBonosVentaMDBService;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.SpringBeanInterceptor;

/**
 * Message-Driven Bean implementation class for: RegistroVentaSIMATMMDB
 */
@MessageDriven()
@Interceptors(SpringBeanInterceptor.class)
public class EvaluacionBonosVentaMDB implements MessageListener {
	
	@Autowired
	private EvaluacionBonosVentaMDBService service;

	//En local 	
//		private final static Logger LOGGER = LoggerFactory.getLogger(ConfirmarVentaAppMDB.class.getName());

		

		public static transient org.apache.log4j.Logger logger = org.apache.log4j.Logger
				.getLogger(EvaluacionBonosVentaMDB.class);

		private String mensajeTransaccion = Constantes.Vacio;

		@Resource
		private MessageDrivenContext context;

		public void setMessageDrivenContext(MessageDrivenContext mycontext) {
			context = mycontext;
		}

		public EvaluacionBonosVentaMDB() {
			super();
			logger.info("*** 'MDB' [EvaluacionBonosVentaMDB] - Inicializado ... ***");
		}

		public void onMessage(Message message) {
			// TODO Auto-generated method stub
			final long vTiempoProceso = System.currentTimeMillis();

			int vDeliveryCount = 0;
			int vRedeliveryLimit = 0;
			String msjTx = null;
			
			try {
				String messageID = message.getJMSMessageID();
				msjTx = "[onMessage][messageID=" + messageID + "] ";
				this.mensajeTransaccion = msjTx;
				//logger.info(msjTx + Constantes.se);
				logger.info(msjTx + "[INICIO] - METODO: [onMessage]");
				//logger.info(msjTx + Constantes.SEPARADOR_GUIONES);
				
				logger.info(msjTx + "Leer mensaje de la cola");

				if (message instanceof ObjectMessage) {
					logger.info(msjTx + "Tipo de mensaje: [ObjectMessage]");

					ObjectMessage objectMessage = (ObjectMessage) message;
					EvaluacionVentasRequest request = (EvaluacionVentasRequest) objectMessage.getObject();
					
					logger.info(msjTx + "OBJETO [INPUT]: " + JAXBUtilitarios.anyObjectToXmlText(request));

					vDeliveryCount = objectMessage.getIntProperty("JMSXDeliveryCount");
					vRedeliveryLimit = objectMessage.getIntProperty("JMS_BEA_RedeliveryLimit");

					//if (ordenCobro == null) {
					//	logger.info(msjTx + "Estructura de mensaje no sorportado.");
					//	throw new JMSException("Estructura de mensaje no sorportado.");
					//}

					//msjTx = msjTx + "[accionCobranzaId=" + request.getDatosCliente().getCicloFacturacion() + "] ";

					service.iniciarService(msjTx, request, messageID);
					
				} else {
					logger.info(msjTx + "Tipo de mensaje diferente al soportado.");
				}
				
			} catch (Exception e) {
				logger.error(msjTx + "Error: " + e.getMessage(), e);
				
				
				forzarReencolamiento(this.mensajeTransaccion);
			} finally {
				logger.info(
						msjTx + "JMSXDeliveryCount - Intento Actual=[" + vDeliveryCount + "]," + "JMS_BEA_RedeliveryLimit=["
								+ vRedeliveryLimit + "], " + "Maximo de intentos=[" + (vRedeliveryLimit + 1) + "]");
				logger.info(msjTx + "Tiempo total de proceso(ms): " + (System.currentTimeMillis() - vTiempoProceso)
						+ " milisegundos.");
				
				//logger.info(msjTx + Constantes.SEPARADOR_GUIONES);
				logger.info(msjTx + "[FIN] - METODO: [onMessage]");
				//logger.info(msjTx + Constantes.SEPARADOR_GUIONES);
			}
			
		}
		
		private void forzarReencolamiento(String mensaje) {
			logger.info(mensaje + "[Se fuerza el reencolamiento]");
			throw new RuntimeException();
		}
		
}
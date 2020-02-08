package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client;

import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;
import pe.com.claro.eai.validarlineascliente.ws.EbsValidarLineasClienteService;
import pe.com.claro.eai.validarlineascliente.ws.ValidarLineasClientePortType;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasRequest;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasResponse;

@Service
public class ValidarLineasClienteWSImpl implements ValidarLineasClienteWS{
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public ContarLineasResponse validarLineasClienteWS(ContarLineasRequest request, ExternalProperties p, String msgTransaction) throws WSException {
		
		long tiempoInicio = System.currentTimeMillis();
		ContarLineasResponse response = new ContarLineasResponse();

		logger.info(msgTransaction + "[Inicio del metodo validarLineasCliente]");

		URL wsUrl;
		
		try {
			
			String url = p.validarLineasClienteUri;
			
			
		    wsUrl = new URL(url);
		    
		    
			logger.info(msgTransaction + " URL del Servicio a invocar: " + p.validarLineasClienteUri);
			logger.info(msgTransaction + " Timeout Connect: " + p.validarLineasClienteTimeOutConnect);
			logger.info(msgTransaction + " Timeout Request: " + p.validarLineasClienteTimeOutRequest);
			logger.info(msgTransaction + " Datos de entrada: " + JAXBUtilitarios.anyObjectToXmlText(request));
				
			EbsValidarLineasClienteService service = new EbsValidarLineasClienteService(wsUrl);
			ValidarLineasClientePortType port = service.getEbsValidarLineasClienteSB12();
			
			BindingProvider bindingProvider = (BindingProvider) port;
			//bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, p.validarLineasClienteUri);
			bindingProvider.getRequestContext().put(Constantes.CONNECT_TIMEOUT,
					Integer.parseInt(p.validarLineasClienteTimeOutConnect));
			bindingProvider.getRequestContext().put(Constantes.REQUEST_TIMEOUT,
					Integer.parseInt(p.validarLineasClienteTimeOutRequest));
			
			response = port.contarLineas(request);
	
			logger.info(msgTransaction + " Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
		
		} catch (Exception e) {
			logger.error(msgTransaction + e, e);
			String error = (e + Constantes.Vacio);

			if (error.contains(Constantes.TIMEOUT)) {
				throw new WSException(p.codigoIdf1,
						String.format(p.mensajeIdf1, p.validarLineasClienteNombre, p.validarLineasClienteMetodo), e);
	
			} else {
				throw new WSException(p.codigoIdf2,
						String.format(p.mensajeIdf2, p.validarLineasClienteNombre, p.validarLineasClienteMetodo), e);
			}
	
		} finally {
			logger.info(msgTransaction + "[FIN metodo obtenerDatos]");
			logger.info(msgTransaction + " Tiempo total de proceso (ms): " + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos");
		}
		return response;
	}
}
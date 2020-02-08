package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HeaderRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.HeaderRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ClaroUtil;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ConsultaClienteImpl  implements ConsultaCliente{

	private static transient Logger logger = Logger.getLogger(ConsultaClienteImpl.class);
	
	@Override
	public ConsultarDatosResponse consultarDatos(String msjTx, ConsultarDatosRequest request, HeaderRequest header,
			ExternalProperties prop) throws WSException {
		String metodo = "consultarDatos";
		logger.info(msjTx + Constantes.INICIO_METODO + metodo);

		ConsultarDatosResponse response = new ConsultarDatosResponse();
		long tiempoInicio = System.currentTimeMillis();

		String errorMsg = Constantes.Vacio;
		String url = prop.consultaClienteUri;
		String nombreComponente = prop.consultaClienteNombre;
		String nombreMetodo = prop.consultaClienteMetodo;

		try {
			logger.info(msjTx + "Componente: " + nombreComponente);
			logger.info(msjTx + "Metodo: " + nombreMetodo);
			logger.info(msjTx + "URL: " + url);
			logger.info(msjTx + Constantes.REQUEST_HEADER +  ClaroUtil.printPrettyJSONString(header));
			logger.info(msjTx + Constantes.REQUEST_BODY +  ClaroUtil.printPrettyJSONString(request));

			Client client;
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, Integer.parseInt(prop.consultaClienteConnectTimeOut));
			clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, Integer.parseInt(prop.consultaClienteReadTimeOut));
			client = Client.create(clientConfig);

			Builder builder = client.resource(url).type(MediaType.APPLICATION_JSON);

			builder.header(Constantes.IDTRANSACCION, header.getIdTransaccion());
			builder.header(Constantes.MSGID, header.getMsgid());
			builder.header(Constantes.TIMESTAMP, header.getTimestamp());
			builder.header(Constantes.USRID, header.getUserId());
			builder.header(Constantes.ACCEPT, MediaType.APPLICATION_JSON);

			response = builder.method(HttpMethod.POST, ConsultarDatosResponse.class, request);
			logger.info(msjTx + Constantes.RESPONSE_HEADER +  ClaroUtil.printPrettyJSONString(header));
			logger.info(msjTx + Constantes.RESPONSE_BODY +  ClaroUtil.printPrettyJSONString(response));

		} catch (Exception e) {
			errorMsg = e + Constantes.Vacio;
			logger.error(msjTx + Constantes.EXCEPCION_REST + nombreComponente + Constantes.DOSPUNTOS + errorMsg, e);
			capturarError(e, nombreComponente, nombreMetodo, prop);

		} finally {
			long tiempofinal = System.currentTimeMillis() - tiempoInicio;
			logger.info(msjTx + Constantes.FIN_METODO + metodo + Constantes.TIEMPO_TOTAL + tiempofinal);
		}
		return response;
	}
	
	private void capturarError(Exception e, String nombreComponente, String nombreMetodo, ExternalProperties prop)
			throws WSException {
		String errorMsg = e + Constantes.Vacio;
		if (errorMsg.contains(Constantes.EXCEPTION_WS_TIMEOUT_01)
				|| errorMsg.contains(Constantes.EXCEPTION_WS_TIMEOUT_02)) {

			throw new WSException(prop.idt1Codigo, String.format(prop.idt1Mensaje, nombreComponente, nombreMetodo), e);

		} else if (errorMsg.contains(Constantes.EXCEPTION_WS_NO_DISPONIBLE_01)
				|| errorMsg.contains(Constantes.EXCEPTION_WS_NO_DISPONIBLE_02)
				|| errorMsg.contains(Constantes.EXCEPTION_WS_NO_DISPONIBLE_03)
				|| errorMsg.contains(Constantes.EXCEPTION_WS_NO_DISPONIBLE_04)) {

			throw new WSException(prop.idt2Codigo, String.format(prop.idt2Mensaje, nombreComponente, nombreMetodo), e);

		} else {
			throw new WSException(prop.idt3Codigo,
					prop.idt3Mensaje.replace(Constantes.EX_CON_CORCHETE, e.getMessage())
							.replace(Constantes.VARIABLE_DB, nombreComponente)
							.replace(Constantes.VARIABLE_SP, nombreMetodo),
					e);
		}
	}
}

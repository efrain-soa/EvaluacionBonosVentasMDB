package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.email;


import java.net.SocketTimeoutException;

import javax.naming.ServiceUnavailableException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.ClaroFaultException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSClientException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Retorno;
import pe.com.claro.eai.util.enviocorreo.EnvioCorreoSBPortType;
import pe.com.claro.eai.util.enviocorreo.types.AuditTypeRequest;
import pe.com.claro.eai.util.enviocorreo.types.EnviarCorreoRequest;
import pe.com.claro.eai.util.enviocorreo.types.EnviarCorreoResponse;
import pe.com.claro.eai.util.enviocorreo.types.ListaArchivosAdjuntos;

@Service
public class EnvioCorreoSBClientImpl implements EnvioCorreoSBClient {

	private static Logger logger = Logger.getLogger(
			EnvioCorreoSBClientImpl.class);

	@Autowired
	@Qualifier( value = "envioCorreoSB" )
	private EnvioCorreoSBPortType envioCorreoSBPortType;


    @Override
	public Retorno<EnviarCorreoResponse> enviarCorreo(String mensajeLogMet, String idTransac, String ipAplic,
			String nomAplic, String usuarioAplic, ListaArchivosAdjuntos listaArchivosAdjuntos, String mensaje, String destinatario,ExternalProperties propiedadesExterna) throws WSClientException, ClaroFaultException {

	String mensajeLog = mensajeLogMet + "[enviarCorreo]-";

	logger.info(mensajeLogMet + "[INICIO] - Metodo[enviarCorreo]");

	Retorno<EnviarCorreoResponse> retorno = new Retorno<EnviarCorreoResponse>();

	try {

	    EnviarCorreoRequest request = new EnviarCorreoRequest();
	    AuditTypeRequest auditTypeRequest = new AuditTypeRequest();

	    EnviarCorreoResponse response = null;

	    auditTypeRequest.setIdTransaccion(idTransac);
	    auditTypeRequest.setCodigoAplicacion(nomAplic);
	    auditTypeRequest.setIpAplicacion(ipAplic);
	    auditTypeRequest.setUsrAplicacion(usuarioAplic);

	    request.setAuditRequest(auditTypeRequest);
	    request.setRemitente(propiedadesExterna.CORREO_REMITENTE);
			//request.setDestinatario(propiedadesExterna.CORREO_DESTINATARIO);
		request.setDestinatario(destinatario);
	    request.setAsunto(propiedadesExterna.CORREO_ASUNTO);
	    request.setMensaje(mensaje);
	    request.setHtmlFlag(propiedadesExterna.CORREO_HTML_FLAG);
	    request.setListaArchivosAdjuntos(listaArchivosAdjuntos);
	    
	    logger.info(mensajeLog + " - ---- Parametros de Entrada ---------");
	    logger.info(mensajeLog + "- request=" + JAXBUtilitarios.anyObjectToXmlText(request));
	    logger.info(mensajeLog + " - ----------------------------------");

	    response = envioCorreoSBPortType.enviarCorreo(request);

	    logger.info(mensajeLog + " - ---- Parametros de Salida ------");
	    logger.info(mensajeLog + "- response=" + JAXBUtilitarios.anyObjectToXmlText(response));

	    if (response != null) {
		retorno.setObjecto(response);
		retorno.setErrorCode(response.getAuditResponse().getCodigoRespuesta());
		retorno.setErrorMsg(response.getAuditResponse().getMensajeRespuesta());
	    } else {
		retorno.setErrorCode(propiedadesExterna.IDF2CODIGO);
		retorno.setErrorMsg(propiedadesExterna.IDF2MENSAJE);

	    }

	    return retorno;

			
			
	} catch (Exception ex) {
	    logger.error(mensajeLog + "Error: [Exception] " + ex, ex);
			if (ex.toString().contains(
					SocketTimeoutException.class.toString()
							.replace("class", Constantes.VACIO).trim())) {

		logger.error(mensajeLog + "Error producido por TIMEOUT");
				logger.error(mensajeLog
						+ "ERROR[Exception]: Se produjo una excepcion al ejecutar WS "
						+ propiedadesExterna.eNVIO_CORREO_SB_WSDL);
		retorno.setErrorCode(propiedadesExterna.IDT2CODIGO);
		retorno.setErrorMsg(propiedadesExterna.IDT2MENSAJE);
			}
			else if (ex.toString().contains( ServiceUnavailableException.class.toString().replace( "class", Constantes.VACIO ).trim() )) {
		logger.error(mensajeLog + "ERROR[Exception]: Se produjo una excepcion al ejecutar OSB " + propiedadesExterna.eNVIO_CORREO_SB_WSDL);
		retorno.setErrorCode(propiedadesExterna.IDT1CODIGO);
		retorno.setErrorMsg(propiedadesExterna.IDT1MENSAJE);
		throw new WSClientException(propiedadesExterna.IDT1CODIGO, propiedadesExterna.IDT1MENSAJE, propiedadesExterna.TIPO_ORIGEN_GENERADOCUMENTOS, ex);
			}			
			else {
				logger.error(mensajeLog
						+ "ERROR[Exception]: Se produjo una excepcion al ejecutar OSB "
						+ propiedadesExterna.eNVIO_CORREO_SB_WSDL);
		retorno.setErrorCode(propiedadesExterna.IDT1CODIGO);
				retorno.setErrorCode(propiedadesExterna.IDT1MENSAJE.replace(
						"RECURSO", propiedadesExterna.eNVIO_CORREO_SB_WSDL));
		throw new ClaroFaultException(ex, propiedadesExterna.IDT1CODIGO, propiedadesExterna.IDT1MENSAJE, propiedadesExterna.TIPO_ORIGEN_GENERADOCUMENTOS);
	    }
	} finally {
	    logger.info(mensajeLogMet + "[FIN] - Metodo[enviarCorreo]");
	}

	return retorno;

    }

}

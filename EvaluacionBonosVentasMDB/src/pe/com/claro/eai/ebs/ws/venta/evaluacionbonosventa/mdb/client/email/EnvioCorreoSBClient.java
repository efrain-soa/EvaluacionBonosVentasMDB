package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.email;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.ClaroFaultException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSClientException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Retorno;
import pe.com.claro.eai.util.enviocorreo.types.EnviarCorreoResponse;
import pe.com.claro.eai.util.enviocorreo.types.ListaArchivosAdjuntos;

public interface EnvioCorreoSBClient {
	
	public Retorno<EnviarCorreoResponse> enviarCorreo(String mensajeLog,String idTransac,String ipAplic,String nomAplic,String usuarioAplic, ListaArchivosAdjuntos listaArchivosAdjuntos, String mensaje, String destinatario, ExternalProperties propiedadesExterna) throws WSClientException, ClaroFaultException;

}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalProperties implements Serializable {

	private static final long serialVersionUID = 3767984029783522404L;




	/* TIMEAI */
	@Value("${db.timeai.name}")
	public String dbTimeai;

	@Value("${db.timeai.owner}")
	public String dbTimeaiOwner;

	@Value("${db.timeai.jndi}")
	public String dbTimeaiJndi;

	@Value("${db.timeai.logintimeout}")
	public String dbTimeaiTimeoutConnectionMaxTime;

	@Value("${db.timeai.executiontimeout}")
	public String dbTimeaiTimeoutExecutionMaxTime;

	@Value("${db.errorSqlTimeoutException}")
	public String bdErrorSqlTimeoutException;

	// Timeai SP
	@Value("${sp.timeai.omsi.operacion}")
	public String spOMSI_OPERACION;

	@Value("${sp.timeai.omsi.operacion.codigo.exito}")
	public String spOMSI_OPERACIONCodigoExito;

	@Value("${id.orden.request}")
	public String idOrdenRequest;

	@Value("${transac.request}")
	public String transacRequest;

	@Value("${estado.request}")
	public String estadoRequest;

	@Value("${prod.instan.request}")
	public String prodInstanRequest;

	/* TIMDWH */
	@Value("${db.dwh.name}")
	public String dbDwh;

	@Value("${db.dwh.owner}")
	public String dbDwhOwner;

	@Value("${db.dwh.jndi}")
	public String dbDwhJndi;

	@Value("${db.dwh.logintimeout}")
	public String dbDwhTimeoutConnectionMaxTime;

	@Value("${db.dwh.executiontimeout}")
	public String dbDwhTimeoutExecutionMaxTime;

	@Value("${sp.dwh.tcrmss.indic.charlt.operacion}")
	public String spTCRMSS_INDIC_CHARLT;

	@Value("${sp.dwh.tcrmss.indic.charlt.operacion.codigo.exito}")
	public String spTCRMSS_INDIC_CHARLTCodigoExito;

	/* BSCS */

	@Value("${db.bscs.name}")
	public String dbBscs;

	@Value("${db.bscs.owner}")
	public String dbBscsOwner;

	@Value("${db.bscs.jndi}")
	public String dbBscsJndi;

	@Value("${db.bscs.timeout.connection.max.time}")
	public String dbBscsTimeoutConnectionMaxTime;

	@Value("${db.bscs.timeout.execution.max.time}")
	public String dbBscsTimeoutExecutionMaxTime;

	@Value("${db.bscs.sp.extrae.data.ext}")
	public String dbBscsSpExtraeDataExt;

	@Value("${db.bscs.sp.extrae.data.ext.codigo.respuesta}")
	public String dbBscsSpExtraeDataExtCodigoRespuesta;

	@Value("${db.bscs.sp.obtener.bonos}")
	public String dbBscsSpObtenerBonos;
	@Value("${db.bscs.sp.actualiza.proc.bonos}")
	public String PromsuActProcTempPasincro;

	@Value("${db.bscs.sp.obtener.bonos.codigo.respuesta}")
	public String dbBscsSpObtenerBonosCodigoRespuesta;

	@Value("${db.bscs.plataforma.dwh}")
	public String dbBscsPlataformaDWH;

	@Value("${db.bscs.plataforma.gwp}")
	public String dbBscsPlataformaGWP;

	@Value("${db.bscs.plataforma.interfaceVenta1}")
	public String dbBscsPlataformaInterfaceVenta1;

	@Value("${db.bscs.plataforma.interfaceVenta2}")
	public String dbBscsPlataformaInterfaceVenta2;
	
	@Value("${db.bscs.plataforma.interfaceVenta3}")
	public String dbBscsPlataformaInterfaceVenta3;

	@Value("${db.bscs.plataforma.interfaceVenta2.1}")
	public String dbBscsPlataformaInterfaceVenta2_1;

	@Value("${db.bscs.plataforma.interfaceVenta2.2}")
	public String dbBscsPlataformaInterfaceVenta2_2;

	@Value("${db.bscs.plataforma.interfaceVenta2.3}")
	public String dbBscsPlataformaInterfaceVenta2_3;

	@Value("${db.bscs.plataforma.interfaceVenta2.4}")
	public String dbBscsPlataformaInterfaceVenta2_4;

	@Value("${db.bscs.plataforma.oac}")
	public String dbBscsPlataformaOac;

	/* OAC */

	@Value("${db.oac.name}")
	public String dbOac;

	@Value("${db.oac.owner}")
	public String dbOacOwner;

	@Value("${db.oac.jndi}")
	public String dbOacJndi;

	@Value("${db.oac.timeout.connection.max.time}")
	public String dbOacTimeoutConnectionMaxTime;

	@Value("${db.oac.timeout.execution.max.time}")
	public String dbOacTimeoutExecutionMaxTime;

	@Value("${db.oac.sp.pago.puntual}")
	public String dbOacSpPagoPuntual;

	@Value("${db.oac.sp.pago.puntual.cantidad.meses}")
	public String dbOacSpPagoPuntualCantidadMeses;

	/* GWP */

	@Value("${db.gwp.name}")
	public String dbGwp;

	@Value("${db.gwp.owner}")
	public String dbGwpOwner;

	@Value("${db.gwp.jndi}")
	public String dbGwpJndi;

	@Value("${db.gwp.timeout.connection.max.time}")
	public String dbGwpTimeoutConnectionMaxTime;

	@Value("${db.gwp.timeout.execution.max.time}")
	public String dbGwpTimeoutExecutionMaxTime;

	@Value("${db.gwp.sp.obtener.operador.cedente}")
	public String dbGwpSpObtenerOperadorCedente;

	@Value("${db.gwp.sp.obtener.operador.cedente.tipo.documento}")
	public String dbGwpSpObtenerOperadorCedenteTipoDocumento;

	// IDT GENERALES

	@Value("${codigo.idt1}")
	public String codigoIdt1;

	@Value("${mensaje.idt1}")
	public String mensajeIdt1;

	@Value("${codigo.idt2}")
	public String codigoIdt2;

	@Value("${mensaje.idt2}")
	public String mensajeIdt2;

	@Value("${codigo.idt3}")
	public String codigoIdt3;

	@Value("${mensaje.idt3}")
	public String mensajeIdt3;

	@Value("${codigo.idt4}")
	public String codigoIdt4;

	@Value("${mensaje.idt4}")
	public String mensajeIdt4;

	/* Idf del método evaluarCriteriosVenta */

	@Value("${evaluar.criterios.venta.codigo.IDF0}")
	public String codigoIdf0;

	@Value("${evaluar.criterios.venta.mensaje.IDF0}")
	public String mensajeIdf0;

	@Value("${evaluar.criterios.venta.codigo.IDF1}")
	public String codigoIdf1;

	@Value("${evaluar.criterios.venta.mensaje.IDF1}")
	public String mensajeIdf1;

	@Value("${evaluar.criterios.venta.ubicacion.IDF1}")
	public String ubicacionIdf1;

	@Value("${evaluar.criterios.venta.codigo.IDF2}")
	public String codigoIdf2;

	@Value("${evaluar.criterios.venta.mensaje.IDF2}")
	public String mensajeIdf2;

	@Value("${evaluar.criterios.venta.ubicacion.IDF2}")
	public String ubicacionIdf2;

	@Value("${evaluar.criterios.venta.codigo.IDF3}")
	public String codigoIdf3;

	@Value("${evaluar.criterios.venta.mensaje.IDF3}")
	public String mensajeIdf3;

	@Value("${evaluar.criterios.venta.ubicacion.IDF3}")
	public String ubicacionIdf3;

	@Value("${evaluar.criterios.venta.codigo.IDF4}")
	public String codigoIdf4;

	@Value("${evaluar.criterios.venta.mensaje.IDF4}")
	public String mensajeIdf4;

	@Value("${evaluar.criterios.venta.ubicacion.IDF4}")
	public String ubicacionIdf4;

	@Value("${evaluar.criterios.venta.codigo.IDF5}")
	public String codigoIdf5;

	@Value("${evaluar.criterios.venta.mensaje.IDF5}")
	public String mensajeIdf5;

	@Value("${evaluar.criterios.venta.ubicacion.IDF5}")
	public String ubicacionIdf5;

	// AHG/
	@Value("${plataformas}")
	public String plataformas;

	// MSB INI
	@Value("${consultaCliente.uri}")
	public String consultaClienteUri;
	@Value("${consultaCliente.nombre}")
	public String consultaClienteNombre;
	@Value("${consultaCliente.metodo}")
	public String consultaClienteMetodo;
	@Value("${consultaCliente.connect.time.out}")
	public String consultaClienteConnectTimeOut;
	@Value("${consultaCliente.read.time.out}")
	public String consultaClienteReadTimeOut;

	@Value("${consultaContrato.uri}")
	public String consultarContratoUri;
	@Value("${consultaContrato.nombre}")
	public String consultarContratoNombre;
	@Value("${consultaContrato.metodo}")
	public String consultarContratoMetodo;
	@Value("${consultaContrato.connect.time.out}")
	public String consultarContratoConnectTimeOut;
	@Value("${consultaContrato.read.time.out}")
	public String consultarContratoReadTimeOut;

	@Value("${validar.lineas.cliente.uri}")
	public String validarLineasClienteUri;
	@Value("${validar.lineas.cliente.nombre}")
	public String validarLineasClienteNombre;
	@Value("${validar.lineas.cliente.metodo}")
	public String validarLineasClienteMetodo;
	@Value("${validar.lineas.cliente.time.out.connect}")
	public String validarLineasClienteTimeOutConnect;
	@Value("${validar.lineas.cliente.time.out.request}")
	public String validarLineasClienteTimeOutRequest;

	@Value("${idt1.codigo}")
	public String idt1Codigo;
	@Value("${idt1.mensaje}")
	public String idt1Mensaje;
	@Value("${idt2.codigo}")
	public String idt2Codigo;
	@Value("${idt2.mensaje}")
	public String idt2Mensaje;
	@Value("${idt3.codigo}")
	public String idt3Codigo;
	@Value("${idt3.Mensaje}")
	public String idt3Mensaje;

	@Value("${header.request.accept}")
	public String headerRequestAccept;
	@Value("${header.request.msgid}")
	public String headerRequestMsgid;

	// MSB FIN

	@Value("${tipo.producto.base}")
	public String tipo_producto_base;
	@Value("${tipo.subscripcion.base}")
	public String tipo_subscripcion_base;
	@Value("${flagactivaciondirecta}")
	public String flagActivacionDirecta;


	@Value("${actualiza.estado}")
	public String ActualizaEstado;


	@Value("${forzar.sin.plataformas}")
	public String forzarsinplataformas;


	//para correos
	@Value("${correo.remitente}")
	public String CORREO_REMITENTE;
	@Value("${correo.asunto}")
	public String CORREO_ASUNTO;
	
	@Value("${correo.html.flag}")
	public String CORREO_HTML_FLAG;
	
	@Value("${idf.2.codigo}")
	public String IDF2CODIGO;
	
	@Value("${idf.2.mensaje}")
	public String IDF2MENSAJE;
	
	@Value("${wsclient.enviocorreosb.wsdl}")
	public String eNVIO_CORREO_SB_WSDL;
	
	@Value("${idt.2.codigo}")
	public String IDT2CODIGO;
	@Value("${idt.2.mensaje}")
	public String IDT2MENSAJE;
	
	@Value("${idt.1.codigo}")
	public String IDT1CODIGO;
	@Value("${idt.1.mensaje}") 
	public String IDT1MENSAJE;
	@Value("${ws.tipo.origen.generaDocumentos}")
	public String TIPO_ORIGEN_GENERADOCUMENTOS;

	@Value("${correo.ipaplicacion}")
	public String correo_ipaplicacion;
	@Value("${correo.nombreaplicacion}")
	public String correo_nombreaplicacion;
	@Value("${correo.usuarioaplicacion}")
	public String correo_usuarioaplicacion;

	@Value("${tipo.operacion}")
	public String TIPO_OPERACION;
	@Value("${correo.mensaje.portabilidad.prepago}")
	public String CORREO_MENSAJE_PORTABILIDAD_PREPAGO;
    @Value("${flag.mandatorio.correo}") 
	public String VALOR_CAMPO_CORREO_VALIDACION;

    @Value("${correo.destino}") 
	public String CorreoDestino;



    @Value("${jms.connectionfactory.jndi}")
	public String jmsCF;

    @Value("${jms.queue.jndi.postventa.activaDesactivaBonosVentaQueue.error}")
    public String jmsQueueActualizaEstadoBonoError;
    
    @Value("${jms.provider.url}")
	public String jmsProviderUrl;





	

}

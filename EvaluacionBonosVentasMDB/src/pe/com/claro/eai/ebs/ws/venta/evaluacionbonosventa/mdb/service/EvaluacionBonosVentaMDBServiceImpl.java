package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.ejb.MessageDrivenContext;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosResponse;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarContratosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarContratosRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarContratosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ConsultarDatosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ContratoConsultaType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.CustomerConsultaType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.DatosClienteBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.DatosOperacionBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HeaderRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HisBloq;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.LineaBaseBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.LineaBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ListaOperador;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Plataforma;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ProductosConsultaType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ResponseAuditType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.RetrieveSubscriptionsBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.RetrieveSubscriptionsResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Rol;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ServiciosAdicionales;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Suscripciones;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.TicklersConsultaType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.ConsultaCliente;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.ConsultarContrato;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.ValidarLineasClienteWS;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.client.email.EnvioCorreoSBClient;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl.BscsDao;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl.DwhDAO;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl.GwpDao;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl.OacDAO;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl.TimeaiDAO;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.ejb.EvaluacionBonosVentaMDB;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.ErrorFuncionalException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.WSException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.jms.JMSSendMessage;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.EvaluacionVentasRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.HeaderRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.ListaDatosLineaRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.ListaServiciosAdicionalesRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.request.ListaSuscripcionesRequestType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.responseslocals.ErrorDetailType;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Retorno;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Util;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Utilitarios;
import pe.com.claro.eai.util.enviocorreo.types.EnviarCorreoResponse;
import pe.com.claro.eai.validarlineascliente.ws.types.AuditRequest;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasRequest;
import pe.com.claro.eai.validarlineascliente.ws.types.ContarLineasResponse;
import pe.com.claro.eai.validarlineascliente.ws.types.ListaLineasConsolidadasType.LineaConsolidada;

@Service
public class EvaluacionBonosVentaMDBServiceImpl implements EvaluacionBonosVentaMDBService {

	@Autowired
	private TimeaiDAO timeaiDAO;

	@Autowired
	private BscsDao bscsDao;

	@Autowired
	private DwhDAO dwhDAO;

	@Autowired
	private OacDAO oacDAO;

	@Autowired
	private GwpDao gwpDAO;

	@Autowired
	private ExternalProperties constantesExternos;

	@Autowired
	private ConsultaCliente consultaCliente;

	@Autowired
	private ConsultarContrato consultarContrato;

	@Autowired
	private ValidarLineasClienteWS validarLineasClienteWS;

	@Autowired
	EnvioCorreoSBClient envioCorreoSBClient;

	@Autowired
	private JMSSendMessage jMSSendMessage;

	public static transient org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(EvaluacionBonosVentaMDB.class);

	private MessageDrivenContext context;

	public void setMessageDrivenContext(MessageDrivenContext mycontext) {
		context = mycontext;
	}

	public EvaluacionBonosVentaMDBServiceImpl() {
		super();
		logger.info("*** 'MDB' [EvaluacionBonosVentaMDB] - Inicializado ... ***");
	}

	@Override
	public void iniciarService(String mensajeTransaccion, EvaluacionVentasRequest request, String messageID) {

		final long vTiempoProceso = System.currentTimeMillis();
		PagoPuntualResponse pagoPuntualResponse = new PagoPuntualResponse();

		try {

			boolean obtenerBonos = false;

			mensajeTransaccion = "  [EvaluacionBonosVentaMDB IdTx="
					+ request.getHeaderRequestType().getIdBusinessTransaction() + "]";

			XMLGregorianCalendar fechaInicio = request.getHeaderRequestType().getStartDate();

			logger.info(mensajeTransaccion + "[INICIO de metodo onMessage]");
			logger.info(mensajeTransaccion + "OBJETO [INPUT]: " + JAXBUtilitarios.anyObjectToXmlText(request));

			try {
				logger.info(mensajeTransaccion + "-------------------------------------------------------------------");
				logger.info(mensajeTransaccion + "===================================================================");
				logger.info(mensajeTransaccion
						+ "============== [INICIO] 1. Validar parametros adicionales ==============");
				logger.info(mensajeTransaccion + "===================================================================");

				RetrieveSubscriptionsResponse retrieveSubscriptionsResponse = new RetrieveSubscriptionsResponse();
				retrieveSubscriptionsResponse.setListaSubscriptions(new ArrayList<RetrieveSubscriptionsBean>());

				ContarLineasResponse contarLineasResponse = new ContarLineasResponse();
				ConsultarContratosResponse consultarContratosResponse = new ConsultarContratosResponse();

				ConsultarDatosResponse consultarDatosResponse = new ConsultarDatosResponse();
				ObtenerOperadorCedenteResponse obtenerOperadorCedenteResponse = new ObtenerOperadorCedenteResponse();
				List<ListaOperador> listaOperadores = new ArrayList<ListaOperador>();
				List<Rol> listaRoles = new ArrayList<Rol>();

				ExtraePlataformasRequest extraePlataformasRequest = new ExtraePlataformasRequest();
				ExtraePlataformasResponse extraePlataformasResponse = new ExtraePlataformasResponse();
				extraePlataformasRequest.setTipoOperacion(request.getDatosOperacion().getTipoOperacion());
				extraePlataformasResponse = bscsDao.extraePlataformas(mensajeTransaccion, extraePlataformasRequest);

				logger.info(
						mensajeTransaccion + "=====================================================================");
				logger.info(
						mensajeTransaccion + "============== [FIN] 1. Validar parametros adicionales ==============");
				logger.info(
						mensajeTransaccion + "=====================================================================");

				boolean forzarsinplataforma = false;
				forzarsinplataforma = constantesExternos.forzarsinplataformas.equals("") ? true
						: Boolean.parseBoolean(constantesExternos.forzarsinplataformas);
				if (Constantes.CADENA_CERO.equals(extraePlataformasResponse.getCodRespuesta())) {
					if (extraePlataformasResponse.getPlataformas() == null
							|| extraePlataformasResponse.getPlataformas().size() == 0 || forzarsinplataforma) {
						obtenerBonos = true;

					} else {

						HeaderRequest headerRequest = new HeaderRequest();
						headerRequest.setAccept(constantesExternos.headerRequestAccept);
						headerRequest.setChannel(request.getHeaderRequestType().getChannel());
						headerRequest.setIdApplication(request.getHeaderRequestType().getUserApplication());
						headerRequest.setIdTransaccion(request.getHeaderRequestType().getIdBusinessTransaction());
						headerRequest.setMsgid(constantesExternos.headerRequestMsgid);
						headerRequest.setTimestamp(Utilitarios
								.convertGregorianCalendarToString(request.getHeaderRequestType().getStartDate()));
						headerRequest.setUserId(request.getHeaderRequestType().getUserSession());
						boolean validacionOutput = true;
						for (Plataforma plt : extraePlataformasResponse.getPlataformas()) {
							// ahg plataforma1 rest

							// MSB INI
							if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaInterfaceVenta1)) {
								// if ("1".equals(Constantes.VALOR_UNO)) {

								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 2. Obtener Parametros (consultarDatosCliente) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");
								consultarDatosResponse = new ConsultarDatosResponse();

								consultarDatosResponse = consultarDatos(
										request.getHeaderRequestType().getIdESBTransaction(), constantesExternos,
										request, headerRequest);

								validacionOutput = validacionPlataformaobligatorios(
										request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
										consultarDatosResponse, consultarContratosResponse, contarLineasResponse, null,
										obtenerOperadorCedenteResponse, pagoPuntualResponse, constantesExternos,
										messageID);

								obtenerBonos = validacionOutput;

								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 2. Obtener Parametros (consultaDatosClientes) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");
								// break;
							}

							else if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaInterfaceVenta2)) {
								// else if ("2".equals(Constantes.VALOR_DOS)) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 3. Obtener Parametros (consultarDatosContrato) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

								consultarContratosResponse = new ConsultarContratosResponse();

								consultarContratosResponse = consultarContrato(
										request.getHeaderRequestType().getIdESBTransaction(), constantesExternos,
										request, headerRequest);

								validacionOutput = validacionPlataformaobligatorios(
										request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
										consultarDatosResponse, consultarContratosResponse, contarLineasResponse, null,
										obtenerOperadorCedenteResponse, pagoPuntualResponse, constantesExternos,
										messageID);

								obtenerBonos = validacionOutput;

								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 3. Obtener Parametros (consultarDatosContrato) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

							}

							else if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaInterfaceVenta3)) {
								// else if (4 == 4) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 4. Obtener Parametros (ValidarLineasClienteWS) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

								ResponseAuditType auditType = new ResponseAuditType();

								contarLineasResponse = new ContarLineasResponse();

								contarLineasResponse = validarLineasClienteWS(
										request.getHeaderRequestType().getIdESBTransaction(), request,
										constantesExternos);

				
								validacionOutput = validacionPlataformaobligatorios(
										request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
										consultarDatosResponse, consultarContratosResponse, contarLineasResponse, null,
										obtenerOperadorCedenteResponse, pagoPuntualResponse, constantesExternos,
										messageID);
								
								logger.info(mensajeTransaccion + "-> " + validacionOutput );
								
								obtenerBonos = validacionOutput;
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 4. Obtener Parametros (ValidarLineasClienteWS) ==============");

							}

							// MSB FIN

							else if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaDWH)) {

								// else if (5==5) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 4. Obtener Parametros (DWH) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");
								IndicCharltRequest indicCharltRequest = new IndicCharltRequest();
								IndicCharltResponse indicCharltResponse = new IndicCharltResponse();

								for (ListaDatosLineaRequestType lb : request.getDatosLinea()) {
									indicCharltRequest.setNroTelefono(lb.getLinea());
									indicCharltResponse = dwhDAO.indicCharlt(mensajeTransaccion, indicCharltRequest);

									validacionOutput = validacionPlataformaobligatorios(
											request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
											consultarDatosResponse, consultarContratosResponse, contarLineasResponse,
											indicCharltResponse, obtenerOperadorCedenteResponse, pagoPuntualResponse,
											constantesExternos, messageID);
									obtenerBonos = validacionOutput;
									if (indicCharltResponse != null) {
										if (indicCharltResponse.getCodRespuesta()
												.equals(Constantes.CONSTANTE_VALOR_0)) {
											if (indicCharltResponse.getRol() != null) {
												if (indicCharltResponse.getRol().size() > 0) {
													for (int n = 0; n < indicCharltResponse.getRol().size(); n++) {
														Rol rol = new Rol();
														rol.setLinea(lb.getLinea());
														rol.setRol(indicCharltResponse.getRol().get(n).getRol());
														listaRoles.add(rol);
													}
												}
											}
										}

									}
								}

								
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 4. Obtener Parametros (DWH) ==============");
							}

							else if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaGWP)) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 10. Obtener Operador cedente (GWP) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

								ObtenerOperadorCedenteRequest obtenerOperadorCedenteRequest = new ObtenerOperadorCedenteRequest();

								String documentType = "";

								if (request.getDatosLinea() != null || !request.getDatosLinea().isEmpty()
										|| request.getDatosLinea().size() > 0) {

									TreeMap<String, String> mapTipoDocumento = JAXBUtilitarios.obtenerMapReemplazos(
											constantesExternos.dbGwpSpObtenerOperadorCedenteTipoDocumento,
											Constantes.PARAMETRO_DELIMITADOR_BARRA, Constantes.VALOR_IGUAL);
									documentType = (mapTipoDocumento
											.containsKey(request.getDatosCliente().getTipoDocumento())
													? mapTipoDocumento.get(request.getDatosCliente().getTipoDocumento())
													: request.getDatosCliente().getTipoDocumento());

									obtenerOperadorCedenteRequest
											.setNumeroDocumento(request.getDatosCliente().getNumeroDocumento());
									obtenerOperadorCedenteRequest.setTipoDocumento(documentType);
									for (ListaDatosLineaRequestType lb : request.getDatosLinea()) {

										String linea = lb.getLinea();
										String lineaNacional = "";
										if (lb.getLinea().substring(0, 2).equals(Constantes.LINEA_INTERNACIONAL)) {
											lineaNacional = lb.getLinea().substring(2, lb.getLinea().length());
										} else {
											lineaNacional = linea;
										}
										obtenerOperadorCedenteRequest.setNumeroAPortar(lineaNacional);

										obtenerOperadorCedenteResponse = gwpDAO.obtenerOperadorCedente(
												mensajeTransaccion, obtenerOperadorCedenteRequest);

										validacionOutput = validacionPlataformaobligatorios(
												request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
												consultarDatosResponse, consultarContratosResponse,
												contarLineasResponse, null, obtenerOperadorCedenteResponse,
												pagoPuntualResponse, constantesExternos, lineaNacional);

										
										obtenerBonos=validacionOutput;
										
										if (obtenerOperadorCedenteResponse.getCodError()
												.equals(Constantes.CONSTANTE_VALOR_0)) {
											if (obtenerOperadorCedenteResponse.getListaOperador() != null) {
												if (obtenerOperadorCedenteResponse.getListaOperador().size() > 0) {
													for (int b = 0; b < obtenerOperadorCedenteResponse
															.getListaOperador().size(); b++) {
														ListaOperador listaOperador = new ListaOperador();
														listaOperador.setCedente(obtenerOperadorCedenteResponse
																.getListaOperador().get(b).getCedente());
														listaOperador.setFechaActivaCedente(
																obtenerOperadorCedenteResponse.getListaOperador().get(b)
																		.getFechaActivaCedente());
														listaOperador.setLinea(lb.getLinea());
														listaOperadores.add(listaOperador);
													}
												}
											}

										}

									}

								} else {
									logger.info(mensajeTransaccion + "No cuenta con Datos de Linea");
									////////////////////////////////////////////
								}
								//obtenerBonos = true;
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 10. Obtener Operador cedente (GWP) ==============");
							} else if (plt.getNombre().equals(constantesExternos.dbBscsPlataformaOac)) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 11. Obtener Parametros (OAC) ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

								PagoPuntualRequest pagoPuntualRequest = new PagoPuntualRequest();

								pagoPuntualRequest.setCustomerId(request.getDatosCliente().getCustomerID());
								pagoPuntualRequest.setCantidadMeses(
										Integer.parseInt(constantesExternos.dbOacSpPagoPuntualCantidadMeses));

								pagoPuntualResponse = oacDAO.pagoPuntual(mensajeTransaccion, pagoPuntualRequest);

								validacionOutput = validacionPlataformaobligatorios(
										request.getHeaderRequestType().getIdESBTransaction(), plt.getNombre(),
										consultarDatosResponse, consultarContratosResponse, contarLineasResponse, null,
										obtenerOperadorCedenteResponse, pagoPuntualResponse, constantesExternos,
										messageID);

								obtenerBonos = validacionOutput;
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 11. Obtener Parametros (OAC) ==============");
							} else {
								obtenerBonos = true;
							}

							
							if(obtenerBonos==false)
							{
								//romper el for
								break;
							}
						}

					}

				} else {
					// Si no encientra data igual va a la actividad 5
					obtenerBonos = true;
				}

				if (obtenerBonos) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					ObtenerBonosRequest obtenerBonosRequest = new ObtenerBonosRequest();
					ObtenerBonosResponse obtenerBonosResponse = new ObtenerBonosResponse();

					DatosClienteBean datosClienteBean = new DatosClienteBean();
					datosClienteBean.setCustomerIdExt(request.getDatosCliente().getCustomerIDPub());
					datosClienteBean.setBillingAccount(request.getDatosCliente().getBillingAccount());
					datosClienteBean.setCicloFact(request.getDatosCliente().getCicloFacturacion());
					datosClienteBean.setSegmentoCliente(request.getDatosCliente().getSegmentoCliente());

					datosClienteBean.setTipoDocumento(request.getDatosCliente().getTipoDocumento());
					datosClienteBean.setNumeroDocumento(request.getDatosCliente().getNumeroDocumento());

					String fecNacimiento = Utilitarios
							.convertGregorianCalendarToString(request.getDatosCliente().getFechaNacimiento());
					Date datefecNacimiento = Util.cadenaAFecha(fecNacimiento);
					datosClienteBean.setFecNacimiento(datefecNacimiento != null ? datefecNacimiento : null);
					datosClienteBean.setGenero(request.getDatosCliente().getGenero());

					String fechaAltaCliente = Utilitarios
							.convertGregorianCalendarToString(request.getDatosCliente().getFechaAltaCliente());
					Date dateAlta = Util.cadenaAFecha(fechaAltaCliente);
					datosClienteBean.setFechaAltaCliente(dateAlta != null ? dateAlta : null);

					if (request.getDatosCliente().getComportamientoPago() != null
							&& request.getDatosCliente().getComportamientoPago() != Constantes.VACIO) {
						datosClienteBean.setComportamientoPago(
								Integer.parseInt(request.getDatosCliente().getComportamientoPago()));
					} else {
						datosClienteBean.setComportamientoPago(null);
					}
					datosClienteBean.setScoreInterconex(null);

					if (pagoPuntualResponse.getIndicadorPp() != null) {
						datosClienteBean.setPago_puntual(pagoPuntualResponse.getIndicadorPp());
					} else {
						datosClienteBean.setPago_puntual(null);
					}

					int cantLineaPrePago = 0;
					int cantLineaPostPago = 0;

					if (contarLineasResponse != null && contarLineasResponse.getListaLineasConsolidadasType() != null
							&& !contarLineasResponse.getListaLineasConsolidadasType().getLineaConsolidada().isEmpty()) {
						for (LineaConsolidada linea : contarLineasResponse.getListaLineasConsolidadasType()
								.getLineaConsolidada()) {
							if (linea.getSegmento().equals(Constantes.SEGMENTO_POS))
								cantLineaPostPago++;
							else if (linea.getSegmento().equals(Constantes.SEGMENTO_PREPAGOCONSUMER))
								cantLineaPrePago++;
						}

					}

					// String nroLineaRepPost = "";
					// String nroLineaRepPre = "";

					logger.info(mensajeTransaccion + "[CantLineaPrepago] = " + cantLineaPrePago);
					logger.info(mensajeTransaccion + "[CantLineaPostpago] = " + cantLineaPostPago);

					datosClienteBean.setCantLineaPrepago(1.0 * cantLineaPrePago);
					datosClienteBean.setCantLineaPostpago(1.0 * cantLineaPostPago);
					/* MOCK CERO */
					datosClienteBean.setCantLineaServFijoTot(0.0);
					datosClienteBean.setCantPortaMovil(0.0);
					datosClienteBean.setCantPortaFijo(0.0);
					datosClienteBean.setCustomerIdExt(request.getDatosCliente().getCustomerIDPub());
					datosClienteBean.setCustomerIdInt(Integer.parseInt(request.getDatosCliente().getCustomerID()));

					DatosOperacionBean datosOperacionBean = new DatosOperacionBean();
					datosOperacionBean.setShoppingCartId(request.getDatosOperacion().getShoppingCartID());
					datosOperacionBean.setAppOrigen(request.getDatosOperacion().getAppOrigen());
					datosOperacionBean.setCanal(request.getDatosOperacion().getCanal());
					datosOperacionBean.setTipoOperacion(request.getDatosOperacion().getTipoOperacion());
					datosOperacionBean.setFecTransaccion(Utilitarios
							.convertGregorianCalendarToString(request.getDatosOperacion().getFechaTransaccion()));
					datosOperacionBean.setModalidadVenta(request.getDatosOperacion().getModalidadVenta());
					datosOperacionBean.setCodPuntoVenta(request.getDatosOperacion().getCodigoPuntoVenta());
					datosOperacionBean.setCodDeptPv(request.getDatosOperacion().getCodDepartamentoPV());
					datosOperacionBean.setCodProvPv(request.getDatosOperacion().getCodProvinciaPV());
					datosOperacionBean.setCodDistPv(request.getDatosOperacion().getCodDistritoPV());
					datosOperacionBean.setCodDeptFac(request.getDatosOperacion().getCodDepartamentoFac());
					datosOperacionBean.setCodProvFac(request.getDatosOperacion().getCodProvinciaFac());
					datosOperacionBean.setCodDistFac(request.getDatosOperacion().getCodDistritoFac());
					datosOperacionBean.setCodDistFac(request.getDatosOperacion().getFlagActivacionDirecta());

					List<LineaBean> listaLinea = new ArrayList<LineaBean>();
					for (ListaDatosLineaRequestType lb : request.getDatosLinea()) {
						LineaBean lineaBean = new LineaBean();

						lineaBean.setLinea(lb.getLinea());

						lineaBean.setPoId(lb.getPoID());
						lineaBean.setPoName(lb.getPoName());
						lineaBean.setIccid(lb.getIccid());
						lineaBean.setCantDecos(
								(lb.getCantidadDecos() != null) ? Integer.parseInt(lb.getCantidadDecos()) : 0);
						lineaBean.setCasoEspecial(lb.getCasoEspecial());
						lineaBean.setCampania(lb.getCampana());
						lineaBean.setTope(lb.getTope());
						lineaBean.setSuscripcionCorreo(lb.getSuscripcionCorreo());
						lineaBean.setLineaReferente(lb.getLineaReferente());
						lineaBean.setCodDeptIns(lb.getCodDepartamentoIns());
						lineaBean.setCodProvIns(lb.getCodProvinciaIns());
						lineaBean.setCodDistIns(lb.getCodDistritoIns());
						lineaBean.setMarcaEquipo(lb.getMarcaEquipo());
						lineaBean.setModeloEquipo(lb.getModeloEquipo());
						lineaBean.setContractId(lb.getContractID());
						lineaBean.setPrecioVentaEquipo(Double.parseDouble(lb.getPrecioVentaEquipo()));
						lineaBean.setContractId(lb.getContractID());
						lineaBean.setContractIdbscs(lb.getContractIdPub());

						if (listaRoles.size() > 0) {
							for (int l1 = 0; l1 < listaRoles.size(); l1++) {
								if (lb.getLinea().equals(listaRoles.get(l1).getLinea())) {
									lineaBean.setClasiCharlotte(String.valueOf(listaRoles.get(l1).getRol()));
								}
							}
						} else {
							lineaBean.setClasiCharlotte(null);
						}

						if (listaOperadores.size() > 0) {
							for (int l = 0; l < listaOperadores.size(); l++) {
								if (lb.getLinea().equals(listaOperadores.get(l).getLinea())) {
									lineaBean.setOperCedente(listaOperadores.get(l).getCedente());
									// String fecNacimiento =
									// Utilitarios.convertGregorianCalendarToString(evaluacionBonosVentaRequest.getDatosCliente().getFechaNacimiento());
									// datosClienteBean.setFecNacimiento(!fecNacimiento.isEmpty() ?
									// fecNacimiento : null);

									lineaBean.setFecActOperCedente(listaOperadores.get(l).getFechaActivaCedente());
								}
							}
						} else {
							lineaBean.setOperCedente(null);
							lineaBean.setFecActOperCedente(null);
						}

						List<Suscripciones> listaSuscripciones = new ArrayList<Suscripciones>();
						Suscripciones susc = null;
						for (ListaSuscripcionesRequestType sct : lb.getSuscripciones()) {
							susc = new Suscripciones();
							susc.setTipoProducto(sct.getTipoProducto());
							susc.setTipoTecnologia(sct.getTipoTecnologia());
							susc.setTipoSuscripcion(sct.getTipoSuscripcion());
							// susc.setBundleID(sct.getBundleID());
							susc.setModalidadPago(sct.getModalidadPago());
							susc.setCargoFijoPlan(
									(sct.getCargoFijoPlan() != null) ? Double.parseDouble(sct.getCargoFijoPlan()) : 0);
							susc.setPlazoContrato(sct.getPlazoContrato());
							listaSuscripciones.add(susc);
						}

						List<ServiciosAdicionales> listaServiciosAdicionales = new ArrayList<ServiciosAdicionales>();
						ServiciosAdicionales srv = null;
						for (ListaServiciosAdicionalesRequestType srvt : lb.getServiciosAdicionales()) {
							srv = new ServiciosAdicionales();
							srv.setPoId(srvt.getPoID());
							srv.setTipoPO(srvt.getTipoPO());
							listaServiciosAdicionales.add(srv);
						}

						lineaBean.setListaSuscripciones(listaSuscripciones);
						lineaBean.setListaServiciosAdicionales(listaServiciosAdicionales);
						lineaBean.setBonos(null);
						listaLinea.add(lineaBean);
					}

					List<LineaBaseBean> listaLineaBase = new ArrayList<LineaBaseBean>();

					if (consultarContratosResponse.getConsultarContratosResponse() != null) {
						if (consultarContratosResponse.getConsultarContratosResponse().getResponseAudit()
								.getCodigoRespuesta() != null) {
							if (consultarContratosResponse.getConsultarContratosResponse().getResponseAudit()
									.getCodigoRespuesta().equals(Constantes.CONSTANTE_VALOR_0)) {
								for (CustomerConsultaType customerCon : consultarContratosResponse
										.getConsultarContratosResponse().getResponseData().getCustomer()) {
									for (ContratoConsultaType contratoConsultaType : customerCon.getContratos()) {

										// LineaBean lineaBean = new LineaBean();
										LineaBaseBean lineaBaseBean = new LineaBaseBean();
										List<HisBloq> listaHisBloqueo = new ArrayList<HisBloq>();
										HisBloq hB = null;

										lineaBaseBean.setContractIdBase(contratoConsultaType.getCoId());
										lineaBaseBean.setLineaBase(contratoConsultaType.getDirNum());

										if (consultarDatosResponse != null
												&& consultarDatosResponse.getConsultarDatosResponse() != null
												&& !consultarDatosResponse.getConsultarDatosResponse().getResponseData()
														.getCustomer().isEmpty())

										{
											for (CustomerConsultaType customerCD : consultarDatosResponse
													.getConsultarDatosResponse().getResponseData().getCustomer()) {
												if (customerCD.getCustomerId().equals(customerCon.getCustomerId())) {

													for (ContratoConsultaType contratoDato : customerCD
															.getContratos()) {
														{

															if (!contratoDato.getProductos().isEmpty()) {
																for (ProductosConsultaType productoCD : contratoDato
																		.getProductos()) {
																	lineaBaseBean.setPoIdBase(
																			productoCD.getProductOfferingId());
																}
															}

															if (contratoDato.getCoIdPub()
																	.equals(contratoConsultaType.getCoId())) {
																for (TicklersConsultaType tk : contratoDato
																		.getTicklers()) {
																	hB = new HisBloq();

																	hB.setFechaCreacionBloq(
																			new SimpleDateFormat("dd/MM/yyyy")
																					.parse(tk.getCreationDate()));
																	hB.setTickShdesBloq(tk.getTickShdes());
																	hB.setTickLdesBloq(tk.getTickLdes());
																	hB.setFechaCierreBloq(
																			new SimpleDateFormat("dd/MM/yyyy")
																					.parse(tk.getClosedDate()));
																	hB.setTickCodigoBloq(tk.getTickCode());
																	hB.setTickEstadobloq(tk.getTickStatus());
																	hB.setIdRazonbloq(tk.getTickLdes());

																	listaHisBloqueo.add(hB);
																	lineaBaseBean.setListaHisBloqueo(listaHisBloqueo);

																}

															}
														}
													}
												}
											}
										}

										lineaBaseBean.setPoNameBase("");

										lineaBaseBean.setCustomerIdExtBase(customerCon.getCustomerIdPub());
										lineaBaseBean.setBillingAccountBase(contratoConsultaType.getBillingAccountId());

										lineaBaseBean.setCargoFijoPlanBase(Double.parseDouble(consultarDatosResponse
												.getConsultarDatosResponse().getResponseData().getCargoFijo()));

										lineaBaseBean.setTipoProductoBase(constantesExternos.tipo_producto_base);
										lineaBaseBean.setTipoSuscripcionBase(constantesExternos.tipo_subscripcion_base);

										Date fecAct = format.parse(contratoConsultaType.getCoActivated());

										lineaBaseBean.setFecActivacionBase(fecAct);
										lineaBaseBean.setEstadoLineaBase(contratoConsultaType.getCoStatus());

									}
								}
							}
						}
					}

					obtenerBonosRequest.setDatosClientes(datosClienteBean);
					obtenerBonosRequest.setDatosOperacion(datosOperacionBean);
					obtenerBonosRequest.setListaLineaBase(listaLineaBase);
					obtenerBonosRequest.setListaLinea(listaLinea);

					logger.info(
							mensajeTransaccion + "===================================================================");
					logger.info(mensajeTransaccion + "============== [INICIO] 12. Obtener Bonos ==============");
					logger.info(
							mensajeTransaccion + "===================================================================");

					obtenerBonosResponse = bscsDao.obtenerBonos(mensajeTransaccion, obtenerBonosRequest);
					logger.info(
							mensajeTransaccion + "===================================================================");
					logger.info(mensajeTransaccion + "============== [Fin] 12. Obtener Bonos ==============");
					logger.info(
							mensajeTransaccion + "===================================================================");

					if (Constantes.CADENA_CERO.equals(obtenerBonosResponse.getCodRespuesta())) {
						boolean flagActivacionDirecta = false;

						flagActivacionDirecta = Boolean.parseBoolean(constantesExternos.flagActivacionDirecta);
						if (!flagActivacionDirecta) {
							if (obtenerBonosResponse.getLinea().size() > 0) {
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [INICIO] 13. Registrar tabla Callback ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");
								// 6. Registrar tabla Callback
								InsertOperacionRequest insertOperacionRequest = new InsertOperacionRequest();
								InsertOperacionResponse insertOperacionResponse = new InsertOperacionResponse();

								Date fecha = new Date();
								insertOperacionRequest.setIdOrden(constantesExternos.idOrdenRequest
										+ request.getDatosOperacion().getShoppingCartID());
								insertOperacionRequest.setTransac(constantesExternos.transacRequest);
								insertOperacionRequest.setFecha(fecha);
								insertOperacionRequest.setEstado(constantesExternos.estadoRequest);
								insertOperacionRequest.setProdInstan(constantesExternos.prodInstanRequest);
								insertOperacionRequest.setUsrModif(request.getHeaderRequestType().getUserApplication());

								insertOperacionResponse = timeaiDAO.insertOperacion(mensajeTransaccion,
										insertOperacionRequest);
								logger.info(mensajeTransaccion
										+ "===================================================================");
								logger.info(mensajeTransaccion
										+ "============== [FIN] 13. Registrar tabla Callback ==============");
								logger.info(mensajeTransaccion
										+ "===================================================================");

								if (Constantes.CADENA_CERO.equals(insertOperacionResponse.getCodError())) {
									logger.info(mensajeTransaccion + Constantes.CERO);
									logger.info(mensajeTransaccion + "CodeResponse:" + constantesExternos.codigoIdf0);
									logger.info(mensajeTransaccion + "Date:" + fechaInicio);
									logger.info(mensajeTransaccion + "DescriptionResponse: "
											+ constantesExternos.mensajeIdf0);

								} else {
									throw new ErrorFuncionalException(constantesExternos.codigoIdf3,
											constantesExternos.mensajeIdf3, null, constantesExternos.ubicacionIdf3,
											null);
								}

							}
						} else { // nuevo metodo
							logger.info(mensajeTransaccion
									+ "===================================================================");
							logger.info(mensajeTransaccion
									+ "============== [INICIO] 13. Actualizar evaluacion bonos ==============");
							logger.info(mensajeTransaccion
									+ "===================================================================");
							// 6. Registrar tabla Callback
							ActualizarEvaluacionBonosRequest actualizarEvaluacionBonosRequest = new ActualizarEvaluacionBonosRequest();
							ActualizarEvaluacionBonosResponse actualizarEvaluacionBonosResponse = new ActualizarEvaluacionBonosResponse();

							// Date fecha = new Date();

							actualizarEvaluacionBonosRequest.setPi_order_id(null);
							actualizarEvaluacionBonosRequest.setPi_accion_id(null);
							actualizarEvaluacionBonosRequest.setPi_estado_om(constantesExternos.ActualizaEstado);
							actualizarEvaluacionBonosRequest.setFecCreaOm(new Date());
							actualizarEvaluacionBonosRequest.setFecIniProcOm(new Date());
							actualizarEvaluacionBonosRequest.setFecFinProcOm(new Date());
							actualizarEvaluacionBonosRequest
									.setPi_shopping_cart_id(request.getDatosOperacion().getShoppingCartID());

							actualizarEvaluacionBonosResponse = bscsDao.actualizarEvaluacionBonos(mensajeTransaccion,
									actualizarEvaluacionBonosRequest);
							logger.info(mensajeTransaccion
									+ "===================================================================");
							logger.info(mensajeTransaccion
									+ "============== [FIN] 13. Actualizar evalacion bonos ==============");
							logger.info(mensajeTransaccion
									+ "===================================================================");

							if (Constantes.CADENA_CERO.equals(actualizarEvaluacionBonosResponse.getCodigo())) {
								logger.info(mensajeTransaccion + Constantes.CERO);
								logger.info(mensajeTransaccion + "CodeResponse:" + constantesExternos.codigoIdf0);
								logger.info(mensajeTransaccion + "Date:" + fechaInicio);
								logger.info(
										mensajeTransaccion + "DescriptionResponse: " + constantesExternos.mensajeIdf0);

							} else {

								logger.info(mensajeTransaccion + actualizarEvaluacionBonosResponse.getCodigo());
								logger.info(mensajeTransaccion + "CodeResponse:"
										+ actualizarEvaluacionBonosResponse.getCodigo());
								logger.info(mensajeTransaccion + "Date:" + fechaInicio);
								logger.info(mensajeTransaccion + "DescriptionResponse: "
										+ actualizarEvaluacionBonosResponse.getMensaje());

							}

						}
					} else {
						throw new ErrorFuncionalException(constantesExternos.codigoIdf2, constantesExternos.mensajeIdf2,
								null, constantesExternos.ubicacionIdf2, null);
					}
				} else {

					logger.info(mensajeTransaccion + "[Envio a la cola de error]");
					jMSSendMessage.sendTextMessageErrorEvaluacionVentaBonoMDBxIDF(mensajeTransaccion, request);
					// throw new ErrorFuncionalException(constantesExternos.codigoIdf2,
					// constantesExternos.mensajeIdf2,
					// null, constantesExternos.ubicacionIdf2, null);

				}

			} catch (ErrorFuncionalException ve) {

				logger.info(mensajeTransaccion + Constantes.STATUS_ERROR);
				logger.info(mensajeTransaccion + "code:" + ve.getCode());
				logger.info(mensajeTransaccion + "Date" + fechaInicio);
				logger.info(mensajeTransaccion + "DescriptionResponse" + ve.getMessage());
				logger.info(mensajeTransaccion + "ErrorLocation" + ve.getUbicacionError());
				logger.info(mensajeTransaccion + "Origin" + ve.getOrigenError());

			} catch (Exception e) {
				logger.error("ERROR: ", e);

				logger.info(mensajeTransaccion + Constantes.STATUS_ERROR);
				logger.info(mensajeTransaccion + "code:" + constantesExternos.codigoIdt3);
				logger.info(mensajeTransaccion + "Date:" + fechaInicio);
				logger.info(mensajeTransaccion + "DescriptionResponse:" + e.getMessage() + " "
						+ constantesExternos.mensajeIdt3.replaceAll(Constantes.IDENTIFICADOR_MSG_ERROR,
								e.getMessage()));
				logger.info(mensajeTransaccion + "ErrorLocation:");
				logger.info(mensajeTransaccion + "Origin" + e);

				logger.info("-----------------------------------------------------------------------------");
				//
				// context.setRollbackOnly();
			}

		} catch (Exception e) {
			logger.error(mensajeTransaccion + "[ERROR]" + Util.SALTOLINEA, e);
			// context.setRollbackOnly();
		} finally {
			logger.info(mensajeTransaccion + "[FIN de metodo onMessage]" + "Tiempo total de proceso(ms): "
					+ (System.currentTimeMillis() - vTiempoProceso) + " milisegundos");
			// context.setRollbackOnly();
		}

	}

	private boolean validacionPlataformaobligatorios(String idTransaccion, String nombre,
			ConsultarDatosResponse consultarDatosResponse, ConsultarContratosResponse consultarContratosResponse,
			ContarLineasResponse contarLineasResponse, IndicCharltResponse indicCharltResponse,
			ObtenerOperadorCedenteResponse obtenerOperadorCedenteResponse, PagoPuntualResponse pagoPuntualResponse,
			ExternalProperties externalProperties, String mensajeTransaccion) {
		// TODO Auto-generated method stub
		String mensaje = "No ok";
		boolean validacion = true;

		switch (nombre) {
		case Constantes.INTERFACE_VENTA_1:

			// consulta datos cliente
			if (consultarDatosResponse.getConsultarDatosResponse().getResponseAudit().getCodigoRespuesta()
					.equals(Constantes.CADENA_CERO)) {
				if (consultarDatosResponse.getConsultarDatosResponse().getResponseData().getCustomer().isEmpty()) {

					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_1);
					mensaje = mensaje.replace(";campo;", consultarDatosResponse.getConsultarDatosResponse().getResponseData()
							.getCustomer().getClass().getName());
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

					validacion = false;
					
				}

			} else {

				logger.info(
						mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.INTERFACE_VENTA_1);

				mensaje = Constantes.EMAILPLATFORMNO0.toString();
				mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_1);
				mensaje = mensaje.replace(";idf;",
						consultarDatosResponse.getConsultarDatosResponse().getResponseAudit().getCodigoRespuesta());
				mensaje = mensaje.replace(";idfmensaje;",
						consultarDatosResponse.getConsultarDatosResponse().getResponseAudit().getMensajeRespuesta());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);
				validacion = false;
			}

			break;

		case Constantes.INTERFACE_VENTA_2:
			// consulta datos cliente
			if (consultarContratosResponse.getConsultarContratosResponse().getResponseAudit().getCodigoRespuesta()
					.equals(Constantes.CADENA_CERO)) {

				if (consultarContratosResponse.getConsultarContratosResponse().getResponseData().getCustomer()
						.isEmpty()) {
					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_2);
					mensaje = mensaje.replace(";campo;", consultarContratosResponse.getConsultarContratosResponse()
							.getResponseData().getCustomer().getClass().getName());
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);
					validacion = false;
				}

			} else {

				logger.info(
						mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.INTERFACE_VENTA_1);

				mensaje = Constantes.EMAILPLATFORMNO0;
				mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_2);
				mensaje = mensaje.replace(";idf;", consultarContratosResponse.getConsultarContratosResponse().getResponseAudit()
						.getCodigoRespuesta());
				mensaje = mensaje.replace(";idfmensaje;", consultarContratosResponse.getConsultarContratosResponse()
						.getResponseAudit().getMensajeRespuesta());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);
				validacion = false;
			}

			break;
		case Constantes.INTERFACE_VENTA_3:
			// consulta datos cliente
			if (contarLineasResponse.getAuditResponse().getCodRespuesta().equals(Constantes.CADENA_CERO)) {

				if (contarLineasResponse.getListaLineasConsolidadasType().getLineaConsolidada().isEmpty()) {
					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_3);
					mensaje = mensaje.replace(";campo;", contarLineasResponse.getAuditResponse().getMsjRespuesta());
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);
					validacion = false;
				}
			} else {

				logger.info(
						mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.INTERFACE_VENTA_3);

				mensaje = Constantes.EMAILPLATFORMNO0;
				mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA_3);
				mensaje = mensaje.replace(";idf;", contarLineasResponse.getAuditResponse().getCodRespuesta());
				mensaje = mensaje.replace(";idfmensaje;", contarLineasResponse.getAuditResponse().getMsjRespuesta());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

				validacion = false;
			}

			break;
		case Constantes.INTERFACE_VENTA1:
			// consulta datos cliente
			if (indicCharltResponse.getCodRespuesta().equals(Constantes.CADENA_CERO)) {

				if (indicCharltResponse.getRol().isEmpty()) {
					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA1);
					mensaje = mensaje.replace(";campo;", indicCharltResponse.getRol().getClass().getName());
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

					validacion = false;
				}

			} else {

				logger.info(
						mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.INTERFACE_VENTA1);
				mensaje = Constantes.EMAILPLATFORMNO0;
				mensaje = mensaje.replace(";platfom;", Constantes.INTERFACE_VENTA1);
				mensaje = mensaje.replace(";idf;", indicCharltResponse.getCodRespuesta());
				mensaje = mensaje.replace(";idfmensaje;", indicCharltResponse.getMsjRespuesta());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

				validacion = false;
			}

			break;
		case Constantes.GWP:
			// consulta datos cliente
			if (obtenerOperadorCedenteResponse.getCodError().equals(Constantes.CADENA_CERO)) {

				if (!(obtenerOperadorCedenteResponse.getListaOperador() != null && !obtenerOperadorCedenteResponse.getListaOperador().isEmpty())) {
					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.GWP);
					mensaje = mensaje.replace(";campo;",
							"ListaOperador"
//							obtenerOperadorCedenteResponse.getListaOperador().getClass().getName().toString()
					);
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

					validacion = false;
				}

			} else {

				logger.info(mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.GWP);
				mensaje = Constantes.EMAILPLATFORMNO0;
				mensaje = mensaje.replace(";platfom;", Constantes.GWP);
				mensaje = mensaje.replace(";idf;", obtenerOperadorCedenteResponse.getCodError());
				mensaje = mensaje.replace(";idfmensaje;", obtenerOperadorCedenteResponse.getDesError());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

				validacion = false;
			}

			break;
		case Constantes.OAC:
			// consulta datos cliente
			if (pagoPuntualResponse.getCodRespuesta().equals(Constantes.CADENA_CERO)) {

				if (pagoPuntualResponse.getIndicadorPp().equals(Constantes.VACIO)) {
					mensaje = Constantes.EMAILCAMPOSOBLIGATORIOSVACIOS;
					mensaje = mensaje.replace(";platfom;", Constantes.OAC);
					mensaje = mensaje.replace(";campo;", pagoPuntualResponse.getIndicadorPp().getClass().getName());
					enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

					validacion = false;
				}

			} else {

				logger.info(mensajeTransaccion + "ENVIO CORREO POR IDF != 0  PLATAFORMA : " + Constantes.OAC);
				mensaje = Constantes.EMAILPLATFORMNO0;
				mensaje = mensaje.replace(";platfom;", Constantes.OAC);
				mensaje = mensaje.replace(";idf;", pagoPuntualResponse.getCodRespuesta());
				mensaje = mensaje.replace(";idfmensaje;", pagoPuntualResponse.getMsgRespuesta());

				enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);

				validacion = false;
			}

			break;
		default:

			logger.info(mensajeTransaccion + "Nueva plataforma no mapeada : " + nombre);

			mensaje = "Nueva plataforma no mapeada: " + nombre;
			enviarCorreo(idTransaccion, nombre, mensaje, externalProperties);
			validacion = false;
			break;
		}

		return validacion;

	}

	private void enviarCorreo(String idTransaccion, String mensajeTransaccion, String mensajeadd,
			ExternalProperties externalProperties) {

		String mensajeTx = mensajeTransaccion + "[EnviarCorreo] ";

		String estadoError = Constantes.VACIO;
		String ipAplic = externalProperties.correo_ipaplicacion;
		String nomAplic = externalProperties.correo_nombreaplicacion;
		String usuarioAplic = externalProperties.correo_usuarioaplicacion;
		String usuarioModificacion = Constantes.VACIO;
		String idTransac = Constantes.VACIO;

		try {

			Retorno<EnviarCorreoResponse> objEnviarCorreo = null;
			Boolean ocurrioError = false;
			boolean flagActualizarCocumentos = false;
			// boolean flagMensajeError = false;
			String tipoOperacion = Constantes.VACIO;
			tipoOperacion = externalProperties.TIPO_OPERACION;
			String validacionCorreo = Constantes.VACIO;

			String mensaje = externalProperties.CORREO_MENSAJE_PORTABILIDAD_PREPAGO;
			String fechaOperacion = Constantes.VACIO;
			String fechaCad = Constantes.VACIO;

			logger.info(mensajeTx + "===============================================================");
			logger.info(mensajeTx + "======== [INICIO] 2. Envio de correo electronico  =============");
			logger.info(mensajeTx + "===============================================================");

			String correo = Constantes.VACIO;
			String telefono = Constantes.VACIO;
			String nombrecliente = Constantes.VACIO;
			correo = externalProperties.CorreoDestino;

			String[] nombre = nombrecliente.split(" ");
			mensaje = mensaje.replaceAll("NOMBRE", nombre[0]);
			logger.info(mensajeTx + "NOMBRE: " + nombre[0]);
			mensaje = mensaje.replaceAll("\\{NUMERO_DE_CELULAR\\}", telefono);
			logger.info(mensajeTx + "NUMERO_DE_CELULAR: " + telefono);
			mensaje = mensaje.replaceAll("\\{FECHA_ADQUISICION\\}", fechaOperacion);
			logger.info(mensajeTx + "FECHA_ADQUISICION " + fechaOperacion);
			mensaje = mensaje.replaceAll("\\{EMAIL\\}", correo);
			logger.info(mensajeTx + "EMAIL: " + correo);
			mensaje = mensaje + mensajeadd;
			logger.info(mensajeTx + "EMAIL: " + mensaje);

			objEnviarCorreo = envioCorreoSBClient.enviarCorreo(mensajeTx, idTransac, ipAplic, nomAplic, usuarioAplic,
					null, mensaje, correo, externalProperties);

			if (!Constantes.VALOR_CERO.equals(objEnviarCorreo.getErrorCode())) {
				logger.info(mensajeTx + "No se ejecuto con exito - Metodo enviarCorreo");
				// logger.info(mensajeTx + "Intento Numero: " + j);
				ocurrioError = true;
				// continue;

			} else {
				logger.info(
						mensajeTx + "Flag de validacion correo: " + externalProperties.VALOR_CAMPO_CORREO_VALIDACION);
				logger.info(mensajeTx + " Consulta exitosa - Metodo enviarCorreo");
				logger.info(mensajeTx + "[FIN] - [2.1 Enviar correo electr�nico con los documentos generados]");
				flagActualizarCocumentos = true;
				validacionCorreo = Constantes.STRING_CERO; // 0
				// SI
				// envi�
				// correo,
				// 1
				// NO
				// envi�
				// correo
				ocurrioError = false;
				// break;
			}
			// }
			if (ocurrioError) {

				logger.info(mensajeTx + "[FIN] - [2.2 Enviar correo electr�nico con los documentos generados]");

			}

			logger.info(mensajeTx + "============================================================");
			logger.info(mensajeTx + "======== [Fin] 2. Envio de correo electronico  =============");
			logger.info(mensajeTx + "============================================================");

			// else
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(mensajeTx + ex.getMessage());
		} finally {
			logger.info(mensajeTx + "--------- Fin -------------");
		}

	}

	private String extraerValorPlataforma(String plataformas, String posicion) {
		// TODO Auto-generated method stub

		String plataforma = "";

		plataforma = posicion;
		String listalibreria = "";
		listalibreria = plataformas;
		logger.info("extraerValorPlataforma Posicion:" + posicion + "; lista: " + listalibreria);
		String[] arrStrGrupo = listalibreria.split(",");

		for (String a : arrStrGrupo) {

			String[] arrStrobj = a.split("\\|");

			if (arrStrobj[0].equals(posicion)) {
				plataforma = arrStrobj[1];
				break;
			} else
				continue;
		}
		logger.info("obtenerTipoDocToOAC  OUT:" + plataforma);

		return plataforma;

	}

	private ConsultarDatosResponse consultarDatos(String msgTransaction, ExternalProperties propertiesExternos,
			EvaluacionVentasRequest request, HeaderRequest header) throws WSException {
		logger.info(msgTransaction + " [INICIO] - ACTIVIDAD: Consulta cuentas de cliente y direcciones ");
		ConsultarDatosRequest consultarDatosRequest = new ConsultarDatosRequest();
		ConsultarDatosRequestType consultarDatosRequestType = new ConsultarDatosRequestType();
		ConsultarDatosResponse datosResponse = new ConsultarDatosResponse();

		try {
			consultarDatosRequestType.setTipoDocumento(request.getDatosCliente().getTipoDocumento());
			consultarDatosRequestType.setNumeroDocumento(request.getDatosCliente().getNumeroDocumento());
			consultarDatosRequest.setConsultarDatosRequest(consultarDatosRequestType);

			datosResponse = consultaCliente.consultarDatos(msgTransaction, consultarDatosRequest, header,
					propertiesExternos);

		} catch (WSException ex) {
			logger.info(msgTransaction + " [FIN] - WSException: consultarDatos de cliente " + ex.getMessage());

		} catch (Exception e) {
			logger.info(msgTransaction + " [FIN] - WException: consultarDatos de cliente " + e.getMessage());

		} finally {
			logger.info(msgTransaction + " [FIN] - ACTIVIDAD: consultarDatos de cliente y direcciones ");
		}
		return datosResponse;
	}

	private ConsultarContratosResponse consultarContrato(String msgTransaction, ExternalProperties propertiesExternos,
			EvaluacionVentasRequest request, HeaderRequest header) throws WSException {
		logger.info(msgTransaction + " [INICIO] - ACTIVIDAD: Consulta contratos de cliente ");
		ConsultarContratosRequest consultarContratosRequest = new ConsultarContratosRequest();
		ConsultarContratosRequestType consultarContratosRequestType = new ConsultarContratosRequestType();
		ConsultarContratosResponse datosResponse = new ConsultarContratosResponse();

		try {
			consultarContratosRequestType.setTipoDocumento(request.getDatosCliente().getTipoDocumento());
			consultarContratosRequestType.setNumeroDocumento(request.getDatosCliente().getNumeroDocumento());
			consultarContratosRequest.setConsultarContratosRequest(consultarContratosRequestType);

			datosResponse = consultarContrato.consultarContrato(msgTransaction, consultarContratosRequest, header,
					propertiesExternos);
			/*
			 * if(!Constantes.VALOR_CERO.equals(datosResponse.
			 * getConsultarContratosResponseType().getResponseAudit().getCodigoRespuesta()))
			 * { throw new
			 * WSException(propertiesExternos.consultarContratosClienteIdf1Mensaje); }
			 */

		} catch (WSException ex) {
			logger.info(msgTransaction + " [FIN] - WSException: Consulta contratos de cliente " + ex.getMessage());

		} catch (Exception e) {
			logger.info(msgTransaction + " [FIN] - WException: Consulta contratos de cliente " + e.getMessage());

		} finally {
			logger.info(msgTransaction + " [FIN] - ACTIVIDAD: Consulta contratos de cliente ");
		}
		return datosResponse;
	}

	private ContarLineasResponse validarLineasClienteWS(String msgTransaction, EvaluacionVentasRequest request,
			ExternalProperties propertiesExternos) throws WSException {

		logger.info(msgTransaction + " [INICIO] - ACTIVIDAD: validarLineasClienteWS ");
		ContarLineasRequest contarLineasRequest = new ContarLineasRequest();
		ContarLineasResponse contarLineasResponse = new ContarLineasResponse();
		AuditRequest auditRequest = new AuditRequest();

		auditRequest.setIdTransaccion(request.getHeaderRequestType().getIdBusinessTransaction());
		auditRequest.setIpAplicacion(request.getHeaderRequestType().getIdApplication());
		auditRequest.setNombreAplicacion(request.getHeaderRequestType().getChannel());
		auditRequest.setUsuarioAplicacion(request.getHeaderRequestType().getUserApplication());

		try {

			contarLineasRequest.setAuditRequest(auditRequest);
			contarLineasRequest.setNumeroDocumento(request.getDatosCliente().getNumeroDocumento());

			contarLineasResponse = validarLineasClienteWS.validarLineasClienteWS(contarLineasRequest,
					propertiesExternos, msgTransaction);
			/*
			 * if(!Constantes.VALOR_CERO.equals(contarLineasResponse.getAuditResponse().
			 * getCodRespuesta())){ throw new
			 * WSException(propertiesExternos.consultarContratosClienteIdf1Mensaje); }
			 */

		} catch (WSException ex) {
			logger.info(msgTransaction + " [FIN] - WSException:validarLineasClienteWS " + ex.getMessage());

		} catch (Exception e) {
			logger.info(msgTransaction + " [FIN] - WException: validarLineasClienteWS " + e.getMessage());

		} finally {
			logger.info(msgTransaction + " [FIN] - ACTIVIDAD: validarLineasClienteWS ");
		}

		return contarLineasResponse;

	}

	public List<ErrorDetailType> isValidEvaluacionBonosVenta(EvaluacionVentasRequest request,
			HeaderRequestType headerReq) {

		List<ErrorDetailType> errorDetails = new ArrayList<ErrorDetailType>();
		ErrorDetailType errorDetailType = new ErrorDetailType();

		if (headerReq == null) {
			errorDetailType = new ErrorDetailType();
			errorDetailType.setErrorDescription("El type headerRequest no puede ser nulo");
			errorDetails.add(errorDetailType);
		} else {
			if (headerReq.getChannel() == null || headerReq.getChannel().length() == 0
					|| headerReq.getChannel().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio headerRequest/channel");
				errorDetails.add(errorDetailType);
			}

			if (headerReq.getIdBusinessTransaction() == null || headerReq.getIdBusinessTransaction().length() == 0
					|| headerReq.getIdBusinessTransaction().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio headerRequest/idBusinessTransaction");
				errorDetails.add(errorDetailType);
			}
		}

		if (request.getDatosCliente() == null) {
			errorDetailType = new ErrorDetailType();
			errorDetailType.setErrorDescription("El type datosCliente no puede ser nulo");
			errorDetails.add(errorDetailType);
		} else {
			if (request.getDatosCliente().getCustomerID() == null
					|| request.getDatosCliente().getCustomerID().length() == 0
					|| request.getDatosCliente().getCustomerID().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosCliente/customerID");
				errorDetails.add(errorDetailType);
			}
			if (request.getDatosCliente().getBillingAccount() == null
					|| request.getDatosCliente().getBillingAccount().length() == 0
					|| request.getDatosCliente().getBillingAccount().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosCliente/billingAccount");
				errorDetails.add(errorDetailType);
			}
			if (request.getDatosCliente().getSegmentoCliente() == null
					|| request.getDatosCliente().getSegmentoCliente().length() == 0
					|| request.getDatosCliente().getSegmentoCliente().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosCliente/segmentoCliente");
				errorDetails.add(errorDetailType);
			}
			/*
			 * if (request.getDatosCliente().getGenero() == null ||
			 * request.getDatosCliente().getGenero().length() == 0 ||
			 * request.getDatosCliente().getGenero().trim().equals(Constantes.VACIO)) {
			 * errorDetailType = new ErrorDetailType();
			 * errorDetailType.setErrorDescription("Campo obligatorio: datosCliente/genero"
			 * ); errorDetails.add(errorDetailType); }
			 */
		}

		if (request.getDatosOperacion() == null) {
			errorDetailType = new ErrorDetailType();
			errorDetailType.setErrorDescription("El type datosOperacion no puede ser nulo");
			errorDetails.add(errorDetailType);
		} else {
			if (request.getDatosOperacion().getShoppingCartID() == null
					|| request.getDatosOperacion().getShoppingCartID().length() == 0
					|| request.getDatosOperacion().getShoppingCartID().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/shoppingCartID");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getAppOrigen() == null
					|| request.getDatosOperacion().getAppOrigen().length() == 0
					|| request.getDatosOperacion().getAppOrigen().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/appOrigen");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getCanal() == null || request.getDatosOperacion().getCanal().length() == 0
					|| request.getDatosOperacion().getCanal().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/canal");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getTipoOperacion() == null
					|| request.getDatosOperacion().getTipoOperacion().length() == 0
					|| request.getDatosOperacion().getTipoOperacion().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/tipoOperacion");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getFechaTransaccion() == null) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/fechaTransaccion");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getCodigoPuntoVenta() == null
					|| request.getDatosOperacion().getCodigoPuntoVenta().length() == 0
					|| request.getDatosOperacion().getCodigoPuntoVenta().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/codigoPuntoVenta");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getCodDepartamentoPV() == null
					|| request.getDatosOperacion().getCodDepartamentoPV().length() == 0
					|| request.getDatosOperacion().getCodDepartamentoPV().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/codDepartamentoPV");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getCodProvinciaPV() == null
					|| request.getDatosOperacion().getCodProvinciaPV().length() == 0
					|| request.getDatosOperacion().getCodProvinciaPV().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/codProvinciaPV");
				errorDetails.add(errorDetailType);
			}

			if (request.getDatosOperacion().getCodDistritoPV() == null
					|| request.getDatosOperacion().getCodDistritoPV().length() == 0
					|| request.getDatosOperacion().getCodDistritoPV().trim().equals(Constantes.VACIO)) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("Campo obligatorio: datosOperacion/codDistritoPV");
				errorDetails.add(errorDetailType);
			}
		}

		if (request.getDatosLinea() == null) {
			errorDetailType = new ErrorDetailType();
			errorDetailType.setErrorDescription("El type DatosLinea no puede ser nulo");
			errorDetails.add(errorDetailType);
		} else {
			if (request.getDatosLinea().size() == Constantes.CERO) {
				errorDetailType = new ErrorDetailType();
				errorDetailType.setErrorDescription("El listado datosLinea no puede estar vacio");
				errorDetails.add(errorDetailType);
			} else {
				for (ListaDatosLineaRequestType datosLineaRequestType : request.getDatosLinea()) {
					/*
					 * if (datosLineaRequestType.getLinea() == null ||
					 * datosLineaRequestType.getLinea().length() == 0 ||
					 * datosLineaRequestType.getLinea().trim().equals(Constantes.VACIO)) {
					 * errorDetailType = new ErrorDetailType();
					 * errorDetailType.setErrorDescription("Campo obligatorio: datosLinea/linea");
					 * errorDetails.add(errorDetailType); }
					 */

					if (datosLineaRequestType.getPoID() == null || datosLineaRequestType.getPoID().length() == 0
							|| datosLineaRequestType.getPoID().trim().equals(Constantes.VACIO)) {
						errorDetailType = new ErrorDetailType();
						errorDetailType.setErrorDescription("Campo obligatorio: datosLinea/poID");
						errorDetails.add(errorDetailType);
					}

					if (datosLineaRequestType.getCampana() == null || datosLineaRequestType.getCampana().length() == 0
							|| datosLineaRequestType.getCampana().trim().equals(Constantes.VACIO)) {
						errorDetailType = new ErrorDetailType();
						errorDetailType.setErrorDescription("Campo obligatorio: datosLinea/campana");
						errorDetails.add(errorDetailType);
					}

					if (datosLineaRequestType.getSuscripcionCorreo() == null
							|| datosLineaRequestType.getSuscripcionCorreo().length() == 0
							|| datosLineaRequestType.getSuscripcionCorreo().trim().equals(Constantes.VACIO)) {
						errorDetailType = new ErrorDetailType();
						errorDetailType.setErrorDescription("Campo obligatorio: datosLinea/suscripcionCorreo");
						errorDetails.add(errorDetailType);
					}

					if (datosLineaRequestType.getSuscripciones() == null) {
						errorDetailType = new ErrorDetailType();
						errorDetailType.setErrorDescription("El type datosLinea/suscripciones no puede ser nulo");
						errorDetails.add(errorDetailType);
					} else {
						if (datosLineaRequestType.getSuscripciones().size() == Constantes.CERO) {
							errorDetailType = new ErrorDetailType();
							errorDetailType
									.setErrorDescription("El listado datosLinea/suscripciones no puede estar vacio");
							errorDetails.add(errorDetailType);
						} else {
							for (ListaSuscripcionesRequestType listaSuscripcionesRequestType : datosLineaRequestType
									.getSuscripciones()) {
								if (listaSuscripcionesRequestType.getTipoProducto() == null
										|| listaSuscripcionesRequestType.getTipoProducto().length() == 0
										|| listaSuscripcionesRequestType.getTipoProducto().trim()
												.equals(Constantes.VACIO)) {
									errorDetailType = new ErrorDetailType();
									errorDetailType.setErrorDescription(
											"Campo obligatorio: datosLinea/suscripciones/tipoProducto");
									errorDetails.add(errorDetailType);
								}

								if (listaSuscripcionesRequestType.getTipoSuscripcion() == null
										|| listaSuscripcionesRequestType.getTipoSuscripcion().length() == 0
										|| listaSuscripcionesRequestType.getTipoSuscripcion().trim()
												.equals(Constantes.VACIO)) {
									errorDetailType = new ErrorDetailType();
									errorDetailType.setErrorDescription(
											"Campo obligatorio: datosLinea/suscripciones/tipoSuscripcion");
									errorDetails.add(errorDetailType);
								}
							}
						}
					}

					if (datosLineaRequestType.getServiciosAdicionales() == null) {
						/*
						 * errorDetailType = new ErrorDetailType(); errorDetailType
						 * .setErrorDescription("El type DatosLinea/ServiciosAdicionales no puede ser nulo"
						 * ); errorDetails.add(errorDetailType);
						 */
					} else {
						if (datosLineaRequestType.getServiciosAdicionales().size() == Constantes.CERO) {
							/*
							 * errorDetailType = new ErrorDetailType(); errorDetailType.setErrorDescription(
							 * "El listado DatosLinea/ServiciosAdicionales no puede estar vacio");
							 * errorDetails.add(errorDetailType);
							 */
						} else {
							for (ListaServiciosAdicionalesRequestType adicionalesRequestType : datosLineaRequestType
									.getServiciosAdicionales()) {
								if (adicionalesRequestType.getPoID() == null
										|| adicionalesRequestType.getPoID().length() == 0
										|| adicionalesRequestType.getPoID().trim().equals(Constantes.VACIO)) {
									errorDetailType = new ErrorDetailType();
									errorDetailType.setErrorDescription(
											"Campo obligatorio: DatosLinea/ServiciosAdicionales/PoID");
									errorDetails.add(errorDetailType);
								}

								if (adicionalesRequestType.getTipoPO() == null
										|| adicionalesRequestType.getTipoPO().length() == 0
										|| adicionalesRequestType.getTipoPO().trim().equals(Constantes.VACIO)) {
									errorDetailType = new ErrorDetailType();
									errorDetailType.setErrorDescription(
											"Campo obligatorio: DatosLinea/ServiciosAdicionales/TipoPO");
									errorDetails.add(errorDetailType);
								}
							}
						}
					}

				}
			}
		}

		return errorDetails;

	}

}

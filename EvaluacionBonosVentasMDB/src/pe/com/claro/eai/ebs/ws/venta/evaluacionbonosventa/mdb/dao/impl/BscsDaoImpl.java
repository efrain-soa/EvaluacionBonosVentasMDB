package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jdbc.support.oracle.SqlStructArrayValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ActualizarEvaluacionBonosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.BolsaLineaBase;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.BolsaLineasMapper;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Bonos;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.DatosClienteBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.DatosOperacionBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ExtraePlataformasResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.HisBloq;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Linea;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.LineaBaseBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.LineaBean;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.LineasMapper;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ListaBonos;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerBonosResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Plataforma;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ServiciosAdicionales;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Suscripciones;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;

@Repository
public class BscsDaoImpl implements BscsDao {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	@Qualifier("bscsDS")
	private DataSource bscsDS;

	@Autowired
	private ExternalProperties constantesExternos;

	public ExtraePlataformasResponse extraePlataformas(String mensajeTransaccion,
			ExtraePlataformasRequest extraePlataformasRequest) throws DBException {

		String nombreMetodo = "extraePlataformas";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();

		ExtraePlataformasResponse extraePlataformasResponse = new ExtraePlataformasResponse();

		try {
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbBscs + ", con JNDI = ["
					+ constantesExternos.dbBscsJndi + "]");
			bscsDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbBscsTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.constantesExternos.dbBscsOwner)
					.withProcedureName(this.constantesExternos.dbBscsSpExtraeDataExt)
					.declareParameters(new SqlParameter("pi_tipo_operacion", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cur_plataformas", OracleTypes.CURSOR, new RowMapper<Plataforma>() {
								public Plataforma mapRow(ResultSet rs, int arg1) throws SQLException {
									Plataforma plataforma = new Plataforma();

									plataforma.setNombre(rs.getString("PLATAFORMA"));

									return plataforma;
								}
							}), new SqlOutParameter("po_cod_err", OracleTypes.INTEGER),
							new SqlOutParameter("po_des_err", OracleTypes.VARCHAR));

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("pi_tipo_operacion",
					extraePlataformasRequest.getTipoOperacion());

			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbBscsOwner
					.concat(Constantes.PUNTO).concat(this.constantesExternos.dbBscsSpExtraeDataExt));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");
			logger.info(mensajeMetodo + "[pi_tipo_operacion] = " + extraePlataformasRequest.getTipoOperacion());

			call.getJdbcTemplate()
					.setQueryTimeout(Integer.parseInt(this.constantesExternos.dbBscsTimeoutExecutionMaxTime));
			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbBscsOwner
					+ Constantes.PUNTO + constantesExternos.dbBscsSpExtraeDataExt);

			String codigoRespuesta = (resultMap.get("po_cod_err") != null) ? resultMap.get("po_cod_err").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("po_des_err") != null) ? resultMap.get("po_des_err").toString()
					: null;

			extraePlataformasResponse.setCodRespuesta(codigoRespuesta);
			extraePlataformasResponse.setMsjRespuesta(mensajeRespuesta);

			if (resultMap.get("po_cur_plataformas") != null) {
				@SuppressWarnings("unchecked")
				List<Plataforma> listaPlataformas = (List<Plataforma>) resultMap.get("po_cur_plataformas");
				if (listaPlataformas != null) {
					extraePlataformasResponse.setPlataformas(listaPlataformas);
				}
			}
			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(extraePlataformasResponse));

		} catch (Exception e) {
			String excepcion = e + "";

			String codError = null;
			String msjError = null;
			logger.error(mensajeMetodo + e.getMessage());

			if (excepcion.contains(this.constantesExternos.bdErrorSqlTimeoutException)) {
				codError = this.constantesExternos.codigoIdt1;
				msjError = this.constantesExternos.mensajeIdt1;

			} else {
				codError = this.constantesExternos.codigoIdt2;
				msjError = this.constantesExternos.mensajeIdt2;
			}
			msjError = msjError
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA,
							Constantes.VALOR_BD + "-" + this.constantesExternos.dbBscs)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbBscsSpExtraeDataExt + " ".concat(e.getMessage()));

			throw new DBException(codError, msjError + " :BscsDAOImpl - ExtraePlataformasResponse", e);

		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");

		}
		return extraePlataformasResponse;
	}

	@Override
	public ObtenerBonosResponse obtenerBonos(String mensajeTransaccion, ObtenerBonosRequest obtenerBonosRequest)
			throws DBException, SQLException {

		String nombreMetodo = "obtenerBonos";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		long tiempoInicio = System.currentTimeMillis();
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");

		ObtenerBonosResponse obtenerBonosResponse = new ObtenerBonosResponse();
		ArrayList<Linea> listaLinea = new ArrayList<Linea>();
		LineasMapper lineasMapper = new LineasMapper();
		BolsaLineasMapper bolsaLineasMapper = new BolsaLineasMapper();
		Connection conexion = null;
		try {

			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbBscs + ", con JNDI = ["
					+ constantesExternos.dbBscsJndi + "]");
			bscsDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbBscsTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(bscsDS);

			String parametrosInput = "PARAMETROS [INPUT]: ";
			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbBscsSpObtenerBonos);
			logger.info(mensajeMetodo + parametrosInput);
			logger.info(mensajeMetodo + "[pi_datos_clie] =\n "
					+ JAXBUtilitarios.anyObjectToXmlText(obtenerBonosRequest.getDatosClientes()));
			logger.info(mensajeMetodo + "[pi_datos_opera] =\n "
					+ JAXBUtilitarios.anyObjectToXmlText(obtenerBonosRequest.getDatosOperacion()));
			if (obtenerBonosRequest.getListaLineaBase() != null) {
				logger.info(mensajeMetodo + "[pi_lista_linea_base] =\n "
						+ JAXBUtilitarios.anyObjectToXmlText(obtenerBonosRequest.getListaLineaBase()));
			} else {
				logger.info(mensajeMetodo + "[pi_lista_linea_base][null]");
			}

			if (obtenerBonosRequest.getListaLinea() != null) {
				int p = 0;
				for (LineaBean row : obtenerBonosRequest.getListaLinea()) {

					logger.info(parametrosInput + "[datosLinea]");
					logger.info(
							mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][linea]: [" + row.getLinea() + "]");
					logger.info(
							mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][po_id]: [" + row.getPoId() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][po_name]: [" + row.getPoName()
							+ "]");
					logger.info(
							mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][iccid]: [" + row.getIccid() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][cant_decos]: ["
							+ row.getCantDecos() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][caso_especial]: ["
							+ row.getCasoEspecial() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][campania]: ["
							+ row.getCampania() + "]");
					logger.info(
							mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][tope]: [" + row.getTope() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][suscripcion_correo]: ["
							+ row.getSuscripcionCorreo() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][linea_referente]: ["
							+ row.getLineaReferente() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][cod_dept_ins]: ["
							+ row.getCodDeptIns() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][cod_prov_ins]: ["
							+ row.getCodProvIns() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][cod_dist_ins]: ["
							+ row.getCodDistIns() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][marca_equipo]: ["
							+ row.getMarcaEquipo() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][modelo_equipo]: ["
							+ row.getModeloEquipo() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][precio_venta_equipo]: ["
							+ row.getPrecioVentaEquipo() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][clasi_charlotte]: ["
							+ row.getClasiCharlotte() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][oper_cedente]: ["
							+ row.getOperCedente() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][fec_act_oper_cedente]: ["
							+ row.getFecActOperCedente() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][contract_id]: ["
							+ row.getContractId() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][ELEMENTO][" + p + "][contract_id_bscs]: ["
							+ row.getContractIdbscs() + "]");
					logger.info(" =\n ");
					int s = 0;
					for (Suscripciones row2 : obtenerBonosRequest.getListaLinea().get(p).getListaSuscripciones()) {
						logger.info(parametrosInput + "[suscripciones]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][tipo_producto]: [" + row2.getTipoProducto() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][tipo_tecnologia]: [" + row2.getTipoTecnologia() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][tipo_suscripcion]: [" + row2.getTipoSuscripcion() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][bundle_id]: [" + row2.getBundleID() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][modalidad_pago]: [" + row2.getModalidadPago() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][cargo_fijo_plan]: [" + row2.getCargoFijoPlan() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SUSCRIPCIONES][ELEMENTO][" + s
								+ "][plazo_contrato]: [" + row2.getPlazoContrato() + "]");
						logger.info(" =\n ");
						s++;
					}
					int sa = 0;
					for (ServiciosAdicionales row3 : obtenerBonosRequest.getListaLinea().get(p)
							.getListaServiciosAdicionales()) {
						logger.info(parametrosInput + "[serviciosAdicionales]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SERVICIOS_ADICIONALES][ELEMENTO][" + sa + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SERVICIOS_ADICIONALES][ELEMENTO][" + sa
								+ "][po_id]: [" + row3.getPoId() + "]");
						logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][SERVICIOS_ADICIONALES][ELEMENTO][" + sa
								+ "][tipo_po]: [" + row3.getTipoPO() + "]");
						logger.info(" =\n ");
						sa++;
					}
					p++;
				}

			} else {
				logger.info(mensajeMetodo + "[PIO_LISTA_LINEA][null]");
			}

			if (obtenerBonosRequest.getListaLineaBase() != null) {

				int p = 0;
				for (LineaBaseBean row : obtenerBonosRequest.getListaLineaBase()) {
					logger.info(parametrosInput + "[datosLineaBase]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][contract_id_base]: ["
							+ row.getContractIdBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][linea_base]: ["
							+ row.getLineaBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][po_id_base]: ["
							+ row.getPoIdBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][po_name_base]: ["
							+ row.getPoNameBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][customer_id_ext_base]: ["
							+ row.getCustomerIdExtBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][billing_account_base]: ["
							+ row.getBillingAccountBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][ciclo_fact_base]: ["
							+ row.getCicloFactBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][cargo_fijo_plan_base]: ["
							+ row.getCargoFijoPlanBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][tipo_producto_base]: ["
							+ row.getTipoProductoBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][tipo_suscripcion_base]: ["
							+ row.getTipoSuscripcionBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][fec_activacion_base]: ["
							+ row.getFecActivacionBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][estado_linea_base]: ["
							+ row.getEstadoLineaBase() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][bundle_id]: ["
							+ row.getBundleId() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][status_billing]: ["
							+ row.getStatusBilling() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][mail]: [" + row.getEmail()
							+ "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][tecnologia]: ["
							+ row.getTecnologia() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][tipo_telefono]: ["
							+ row.getTipoTelefono() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][fec_mod_suscription]: ["
							+ row.getFecModSuscription() + "]");
					logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][ELEMENTO][" + p + "][ind_linea_porta_base]: ["
							+ row.getIndLineaPortaBase() + "]");
					logger.info(" =\n ");
					int s = 0;
					if (obtenerBonosRequest.getListaLineaBase().get(p).getListaHisBloqueo() != null
							&& !obtenerBonosRequest.getListaLineaBase().isEmpty()) {
						for (HisBloq row2 : obtenerBonosRequest.getListaLineaBase().get(p).getListaHisBloqueo()) {
							logger.info(parametrosInput + "[ListaHisBloqueo]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][fecha_creacion_bloq]: [" + row2.getFechaCreacionBloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][tick_shdes_bloq]: [" + row2.getTickShdesBloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][tick_ldes_bloq]: [" + row2.getTickLdesBloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][fecha_cierre_bloq]: [" + row2.getFechaCierreBloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][tick_codigo_bloq]: [" + row2.getTickCodigoBloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][tick_estado_bloq]: [" + row2.getTickEstadobloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][id_razon_bloq]: [" + row2.getIdRazonbloq() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][HIS_BLOQUEO][ELEMENTO][" + s
									+ "][razon_bloq]: [" + row2.getRazonbloq() + "]");
							logger.info(" =\n ");
							s++;
						}
					}
					int sa = 0;
					if (obtenerBonosRequest.getListaLineaBase().get(p).getListaBolsaLineaBase() != null) {
						for (BolsaLineaBase row2 : obtenerBonosRequest.getListaLineaBase().get(p)
								.getListaBolsaLineaBase()) {
							logger.info(parametrosInput + "[ListaBolsaLineaBase]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][LISTA_BOLSA_LINEA_BASE][ELEMENTO][" + sa
									+ "][bolsa]: [" + row2.getBolsa() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][LISTA_BOLSA_LINEA_BASE][ELEMENTO][" + sa
									+ "][unidades_medida]: [" + row2.getUnidadesMedida() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][LISTA_BOLSA_LINEA_BASE][ELEMENTO][" + sa
									+ "][unidades_asignadas]: [" + row2.getUnidadesAsignadas() + "]");
							logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][LISTA_BOLSA_LINEA_BASE][ELEMENTO][" + sa
									+ "][unidades_consumidas]: [" + row2.getUnidadesConsumidas() + "]");
							logger.info(" =\n ");
							sa++;
						}
					}
					p++;
				}
			} else {
				logger.info(mensajeMetodo + "[PIO_LISTA_LINEA_BASE][null]");
			}

			conexion = bscsDS.getConnection();
			LineaBean[] sqlLineaBean = null;
			LineaBaseBean[] sqlBolsaLineaBase = null;

			StructDescriptor suscripcionStructDesc = StructDescriptor.createDescriptor("MOTPROM.T_PROM_VENTA_SUSCRIP",
					conexion);
			StructDescriptor servAdicStructDesc = StructDescriptor.createDescriptor("MOTPROM.T_PROM_VENTA_SERV",
					conexion);

			StructDescriptor hisBloqueoStructDesc = StructDescriptor.createDescriptor("MOTPROM.T_PROM_VENTA_HIST_BLOQ",
					conexion);
			StructDescriptor bolsaLineaBaseStructDesc = StructDescriptor
					.createDescriptor("MOTPROM.T_PROM_VENTA_DATOS_BASE_BOLSA", conexion);
			// CAMBIO
			StructDescriptor datosClienteStructDesc = StructDescriptor
					.createDescriptor("MOTPROM.T_PROM_VENTA_DATOS_CLIE", conexion);

			STRUCT structDatosCliente = new STRUCT(datosClienteStructDesc, conexion,
					getStructDatosClientes(obtenerBonosRequest.getDatosClientes()));

			StructDescriptor datosOperacionStructDesc = StructDescriptor
					.createDescriptor("MOTPROM.T_PROM_VENTA_DATOS_OPERA", conexion);

			STRUCT structDatosOperacion = new STRUCT(datosOperacionStructDesc, conexion,
					getStructDatosOperacion(obtenerBonosRequest.getDatosOperacion()));

//			logger.info(mensajeMetodo + "[pi_datos_opera] =\n "
//					+ getStructDatosOperacion(obtenerBonosRequest.getDatosOperacion())[4].toString());

			logger.info(mensajeMetodo + "[pi_datos_opera] =\n " + JAXBUtilitarios
					.anyObjectToXmlText(getStructDatosOperacion(obtenerBonosRequest.getDatosOperacion())));

			sqlLineaBean = new LineaBean[obtenerBonosRequest.getListaLinea().size()];
			int i = 0;
			for (LineaBean lb : obtenerBonosRequest.getListaLinea()) {
				lb.setSuscripciones(
						suscripcionStructArray(lb.getListaSuscripciones(), conexion, suscripcionStructDesc));
				lb.setServiciosAdicionales(
						servAdicionalStructArray(lb.getListaServiciosAdicionales(), conexion, servAdicStructDesc));
				sqlLineaBean[i] = lb;
				i++;
			}

			if (obtenerBonosRequest.getListaLineaBase() != null) {
				sqlBolsaLineaBase = new LineaBaseBean[obtenerBonosRequest.getListaLineaBase().size()];
				int g = 0;
				for (LineaBaseBean blb : obtenerBonosRequest.getListaLineaBase()) {
					if (blb.getListaHisBloqueo() != null) {
						blb.setHisBloqueo(
								hisBloqueoStructArray(blb.getListaHisBloqueo(), conexion, hisBloqueoStructDesc));
					}
					if (blb.getListaBolsaLineaBase() != null) {
						blb.setBolsaLineaBase(
								bolsaLineaBaseArray(blb.getListaBolsaLineaBase(), conexion, bolsaLineaBaseStructDesc));
					}
					sqlBolsaLineaBase[g] = blb;
					g++;
				}
			}

			MapSqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_DATOS_CLIE", structDatosCliente)
					.addValue("PI_DATOS_OPERA", structDatosOperacion)
					.addValue("PI_LISTA_LINEA_BASE",
							new SqlStructArrayValue<LineaBaseBean>(sqlBolsaLineaBase, bolsaLineasMapper,
									"MOTPROM.T_PROM_VENTA_DATOS_LINEA_BASE"))
					.addValue("PIO_LISTA_LINEA", new SqlStructArrayValue<LineaBean>(sqlLineaBean, lineasMapper,
							"MOTPROM.T_PROM_VENTA_DATOS_LINEA"));

			call.getJdbcTemplate()
					.setQueryTimeout(Integer.parseInt(this.constantesExternos.dbBscsTimeoutExecutionMaxTime));

			Map<String, Object> resultMap = call.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.constantesExternos.dbBscsOwner)
					.withProcedureName(this.constantesExternos.dbBscsSpObtenerBonos)
					.declareParameters(
							new SqlParameter("PI_DATOS_CLIE", OracleTypes.STRUCT, "MOTPROM.T_PROM_VENTA_DATOS_CLIE"),
							new SqlParameter("PI_DATOS_OPERA", OracleTypes.STRUCT, "MOTPROM.T_PROM_VENTA_DATOS_OPERA"),
							new SqlParameter("PI_LISTA_LINEA_BASE", OracleTypes.ARRAY,
									"MOTPROM.T_PROM_VENTA_LISTA_LINEA_BASE"),
							new SqlInOutParameter("PIO_LISTA_LINEA", OracleTypes.ARRAY,
									"MOTPROM.T_PROM_VENTA_LISTA_LINEA"),
							new SqlOutParameter("po_cod_err", OracleTypes.INTEGER),
							new SqlOutParameter("po_des_err", OracleTypes.VARCHAR))
					.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbBscsOwner
					+ Constantes.PUNTO + constantesExternos.dbBscsSpObtenerBonos);

			String codigoRespuesta = (resultMap.get("po_cod_err") != null) ? resultMap.get("po_cod_err").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("po_des_err") != null) ? resultMap.get("po_des_err").toString()
					: null;

			obtenerBonosResponse.setCodRespuesta(codigoRespuesta);
			obtenerBonosResponse.setMsjRespuesta(mensajeRespuesta);
			resultMap.get("PIO_LISTA_LINEA");

			ARRAY outListaLinea = (ARRAY) resultMap.get("PIO_LISTA_LINEA");

			if (outListaLinea != null) {

				Object[] filasArrayLineas = (Object[]) outListaLinea.getArray();
				if (filasArrayLineas != null) {

					for (int j = 0; j < filasArrayLineas.length; j++) {

						STRUCT celdas = (STRUCT) filasArrayLineas[j];
						Object[] valuesCabecera = celdas.getAttributes();

						Linea linea = new Linea();
						ListaBonos listaBonos = new ListaBonos();
						linea.setLinea((valuesCabecera[0] != null) ? valuesCabecera[0].toString() : null);
						linea.setPoID((valuesCabecera[1] != null) ? valuesCabecera[1].toString() : null);
						linea.setPoName((valuesCabecera[2] != null) ? valuesCabecera[2].toString() : null);

						ArrayList<Bonos> listBonos = new ArrayList<Bonos>();

						ARRAY arrayListaBonos = null;
						if (valuesCabecera[23] != null) {
							arrayListaBonos = (ARRAY) valuesCabecera[23];
						}
						if (arrayListaBonos != null) {
							Object[] filasArrayDetalle = (Object[]) arrayListaBonos.getArray();

							for (int k = 0; k < filasArrayDetalle.length; k++) {
								STRUCT celdasDetalle = (STRUCT) filasArrayDetalle[k];
								Object[] valoresDetalle = celdasDetalle.getAttributes();
								Bonos bonoResponse = new Bonos();
								bonoResponse.setIdBono(
										(valoresDetalle[0] != null) ? Integer.parseInt(valoresDetalle[0].toString())
												: null);
								bonoResponse
										.setPoBono((valoresDetalle[1] != null) ? valoresDetalle[1].toString() : null);
								bonoResponse.setPoBonoName(
										(valoresDetalle[2] != null) ? valoresDetalle[2].toString() : null);
								bonoResponse
										.setBonoDes((valoresDetalle[3] != null) ? valoresDetalle[3].toString() : null);
								bonoResponse
										.setFlgProg((valoresDetalle[4] != null) ? valoresDetalle[4].toString() : null);
								bonoResponse.setBonoGrupo(
										(valoresDetalle[5] != null) ? valoresDetalle[5].toString() : null);
								bonoResponse
										.setPoType((valoresDetalle[6] != null) ? valoresDetalle[6].toString() : null);
								bonoResponse
										.setFlgElec((valoresDetalle[7] != null) ? valoresDetalle[7].toString() : null);
								listBonos.add(bonoResponse);
							}
							listaBonos.setBono(listBonos);
							linea.setListaBonos(listaBonos);

							listaLinea.add(linea);
						}

					}
				}
			}

			obtenerBonosResponse.setLinea(listaLinea);
			logger.info(
					mensajeMetodo + " PARAMETROS [OUPUT]: " + JAXBUtilitarios.anyObjectToXmlText(obtenerBonosResponse));

		} catch (SQLException e) {
			String excepcion = e + "";

			String codError = null;
			String msjError = null;
			logger.error(mensajeMetodo, e);
			if (excepcion.contains(this.constantesExternos.bdErrorSqlTimeoutException)) {
				codError = this.constantesExternos.codigoIdt1;
				msjError = this.constantesExternos.mensajeIdt1;
			} else {
				codError = this.constantesExternos.codigoIdt2;
				msjError = this.constantesExternos.mensajeIdt2;
			}

			msjError = msjError
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA,
							Constantes.VALOR_BD + "-" + this.constantesExternos.dbBscs)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbBscsSpObtenerBonos + " " + e.getMessage());
			obtenerBonosResponse.setCodRespuesta(codError);
			obtenerBonosResponse.setMsjRespuesta(msjError);
		} catch (Exception e) {
			String excepcion = e + "";

			String codError = null;
			String msjError = null;
			logger.error(mensajeMetodo, e);
			if (excepcion.contains(this.constantesExternos.bdErrorSqlTimeoutException)) {
				codError = this.constantesExternos.codigoIdt1;
				msjError = this.constantesExternos.mensajeIdt1;
			} else {
				codError = this.constantesExternos.codigoIdt2;
				msjError = this.constantesExternos.mensajeIdt2;
			}

			msjError = msjError
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA,
							Constantes.VALOR_BD + "-" + this.constantesExternos.dbBscs)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbBscsSpObtenerBonos + " " + e.getMessage());
			obtenerBonosResponse.setCodRespuesta(codError);
			obtenerBonosResponse.setMsjRespuesta(msjError);

		} finally {

			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");
		}
		return obtenerBonosResponse;
	}

	public Object[] hisBloqueoStructArray(List<HisBloq> listaHisBloq, Connection conexion,
			StructDescriptor hisBloqueoStructDesc) throws SQLException {
		Object[] hisBloqueoStructArray = new Object[listaHisBloq.size()];
		if (listaHisBloq != null) {
			int g = 0;
			for (HisBloq hb : listaHisBloq) {
				Object[] hbParameter = new Object[8];
				hbParameter[0] = hb.getFechaCreacionBloq();
				hbParameter[1] = hb.getTickShdesBloq();
				hbParameter[2] = hb.getTickLdesBloq();
				hbParameter[3] = hb.getFechaCierreBloq();
				hbParameter[4] = hb.getTickCodigoBloq();
				hbParameter[5] = hb.getTickEstadobloq();
				hbParameter[6] = hb.getIdRazonbloq();
				hbParameter[7] = hb.getRazonbloq();

				STRUCT m = new STRUCT(hisBloqueoStructDesc, conexion, hbParameter);
				hisBloqueoStructArray[g] = m;

				g++;
			}
		}
		return hisBloqueoStructArray;
	}

	public Object[] bolsaLineaBaseArray(List<BolsaLineaBase> listaBolsaLineaBase, Connection conexion,
			StructDescriptor bolsaLineaBaseDesc) throws SQLException {
		Object[] bolsaLineaBaseStructArray = new Object[listaBolsaLineaBase.size()];

		if (listaBolsaLineaBase != null) {
			int b = 0;
			for (BolsaLineaBase blb : listaBolsaLineaBase) {
				Object[] blbParameter = new Object[4];
				blbParameter[0] = blb.getBolsa();
				blbParameter[1] = blb.getUnidadesMedida();
				blbParameter[2] = blb.getUnidadesAsignadas();
				blbParameter[3] = blb.getUnidadesConsumidas();

				STRUCT m = new STRUCT(bolsaLineaBaseDesc, conexion, blbParameter);
				bolsaLineaBaseStructArray[b] = m;

				b++;
			}

		}

		return bolsaLineaBaseStructArray;
	}

	public Object[] suscripcionStructArray(List<Suscripciones> listaSuscripciones, Connection conexion,
			StructDescriptor suscripcionStructDesc) throws SQLException {

		Object[] suscripcionStructArray = new Object[listaSuscripciones.size()];

		if (listaSuscripciones != null) {
			int j = 0;
			for (Suscripciones sc : listaSuscripciones) {
				Object[] suscParameter = new Object[7];
				suscParameter[0] = sc.getTipoProducto();
				suscParameter[1] = sc.getTipoTecnologia();
				suscParameter[2] = sc.getTipoSuscripcion();
				suscParameter[3] = sc.getBundleID();
				suscParameter[4] = sc.getModalidadPago();
				suscParameter[5] = sc.getCargoFijoPlan();
				suscParameter[6] = sc.getPlazoContrato();

				STRUCT m = new STRUCT(suscripcionStructDesc, conexion, suscParameter);
				suscripcionStructArray[j] = m;

				j++;
			}
		}
		return suscripcionStructArray;
	}

	private Object[] servAdicionalStructArray(List<ServiciosAdicionales> listaServAdicional, Connection conexion,
			StructDescriptor servAdicStructDesc) throws SQLException {

		Object[] servAdicionalStructArray = new Object[listaServAdicional.size()];

		if (listaServAdicional != null) {
			int k = 0;
			for (ServiciosAdicionales sc : listaServAdicional) {
				Object[] servAdicParameter = new Object[2];
				servAdicParameter[0] = sc.getPoId();
				servAdicParameter[1] = sc.getTipoPO();

				STRUCT m = new STRUCT(servAdicStructDesc, conexion, servAdicParameter);
				servAdicionalStructArray[k] = m;

				k++;
			}
		}
		return servAdicionalStructArray;
	}

	private Object[] getStructDatosOperacion(DatosOperacionBean datosOperacion) {

//	    //Date date = new Date();  
//	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	    String strDate = formatter.format(datosOperacion.getFecTransaccion());  

		Object[] objDatosOperacion = new Object[14];
		objDatosOperacion[0] = datosOperacion.getShoppingCartId();
		objDatosOperacion[1] = datosOperacion.getAppOrigen();
		objDatosOperacion[2] = datosOperacion.getCanal();
		objDatosOperacion[3] = datosOperacion.getTipoOperacion();

		objDatosOperacion[4] = datosOperacion.getFecTransaccion();
		objDatosOperacion[5] = datosOperacion.getModalidadVenta();
		objDatosOperacion[6] = datosOperacion.getCodPuntoVenta();
		objDatosOperacion[7] = datosOperacion.getCodDeptPv();
		objDatosOperacion[8] = datosOperacion.getCodProvPv();
		objDatosOperacion[9] = datosOperacion.getCodDistPv();
		objDatosOperacion[10] = datosOperacion.getCodDeptFac();
		objDatosOperacion[11] = datosOperacion.getCodProvFac();
		objDatosOperacion[12] = datosOperacion.getCodDistFac();
		objDatosOperacion[13] = datosOperacion.getFlagActivacionDirecta();

		return objDatosOperacion;
	}

	public Date cadenaAFecha(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		String cadenaFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = (Date) formatter.parse(cadenaFecha);
		} catch (ParseException e) {
			fechaDate = null;
		}
		return fechaDate;
	}

	private Object[] getStructDatosClientes(DatosClienteBean datosClientes) {

		Object[] objDatosClientes = new Object[21];
		objDatosClientes[0] = datosClientes.getCustomerIdExt();
		objDatosClientes[1] = datosClientes.getBillingAccount();
		objDatosClientes[2] = datosClientes.getCicloFact();
		objDatosClientes[3] = datosClientes.getSegmentoCliente();
		objDatosClientes[4] = datosClientes.getTipoDocumento();
		objDatosClientes[5] = datosClientes.getNumeroDocumento();
		objDatosClientes[6] = datosClientes.getFecNacimiento();
		objDatosClientes[7] = datosClientes.getGenero();
		objDatosClientes[8] = datosClientes.getFechaAltaCliente();
		objDatosClientes[9] = datosClientes.getComportamientoPago();
		objDatosClientes[10] = datosClientes.getScoreInterconex();
		objDatosClientes[11] = datosClientes.getPago_puntual();
		objDatosClientes[12] = datosClientes.getIngPromMovilFija();
		objDatosClientes[13] = datosClientes.getIngPromLineaFag();
		objDatosClientes[14] = datosClientes.getCantLineaPrepago();
		objDatosClientes[15] = datosClientes.getCantLineaPostpago();
		objDatosClientes[16] = datosClientes.getCantLineaServFijo();
		objDatosClientes[17] = datosClientes.getCantLineaServFijoTot();
		objDatosClientes[18] = datosClientes.getCantPortaMovil();
		objDatosClientes[19] = datosClientes.getCantPortaFijo();
		objDatosClientes[20] = datosClientes.getCustomerIdInt();
		return objDatosClientes;
	}

	@Override
	public ActualizarEvaluacionBonosResponse actualizarEvaluacionBonos(String mensajeTransaccion,
			ActualizarEvaluacionBonosRequest actualizarEvaluacionBonosRequest) throws DBException, SQLException {
		// TODO Auto-generated method stub

		String nombreMetodo = "actualizarEvaluacionBonosResponse";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();

		ActualizarEvaluacionBonosResponse actualizarEvaluacionBonosResponse = new ActualizarEvaluacionBonosResponse();

		try {
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbBscs + ", con JNDI = ["
					+ constantesExternos.dbBscsJndi + "]");
			bscsDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbBscsTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.constantesExternos.dbBscsOwner)
					.withProcedureName(this.constantesExternos.PromsuActProcTempPasincro)
					.declareParameters(new SqlParameter("pi_order_id", OracleTypes.VARCHAR),
							new SqlParameter("pi_accion_id", OracleTypes.VARCHAR),
							new SqlParameter("pi_estado_om", OracleTypes.VARCHAR),
							new SqlParameter("pi_fec_crea_om", OracleTypes.DATE),
							new SqlParameter("pi_fec_ini_proc_om", OracleTypes.DATE),
							new SqlParameter("pi_fec_fin_proc_om", OracleTypes.DATE),
							new SqlParameter("pi_shopping_cart_id", OracleTypes.VARCHAR),

							new SqlOutParameter("po_cod_err", OracleTypes.INTEGER),
							new SqlOutParameter("po_des_err", OracleTypes.VARCHAR));

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_order_id", actualizarEvaluacionBonosRequest.getPi_order_id())
					.addValue("pi_accion_id", actualizarEvaluacionBonosRequest.getPi_accion_id())
					.addValue("pi_estado_om", actualizarEvaluacionBonosRequest.getPi_estado_om())
					.addValue("pi_fec_crea_om", actualizarEvaluacionBonosRequest.getFecCreaOm())

					.addValue("pi_fec_ini_proc_om", actualizarEvaluacionBonosRequest.getFecIniProcOm())
					.addValue("pi_fec_fin_proc_om", actualizarEvaluacionBonosRequest.getFecFinProcOm())
					.addValue("pi_shopping_cart_id", actualizarEvaluacionBonosRequest.getPi_shopping_cart_id());

			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbBscsOwner
					.concat(Constantes.PUNTO).concat(this.constantesExternos.PromsuActProcTempPasincro));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");

			logger.info(mensajeMetodo + "[pi_order_id]=" + actualizarEvaluacionBonosRequest.getPi_order_id());
			logger.info(mensajeMetodo + "[pi_accion_id]=" + actualizarEvaluacionBonosRequest.getPi_accion_id());
			logger.info(mensajeMetodo + "[pi_estado_om]=" + actualizarEvaluacionBonosRequest.getPi_estado_om());
			logger.info(mensajeMetodo + "[pi_fec_crea_om]=" + actualizarEvaluacionBonosRequest.getFecCreaOm());
			logger.info(mensajeMetodo + "[pi_fec_ini_proc_om]=" + actualizarEvaluacionBonosRequest.getFecIniProcOm());
			logger.info(mensajeMetodo + "[pi_fec_fin_proc_om]=" + actualizarEvaluacionBonosRequest.getFecFinProcOm());
			logger.info(mensajeMetodo + "[pi_shopping_cart_id]="
					+ actualizarEvaluacionBonosRequest.getPi_shopping_cart_id());

			call.getJdbcTemplate()
					.setQueryTimeout(Integer.parseInt(this.constantesExternos.dbBscsTimeoutExecutionMaxTime));
			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbBscsOwner
					+ Constantes.PUNTO + constantesExternos.PromsuActProcTempPasincro);

			String codigoRespuesta = (resultMap.get("po_cod_err") != null) ? resultMap.get("po_cod_err").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("po_des_err") != null) ? resultMap.get("po_des_err").toString()
					: null;

			actualizarEvaluacionBonosResponse.setCodigo(codigoRespuesta);
			actualizarEvaluacionBonosResponse.setMensaje(mensajeRespuesta);

			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(actualizarEvaluacionBonosResponse));

		} catch (Exception e) {
			String excepcion = e + "";

			String codError = null;
			String msjError = null;
			logger.error(mensajeMetodo + e.getMessage());

			if (excepcion.contains(this.constantesExternos.bdErrorSqlTimeoutException)) {
				codError = this.constantesExternos.codigoIdt1;
				msjError = this.constantesExternos.mensajeIdt1;

			} else {
				codError = this.constantesExternos.codigoIdt2;
				msjError = this.constantesExternos.mensajeIdt2;
			}
			msjError = msjError
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA,
							Constantes.VALOR_BD + "-" + this.constantesExternos.dbBscs)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbBscsSpExtraeDataExt + " ".concat(e.getMessage()));

			throw new DBException(codError, msjError + " :BscsDAOImpl - ExtraePlataformasResponse", e);

		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");

		}

		return actualizarEvaluacionBonosResponse;
	}
}

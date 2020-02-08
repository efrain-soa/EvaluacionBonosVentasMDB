package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.jdbc.OracleTypes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ListaOperador;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.ObtenerOperadorCedenteResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;

@Service
public class GwpDaoImpl implements GwpDao{

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	@Qualifier("gwpDS")
	private DataSource gwpDS;
	
	@Autowired
	private ExternalProperties constantesExternos;
	
	@SuppressWarnings("unchecked")
	@Override
	public ObtenerOperadorCedenteResponse obtenerOperadorCedente(String mensajeTransaccion,
			ObtenerOperadorCedenteRequest request) throws DBException {
		
		String nombreMetodo = "obtenerOperadorCedente";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();	
		
		ObtenerOperadorCedenteResponse obtenerOperadorCedenteResponse = new ObtenerOperadorCedenteResponse();
		
		try{
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbDwh + ", con JNDI = ["
					+ constantesExternos.dbGwpJndi + "]");
			
			gwpDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbGwpTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(gwpDS).withoutProcedureColumnMetaDataAccess().withSchemaName(this.constantesExternos.dbGwpOwner)
					.withProcedureName(this.constantesExternos.dbGwpSpObtenerOperadorCedente).declareParameters(
							new SqlParameter("pi_tipodocumentoIn",OracleTypes.CHAR),
							new SqlParameter("pi_numerodocumento",OracleTypes.VARCHAR),
							new SqlParameter("pi_numeroaportar",OracleTypes.VARCHAR),
							new SqlOutParameter("po_operadorcur", OracleTypes.CURSOR, new RowMapper<ListaOperador>() {
								public ListaOperador mapRow(ResultSet rs, int arg1) throws SQLException {
									ListaOperador operador = new ListaOperador();
									operador.setIdPortabilidad(rs.getInt("PORTAN_ID_PORTABILIDAD"));			
									operador.setTipoDocumento(rs.getString("PORTAC_TIPO_DOCUMENTO"));			
									operador.setNumeroDocumento(rs.getString("PORTAV_NUMERO_DOCUMENTO"));			
									operador.setNumeroAPortar(rs.getString("PORTAV_NUMERO_A_PORTAR"));			
									operador.setFechaRegistro(rs.getTimestamp("PORTAT_FECHA_REGISTRO"));
									operador.setCedente(rs.getString("PORTAC_CEDENTE"));
									operador.setFechaActivaCedente(rs.getDate("PORTAD_FECHA_ACTIVA_CEDENTE"));
									return operador;
								}
							}),
							new SqlOutParameter("po_cod_err", OracleTypes.NUMBER),
							new SqlOutParameter("po_des_err", OracleTypes.VARCHAR));
			
			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_tipodocumentoIn", request.getTipoDocumento())
					.addValue("pi_numerodocumento", request.getNumeroDocumento())
					.addValue("pi_numeroaportar", request.getNumeroAPortar());
			
			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbGwpOwner.concat(Constantes.PUNTO).concat(this.constantesExternos.dbGwpSpObtenerOperadorCedente));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");
			logger.info(mensajeMetodo + "[pi_tipodocumentoIn] = " + request.getTipoDocumento());
			logger.info(mensajeMetodo + "[pi_numerodocumento] = " + request.getNumeroDocumento());
			logger.info(mensajeMetodo + "[pi_numeroaportar] = " + request.getNumeroAPortar());
			
			call.getJdbcTemplate().setQueryTimeout(Integer.parseInt(this.constantesExternos.dbGwpTimeoutExecutionMaxTime));
			
			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbGwpOwner + Constantes.PUNTO 
					+ constantesExternos.dbGwpSpObtenerOperadorCedente);
			
			String codigoRespuesta = (resultMap.get("po_cod_err") != null) ? resultMap.get("po_cod_err").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("po_desc_err") != null) ? resultMap.get("po_desc_err").toString()
					: null;
			
			obtenerOperadorCedenteResponse.setCodError(codigoRespuesta);
			obtenerOperadorCedenteResponse.setDesError(mensajeRespuesta);
			
			//ListaOperador
			//List<Rol> listaRoles = (List<Rol>) resultMap.get("P_CURSOR");
			List<ListaOperador> listaOperadores = (List<ListaOperador>) resultMap.get("po_operadorcur");
			if (listaOperadores != null) {
				if (listaOperadores.size() > 0) {
					obtenerOperadorCedenteResponse.setListaOperador(listaOperadores);
				}else{
					logger.info(mensajeMetodo + "po_operadorcur se encuentra vacio");
				}
			}else {
				logger.info(mensajeMetodo + "po_operadorcur es nulo");
			}
			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(obtenerOperadorCedenteResponse));
			
		}catch (Exception e) {
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
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA, Constantes.VALOR_BD + "-" + this.constantesExternos.dbGwp)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbGwpSpObtenerOperadorCedente + " ".concat(e.getMessage()));
			
			throw new DBException(codError, msjError, "GwpDaoImpl", e);
			
		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");
		}
		
		return obtenerOperadorCedenteResponse;
	}

}

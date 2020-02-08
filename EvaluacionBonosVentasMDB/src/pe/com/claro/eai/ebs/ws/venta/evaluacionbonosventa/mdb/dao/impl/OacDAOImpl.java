package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.stereotype.Service;

import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.PagoPuntualResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;

@Service
public class OacDAOImpl implements OacDAO{

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	@Qualifier("oacDS")
	private DataSource oacDS;
	
	@Autowired
	private ExternalProperties constantesExternos;
	
	@SuppressWarnings("unchecked")
	@Override
	public PagoPuntualResponse pagoPuntual(String mensajeTransaccion, PagoPuntualRequest request) throws DBException {


		String nombreMetodo = "pagoPuntual";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();
		
		PagoPuntualResponse pagoPuntualResponse = new PagoPuntualResponse();
		
		try{
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbOac + ", con JNDI = ["
					+ constantesExternos.dbOacJndi + "]");
			oacDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbOacTimeoutConnectionMaxTime));
			
			SimpleJdbcCall call = new SimpleJdbcCall(oacDS).withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.constantesExternos.dbOacOwner)
					.withProcedureName(this.constantesExternos.dbOacSpPagoPuntual)
					.declareParameters(
							new SqlParameter("piv_CUSTOMER_ID", OracleTypes.VARCHAR),
							new SqlParameter("pin_CANTIDAD_MESES", OracleTypes.INTEGER),
							new SqlOutParameter("pov_COD_RESPUESTA", OracleTypes.VARCHAR),
							new SqlOutParameter("pov_MSG_RESPUESTA", OracleTypes.VARCHAR),
							new SqlOutParameter("pov_INDICADOR_PP", OracleTypes.INTEGER)
							);
			
			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("piv_CUSTOMER_ID", request.getCustomerId())
					.addValue("pin_CANTIDAD_MESES", request.getCantidadMeses());
			
			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbOacOwner
					.concat(Constantes.PUNTO).concat(this.constantesExternos.dbOacSpPagoPuntual));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");
			logger.info(mensajeMetodo + "[piv_CUSTOMER_ID] = " + request.getCustomerId());
			logger.info(mensajeMetodo + "[pin_CANTIDAD_MESES] = " + request.getCantidadMeses());
			
			call.getJdbcTemplate()
			.setQueryTimeout(Integer.parseInt(this.constantesExternos.dbOacTimeoutExecutionMaxTime));
			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbOacOwner + Constantes.PUNTO 
					+ constantesExternos.dbOacSpPagoPuntual);
			
			String codigoRespuesta = (resultMap.get("pov_COD_RESPUESTA") != null) ? resultMap.get("pov_COD_RESPUESTA").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("pov_MSG_RESPUESTA") != null) ? resultMap.get("pov_MSG_RESPUESTA").toString()
					: null;
			String indicadorPP = (resultMap.get("pov_INDICADOR_PP") != null) ? resultMap.get("pov_INDICADOR_PP").toString()
					: null;
			
			pagoPuntualResponse.setCodRespuesta(codigoRespuesta);
			pagoPuntualResponse.setMsgRespuesta(mensajeRespuesta);
			pagoPuntualResponse.setIndicadorPp(indicadorPP);
			
			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(pagoPuntualResponse));

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
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA, Constantes.VALOR_BD + "-" + this.constantesExternos.dbOac)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.dbOacSpPagoPuntual + " ".concat(e.getMessage()));
			
			throw new DBException(codError, msjError, "OacDAOImpl - pagoPuntual", e);
			
		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");
		}
		
		return pagoPuntualResponse;
	}

}

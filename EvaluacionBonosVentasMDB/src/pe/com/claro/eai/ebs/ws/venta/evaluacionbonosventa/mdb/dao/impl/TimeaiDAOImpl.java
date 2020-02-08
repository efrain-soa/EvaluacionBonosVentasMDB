package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.InsertOperacionResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;

import java.util.Map;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class TimeaiDAOImpl implements TimeaiDAO {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	@Qualifier("timeaiDS")
	private DataSource timeaiDS;

	@Autowired
	private ExternalProperties constantesExternos;

	@SuppressWarnings("unchecked")
	@Override
	public InsertOperacionResponse insertOperacion(String mensajeTransaccion,
			InsertOperacionRequest insertOperacionRequest) throws DBException {

		String nombreMetodo = "insertOperacion";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();

		InsertOperacionResponse insertOperacionResponse = new InsertOperacionResponse();

		try {
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbTimeai + ", con JNDI = ["
					+ constantesExternos.dbTimeaiJndi + "]");
			timeaiDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbTimeaiTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(timeaiDS).withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.constantesExternos.dbTimeaiOwner)
					.withProcedureName(this.constantesExternos.spOMSI_OPERACION)
					.declareParameters(new SqlParameter("K_ID_ORDEN", OracleTypes.VARCHAR),
							new SqlParameter("K_TRANSAC", OracleTypes.VARCHAR),
							new SqlParameter("K_FECHA", OracleTypes.DATE),
							new SqlParameter("K_ESTADO", OracleTypes.VARCHAR),
							new SqlParameter("K_PROD_INSTAN", OracleTypes.CLOB),
							new SqlParameter("K_USR_MODIF", OracleTypes.VARCHAR),
							new SqlOutParameter("K_CODERROR", OracleTypes.VARCHAR),
							new SqlOutParameter("K_MSGERROR", OracleTypes.VARCHAR));

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("K_ID_ORDEN", insertOperacionRequest.getIdOrden())
					.addValue("K_TRANSAC", insertOperacionRequest.getTransac())
					.addValue("K_FECHA", insertOperacionRequest.getFecha())
					.addValue("K_ESTADO", insertOperacionRequest.getEstado())
					.addValue("K_PROD_INSTAN", insertOperacionRequest.getProdInstan())
					.addValue("K_USR_MODIF", insertOperacionRequest.getUsrModif());

			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbTimeaiOwner
					.concat(Constantes.PUNTO).concat(this.constantesExternos.spOMSI_OPERACION));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");
			logger.info(mensajeMetodo + "[K_ID_ORDEN] = " + insertOperacionRequest.getIdOrden());
			logger.info(mensajeMetodo + "[K_TRANSAC] = " + insertOperacionRequest.getTransac());
			logger.info(mensajeMetodo + "[K_FECHA] = " + insertOperacionRequest.getFecha());
			logger.info(mensajeMetodo + "[K_ESTADO] = " + insertOperacionRequest.getEstado());
			logger.info(mensajeMetodo + "[K_PROD_INSTAN] = " + insertOperacionRequest.getProdInstan());
			logger.info(mensajeMetodo + "[K_USR_MODIF] = " + insertOperacionRequest.getUsrModif());

			call.getJdbcTemplate()
					.setQueryTimeout(Integer.parseInt(this.constantesExternos.dbTimeaiTimeoutExecutionMaxTime));

			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbTimeaiOwner + "."
					+ constantesExternos.spOMSI_OPERACION);

			String codigoError = (resultMap.get("K_CODERROR") != null) ? resultMap.get("K_CODERROR").toString() : null;
			String mensajeError = (resultMap.get("K_MSGERROR") != null) ? resultMap.get("K_MSGERROR").toString() : null;

			insertOperacionResponse.setCodError(codigoError);
			insertOperacionResponse.setMsgError(mensajeError);

			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(insertOperacionResponse));

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
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA, Constantes.VALOR_BD + "-" + this.constantesExternos.dbTimeai)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.spOMSI_OPERACION + " ".concat(e.getMessage()));
			throw new DBException(codError, msjError, "TimeaiDAOImpl", e);

		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");
		}

		return insertOperacionResponse;

	}

}
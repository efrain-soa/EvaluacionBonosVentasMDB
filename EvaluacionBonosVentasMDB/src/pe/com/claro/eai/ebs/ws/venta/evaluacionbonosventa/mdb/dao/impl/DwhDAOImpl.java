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
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltRequest;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.IndicCharltResponse;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean.Rol;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception.DBException;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.Constantes;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.ExternalProperties;
import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util.JAXBUtilitarios;

@Service
public class DwhDAOImpl implements DwhDAO{

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	@Qualifier("timdwhDS")
	private DataSource timdwhDS;
	
	@Autowired
	private ExternalProperties constantesExternos;
	
	@SuppressWarnings("unchecked")
	@Override
	public IndicCharltResponse indicCharlt(String mensajeTransaccion, IndicCharltRequest indicCharltRequest)
			throws DBException {
		
		String nombreMetodo = "indicCharlt";
		String mensajeMetodo = mensajeTransaccion + " [" + nombreMetodo + "]";
		logger.info(mensajeMetodo + "[INICIO] - METODO: [" + nombreMetodo + " - DAO] ");
		long tiempoInicio = System.currentTimeMillis();	
		
		IndicCharltResponse indicCharltResponse = new IndicCharltResponse();
		
		try {
			logger.info(mensajeMetodo + " Consultando BD " + constantesExternos.dbDwh + ", con JNDI = ["
					+ constantesExternos.dbDwhJndi + "]");
			timdwhDS.setLoginTimeout(Integer.parseInt(constantesExternos.dbDwhTimeoutConnectionMaxTime));
			SimpleJdbcCall call = new SimpleJdbcCall(timdwhDS).withoutProcedureColumnMetaDataAccess().withSchemaName(this.constantesExternos.dbDwhOwner)
					.withProcedureName(this.constantesExternos.spTCRMSS_INDIC_CHARLT).declareParameters(
							new SqlParameter("p_nro_telefeno",OracleTypes.VARCHAR),
							new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR, new RowMapper<Rol>() {
								public Rol mapRow(ResultSet rs, int arg1) throws SQLException {
									Rol roles = new Rol();
									roles.setPeriodo(rs.getString("PERIODO"));			
									roles.setNro_telefono(rs.getString("NRO_TELEFONO"));			
									roles.setOperador(rs.getString("OPERADOR"));			
									roles.setNlineaid(rs.getLong("NLINEAID"));			
									roles.setRol(rs.getInt("ROL"));
									roles.setComunidad(rs.getInt("COMUNIDAD"));
									roles.setVecindad(rs.getInt("VECINDAD")); 
									roles.setCentralidad_de_entrada(rs.getInt("CENTRALIDAD_DE_ENTRADA"));
									roles.setNo_centralidad(rs.getInt("NO_CENTRALIDAD"));
									roles.setCentralidad_de_salida(rs.getInt("CENTRALIDAD_DE_SALIDA"));
									roles.setCentralidad_total(rs.getInt("CENTRALIDAD_TOTAL"));
									roles.setIntensidad(rs.getDouble("INTENSIDAD"));
									roles.setFecha(rs.getString("FECHA"));
									roles.setSmodsuscrid(rs.getString("SMODSUSCRID"));
									roles.setSregionid(rs.getString("SREGIONID"));
									roles.setNimptotfacli(rs.getInt("NIMPTOTFACLI"));
									roles.setNantiguedadlinea(rs.getInt("NANTIGUEDADLINEA"));
									roles.setNduracion_tcl_porc(rs.getInt("NDURACION_TCL_PORC"));
									roles.setNnivel(rs.getInt("NNIVEL"));
									roles.setNimprlongdist(rs.getInt("NIMPRLONGDIST"));
									roles.setNimproamer(rs.getInt("NIMPROAMER"));
									roles.setStecnologiaid(rs.getString("STECNOLOGIAID"));
									roles.setNmesrenovaden(rs.getInt("NMESRENOVADEN"));
									roles.setSfeadden(rs.getString("SFEADDEN"));
									roles.setNduraddendum(rs.getInt("NDURADDENDUM"));
									roles.setNnumrecargas(rs.getInt("NNUMRECARGAS"));
									roles.setNsegmentocliente(rs.getInt("NSEGMENTOCLIENTE"));
									roles.setSmarcaid(rs.getString("SMARCAID"));
									roles.setSmodeloid(rs.getString("SMODELOID"));
									roles.setSmarca_comercial(rs.getString("SMARCA_COMERCIAL"));
									roles.setSstatuslineaid(rs.getString("SSTATUSLINEAID"));
									roles.setVz(rs.getInt("VZ"));
									roles.setSms(rs.getInt("SMS"));
									roles.setMm(rs.getInt("MM"));
									roles.setEsp(rs.getInt("ESP"));
									roles.setNduracion(rs.getInt("NDURACION"));
									roles.setNduracionred(rs.getInt("NDURACIONRED"));
									roles.setVzen(rs.getInt("VZEN"));
									roles.setSmsen(rs.getInt("SMSEN"));
									roles.setMmen(rs.getInt("MMEN"));
									roles.setEspen(rs.getInt("ESPEN"));
									roles.setNduracionen(rs.getInt("NDURACIONEN"));
									roles.setNduracionreden(rs.getInt("NDURACIONREDEN"));
									roles.setFlg_portad(rs.getString("FLG_PORTADO"));

									return roles;
								}
							}), 
							new SqlOutParameter("po_cod_err", OracleTypes.NUMBER),
							new SqlOutParameter("po_des_err", OracleTypes.VARCHAR));
			
			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("p_nro_telefeno", indicCharltRequest.getNroTelefono());
			
			logger.info(mensajeMetodo + "Se invocara el SP : " + this.constantesExternos.dbDwhOwner.concat(Constantes.PUNTO).concat(this.constantesExternos.spTCRMSS_INDIC_CHARLT));
			logger.info(mensajeMetodo + "PARAMETROS [INPUT]: ");
			logger.info(mensajeMetodo + "[p_nro_telefeno] = " + indicCharltRequest.getNroTelefono());
			
			call.getJdbcTemplate().setQueryTimeout(Integer.parseInt(this.constantesExternos.dbDwhTimeoutExecutionMaxTime));
			
			Map<String, Object> resultMap = call.execute(objParametrosIN);
			logger.info(mensajeMetodo + " Se invoco con exito el SP: " + this.constantesExternos.dbDwhOwner + Constantes.PUNTO 
					+ constantesExternos.spTCRMSS_INDIC_CHARLT);
			
			String codigoRespuesta = (resultMap.get("po_cod_err") != null) ? resultMap.get("po_cod_err").toString()
					: null;
			String mensajeRespuesta = (resultMap.get("po_desc_err") != null) ? resultMap.get("po_desc_err").toString()
					: null;
			
			indicCharltResponse.setCodRespuesta(codigoRespuesta);
			indicCharltResponse.setMsjRespuesta(mensajeRespuesta);
			
			List<Rol> listaRoles = (List<Rol>) resultMap.get("P_CURSOR");
			if (listaRoles != null) {
				if (listaRoles.size() > 0) {
				indicCharltResponse.setRol(listaRoles);
				} else{
				logger.info(mensajeMetodo + "P_CURSOR se encuentra vacio");
				}
			}else {
				logger.info(mensajeMetodo + "P_CURSOR es nulo");
			}
			
			logger.info(mensajeMetodo + " PARAMETROS [OUPUT]: "
					+ JAXBUtilitarios.anyObjectToXmlText(indicCharltResponse));
			
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
					.replace(Constantes.IDENTIFICADOR_PLATAFORMA, Constantes.VALOR_BD + "-" + this.constantesExternos.dbDwh)
					.replace(Constantes.IDENTIFICADOR_ERROR,
							this.constantesExternos.spTCRMSS_INDIC_CHARLT + " ".concat(e.getMessage()));
			
			//throw new DBException(codError, msjError, "DwhDAOImpl", e);
			indicCharltResponse.setCodRespuesta(codError);
			indicCharltResponse.setMsjRespuesta(msjError);
		} finally {
			this.logger.info(mensajeMetodo + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicio)
					+ " milisegundos ]");
			this.logger.info(mensajeMetodo + "[FIN] - METODO: [" + nombreMetodo + " - DAO] ");
		}
		
		return indicCharltResponse;
	}

}

package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

import org.springframework.data.jdbc.support.oracle.StructMapper;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class BolsaLineasMapper implements StructMapper<LineaBaseBean>{

	@Override
	public LineaBaseBean fromStruct(STRUCT struct) throws SQLException {
		Object[] attr = struct.getAttributes();
		LineaBaseBean bean = new LineaBaseBean();
		
		if (attr[0] != null && attr[0] instanceof String) {
			bean.setContractIdBase((String) attr[0]);
		}
		if (attr[1] != null && attr[1] instanceof String) {
			bean.setLineaBase((String) attr[1]);
		}
		if (attr[2] != null && attr[2] instanceof String) {
			bean.setPoIdBase((String) attr[2]);
		}
		if (attr[3] != null && attr[3] instanceof String) {
			bean.setPoNameBase((String) attr[3]);
		}
		if (attr[4] != null && attr[4] instanceof String) {
			bean.setCustomerIdExtBase((String) attr[4]);
		}
		if (attr[5] != null && attr[5] instanceof String) {
			bean.setCustomerIdIntBase((Integer) attr[5]);
		}
		if (attr[6] != null && attr[6] instanceof String) {
			bean.setBillingAccountBase((String) attr[6]);
		}
		if (attr[7] != null && attr[7] instanceof String) {
			bean.setCicloFactBase((String) attr[7]);
		}
		if (attr[8] != null && attr[8] instanceof Double) {
			bean.setCargoFijoPlanBase((Double) attr[8]);
		}
		if (attr[9] != null && attr[9] instanceof String) {
			bean.setTipoProductoBase((String) attr[9]);
		}
		if (attr[10] != null && attr[10] instanceof String) {
			bean.setTipoSuscripcionBase((String) attr[10]);
		}
		if (attr[11] != null && attr[11] instanceof Date) {
			bean.setFecActivacionBase((Date) attr[11]);
		}
		if (attr[12] != null && attr[12] instanceof String) {
			bean.setEstadoLineaBase((String) attr[12]);
		}
		
		/*2019-03-31*/
		if (attr[13] != null && attr[13] instanceof String) {
			bean.setBundleId((String) attr[13]);
		}
		if (attr[14] != null && attr[14] instanceof String) {
			bean.setStatusBilling((String) attr[14]);
		}
		if (attr[15] != null && attr[15] instanceof String) {
			bean.setEmail((String) attr[15]);
		}
		if (attr[16] != null && attr[16] instanceof String) {
			bean.setTecnologia((String) attr[16]);
		}
		if (attr[17] != null && attr[17] instanceof String) {
			bean.setTipoTelefono((String) attr[17]);
		}
		if (attr[18] != null && attr[18] instanceof Date) {
			bean.setFecModSuscription((Date) attr[18]);
		}
		/*2019-03-31*/
		
		if (attr[19] != null && attr[19] instanceof String) {
			bean.setIndLineaPortaBase((String) attr[19]);
		}
		
		
		return bean;
	}

	@Override
	public STRUCT toStruct(LineaBaseBean source, Connection conn, String typeName) throws SQLException {
		StructDescriptor descriptor = new StructDescriptor(typeName, conn);
		
	    Object[] values = {
	            source.getContractIdBase(),
	            source.getLineaBase(),
	            source.getPoIdBase(),
	            source.getPoNameBase(),
	            source.getCustomerIdExtBase(),
	            source.getCustomerIdIntBase(),
	            source.getBillingAccountBase(),
	            source.getCicloFactBase(),
	            source.getCargoFijoPlanBase(),
	            source.getTipoProductoBase(),
	            source.getTipoSuscripcionBase(),
	            source.getFecActivacionBase(),
	            source.getEstadoLineaBase(),
	            source.getBundleId(),
	            source.getStatusBilling(),
	            source.getEmail(),
	            source.getTecnologia(),
	            source.getTipoTelefono(),
	            source.getFecModSuscription(),
	            source.getHisBloqueo(),
	            source.getIndLineaPortaBase(),
	            source.getHisCambPlanBase(),
	            source.getHisRenovacionBase(),
	            source.getBolsaLineaBase()
	        };
		
		return new STRUCT(descriptor, conn, values);
	}

}

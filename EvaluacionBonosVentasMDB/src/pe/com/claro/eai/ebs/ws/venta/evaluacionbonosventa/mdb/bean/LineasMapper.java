package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.springframework.data.jdbc.support.oracle.StructMapper;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class LineasMapper implements StructMapper<LineaBean> {

	@Override
	public LineaBean fromStruct(STRUCT struct) throws SQLException {
		Object[] attr = struct.getAttributes();
		LineaBean bean = new LineaBean();

		if (attr[0] != null && attr[0] instanceof String) {
			bean.setLinea((String) attr[0]);
		}
		if (attr[1] != null && attr[1] instanceof String) {
			bean.setPoId((String) attr[1]);
		}
		if (attr[2] != null && attr[2] instanceof String) {
			bean.setPoName((String) attr[2]);
		}
		if (attr[3] != null && attr[3] instanceof String) {
			bean.setIccid((String) attr[3]);
		}
		if (attr[4] != null && attr[4] instanceof Integer) {
			bean.setCantDecos((Integer) attr[4]);
		}
		if (attr[5] != null && attr[5] instanceof String) {
			bean.setCasoEspecial((String) attr[5]);
		}
		if (attr[6] != null && attr[6] instanceof String) {
			bean.setCampania((String) attr[6]);
		}
		if (attr[7] != null && attr[7] instanceof String) {
			bean.setTope((String) attr[7]);
		}
		if (attr[8] != null && attr[8] instanceof String) {
			bean.setSuscripcionCorreo((String) attr[8]);
		}
		if (attr[9] != null && attr[9] instanceof String) {
			bean.setLineaReferente((String) attr[9]);
		}
		if (attr[10] != null && attr[10] instanceof String) {
			bean.setCodDeptIns((String) attr[10]);
		}
		if (attr[11] != null && attr[11] instanceof String) {
			bean.setCodProvIns((String) attr[11]);
		}
		if (attr[12] != null && attr[12] instanceof String) {
			bean.setCodDistIns((String) attr[12]);
		}
		if (attr[13] != null && attr[13] instanceof String) {
			bean.setMarcaEquipo((String) attr[13]);
		}
		if (attr[14] != null && attr[14] instanceof String) {
			bean.setModeloEquipo((String) attr[14]);
		}
		if (attr[15] != null && attr[15] instanceof Double) {
			bean.setPrecioVentaEquipo((Double) attr[15]);
		}
		if (attr[16] != null && attr[16] instanceof String) {
			bean.setClasiCharlotte((String) attr[16]);
		}
		if (attr[17] != null && attr[17] instanceof String) {
			bean.setOperCedente((String) attr[17]);
		}
		if (attr[18] != null && attr[18] instanceof Date) {
			bean.setFecActOperCedente((Date) attr[18]);
		}
		if (attr[19] != null && attr[19] instanceof String) {
			bean.setContractId((String) attr[19]);
		}
		if (attr[20] != null && attr[20] instanceof String) {
			bean.setContractIdbscs((String) attr[20]);
		}

		return bean;
	}

	@Override
	public STRUCT toStruct(LineaBean source, Connection conn, String typeName) throws SQLException {
		StructDescriptor descriptor = new StructDescriptor(typeName, conn);
		Object[] values = {
				source.getLinea(),
			    source.getPoId(),
			    source.getPoName(),
			    source.getIccid(),
			    source.getCantDecos(),
			    source.getCasoEspecial(),
			    source.getCampania(),
			    source.getTope(),
			    source.getSuscripcionCorreo(),
			    source.getLineaReferente(),
			    source.getCodDeptIns(),
			    source.getCodProvIns(),
			    source.getCodDistIns(),
			    source.getMarcaEquipo(),
			    source.getModeloEquipo(),
			    source.getPrecioVentaEquipo(),
			    source.getClasiCharlotte(),
			    source.getOperCedente(),
			    source.getFecActOperCedente(),
			    source.getContractId(),
			    source.getContractIdbscs(),
			    source.getSuscripciones(),
			    source.getServiciosAdicionales(),
			    source.getBonos()
			};
		return new STRUCT(descriptor, conn, values);
	}

}

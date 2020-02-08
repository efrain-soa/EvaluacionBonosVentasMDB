package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

import java.io.Serializable;
import java.util.Date;

public class InsertOperacionRequest implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6211415670531988474L;
	private String idOrden;
	private String transac;
	private Date fecha;
	private String estado;
	private String prodInstan;
	private String usrModif;

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getTransac() {
		return transac;
	}

	public void setTransac(String transac) {
		this.transac = transac;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProdInstan() {
		return prodInstan;
	}

	public void setProdInstan(String prodInstan) {
		this.prodInstan = prodInstan;
	}

	public String getUsrModif() {
		return usrModif;
	}

	public void setUsrModif(String usrModif) {
		this.usrModif = usrModif;
	}

}

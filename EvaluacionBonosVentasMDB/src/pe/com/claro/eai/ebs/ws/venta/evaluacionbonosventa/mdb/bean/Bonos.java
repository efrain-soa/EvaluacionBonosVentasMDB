package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.bean;

public class Bonos {

	private Integer idBono;
	private String poBono;
	private String poBonoName;
	private String bonoDes;
	private String flgProg;
	private String bonoGrupo;
	private String poType;
	private String flgElec;

	public String getPoBono() {
		return poBono;
	}

	public void setPoBono(String poBono) {
		this.poBono = poBono;
	}

	public String getPoBonoName() {
		return poBonoName;
	}

	public void setPoBonoName(String poBonoName) {
		this.poBonoName = poBonoName;
	}

	public String getBonoDes() {
		return bonoDes;
	}

	public void setBonoDes(String bonoDes) {
		this.bonoDes = bonoDes;
	}

	public String getFlgProg() {
		return flgProg;
	}

	public void setFlgProg(String flgProg) {
		this.flgProg = flgProg;
	}


	public Integer getIdBono() {
		return idBono;
	}

	public void setIdBono(Integer idBono) {
		this.idBono = idBono;
	}

	public String getBonoGrupo() {
		return bonoGrupo;
	}

	public void setBonoGrupo(String bonoGrupo) {
		this.bonoGrupo = bonoGrupo;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getFlgElec() {
		return flgElec;
	}

	public void setFlgElec(String flgElec) {
		this.flgElec = flgElec;
	}

}

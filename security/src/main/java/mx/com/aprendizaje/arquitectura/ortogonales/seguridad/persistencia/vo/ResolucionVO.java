package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

public class ResolucionVO {

	private Long idResolucion;
	private String cdResolucion;
	private String nbResolucion;
	private String nuPixelesBase;
	private String txResolucion;
	private Integer stActivo;

	 

	public Long getIdResolucion() {
		return idResolucion;
	}

	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}

	public String getCdResolucion() {
		return cdResolucion;
	}

	public void setCdResolucion(String cdResolucion) {
		this.cdResolucion = cdResolucion;
	}

	public String getNbResolucion() {
		return nbResolucion;
	}

	public void setNbResolucion(String nbResolucion) {
		this.nbResolucion = nbResolucion;
	}

	public String getNuPixelesBase() {
		return nuPixelesBase;
	}

	public void setNuPixelesBase(String nuPixelesBase) {
		this.nuPixelesBase = nuPixelesBase;
	}

	public String getTxResolucion() {
		return txResolucion;
	}

	public void setTxResolucion(String txResolucion) {
		this.txResolucion = txResolucion;
	}

	public Integer getStActivo() {
		return stActivo;
	}

	public void setStActivo(Integer stActivo) {
		this.stActivo = stActivo;
	}

}

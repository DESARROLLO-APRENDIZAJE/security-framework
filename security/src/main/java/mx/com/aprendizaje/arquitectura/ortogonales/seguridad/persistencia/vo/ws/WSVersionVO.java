package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws;

import java.util.Date;

public class WSVersionVO {

	private Long versionId;
	//private WebServiceVO servicio;
	private String versionNombre;
	private String versionDescripcion;
	private Date fechaLiberacionProduccion;
	private Integer versionActual;
	/**
	 * @return the versionId
	 */
	public Long getVersionId() {
		return versionId;
	}
	/**
	 * @param versionId the versionId to set
	 */
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	/**
	 * @return the versionNombre
	 */
	public String getVersionNombre() {
		return versionNombre;
	}
	/**
	 * @param versionNombre the versionNombre to set
	 */
	public void setVersionNombre(String versionNombre) {
		this.versionNombre = versionNombre;
	}
	/**
	 * @return the versionDescripcion
	 */
	public String getVersionDescripcion() {
		return versionDescripcion;
	}
	/**
	 * @param versionDescripcion the versionDescripcion to set
	 */
	public void setVersionDescripcion(String versionDescripcion) {
		this.versionDescripcion = versionDescripcion;
	}
	/**
	 * @return the fechaLiberacionProduccion
	 */
	public Date getFechaLiberacionProduccion() {
		return fechaLiberacionProduccion;
	}
	/**
	 * @param fechaLiberacionProduccion the fechaLiberacionProduccion to set
	 */
	public void setFechaLiberacionProduccion(Date fechaLiberacionProduccion) {
		this.fechaLiberacionProduccion = fechaLiberacionProduccion;
	}
	/**
	 * @return the versionActual
	 */
	public Integer getVersionActual() {
		return versionActual;
	}
	/**
	 * @param versionActual the versionActual to set
	 */
	public void setVersionActual(Integer versionActual) {
		this.versionActual = versionActual;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WSVersionVO [versionId=" + versionId + ", versionNombre=" + versionNombre + ", versionDescripcion="
				+ versionDescripcion + ", fechaLiberacionProduccion=" + fechaLiberacionProduccion + ", versionActual="
				+ versionActual + "]";
	}
	
	
}

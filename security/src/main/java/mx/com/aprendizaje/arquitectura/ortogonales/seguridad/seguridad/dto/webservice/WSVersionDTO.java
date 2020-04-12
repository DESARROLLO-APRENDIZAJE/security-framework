package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kevin Ojeda
 *
 */
@Entity
@Table(name = "TAQ037D_WS_VERSIONES")
public class WSVersionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186543590600625583L;
	
	@Id
	@Column(name = "ID_VERSION", unique = true, nullable = false)
	private Long versionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SERVICIO_WEB")
	private WebServiceDTO servicio;
	
	@Column(name = "NB_VERSION")
	private String versionNombre;
	
	@Column(name = "TX_VERSION")
	private String versionDescripcion;
	
	@Column(name = "FH_LIBERACION_PRODU")
	private Date fechaLiberacionProduccion;
	
	@Column(name = "ST_ACTUAL")
	private Integer versionActual;
	
	@Column(name = "ST_ACTIVO")
	private Integer activo;
	
	@Column(name = "ID_USR_CREACION")
	private Long creadoPor;

	@Column(name = "FH_CREACION")
	private Date fechaCreacion;

	@Column(name = "ID_USR_MODIFICA")
	private Long modificadoPor;

	@Column(name = "FH_MODIFICACION")
	private Date fechaModificacion;

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
	 * @return the servicio
	 */
	public WebServiceDTO getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(WebServiceDTO servicio) {
		this.servicio = servicio;
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

	/**
	 * @return the activo
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return the creadoPor
	 */
	public Long getCreadoPor() {
		return creadoPor;
	}

	/**
	 * @param creadoPor the creadoPor to set
	 */
	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the modificadoPor
	 */
	public Long getModificadoPor() {
		return modificadoPor;
	}

	/**
	 * @param modificadoPor the modificadoPor to set
	 */
	public void setModificadoPor(Long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WSVersionDTO [versionId=" + versionId + ", servicio=" + servicio + ", versionNombre=" + versionNombre
				+ ", versionDescripcion=" + versionDescripcion + ", fechaLiberacionProduccion="
				+ fechaLiberacionProduccion + ", versionActual=" + versionActual + ", activo=" + activo + ", creadoPor="
				+ creadoPor + ", fechaCreacion=" + fechaCreacion + ", modificadoPor=" + modificadoPor
				+ ", fechaModificacion=" + fechaModificacion + "]";
	}
	
}

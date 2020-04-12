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
@Table(name = "TAQ022D_WS_FUNCIONES_TMP")
public class FuncionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6810840549157815253L;

	@Id
	@Column(name = "ID_FUNCION", unique = true, nullable = false)
	private Long funcionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SERVICIO_WEB")
	private WebServiceDTO servicio;
	
	@Column(name = "CD_FUNCION")
	private String codigoFuncion;
	
	@Column(name = "NB_FUNCION")
	private String nombreFuncion;
	
	@Column(name = "TX_FUNCION_DESC")
	private String descripcionFuncion;
	
	@Column(name = "NB_URI")
	private String nombreUri;
	
	@Column(name = "NU_FUNCION")
	private String numeroFuncion;
	
	@Column(name = "TP_PETICION")
	private String tpPeticion;
	
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
	 * @return the funcionId
	 */
	public Long getFuncionId() {
		return funcionId;
	}

	/**
	 * @param funcionId the funcionId to set
	 */
	public void setFuncionId(Long funcionId) {
		this.funcionId = funcionId;
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
	 * @return the codigoFuncion
	 */
	public String getCodigoFuncion() {
		return codigoFuncion;
	}

	/**
	 * @param codigoFuncion the codigoFuncion to set
	 */
	public void setCodigoFuncion(String codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}

	/**
	 * @return the nombreFuncion
	 */
	public String getNombreFuncion() {
		return nombreFuncion;
	}

	/**
	 * @param nombreFuncion the nombreFuncion to set
	 */
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}

	/**
	 * @return the descripcionFuncion
	 */
	public String getDescripcionFuncion() {
		return descripcionFuncion;
	}

	/**
	 * @param descripcionFuncion the descripcionFuncion to set
	 */
	public void setDescripcionFuncion(String descripcionFuncion) {
		this.descripcionFuncion = descripcionFuncion;
	}

	/**
	 * @return the nombreUri
	 */
	public String getNombreUri() {
		return nombreUri;
	}

	/**
	 * @param nombreUri the nombreUri to set
	 */
	public void setNombreUri(String nombreUri) {
		this.nombreUri = nombreUri;
	}

	/**
	 * @return the numeroFuncion
	 */
	public String getNumeroFuncion() {
		return numeroFuncion;
	}

	/**
	 * @param numeroFuncion the numeroFuncion to set
	 */
	public void setNumeroFuncion(String numeroFuncion) {
		this.numeroFuncion = numeroFuncion;
	}

	/**
	 * @return the tpPeticion
	 */
	public String getTpPeticion() {
		return tpPeticion;
	}

	/**
	 * @param tpPeticion the tpPeticion to set
	 */
	public void setTpPeticion(String tpPeticion) {
		this.tpPeticion = tpPeticion;
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

}
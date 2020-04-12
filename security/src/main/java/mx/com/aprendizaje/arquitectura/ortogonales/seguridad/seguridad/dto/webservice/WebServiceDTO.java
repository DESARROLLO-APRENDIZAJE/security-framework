package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Kevin Ojeda
 *
 */
@Entity
@Table(name = "TAQ021C_WS_SERVICIOS_WEB_TMP")
public class WebServiceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009412444898138600L;
	
	@Id
	@Column(name = "ID_SERVICIO_WEB", unique = true, nullable = false)
	private Long servicioId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteDTO cliente;
	
	@Column(name = "NB_SERVICIO_WEB")
	private String nombreServicio;
	
	@Column(name = "CD_SERVICIO_WEB")
	private String codigoServicio;
	
	@Column(name = "TX_DESCRIPCION")
	private String descripcionServicio;
	
	@Column(name = "NB_CONTEXTO_WEB")
	private String contexto;
	
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servicio")
	private Set<FuncionDTO> funciones;

	/**
	 * @return the servicioId
	 */
	public Long getServicioId() {
		return servicioId;
	}

	/**
	 * @param servicioId the servicioId to set
	 */
	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
	}

	/**
	 * @return the cliente
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the nombreServicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}

	/**
	 * @param nombreServicio the nombreServicio to set
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/**
	 * @return the codigoServicio
	 */
	public String getCodigoServicio() {
		return codigoServicio;
	}

	/**
	 * @param codigoServicio the codigoServicio to set
	 */
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	/**
	 * @return the descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param descripcionServicio the descripcionServicio to set
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	/**
	 * @return the contexto
	 */
	public String getContexto() {
		return contexto;
	}

	/**
	 * @param contexto the contexto to set
	 */
	public void setContexto(String contexto) {
		this.contexto = contexto;
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

	/**
	 * @return the funciones
	 */
	public Set<FuncionDTO> getFunciones() {
		return funciones;
	}

	/**
	 * @param funciones the funciones to set
	 */
	public void setFunciones(Set<FuncionDTO> funciones) {
		this.funciones = funciones;
	}
}

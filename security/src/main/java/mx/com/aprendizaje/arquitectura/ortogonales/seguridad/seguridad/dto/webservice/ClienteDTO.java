package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Kevin Ojeda
 *
 */
@Entity
@Table(name = "TAQ036D_WS_CLIENTES")
public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6096146777815888773L;
	
	@Id
	@Column(name = "ID_CLIENTE", unique = true, nullable = false)
	private Long clienteId;
	
	@Column(name = "NB_CLIENTE")
	private String nombreCliente;

	@Column(name = "CD_CLIENTE")
	private String codigoCliente;
	
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
	 * @return the clienteId
	 */
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the codigoCliente
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
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
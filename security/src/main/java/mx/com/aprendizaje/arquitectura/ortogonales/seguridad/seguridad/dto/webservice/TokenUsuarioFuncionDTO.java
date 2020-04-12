package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kevin Ojeda
 *
 */
@Entity
@Table(name = "TAQ024D_WS_USUARIOS_FUNCIONES")
public class TokenUsuarioFuncionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -136564782978798336L;
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "usuarioId", column = @Column(name = "ID_USUARIO")),
		@AttributeOverride(name = "funcionId", column = @Column(name = "ID_FUNCION"))})
	private TokenUsuarioFuncionIdDTO id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", referencedColumnName="ID_USUARIO", insertable=false, updatable=false)
	private UsuarioDTO usuario;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FUNCION", referencedColumnName="ID_FUNCION", insertable=false, updatable=false)
	private FuncionDTO funcion;
	
	@Column(name = "PW_TOKEN")
	private String token;
	
	@Column(name = "PW_USUARIO_FUNCION")
	private String funcionPassword;
	
	@Column(name = "ST_ACTIVO")
	private Integer activo;
	
	@Column(name = "FH_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FH_MODIFICACION")
	private Date fechaModificacion;
	
	@Column(name = "ID_USR_CREACION")
	private Long creadoPor;
	
	@Column(name = "ID_USR_MODIFICA")
	private Long modificadoPor;

	/**
	 * @return the id
	 */
	public TokenUsuarioFuncionIdDTO getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TokenUsuarioFuncionIdDTO id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the funcion
	 */
	public FuncionDTO getFuncion() {
		return funcion;
	}

	/**
	 * @param funcion the funcion to set
	 */
	public void setFuncion(FuncionDTO funcion) {
		this.funcion = funcion;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the funcionPassword
	 */
	public String getFuncionPassword() {
		return funcionPassword;
	}

	/**
	 * @param funcionPassword the funcionPassword to set
	 */
	public void setFuncionPassword(String funcionPassword) {
		this.funcionPassword = funcionPassword;
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
	
}

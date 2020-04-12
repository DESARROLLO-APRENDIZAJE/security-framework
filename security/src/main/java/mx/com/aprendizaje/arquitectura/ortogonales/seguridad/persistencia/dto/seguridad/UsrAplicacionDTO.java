package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAQ029D_SE_USR_APLICACION")
public class UsrAplicacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611532874828006635L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_USR_APLI", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idUsrApli;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	private UsuariosDTO usuarios;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACION", nullable = false)
	private AplicacionesDTO aplicaciones;
	
	@Column(name = "ST_ACTIVO", nullable = false, precision = 1, scale = 0)
	private Boolean stActivo;

	@Column(name = "ID_USR_CREACION", nullable = false, precision = 11, scale = 0)
	private Long idUsrCreacion;
	
	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;
	
	@Column(name = "ID_USR_MODIFICA", nullable = false, precision = 11, scale = 0)
	private Long idUsrModifica;
	
	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;
	

	public Long getIdUsrApli() {
		return idUsrApli;
	}

	public void setIdUsrApli(Long idUsrApli) {
		this.idUsrApli = idUsrApli;
	}

	public UsuariosDTO getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuariosDTO usuarios) {
		this.usuarios = usuarios;
	}

	public AplicacionesDTO getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(AplicacionesDTO aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public Boolean getStActivo() {
		return this.stActivo;
	}
	
	public void setStActivo(Boolean stActivo) {
		this.stActivo = stActivo;
	}

	public Long getIdUsrCreacion() {
		return this.idUsrCreacion;
	}

	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	public Date getFhCreacion() {
		return this.fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getIdUsrModifica() {
		return this.idUsrModifica;
	}

	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	public Date getFhModificacion() {
		return this.fhModificacion;
	}

	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}


}

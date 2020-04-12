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
@Table(name = "TAQ027D_SE_PERFIL_USUARIO")
public class PerfilUsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611532874828006635L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_PERFIL_USR", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idPerfilUsr;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", nullable = false, updatable=false)
	private UsuariosDTO usuarios;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERFIL", nullable = false)
	private PerfilesDTO perfiles;
	
	@Column(name = "ST_ACTIVO", nullable = false, precision = 1, scale = 0)
	private Integer stActivo;

	@Column(name = "ID_USR_CREACION", nullable = false, precision = 11, scale = 0)
	private Long idUsrCreacion;
	
	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;
	
	@Column(name = "ID_USR_MODIFICA", nullable = false, precision = 11, scale = 0)
	private Long idUsrModifica;
	
	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;
	
	public Long getIdPerfilUsr() {
		return idPerfilUsr;
	}

	public void setIdPerfilUsr(Long idPerfilUsr) {
		this.idPerfilUsr = idPerfilUsr;
	}

	public UsuariosDTO getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuariosDTO usuarios) {
		this.usuarios = usuarios;
	}

	public PerfilesDTO getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(PerfilesDTO perfiles) {
		this.perfiles = perfiles;
	}

	public Integer getStActivo() {
		return this.stActivo;
	}
	
	public void setStActivo(Integer stActivo) {
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

	@Override
	public String toString() {
		return "PerfilUsuarioDTO [idPerfilUsr=" + idPerfilUsr + ", usuarios=" + usuarios + ", perfiles=" + perfiles
				+ ", stActivo=" + stActivo + ", idUsrCreacion=" + idUsrCreacion + ", fhCreacion=" + fhCreacion
				+ ", idUsrModifica=" + idUsrModifica + ", fhModificacion=" + fhModificacion + "]";
	}

}

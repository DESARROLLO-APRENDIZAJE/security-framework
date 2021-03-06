package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TAQ025C_SE_USUARIOS")
public class UsuariosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4162120001095351651L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idUsuario;

	@Column(name = "CD_USUARIO", nullable = false, length = 15)
	private String cdUsuario;

	@Column(name = "NB_CONTRASENIA", nullable = false, length = 100)
	private String nbContrasenia;

	@Transient
	private String nbContraseniaBackup;

	@Column(name = "NB_USUARIO", nullable = false, length = 100)
	private String nbUsuario;

	@Column(name = "NB_APATERNO", nullable = false, length = 100)
	private String nbApaterno;

	@Column(name = "NB_AMATERNO", nullable = true, length = 100)
	private String nbAmaterno;

	@Column(name = "NB_EMAIL", nullable = true, length = 100)
	private String nbEmail;

	@Column(name = "NU_TELEFONO", nullable = true, precision = 11, scale = 0)
	private Long nuTelefono;

	@Column(name = "ST_CONTRASENIA", nullable = true, precision = 1, scale = 0)
	private Boolean stContrasenia;

	@Column(name = "FH_MODIF_CONTRASENIA", nullable = true, length = 7)
	private Date fhModifContrasenia;

//	@Column(name = "LB_FOTO", nullable = true)
//	private byte[]  lbFoto;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	private List<PerfilUsuarioDTO> perfilUsuario = new ArrayList<PerfilUsuarioDTO>(0);

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNbContrasenia() {
		return nbContrasenia;
	}

	public void setNbContrasenia(String nbContrasenia) {
		this.nbContrasenia = nbContrasenia;
	}

	public String getNbUsuario() {
		return nbUsuario;
	}

	public void setNbUsuario(String nbUsuario) {
		this.nbUsuario = nbUsuario;
	}

	public String getNbApaterno() {
		return nbApaterno;
	}

	public void setNbApaterno(String nbApaterno) {
		this.nbApaterno = nbApaterno;
	}

	public String getNbAmaterno() {
		return nbAmaterno;
	}

	public void setNbAmaterno(String nbAmaterno) {
		this.nbAmaterno = nbAmaterno;
	}

	public String getNbEmail() {
		return nbEmail;
	}

	public void setNbEmail(String nbEmail) {
		this.nbEmail = nbEmail;
	}

	public Long getNuTelefono() {
		return nuTelefono;
	}

	public void setNuTelefono(Long nuTelefono) {
		this.nuTelefono = nuTelefono;
	}

	public Boolean getStContrasenia() {
		return stContrasenia;
	}

	public void setStContrasenia(Boolean stContrasenia) {
		this.stContrasenia = stContrasenia;
	}

	public Date getFhModifContrasenia() {
		return fhModifContrasenia;
	}

	public void setFhModifContrasenia(Date fhModifContrasenia) {
		this.fhModifContrasenia = fhModifContrasenia;
	}

//	public byte[] getLbFoto() {
//		return lbFoto;
//	}
//
//	public void setLbFoto(byte[] lbFoto) {
//		this.lbFoto = lbFoto;
//	}

	public Integer getStActivo() {
		return stActivo;
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

	public List<PerfilUsuarioDTO> getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(List<PerfilUsuarioDTO> perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public String getNbContraseniaBackup() {
		return nbContraseniaBackup;
	}

	public void setNbContraseniaBackup(String nbContraseniaBackup) {
		this.nbContraseniaBackup = nbContraseniaBackup;
	}

	@Override
	public String toString() {
		return "UsuariosDTO [idUsuario=" + idUsuario + ", cdUsuario=" + cdUsuario + ", nbContrasenia=" + nbContrasenia
				+ ", nbUsuario=" + nbUsuario + ", nbApaterno=" + nbApaterno + ", nbAmaterno=" + nbAmaterno
				+ ", nbEmail=" + nbEmail + ", nuTelefono=" + nuTelefono + ", stContrasenia=" + stContrasenia
				+ ", fhModifContrasenia=" + fhModifContrasenia + ", stActivo=" + stActivo + ", idUsrCreacion="
				+ idUsrCreacion + ", fhCreacion=" + fhCreacion + ", idUsrModifica=" + idUsrModifica
				+ ", fhModificacion=" + fhModificacion + "]";
	}

}

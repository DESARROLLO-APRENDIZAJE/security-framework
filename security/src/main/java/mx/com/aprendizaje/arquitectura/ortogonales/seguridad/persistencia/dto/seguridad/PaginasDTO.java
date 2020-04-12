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
@Table(name = "TAQ031C_SE_PAGINAS")
public class PaginasDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5353714765333118177L;

	@Id
	@Column(name = "ID_PAGINA", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idPagina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENU", nullable = false)
	private MenusDTO menus;

	@Column(name = "NB_PAGINA", nullable = false, length = 100)
	private String nbPagina;

	@Column(name = "CD_PAGINA", nullable = false, length = 15)
	private String cdPagina;

	@Column(name = "NB_URI_PAGINA", length = 100)
	private String nbUriPagina;

	@Column(name = "ST_ACTIVO", nullable = false, length = 1)
	private Long stActivo;

	@Column(name = "ID_USR_CREACION", nullable = false, length = 11)
	private Long idUsrCreacion;

	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;

	@Column(name = "ID_USR_MODIFICA", nullable = false, length = 11)
	private Long idUsrModifica;

	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;

	public Long getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}
	
	public MenusDTO getMenus() {
		return menus;
	}

	public void setMenus(MenusDTO menus) {
		this.menus = menus;
	}

	public String getNbPagina() {
		return nbPagina;
	}

	public void setNbPagina(String nbPagina) {
		this.nbPagina = nbPagina;
	}

	public String getCdPagina() {
		return cdPagina;
	}

	public void setCdPagina(String cdPagina) {
		this.cdPagina = cdPagina;
	}

	public String getNbUriPagina() {
		return nbUriPagina;
	}

	public void setNbUriPagina(String nbUriPagina) {
		this.nbUriPagina = nbUriPagina;
	}

	public Long getStActivo() {
		return stActivo;
	}

	public void setStActivo(Long stActivo) {
		this.stActivo = stActivo;
	}

	public Long getIdUsrCreacion() {
		return idUsrCreacion;
	}

	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	public Date getFhCreacion() {
		return fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getIdUsrModifica() {
		return idUsrModifica;
	}

	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	public Date getFhModificacion() {
		return fhModificacion;
	}

	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}

}

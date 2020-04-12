package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;

@Entity
@Table(name = "TAQ003C_CN_TEMAS")
public class TemasDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8609290506611702822L;

	@Id
	@Column(name = "ID_TEMA", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idTema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACION", nullable = false)
	private AplicacionesDTO aplicaciones;

	@Column(name = "NB_TEMA", nullable = false, length = 100)
	private String nbTema;

	@Column(name = "CD_TEMA", nullable = false, length = 15)
	private String cdTema;

	@Column(name = "ST_ACTIVO", nullable = false, length = 1)
	private Integer stActivo;

	@Column(name = "ID_USR_CREACION", nullable = false, length = 11)
	private Long idUsrCreacion;

	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;

	@Column(name = "ID_USR_MODIFICA", nullable = false, length = 11)
	private Long idUsrModifica;

	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public AplicacionesDTO getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(AplicacionesDTO aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public String getNbTema() {
		return nbTema;
	}

	public void setNbTema(String nbTema) {
		this.nbTema = nbTema;
	}

	public String getCdTema() {
		return cdTema;
	}

	public void setCdTema(String cdTema) {
		this.cdTema = cdTema;
	}
 
	
	public Integer getStActivo() {
		return stActivo;
	}

	public void setStActivo(Integer stActivo) {
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

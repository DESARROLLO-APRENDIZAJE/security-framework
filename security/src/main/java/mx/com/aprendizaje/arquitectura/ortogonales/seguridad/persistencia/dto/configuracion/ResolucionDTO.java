package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAQ001C_CN_RESOLUCION")
public class ResolucionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -953045816151600431L;

	@Id
	@Column(name = "ID_RESOLUCION", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idResolucion;

	@Column(name = "CD_RESOLUCION", nullable = false, length = 15)
	private String cdResolucion;

	@Column(name = "NB_RESOLUCION", nullable = false, length = 100)
	private String nbResolucion;

	@Column(name = "NU_PIXELES_BASE", nullable = false, length = 11)
	private Long nuPixelesBase;

	@Column(name = "TX_RESOLUCION", length = 250)
	private String txResolucion;

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

	public Long getIdResolucion() {
		return idResolucion;
	}

	public void setIdResolucion(Long idResolucion) {
		this.idResolucion = idResolucion;
	}

	public String getCdResolucion() {
		return cdResolucion;
	}

	public void setCdResolucion(String cdResolucion) {
		this.cdResolucion = cdResolucion;
	}

	public String getNbResolucion() {
		return nbResolucion;
	}

	public void setNbResolucion(String nbResolucion) {
		this.nbResolucion = nbResolucion;
	}

	public Long getNuPixelesBase() {
		return nuPixelesBase;
	}

	public void setNuPixelesBase(Long nuPixelesBase) {
		this.nuPixelesBase = nuPixelesBase;
	}

	public String getTxResolucion() {
		return txResolucion;
	}

	public void setTxResolucion(String txResolucion) {
		this.txResolucion = txResolucion;
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

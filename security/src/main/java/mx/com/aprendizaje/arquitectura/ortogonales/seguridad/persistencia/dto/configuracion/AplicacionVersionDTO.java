package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;

@Entity
@Table(name = "TAQ062D_CN_APP_VERSION")
public class AplicacionVersionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758727355384055525L;

	@Id
	@SequenceGenerator(name = "SQAQ062", sequenceName = "SQAQ062_APP_VERSION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQAQ062")
	@Column(name = "ID_VERSION", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idVersion;
	
	@Column(name = "TX_VERSION", nullable = true, length = 250)
	private String txVersion;

	@Column(name = "TX_VALOR", nullable = true, length = 100)
	private String txValor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACION", nullable = false)
	private AplicacionesDTO aplicacion;

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

	public Long getIdVersion() {
		return idVersion;
	}

	public void setIdVersion(Long idVersion) {
		this.idVersion = idVersion;
	}

	public String getTxVersion() {
		return txVersion;
	}

	public void setTxVersion(String txVersion) {
		this.txVersion = txVersion;
	}

	public String getTxValor() {
		return txValor;
	}

	public void setTxValor(String txValor) {
		this.txValor = txValor;
	}

	public AplicacionesDTO getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(AplicacionesDTO aplicacion) {
		this.aplicacion = aplicacion;
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

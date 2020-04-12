package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAQ059C_CN_MENU_ORIENTACION")
public class MenuOrientacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1292456566119729674L;

	@Id
	@SequenceGenerator(name = "SQAQ059", sequenceName = "SQAQ059_MENU_ORIENTACION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQAQ059")
	@Column(name = "ID_MENU_ORIENTACION", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idMenuOrientacion;

	@Column(name = "CD_MENU_ORIENTACION", nullable = false, length = 15)
	private String cdMenuOrientacion;

	@Column(name = "NB_MENU_ORIENTACION", nullable = false, length = 100)
	private String nbMenuOrientacion;

	@Column(name = "TX_MENU_ORIENTACION", nullable = true, length = 250)
	private String txMenuOrientacion;
	
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

	/**
	 * @return the idMenuOrientacion
	 */
	public Long getIdMenuOrientacion() {
		return idMenuOrientacion;
	}

	/**
	 * @param idMenuOrientacion the idMenuOrientacion to set
	 */
	public void setIdMenuOrientacion(Long idMenuOrientacion) {
		this.idMenuOrientacion = idMenuOrientacion;
	}

	/**
	 * @return the cdMenuOrientacion
	 */
	public String getCdMenuOrientacion() {
		return cdMenuOrientacion;
	}

	/**
	 * @param cdMenuOrientacion the cdMenuOrientacion to set
	 */
	public void setCdMenuOrientacion(String cdMenuOrientacion) {
		this.cdMenuOrientacion = cdMenuOrientacion;
	}

	/**
	 * @return the nbMenuOrientacion
	 */
	public String getNbMenuOrientacion() {
		return nbMenuOrientacion;
	}

	/**
	 * @param nbMenuOrientacion the nbMenuOrientacion to set
	 */
	public void setNbMenuOrientacion(String nbMenuOrientacion) {
		this.nbMenuOrientacion = nbMenuOrientacion;
	}

	/**
	 * @return the txMenuOrientacion
	 */
	public String getTxMenuOrientacion() {
		return txMenuOrientacion;
	}

	/**
	 * @param txMenuOrientacion the txMenuOrientacion to set
	 */
	public void setTxMenuOrientacion(String txMenuOrientacion) {
		this.txMenuOrientacion = txMenuOrientacion;
	}

	/**
	 * @return the stActivo
	 */
	public Integer getStActivo() {
		return stActivo;
	}

	/**
	 * @param stActivo the stActivo to set
	 */
	public void setStActivo(Integer stActivo) {
		this.stActivo = stActivo;
	}

	/**
	 * @return the idUsrCreacion
	 */
	public Long getIdUsrCreacion() {
		return idUsrCreacion;
	}

	/**
	 * @param idUsrCreacion the idUsrCreacion to set
	 */
	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	/**
	 * @return the fhCreacion
	 */
	public Date getFhCreacion() {
		return fhCreacion;
	}

	/**
	 * @param fhCreacion the fhCreacion to set
	 */
	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	/**
	 * @return the idUsrModifica
	 */
	public Long getIdUsrModifica() {
		return idUsrModifica;
	}

	/**
	 * @param idUsrModifica the idUsrModifica to set
	 */
	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	/**
	 * @return the fhModificacion
	 */
	public Date getFhModificacion() {
		return fhModificacion;
	}

	/**
	 * @param fhModificacion the fhModificacion to set
	 */
	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}

}

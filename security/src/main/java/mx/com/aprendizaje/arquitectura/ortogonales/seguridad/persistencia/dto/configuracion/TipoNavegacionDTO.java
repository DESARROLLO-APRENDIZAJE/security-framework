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
@Table(name = "TAQ060C_CN_TIPO_NEVEGACION")
public class TipoNavegacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684790825104823111L;

	@Id
	@SequenceGenerator(name = "SQAQ060", sequenceName = "SQAQ060_TIPO_NAVEGACION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQAQ060")
	@Column(name = "ID_TIPO_NEVEGACION", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idTipoNavegacion;

	@Column(name = "CD_TIPO_NEVEGACION", nullable = false, length = 15)
	private String cdTipoNavegacion;

	@Column(name = "NB_TIPO_NEVEGACION", nullable = false, length = 100)
	private String nbTipoNavegacion;

	@Column(name = "TX_TIPO_NEVEGACION", nullable = true, length = 250)
	private String txTipoNavegacion;

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
	 * @return the idTipoNavegacion
	 */
	public Long getIdTipoNavegacion() {
		return idTipoNavegacion;
	}

	/**
	 * @param idTipoNavegacion the idTipoNavegacion to set
	 */
	public void setIdTipoNavegacion(Long idTipoNavegacion) {
		this.idTipoNavegacion = idTipoNavegacion;
	}

	/**
	 * @return the cdTipoNavegacion
	 */
	public String getCdTipoNavegacion() {
		return cdTipoNavegacion;
	}

	/**
	 * @param cdTipoNavegacion the cdTipoNavegacion to set
	 */
	public void setCdTipoNavegacion(String cdTipoNavegacion) {
		this.cdTipoNavegacion = cdTipoNavegacion;
	}

	/**
	 * @return the nbTipoNavegacion
	 */
	public String getNbTipoNavegacion() {
		return nbTipoNavegacion;
	}

	/**
	 * @param nbTipoNavegacion the nbTipoNavegacion to set
	 */
	public void setNbTipoNavegacion(String nbTipoNavegacion) {
		this.nbTipoNavegacion = nbTipoNavegacion;
	}

	/**
	 * @return the txTipoNavegacion
	 */
	public String getTxTipoNavegacion() {
		return txTipoNavegacion;
	}

	/**
	 * @param txTipoNavegacion the txTipoNavegacion to set
	 */
	public void setTxTipoNavegacion(String txTipoNavegacion) {
		this.txTipoNavegacion = txTipoNavegacion;
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

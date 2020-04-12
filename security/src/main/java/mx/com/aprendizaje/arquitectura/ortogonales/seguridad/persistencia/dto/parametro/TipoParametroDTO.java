package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro;

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
@Table(name = "TAQ064C_SE_TIPO_PARAMETRO")
public class TipoParametroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3771756876128260081L;

	@Id
	@SequenceGenerator(name = "SQAQ064", sequenceName = "SQAQ064_TIPO_PARAMETRO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQAQ064")
	@Column(name = "ID_TIPO_PARAMETRO", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idTipoParametro;

	@Column(name = "CD_TIPO_PARAMETRO", unique = false, nullable = false, length = 15)
	private String cdTipoParametro;

	@Column(name = "NB_TIPO_PARAMETRO", nullable = false, length = 100)
	private String nbTipoParametro;

	@Column(name = "TX_TIPO_PARAMETRO", nullable = false, length = 250)
	private String txTipoParametro;

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
	 * @return the idTipoParametro
	 */
	public Long getIdTipoParametro() {
		return idTipoParametro;
	}

	/**
	 * @param idTipoParametro the idTipoParametro to set
	 */
	public void setIdTipoParametro(Long idTipoParametro) {
		this.idTipoParametro = idTipoParametro;
	}

	/**
	 * @return the cdTipoParametro
	 */
	public String getCdTipoParametro() {
		return cdTipoParametro;
	}

	/**
	 * @param cdTipoParametro the cdTipoParametro to set
	 */
	public void setCdTipoParametro(String cdTipoParametro) {
		this.cdTipoParametro = cdTipoParametro;
	}

	/**
	 * @return the nbTipoParametro
	 */
	public String getNbTipoParametro() {
		return nbTipoParametro;
	}

	/**
	 * @param nbTipoParametro the nbTipoParametro to set
	 */
	public void setNbTipoParametro(String nbTipoParametro) {
		this.nbTipoParametro = nbTipoParametro;
	}

	/**
	 * @return the txTipoParametro
	 */
	public String getTxTipoParametro() {
		return txTipoParametro;
	}

	/**
	 * @param txTipoParametro the txTipoParametro to set
	 */
	public void setTxTipoParametro(String txTipoParametro) {
		this.txTipoParametro = txTipoParametro;
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

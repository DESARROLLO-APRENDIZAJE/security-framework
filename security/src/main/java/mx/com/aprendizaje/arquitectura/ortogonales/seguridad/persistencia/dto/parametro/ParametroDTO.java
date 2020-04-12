package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro;

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
@Table(name = "TAQ058C_SE_PARAMETRO")
public class ParametroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263562110003920695L;

	@Id
	@SequenceGenerator(name = "SQAQ058", sequenceName = "SQAQ058_SE_PARAMETRO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQAQ058")
	@Column(name = "ID_PARAMETRO", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idParametro;

	@Column(name = "CD_PARAMETRO", unique = false, nullable = false, length = 15)
	private String cdParametro;

	@Column(name = "NB_PARAMETRO", nullable = false, length = 100)
	private String nbParametro;

	@Column(name = "NB_VALOR", nullable = false, length = 300)
	private String nbValor;

	@Column(name = "TX_PARAMETRO", nullable = false, length = 250)
	private String txParametro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACION")
	private AplicacionesDTO aplicacion;

	@Column(name = "ST_PARAMETRO_INTERNO")
	private Integer stParametroInterno;

	@Column(name = "ST_BANDERA", nullable = false, precision = 1, scale = 0)
	private Integer stBandera;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_PARAMETRO")
	private TipoParametroDTO tipoParametro;

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
	 * @return the idParametro
	 */
	public Long getIdParametro() {
		return idParametro;
	}

	/**
	 * @param idParametro the idParametro to set
	 */
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	/**
	 * @return the cdParametro
	 */
	public String getCdParametro() {
		return cdParametro;
	}

	/**
	 * @param cdParametro the cdParametro to set
	 */
	public void setCdParametro(String cdParametro) {
		this.cdParametro = cdParametro;
	}

	/**
	 * @return the nbParametro
	 */
	public String getNbParametro() {
		return nbParametro;
	}

	/**
	 * @param nbParametro the nbParametro to set
	 */
	public void setNbParametro(String nbParametro) {
		this.nbParametro = nbParametro;
	}

	/**
	 * @return the nbValor
	 */
	public String getNbValor() {
		return nbValor;
	}

	/**
	 * @param nbValor the nbValor to set
	 */
	public void setNbValor(String nbValor) {
		this.nbValor = nbValor;
	}

	/**
	 * @return the txParametro
	 */
	public String getTxParametro() {
		return txParametro;
	}

	/**
	 * @param txParametro the txParametro to set
	 */
	public void setTxParametro(String txParametro) {
		this.txParametro = txParametro;
	}

	/**
	 * @return the aplicacion
	 */
	public AplicacionesDTO getAplicacion() {
		return aplicacion;
	}

	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(AplicacionesDTO aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * @return the stParametroInterno
	 */
	public Integer getStParametroInterno() {
		return stParametroInterno;
	}

	/**
	 * @param stParametroInterno the stParametroInterno to set
	 */
	public void setStParametroInterno(Integer stParametroInterno) {
		this.stParametroInterno = stParametroInterno;
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

	/**
	 * @return the stBandera
	 */
	public Integer getStBandera() {
		return stBandera;
	}

	/**
	 * @param stBandera the stBandera to set
	 */
	public void setStBandera(Integer stBandera) {
		this.stBandera = stBandera;
	}

	/**
	 * @return the tipoParametro
	 */
	public TipoParametroDTO getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametro(TipoParametroDTO tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

}

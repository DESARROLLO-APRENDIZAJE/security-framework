package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

/**
 * @author jorgeluis
 *
 */
public class ParametroVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7975641540820527381L;

	private Long idParametro;
	private String cdParametro;
	private String nbParametro;
	private String nbValor;
	private String txParametro;
	private Integer stParametroInterno;
	private Integer stActivo;
	private Integer stBandera;
	private TipoParametroVO tipoParametro;

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
	public TipoParametroVO getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametro(TipoParametroVO tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

}

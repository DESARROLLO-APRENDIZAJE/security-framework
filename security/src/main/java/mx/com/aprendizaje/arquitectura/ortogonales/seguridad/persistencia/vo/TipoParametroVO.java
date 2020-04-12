package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class TipoParametroVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5676774771365250233L;

	private Long idTipoParametro;
	private String cdTipoParametro;
	private String nbTipoParametro;
	private String txTipoParametro;

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

}

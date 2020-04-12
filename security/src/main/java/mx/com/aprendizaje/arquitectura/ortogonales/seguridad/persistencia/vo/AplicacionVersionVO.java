package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class AplicacionVersionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5092768288852076007L;

	private Long idVersion;
	private String txVersion;
	private String txValor;
	private Integer stActivo;

	/**
	 * @return the idVersion
	 */
	public Long getIdVersion() {
		return idVersion;
	}

	/**
	 * @param idVersion the idVersion to set
	 */
	public void setIdVersion(Long idVersion) {
		this.idVersion = idVersion;
	}

	/**
	 * @return the txVersion
	 */
	public String getTxVersion() {
		return txVersion;
	}

	/**
	 * @param txVersion the txVersion to set
	 */
	public void setTxVersion(String txVersion) {
		this.txVersion = txVersion;
	}

	/**
	 * @return the txValor
	 */
	public String getTxValor() {
		return txValor;
	}

	/**
	 * @param txValor the txValor to set
	 */
	public void setTxValor(String txValor) {
		this.txValor = txValor;
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

}

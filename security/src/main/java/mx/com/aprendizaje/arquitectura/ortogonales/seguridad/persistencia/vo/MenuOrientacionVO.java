package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class MenuOrientacionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5468643490950692129L;

	private Long idMenuOrientacion;
	private String cdMenuOrientacion;
	private String nbMenuOrientacion;
	private String txMenuOrientacion;

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

}

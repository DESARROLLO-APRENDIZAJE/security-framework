package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class TipoNavegacionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7437280853642996475L;
	
	private Long idTipoNavegacion;
	private String cdTipoNavegacion;
	private String nbTipoNavegacion;
	private String txTipoNavegacion;
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
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

 
public class TemaVO implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 2015682584276886059L;
	
	private Long idTema;
 	private String nbTema;
 	private String cdTema;
 	private Integer stActivo;
 	
	public Long getIdTema() {
		return idTema;
	}
	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	public String getNbTema() {
		return nbTema;
	}
	public void setNbTema(String nbTema) {
		this.nbTema = nbTema;
	}
	public String getCdTema() {
		return cdTema;
	}
	public void setCdTema(String cdTema) {
		this.cdTema = cdTema;
	}
	public Integer getStActivo() {
		return stActivo;
	}
	public void setStActivo(Integer stActivo) {
		this.stActivo = stActivo;
	}
 	
	
}

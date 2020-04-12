package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;
import java.util.List;

public class ComponentesVO implements Serializable {

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8814361187484065661L;
	private Long idComponente;
 	private String nbComponente;
 	private String txComponente;
 	private List<MenuDinamicoVO> listaMenus;
 	private Long perfilId;
 	private boolean stActivo;
 	
	public Long getIdComponente() {
		return idComponente;
	}
	public void setIdComponente(Long idComponente) {
		this.idComponente = idComponente;
	}
	public String getNbComponente() {
		return nbComponente;
	}
	public void setNbComponente(String nbComponente) {
		this.nbComponente = nbComponente;
	}
	public String getTxComponente() {
		return txComponente;
	}
	public void setTxComponente(String txComponente) {
		this.txComponente = txComponente;
	}
	public boolean isStActivo() {
		return stActivo;
	}
	public void setStActivo(boolean stActivo) {
		this.stActivo = stActivo;
	}
	public List<MenuDinamicoVO> getListaMenus() {
		return listaMenus;
	}
	public void setListaMenus(List<MenuDinamicoVO> listaMenus) {
		this.listaMenus = listaMenus;
	}
	public Long getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
	
	 
	
	 
}

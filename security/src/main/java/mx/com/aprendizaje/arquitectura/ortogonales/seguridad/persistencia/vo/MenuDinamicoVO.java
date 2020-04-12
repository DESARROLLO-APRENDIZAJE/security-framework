package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class MenuDinamicoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String menuTexto;
	private String menuTextoEn;
	private Integer menuSuperior;
	private String menuUri;
	private String menuIcono;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuTexto() {
		return menuTexto;
	}

	public void setMenuTexto(String menuTexto) {
		this.menuTexto = menuTexto;
	}
	

	public String getMenuTextoEn() {
		return menuTextoEn;
	}

	public void setMenuTextoEn(String menuTextoEn) {
		this.menuTextoEn = menuTextoEn;
	}

	public Integer getMenuSuperior() {
		return menuSuperior;
	}

	public void setMenuSuperior(Integer menuSuperior) {
		this.menuSuperior = menuSuperior;
	}

	public String getMenuUri() {
		return menuUri;
	}

	public void setMenuUri(String menuUri) {
		this.menuUri = menuUri;
	}

	public String getMenuIcono() {
		return menuIcono;
	}

	public void setMenuIcono(String menuIcono) {
		this.menuIcono = menuIcono;
	}
}

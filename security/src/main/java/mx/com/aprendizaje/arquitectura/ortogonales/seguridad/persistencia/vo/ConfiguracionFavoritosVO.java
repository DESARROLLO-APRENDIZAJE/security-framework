package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class ConfiguracionFavoritosVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7275353603760206100L;

	private Long idFavorito;
	private String txFavorito;
	private UsuarioFirmadoVO usuario;
	private MenuDinamicoVO menu;
	private AplicacionVO aplicacion;

	/**
	 * @return the idFavorito
	 */
	public Long getIdFavorito() {
		return idFavorito;
	}

	/**
	 * @param idFavorito the idFavorito to set
	 */
	public void setIdFavorito(Long idFavorito) {
		this.idFavorito = idFavorito;
	}

	/**
	 * @return the txFavorito
	 */
	public String getTxFavorito() {
		return txFavorito;
	}

	/**
	 * @param txFavorito the txFavorito to set
	 */
	public void setTxFavorito(String txFavorito) {
		this.txFavorito = txFavorito;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioFirmadoVO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioFirmadoVO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the menu
	 */
	public MenuDinamicoVO getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(MenuDinamicoVO menu) {
		this.menu = menu;
	}

	/**
	 * @return the aplicacion
	 */
	public AplicacionVO getAplicacion() {
		return aplicacion;
	}

	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(AplicacionVO aplicacion) {
		this.aplicacion = aplicacion;
	}

}

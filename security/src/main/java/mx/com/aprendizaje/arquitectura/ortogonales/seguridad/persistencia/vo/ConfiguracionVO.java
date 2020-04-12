package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ConfiguracionVO {

	private Long idConfiguracion;
	private ResolucionVO resolucion;
	private TemaVO tema;
	private AplicacionVO aplicacion;
	private byte[] logoMenuPrincipal;
	private byte[] logoMenuSecundario;
	private byte[] logoHeader;
	private byte[] logoIndex;
	private Integer stActivo;
	private Integer stMenuFijo;
	private Integer stHeaderFijo;
	private Integer stMenuDesplegable;
	private Integer stFooterFijo;
	private MenuOrientacionVO menuOrientacion;
	private TipoNavegacionVO tipoNavegacion;
	private String strSectionToModif;
	private AplicacionVersionVO version;
	private String txFooterLogin;
	private String txFooterMain;

	public Long getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(Long idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public ResolucionVO getResolucion() {
		return resolucion;
	}

	public void setResolucion(ResolucionVO resolucion) {
		this.resolucion = resolucion;
	}

	public AplicacionVO getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(AplicacionVO aplicacion) {
		this.aplicacion = aplicacion;
	}

	public TemaVO getTema() {
		return tema;
	}

	public void setTema(TemaVO tema) {
		this.tema = tema;
	}

	public byte[] getLogoMenuPrincipal() {
		return logoMenuPrincipal;
	}

	public void setLogoMenuPrincipal(byte[] logoMenuPrincipal) {
		this.logoMenuPrincipal = logoMenuPrincipal;
	}

	public byte[] getLogoMenuSecundario() {
		return logoMenuSecundario;
	}

	public void setLogoMenuSecundario(byte[] logoMenuSecundario) {
		this.logoMenuSecundario = logoMenuSecundario;
	}

	public byte[] getLogoHeader() {
		return logoHeader;
	}

	public void setLogoHeader(byte[] logoHeader) {
		this.logoHeader = logoHeader;
	}

	public byte[] getLogoIndex() {
		return logoIndex;
	}

	public void setLogoIndex(byte[] logoIndex) {
		this.logoIndex = logoIndex;
	}

	public Integer getStActivo() {
		return stActivo;
	}

	public void setStActivo(Integer stActivo) {
		this.stActivo = stActivo;
	}

	public Integer getStMenuFijo() {
		return stMenuFijo;
	}

	public void setStMenuFijo(Integer stMenuFijo) {
		this.stMenuFijo = stMenuFijo;
	}

	public Integer getStHeaderFijo() {
		return stHeaderFijo;
	}

	public void setStHeaderFijo(Integer stHeaderFijo) {
		this.stHeaderFijo = stHeaderFijo;
	}

	public Integer getStMenuDesplegable() {
		return stMenuDesplegable;
	}

	public void setStMenuDesplegable(Integer stMenuDesplegable) {
		this.stMenuDesplegable = stMenuDesplegable;
	}

	/**
	 * @return the stFooterFijo
	 */
	public Integer getStFooterFijo() {
		return stFooterFijo;
	}

	/**
	 * @param stFooterFijo the stFooterFijo to set
	 */
	public void setStFooterFijo(Integer stFooterFijo) {
		this.stFooterFijo = stFooterFijo;
	}

	/**
	 * @return the menuOrientacion
	 */
	public MenuOrientacionVO getMenuOrientacion() {
		return menuOrientacion;
	}

	/**
	 * @param menuOrientacion the menuOrientacion to set
	 */
	public void setMenuOrientacion(MenuOrientacionVO menuOrientacion) {
		this.menuOrientacion = menuOrientacion;
	}

	/**
	 * @return the tipoNavegacion
	 */
	public TipoNavegacionVO getTipoNavegacion() {
		return tipoNavegacion;
	}

	/**
	 * @param tipoNavegacion the tipoNavegacion to set
	 */
	public void setTipoNavegacion(TipoNavegacionVO tipoNavegacion) {
		this.tipoNavegacion = tipoNavegacion;
	}

	/**
	 * @return the strSectionToModif
	 */
	public String getStrSectionToModif() {
		return strSectionToModif;
	}

	/**
	 * @param strSectionToModif the strSectionToModif to set
	 */
	public void setStrSectionToModif(String strSectionToModif) {
		this.strSectionToModif = strSectionToModif;
	}

	public AplicacionVersionVO getVersion() {
		return version;
	}

	public void setVersion(AplicacionVersionVO version) {
		this.version = version;
	}

	/**
	 * @return the txFooterLogin
	 */
	public String getTxFooterLogin() {
		return txFooterLogin;
	}

	/**
	 * @param txFooterLogin the txFooterLogin to set
	 */
	public void setTxFooterLogin(String txFooterLogin) {
		this.txFooterLogin = txFooterLogin;
	}

	/**
	 * @return the txFooterMain
	 */
	public String getTxFooterMain() {
		return txFooterMain;
	}

	/**
	 * @param txFooterMain the txFooterMain to set
	 */
	public void setTxFooterMain(String txFooterMain) {
		this.txFooterMain = txFooterMain;
	}

}

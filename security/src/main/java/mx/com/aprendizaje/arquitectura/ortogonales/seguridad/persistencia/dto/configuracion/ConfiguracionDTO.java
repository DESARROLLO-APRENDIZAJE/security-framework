package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;

@Entity
@Table(name = "TAQ002D_CN_CONFIGURACION")
public class ConfiguracionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3075221460305198961L;

	@Id
	@Column(name = "ID_CONFIGURACION", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idConfiguracion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RESOLUCION", nullable = false)
	private ResolucionDTO resoluciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APLICACION", nullable = false)
	private AplicacionesDTO aplicaciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TEMA", nullable = false)
	private TemasDTO temas;

	@Column(name = "LB_MENU_PRINCIPAL")
	private byte[] lbMenuPricipal;

	@Column(name = "LB_MENU_SECUNDARIO")
	private byte[] lbMenuSecundario;

	@Column(name = "LB_HEADER")
	private byte[] lbHeader;

	@Column(name = "LB_INDEX")
	private byte[] lbIndex;

	@Column(name = "ST_MENU_FIJO", nullable = false, length = 1)
	private Long stMenuFijo;

	@Column(name = "ST_HEADER_FIJO", nullable = false, length = 1)
	private Long stHeaderFijo;

	@Column(name = "ST_MENU_DESPLEGADO", nullable = false, length = 1)
	private Long stMenuDesplegado;

	@Column(name = "ST_FOOTER_FIJO", nullable = true, length = 1)
	private Long stFooterFijo;

	@Column(name = "ST_ACTIVO", nullable = false, length = 1)
	private Integer stActivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENU_ORIENTACION", nullable = false)
	private MenuOrientacionDTO menuOrientacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_NEVEGACION", nullable = false)
	private TipoNavegacionDTO tipoNavegacion;

	@Column(name = "TX_FOOTER_LOGIN", nullable = true, length = 250)
	private String txFooterLogin;

	@Column(name = "TX_FOOTER_MAIN", nullable = true, length = 250)
	private String txFooterMain;

	@Column(name = "ID_USR_CREACION", nullable = false, length = 11)
	private Long idUsrCreacion;

	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;

	@Column(name = "ID_USR_MODIFICA", nullable = false, length = 11)
	private Long idUsrModifica;

	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;

	public Long getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(Long idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public ResolucionDTO getResoluciones() {
		return resoluciones;
	}

	public void setResoluciones(ResolucionDTO resoluciones) {
		this.resoluciones = resoluciones;
	}

	public AplicacionesDTO getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(AplicacionesDTO aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public TemasDTO getTemas() {
		return temas;
	}

	public void setTemas(TemasDTO temas) {
		this.temas = temas;
	}

	public byte[] getLbMenuPricipal() {
		return lbMenuPricipal;
	}

	public void setLbMenuPricipal(byte[] lbMenuPricipal) {
		this.lbMenuPricipal = lbMenuPricipal;
	}

	public byte[] getLbMenuSecundario() {
		return lbMenuSecundario;
	}

	public void setLbMenuSecundario(byte[] lbMenuSecundario) {
		this.lbMenuSecundario = lbMenuSecundario;
	}

	public byte[] getLbHeader() {
		return lbHeader;
	}

	public void setLbHeader(byte[] lbHeader) {
		this.lbHeader = lbHeader;
	}

	public byte[] getLbIndex() {
		return lbIndex;
	}

	public void setLbIndex(byte[] lbIndex) {
		this.lbIndex = lbIndex;
	}

	public Long getStMenuFijo() {
		return stMenuFijo;
	}

	public void setStMenuFijo(Long stMenuFijo) {
		this.stMenuFijo = stMenuFijo;
	}

	public Long getStHeaderFijo() {
		return stHeaderFijo;
	}

	public void setStHeaderFijo(Long stHeaderFijo) {
		this.stHeaderFijo = stHeaderFijo;
	}

	public Long getStMenuDesplegado() {
		return stMenuDesplegado;
	}

	public void setStMenuDesplegado(Long stMenuDesplegado) {
		this.stMenuDesplegado = stMenuDesplegado;
	}

	public Integer getStActivo() {
		return stActivo;
	}

	public void setStActivo(Integer stActivo) {
		this.stActivo = stActivo;
	}

	public Long getIdUsrCreacion() {
		return idUsrCreacion;
	}

	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	public Date getFhCreacion() {
		return fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getIdUsrModifica() {
		return idUsrModifica;
	}

	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	public Date getFhModificacion() {
		return fhModificacion;
	}

	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}

	/**
	 * @return the stFooterFijo
	 */
	public Long getStFooterFijo() {
		return stFooterFijo;
	}

	/**
	 * @param stFooterFijo the stFooterFijo to set
	 */
	public void setStFooterFijo(Long stFooterFijo) {
		this.stFooterFijo = stFooterFijo;
	}

	/**
	 * @return the menuOrientacion
	 */
	public MenuOrientacionDTO getMenuOrientacion() {
		return menuOrientacion;
	}

	/**
	 * @param menuOrientacion the menuOrientacion to set
	 */
	public void setMenuOrientacion(MenuOrientacionDTO menuOrientacion) {
		this.menuOrientacion = menuOrientacion;
	}

	/**
	 * @return the tipoNavegacion
	 */
	public TipoNavegacionDTO getTipoNavegacion() {
		return tipoNavegacion;
	}

	/**
	 * @param tipoNavegacion the tipoNavegacion to set
	 */
	public void setTipoNavegacion(TipoNavegacionDTO tipoNavegacion) {
		this.tipoNavegacion = tipoNavegacion;
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

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.util.List;

public class AuthenticationResponseVO {

	private Long idUser;
	private Long idPerfil;
	private String username;
	private String token;
	private String firstName;
	private String lastName;
	private String isActive;
	private String imei;
	private List<Long> favoriteCollection;
	private Boolean stContrasenia;
	private List<ParametroVO> restrictionCollection;

	public AuthenticationResponseVO(String token) {
		super();
		this.token = token;
	}

	public AuthenticationResponseVO(String token, List<Long> favoriteCollection, Boolean stContrasenia) {
		super();
		this.token = token;
		this.favoriteCollection = favoriteCollection;
		this.stContrasenia = stContrasenia;
	}
	
	public AuthenticationResponseVO(String token, List<Long> favoriteCollection, Boolean stContrasenia, List<ParametroVO> restrictionCollection, Long idPerfil) {
		super();
		this.token = token;
		this.favoriteCollection = favoriteCollection;
		this.stContrasenia = stContrasenia;
		this.restrictionCollection = restrictionCollection;
		this.idPerfil = idPerfil;
	}

	public AuthenticationResponseVO(Long idUser, Long idPerfil, String username, String token, String firstName,
			String lastName, String isActive, String imei) {
		super();
		this.idUser = idUser;
		this.idPerfil = idPerfil;
		this.username = username;
		this.token = token;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.imei = imei;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the favoriteCollection
	 */
	public List<Long> getFavoriteCollection() {
		return favoriteCollection;
	}

	/**
	 * @param favoriteCollection the favoriteCollection to set
	 */
	public void setFavoriteCollection(List<Long> favoriteCollection) {
		this.favoriteCollection = favoriteCollection;
	}

	/**
	 * @return the stContrasenia
	 */
	public Boolean getStContrasenia() {
		return stContrasenia;
	}

	/**
	 * @param stContrasenia the stContrasenia to set
	 */
	public void setStContrasenia(Boolean stContrasenia) {
		this.stContrasenia = stContrasenia;
	}

	public List<ParametroVO> getRestrictionCollection() {
		return restrictionCollection;
	}

	public void setRestrictionCollection(List<ParametroVO> restrictionCollection) {
		this.restrictionCollection = restrictionCollection;
	}

}

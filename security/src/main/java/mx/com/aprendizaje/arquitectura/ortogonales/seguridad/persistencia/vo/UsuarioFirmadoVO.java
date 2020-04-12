package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioFirmadoVO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long perfilId;
	private String username;
	private String password;
	private String cdPerfil;
	private String email;
	private String login;
	private String paginasAcceso;
	private String perfilNombre;
	private String firstName;
	private String lastName;
	private Integer isActive;
	private String apiKey;
	private Date lastPasswordReset;
	private Collection<? extends GrantedAuthority> authorities;
	private Boolean accountNonExpired = true;
	private Boolean accountNonLocked = true;
	private Boolean credentialsNonExpired = true;
	private Boolean enabled = true;
	private Long tiempoExpiracion;
	private Long tiempoInactividad;
	private Boolean stContrasenia;

	public UsuarioFirmadoVO() {
		super();
	}

	public UsuarioFirmadoVO(Long id, String username, String password, String email, Date lastPasswordReset,
			Collection<? extends GrantedAuthority> authorities) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setLastPasswordReset(lastPasswordReset);
		this.setAuthorities(authorities);
	}

	public UsuarioFirmadoVO(Long id, String username, String password, String login, String paginasAcceso,
			Collection<? extends GrantedAuthority> authorities, Long perfilId, String perfilNombre,
			Long tiempoExpiracion, Long tiempoInactividad) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setLogin(login);
		this.setPaginasAcceso(paginasAcceso);
		this.setAuthorities(authorities);
		this.setPerfilId(perfilId);
		this.setPerfilNombre(perfilNombre);
		this.setTiempoExpiracion(tiempoExpiracion);
		this.setTiempoInactividad(tiempoInactividad);

	}

	public UsuarioFirmadoVO(Long id, String username, String password, String login, String userNum, String cdPerfil,
			String paginasAcceso, Collection<? extends GrantedAuthority> authorities, Long perfilId,
			String perfilNombre, Long tiempoExpiracion, Long tiempoInactividad, String firstName, String lastName,
			Integer isActive) {
		this.setId(id);
//		this.setUserNum(userNum);
		this.setUsername(username);
		this.setPassword(password);
		this.setCdPerfil(cdPerfil);
		this.setLogin(login);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setPaginasAcceso(paginasAcceso);
		this.setAuthorities(authorities);
		this.setPerfilId(perfilId);
		this.setPerfilNombre(perfilNombre);
		this.setTiempoExpiracion(tiempoExpiracion);
		this.setTiempoInactividad(tiempoInactividad);
		this.setIsActive(isActive);
	}

	public UsuarioFirmadoVO(Long id, String username, String password, String login,String userNum, 
			String cdPerfil,String paginasAcceso, Collection<? extends GrantedAuthority> authorities,
			Long perfilId, String perfilNombre,Long tiempoExpiracion,Long tiempoInactividad, 
			String firstName, String lastName, Integer isActive, Boolean stContrasenia) {
		this.setId(id);
//		this.setUserNum(userNum);
		this.setUsername(username);
		this.setPassword(password);
		this.setCdPerfil(cdPerfil);
		this.setLogin(login);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setPaginasAcceso(paginasAcceso);
		this.setAuthorities(authorities);
		this.setPerfilId(perfilId);
		this.setPerfilNombre(perfilNombre);
		this.setTiempoExpiracion(tiempoExpiracion);
		this.setTiempoInactividad(tiempoInactividad);
		this.setIsActive(isActive);
		this.setStContrasenia(stContrasenia);
	}

	public UsuarioFirmadoVO(Long id, String username, String password, String login, String userNum, String cdPerfil,
			String paginasAcceso, Collection<? extends GrantedAuthority> authorities, Long perfilId,
			String perfilNombre, Long tiempoExpiracion, Long tiempoInactividad, String firstName, String lastName,
			Integer isActive, String emial) {
		// super();
		this.setId(id);
//		this.setUserNum(userNum);
		this.setUsername(username);
		this.setPassword(password);
		this.setCdPerfil(cdPerfil);
		this.setLogin(login);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setPaginasAcceso(paginasAcceso);
		this.setAuthorities(authorities);
		this.setPerfilId(perfilId);
		this.setPerfilNombre(perfilNombre);
		this.setTiempoExpiracion(tiempoExpiracion);
		this.setTiempoInactividad(tiempoInactividad);
		this.setIsActive(isActive);
		this.setEmail(emial);
	}

	public UsuarioFirmadoVO(Long id, String username, String password, String login, String apiKey,
			String paginasAcceso, Collection<? extends GrantedAuthority> authorities, Long perfilId,
			String perfilNombre) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setLogin(login);
		this.setApiKey(apiKey);
		this.setPaginasAcceso(paginasAcceso);
		this.setAuthorities(authorities);
		this.setPerfilId(perfilId);
		this.setPerfilNombre(perfilNombre);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonIgnore
	public Date getLastPasswordReset() {
		return this.lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@JsonIgnore
	public Boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.getAccountNonExpired();
	}

	@JsonIgnore
	public Boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.getAccountNonLocked();
	}

	@JsonIgnore
	public Boolean getCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.getCredentialsNonExpired();
	}

	@JsonIgnore
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isEnabled() {
		return this.getEnabled();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCdPerfil() {
		return cdPerfil;
	}

	public void setCdPerfil(String cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getPaginasAcceso() {
		return paginasAcceso;
	}

	public void setPaginasAcceso(String paginasAcceso) {
		this.paginasAcceso = paginasAcceso;
	}

	public Long getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}

	public String getPerfilNombre() {
		return perfilNombre;
	}

	public void setPerfilNombre(String perfilNombre) {
		this.perfilNombre = perfilNombre;
	}

	public Long getTiempoExpiracion() {
		return tiempoExpiracion;
	}

	public void setTiempoExpiracion(Long tiempoExpiracion) {
		this.tiempoExpiracion = tiempoExpiracion;
	}

	public Long getTiempoInactividad() {
		return tiempoInactividad;
	}

	public void setTiempoInactividad(Long tiempoInactividad) {
		this.tiempoInactividad = tiempoInactividad;
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

}
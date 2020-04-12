package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.facade;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

  
public interface UserDetailsServiceCustom extends UserDetailsService{
	
	public UserDetails loadUserByUsername(String innerPassword, String clientUser, String uri) throws AuthenticationException;
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.TokenUsuarioFuncionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.factory.SpringSecurityUserFactory;

@Service("userDetailsWebService")
public class SeguridadWebServiceFacade implements UserDetailsServiceCustom{
		
	@Autowired
	private TokenUsuarioFuncionDAO tokenUsuarioFuncionDAO;
	
	/**
	 * {@inheritDoc}
	 * Version o.4.0.3
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String funcionPassword, String userName, String uri) throws AuthenticationException {
		TokenUsuarioFuncionDTO token = tokenUsuarioFuncionDAO.byInnerPasswordUserNameAndUri(funcionPassword, userName, uri);
		return SpringSecurityUserFactory.create(token);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
		
}

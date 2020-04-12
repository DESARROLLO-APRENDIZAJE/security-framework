package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.PerfilUsuarioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.UsuarioDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.factory.SpringSecurityUserFactory;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.menus.MenusService;

@Service("customUserDetailService")
public class SeguridadWebFacade implements UserDetailsService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private MenusService menusService;
	
	@Value("${app.config.codigo}")
	private String codeApplication;
	
	@Value("${app.config.authType}")
	private String authType;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PerfilUsuarioDTO perfilUsuarioDTO = usuarioDAO.findByUsername(username, codeApplication);
		if (perfilUsuarioDTO == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
		List<ViewPaginaServicioDTO> menusPrivilegios = menusService.byAppCodeAndPerfil(perfilUsuarioDTO.getPerfiles().getIdPerfil(),  perfilUsuarioDTO.getUsuarios().getIdUsuario(), codeApplication);
		return SpringSecurityUserFactory.create(perfilUsuarioDTO, menusPrivilegios);
	}
	
}
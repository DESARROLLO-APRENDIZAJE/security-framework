package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.factory;

import java.util.ArrayList;
import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.PerfilUsuarioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ServicioRestDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ClienteVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;

public class SpringSecurityUserFactory {

 
	public static UsuarioFirmadoVO create(PerfilUsuarioDTO perfilUsuarioDTO, List<ViewPaginaServicioDTO> menusPrivilegios) {
		
		return new UsuarioFirmadoVO(
			perfilUsuarioDTO.getUsuarios().getIdUsuario(),
			perfilUsuarioDTO.getUsuarios().getNbUsuario()+ " " + perfilUsuarioDTO.getUsuarios().getNbApaterno(),
			perfilUsuarioDTO.getUsuarios().getNbContraseniaBackup(),
			perfilUsuarioDTO.getUsuarios().getCdUsuario(),
			perfilUsuarioDTO.getUsuarios().getCdUsuario(),
			perfilUsuarioDTO.getPerfiles().getCdPerfil(),
			SpringSecurityUserFactory.obtenerPaginasAccesoUsuario(menusPrivilegios),
			SpringSecurityUserFactory.obtenerServiciosAccesoUsuario(menusPrivilegios),
			perfilUsuarioDTO.getPerfiles().getIdPerfil(),
			perfilUsuarioDTO.getPerfiles().getNbPerfil(),
			perfilUsuarioDTO.getPerfiles().getAplicaciones().getNuExpiracion(),
			perfilUsuarioDTO.getPerfiles().getAplicaciones().getNuInactividad(),
			perfilUsuarioDTO.getUsuarios().getNbApaterno(),
			perfilUsuarioDTO.getUsuarios().getNbAmaterno(),
			perfilUsuarioDTO.getUsuarios().getStActivo(),
			perfilUsuarioDTO.getUsuarios().getStContrasenia());
	}
	
	/**
	 * Version o.4.0.3
	 * @param menusPrivilegios
	 * @return ClienteVO
	 */
	public static ClienteVO create(TokenUsuarioFuncionDTO dto){
		return new ClienteVO(dto.getUsuario().getUsuario(), dto.getFuncionPassword());
	}
	

	// METODOS RENOMBRADOS
	public static String obtenerPaginasAccesoUsuario(List<ViewPaginaServicioDTO> menusPrivilegios) {

		StringBuilder sb = new StringBuilder();
		for (ViewPaginaServicioDTO viewPaginaServicioDTO : menusPrivilegios) {
			if (viewPaginaServicioDTO != null) {
				sb.append(viewPaginaServicioDTO.getId().getMenuUri());
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static List<ServicioRestDTO> obtenerServiciosAccesoUsuario(List<ViewPaginaServicioDTO> menusPrivilegios) {
		List<ServicioRestDTO> listaServicios = new ArrayList<>();
		ServicioRestDTO servicioRestDTO;
		for (ViewPaginaServicioDTO viewServicioDTO : menusPrivilegios) {
			if (viewServicioDTO != null) {
				servicioRestDTO = new ServicioRestDTO();
				servicioRestDTO.setNbServicio(viewServicioDTO.getId().getServicioNombre());
				listaServicios.add(servicioRestDTO);
			}
		}
		return listaServicios;
	}

}

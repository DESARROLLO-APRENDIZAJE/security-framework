package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;

public interface MenusDAO extends BaseDao<MenusDTO> {

	public List<MenusDTO> buscarMenuUsuario(Long perfilId,  String codeApplication);
	public List<ViewPaginaServicioDTO> buscarPrivilegios(Long perfilId, String codeApplication);
	
	/**
	 * Descripci�n: M�todo para consultar un men� por su ID
	 * @author Jorge Luis
	 * @return MenusDTO
	 */
	public MenusDTO getMenuById(Long idMenu);
	
	
	/**
	 * Descripci�n: M�todo para consultar los men�s 
	 * por el filtro del usuario
	 * @author Jorge Luis
	 * @return MenusDTO
	 */
	public List<MenusDTO> buscarMenuUsuario(Long idPerfil, Long idUsuario, String cdApp);

}

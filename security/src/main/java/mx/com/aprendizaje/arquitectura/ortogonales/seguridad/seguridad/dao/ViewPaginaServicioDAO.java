package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;

public interface ViewPaginaServicioDAO extends BaseDao<ViewPaginaServicioDTO>{

	/**
	 * @author Kevin Ojeda
	 * @param perfilId
	 * @param AppCode
	 * @return List<ViewPaginaServicioDTO>
	 */
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId, String AppCode);
	
	
	/**
	 * @author jorgeluis
	 * @param perfilId
	 * @param idUsuario
	 * @param appCode
	 * @return List<ViewPaginaServicioDTO>
	 */
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId, Long idUser, String appCode);

}

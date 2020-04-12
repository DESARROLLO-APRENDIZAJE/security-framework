package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionFavoritosDTO;

public interface ConfiguracionFavoritosDAO extends BaseDao<ConfiguracionFavoritosDTO> {

	/**
	 * Descripci�n: M�todo para consultar los men�s favoritos 
	 * del usuario
	 * @author Jorge Luis
	 * @return List<ConfiguracionFavoritosDTO>
	 */
	public List<ConfiguracionFavoritosDTO> getFavoritesByUsr(Long idUsuario, String cdApp);

	
	/**
	 * Descripci�n: M�todo para consultar todos los men�s favoritos 
	 * del usuario
	 * @author Jorge Luis
	 * @return List<ConfiguracionFavoritosDTO>
	 */
	public List<ConfiguracionFavoritosDTO> getAllFavoritesByUsr(Long idUsuario, String cdApp);
	
}

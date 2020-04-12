package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.favoritos1;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.exception.NotFoundException;

public interface FavoritosService {

	/**
	 * Descripci�n: M�todo para guardar, actualizar y 
	 * borrar los men�s favoritos del usuario
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean favoriteSetting(List<Long> idMenu) throws BusinessException, NotFoundException;
	
	/**
	 * Descripci�n: M�todo para consultar todos los 
	 * men�s favoritos del usuarios
	 * @author Jorge Luis
	 * @return List<Long>
	 */
	public List<Long> getFavorites();

	
}

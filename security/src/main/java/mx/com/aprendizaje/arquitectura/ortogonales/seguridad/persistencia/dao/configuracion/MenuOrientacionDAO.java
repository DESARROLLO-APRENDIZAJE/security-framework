package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.MenuOrientacionDTO;

public interface MenuOrientacionDAO extends BaseDao<MenuOrientacionDTO> {

	/**
	 * Descripci�n: M�todo para consultar todos los registro de
	 * orientaci�n de menu en BD
	 * @author Jorge Luis
	 * @return List<MenuOrientacionDTO>
	 */
	public List<MenuOrientacionDTO> getMenuOrientation();
	
}

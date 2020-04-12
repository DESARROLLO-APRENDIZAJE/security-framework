package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TipoNavegacionDTO;

public interface TipoNavegacionDAO extends BaseDao<TipoNavegacionDTO> {


	/**
	 * Descripci�n: M�todo para consultar todos los registro de
	 * tipo de navegaci�n en BD
	 * @author Jorge Luis
	 * @return List<TipoNavegacionDTO>
	 */
	public List<TipoNavegacionDTO> getNavigationType();
	
}

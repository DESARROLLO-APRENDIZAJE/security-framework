package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.TipoParametroDTO;

public interface TipoParametroDAO extends BaseDao<TipoParametroDTO>{

	/**
	 * Descripci�n: M�todo para consultar las clasificaci�n
	 * de los par�metros
	 * @author Jorge Luis
	 * @return List<TipoParametroDTO>
	 */
	public List<TipoParametroDTO> typeRestriction();
}

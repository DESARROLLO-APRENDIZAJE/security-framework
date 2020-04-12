package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.UsuarioDTO;

public interface UsuarioDAO extends BaseDao<UsuarioDTO>{
	
	/**
	 * @author Kevin Ojeda
	 * @param code
	 * @return UsuarioDTO
	 */
	public UsuarioDTO activoByUserName(String code);
}

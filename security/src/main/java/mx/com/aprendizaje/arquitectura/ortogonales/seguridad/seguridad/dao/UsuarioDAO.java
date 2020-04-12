package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.PerfilUsuarioDTO;


public interface UsuarioDAO extends BaseDao<PerfilUsuarioDTO> {
	
	public PerfilUsuarioDTO findByUsername(String username,String codeApplication);	
	
}

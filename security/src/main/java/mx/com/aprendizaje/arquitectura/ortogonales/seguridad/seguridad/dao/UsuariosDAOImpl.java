package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.UsuariosDTO;

@Repository
public class UsuariosDAOImpl extends BaseDaoHibernate<UsuariosDTO> implements UsuariosDAO{

}

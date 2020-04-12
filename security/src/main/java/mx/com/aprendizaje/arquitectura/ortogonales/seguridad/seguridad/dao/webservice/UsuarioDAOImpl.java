package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.UsuarioDTO;

@Repository("WebServiceUser")
public class UsuarioDAOImpl extends BaseDaoHibernate<UsuarioDTO> implements UsuarioDAO{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioDTO activoByUserName(String userName){
		return (UsuarioDTO) getCurrentSession().createCriteria(UsuarioDTO.class)
		.add(Restrictions.eq("usuario", userName))
		.add(Restrictions.eq("activo", 1)).uniqueResult();
	}
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;

@Repository
public class TokenUsuarioFuncionDAOImpl extends BaseDaoHibernate<TokenUsuarioFuncionDTO> implements TokenUsuarioFuncionDAO {

	@Override
	public TokenUsuarioFuncionDTO byInnerPasswordUserNameAndUri(String funcionPassword, String userName, String uri){
		return (TokenUsuarioFuncionDTO) getCurrentSession().createCriteria(TokenUsuarioFuncionDTO.class)
		.createAlias("funcion", "funcion")
		.createAlias("funcion.servicio", "servicio")
		.createAlias("usuario", "usuario")
		.add(Restrictions.eq("funcionPassword", funcionPassword))
		.add(Restrictions.eq("usuario.usuario", userName))
		.add(Restrictions.eq("funcion.nombreUri", uri))
		.add(Restrictions.eq("servicio.activo", 1))
		.add(Restrictions.eq("usuario.activo", 1))
		.add(Restrictions.eq("funcion.activo", 1))
		.add(Restrictions.eq("activo", 1))
		.uniqueResult();
	}
	
	@Override
	public TokenUsuarioFuncionDTO byUserNameAndFunctionCode(String userName, String codigoFuncion){
		return (TokenUsuarioFuncionDTO) getCurrentSession().createCriteria(TokenUsuarioFuncionDTO.class)
		.createAlias("funcion", "funcion")
		.createAlias("usuario", "usuario")
		.add(Restrictions.eq("usuario.usuario", userName))
		.add(Restrictions.eq("funcion.codigoFuncion", codigoFuncion))
		.uniqueResult();
	}
}

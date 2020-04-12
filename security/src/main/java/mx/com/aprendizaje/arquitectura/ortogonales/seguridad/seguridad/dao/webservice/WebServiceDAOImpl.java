package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WebServiceDTO;

@Repository
public class WebServiceDAOImpl extends BaseDaoHibernate<WebServiceDTO> implements WebServiceDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebServiceDTO byContextPath(String contextPath){
		return (WebServiceDTO) getCurrentSession().createCriteria(WebServiceDTO.class)
				.add(Restrictions.eq("contexto", contextPath))
				.add(Restrictions.eq("activo", 1)).uniqueResult();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebServiceDTO byCode(String cdWebService){
		return (WebServiceDTO) getCurrentSession().createCriteria(WebServiceDTO.class)
				.add(Restrictions.eq("codigoServicio", cdWebService))
				.add(Restrictions.eq("activo", 1)).uniqueResult();
	}
}

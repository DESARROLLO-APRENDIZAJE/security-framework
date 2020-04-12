package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.FuncionDTO;

@Repository
public class FuncionDAOImpl extends BaseDaoHibernate<FuncionDTO> implements FuncionDAO {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FuncionDTO activoByCode(String code){
		return (FuncionDTO) getCurrentSession().createCriteria(FuncionDTO.class)
			.createAlias("servicio", "servicio")
			.add(Restrictions.eq("servicio.activo", 1))
			.add(Restrictions.eq("codigoFuncion", code))
			.add(Restrictions.eq("activo", 1)).uniqueResult();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FuncionDTO byContextPathAndEndPoint(String contextPath, String endPoint){
		return (FuncionDTO) getCurrentSession().createCriteria(FuncionDTO.class)
			.createAlias("servicio", "servicio")
			.add(Restrictions.eq("servicio.contexto", contextPath))
			.add(Restrictions.eq("servicio.activo", 1))
			.add(Restrictions.eq("nombreUri", endPoint))
			.add(Restrictions.eq("activo", 1)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FuncionDTO> byCodeService(String cdServiceWeb) {
		return (List<FuncionDTO>) getCurrentSession().createCriteria(FuncionDTO.class)
			.createAlias("servicio", "servicio")
			.add(Restrictions.eq("servicio.activo", 1))
			.add(Restrictions.eq("servicio.codigoServicio", cdServiceWeb))
			.add(Restrictions.eq("activo", 1))
			.list();
	}
	
}

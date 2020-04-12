package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;

@Repository
public class ParametroDAOImpl extends BaseDaoHibernate<ParametroDTO> implements ParametroDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ParametroDTO> getParamsByAplication(String cdAplicacion) {
		Criteria c = getCurrentSession().createCriteria(ParametroDTO.class);
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("app.cdAplicacion", cdAplicacion));
		c.add(Restrictions.eq("stActivo", 1));
		c.addOrder(Order.asc("idParametro"));
		return c.list();
 	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParametroDTO> getParamsInterByAplication(String cdAplicacion, Integer interno) {
		Criteria c = getCurrentSession().createCriteria(ParametroDTO.class);
		c.createAlias("aplicacion", "app");	
		c.add(Restrictions.eq("app.cdAplicacion", cdAplicacion));
		c.add(Restrictions.eq("stParametroInterno", interno));
		c.add(Restrictions.eq("stActivo", 1));
		return c.list();
 	}
	
	@Override
	public ParametroDTO getParameterByAplicationAndCod(String cdAplicacion, String cdParameter) {
		Criteria c = getCurrentSession().createCriteria(ParametroDTO.class);
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("cdParametro", cdParameter));
		c.add(Restrictions.eq("app.cdAplicacion", cdAplicacion));
		c.add(Restrictions.eq("stActivo", 1));
		return (ParametroDTO) c.uniqueResult();
	}

	@Override
	public ParametroDTO restrictionById(Long idParametro) {
		Criteria c = getCurrentSession().createCriteria(ParametroDTO.class);
		c.add(Restrictions.eq("idParametro", idParametro));
		return (ParametroDTO)c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParametroDTO> getRestrictions(String cdAplicacion) {
		Criteria c = getCurrentSession().createCriteria(ParametroDTO.class);
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("app.cdAplicacion", cdAplicacion));
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq("stActivo", 1));
		or.add(Restrictions.eq("stActivo", 0));
		c.add(or);
		c.addOrder(Order.asc("idParametro"));
		return (List<ParametroDTO>) c.list();
	}
}

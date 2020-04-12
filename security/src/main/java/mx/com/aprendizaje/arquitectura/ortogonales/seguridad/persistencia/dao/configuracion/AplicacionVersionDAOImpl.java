package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.AplicacionVersionDTO;

@Repository
public class AplicacionVersionDAOImpl extends BaseDaoHibernate<AplicacionVersionDTO> implements AplicacionVersionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public AplicacionVersionDTO getCurrentVersion(String cdApp) {
		Criteria c = getCurrentSession().createCriteria(AplicacionVersionDTO.class);
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("app.stActivo", 1));
		c.add(Restrictions.eq("app.cdAplicacion", cdApp));
		c.add(Restrictions.eq("stActivo", 1));
		List<AplicacionVersionDTO> list = (List<AplicacionVersionDTO>) c.list();
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AplicacionVersionDTO> getVersion(String cdApp) {
		Criteria c = getCurrentSession().createCriteria(AplicacionVersionDTO.class);
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("app.stActivo", 1));
		c.add(Restrictions.eq("app.cdAplicacion", cdApp));
		
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq("stActivo", 1));
		or.add(Restrictions.eq("stActivo", 0));
		c.add(or);
		c.addOrder(Order.asc("txValor"));
		return (List<AplicacionVersionDTO>) c.list();
	}

	@Override
	public AplicacionVersionDTO getVersion(Long idVersion) {
		Criteria c = getCurrentSession().createCriteria(AplicacionVersionDTO.class);
		c.add(Restrictions.eq("idVersion", idVersion));
		return (AplicacionVersionDTO) c.uniqueResult();
	}

}

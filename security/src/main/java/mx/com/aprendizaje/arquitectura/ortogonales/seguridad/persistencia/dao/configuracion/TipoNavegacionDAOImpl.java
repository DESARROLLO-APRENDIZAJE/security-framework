package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TipoNavegacionDTO;

@Repository
public class TipoNavegacionDAOImpl extends BaseDaoHibernate<TipoNavegacionDTO> implements TipoNavegacionDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoNavegacionDTO> getNavigationType() {
		Criteria c = getCurrentSession().createCriteria(TipoNavegacionDTO.class);
		c.add(Restrictions.eq("stActivo", 1));
		c.addOrder(Order.asc("idTipoNavegacion"));
		return (List<TipoNavegacionDTO>)c.list();
	}

}

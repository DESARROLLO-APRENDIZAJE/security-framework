package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.MenuOrientacionDTO;

@Repository
public class MenuOrientacionDAOImpl extends BaseDaoHibernate<MenuOrientacionDTO> implements MenuOrientacionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuOrientacionDTO> getMenuOrientation() {
		Criteria c = getCurrentSession().createCriteria(MenuOrientacionDTO.class);
		c.add(Restrictions.eq("stActivo", 1));
		c.addOrder(Order.asc("idMenuOrientacion"));
		return (List<MenuOrientacionDTO>)c.list();
	}

}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.TipoParametroDTO;

@Repository
public class TipoParametroDAOImpl extends BaseDaoHibernate<TipoParametroDTO> implements TipoParametroDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoParametroDTO> typeRestriction() {
		Criteria c = getCurrentSession().createCriteria(TipoParametroDTO.class);
		c.add(Restrictions.eq("stActivo", 1));
		return (List<TipoParametroDTO>)c.list();
	}

}

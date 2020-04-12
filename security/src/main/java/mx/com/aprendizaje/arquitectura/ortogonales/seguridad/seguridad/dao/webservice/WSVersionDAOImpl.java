package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WSVersionDTO;

@Repository
public class WSVersionDAOImpl extends BaseDaoHibernate<WSVersionDTO> implements WSVersionDAO {
	
	@Override
	public WSVersionDTO currentVersion(String wSCode){
		return (WSVersionDTO) getCurrentSession().createCriteria(WSVersionDTO.class)
			.createAlias("servicio", "servicio")
			.add(Restrictions.eq("servicio.codigoServicio",wSCode))
			.add(Restrictions.eq("servicio.activo",1))
			.add(Restrictions.eq("versionActual",1))
			.add(Restrictions.eq("activo",1))
			.uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WSVersionDTO> recordVersions(String wSCode){
		return getCurrentSession().createCriteria(WSVersionDTO.class)
			.createAlias("servicio", "servicio")
			.add(Restrictions.eq("servicio.codigoServicio",wSCode))
			.add(Restrictions.eq("servicio.activo",1))
			.add(Restrictions.eq("activo",1))
			.addOrder(Order.desc("versionNombre"))
			.list();
	}
}

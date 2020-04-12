package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionFavoritosDTO;

@Repository
public class ConfiguracionFavoritosDAOImpl extends BaseDaoHibernate<ConfiguracionFavoritosDTO>
		implements ConfiguracionFavoritosDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ConfiguracionFavoritosDTO> getFavoritesByUsr(Long idUsuario, String cdApp) {
		Criteria c = getCurrentSession().createCriteria(ConfiguracionFavoritosDTO.class);
		c.createAlias("usuario", "usr");
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("stActivo", 1));
		c.add(Restrictions.eq("usr.idUsuario", idUsuario));
		c.add(Restrictions.eq("app.cdAplicacion", cdApp));
		return (List<ConfiguracionFavoritosDTO>)c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConfiguracionFavoritosDTO> getAllFavoritesByUsr(Long idUsuario, String cdApp) {
		Criteria c = getCurrentSession().createCriteria(ConfiguracionFavoritosDTO.class);
		c.createAlias("usuario", "usr");
		c.createAlias("aplicacion", "app");
		c.add(Restrictions.eq("usr.idUsuario", idUsuario));
		c.add(Restrictions.eq("app.cdAplicacion", cdApp));
		return (List<ConfiguracionFavoritosDTO>)c.list();
	}

}

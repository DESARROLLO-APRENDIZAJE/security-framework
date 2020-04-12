package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;

@Repository
public class MenusDAOImpl extends BaseDaoHibernate<MenusDTO> implements MenusDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MenusDTO> buscarMenuUsuario(Long perfilId, String codeApplication) {
		
		
//		sql.append(" SELECT md.* from MENU_DINAMICO md  ");
//		sql.append(" JOIN  PERFIL_MENU pm  on md.MENU_ID = pm.MENU_ID  ");
//		sql.append(" JOIN  TSEG_CAT_APLICACIONES app on md.ID_APLICACION = app.ID_APLICACION ");
//		sql.append("  WHERE   pm.PERFIL_ID = :perfilId  AND app.CD_APLICACION = :codeApplication");
//		sql.append("  AND ST_ACTIVO=1 ORDER BY MENU_ORDEN ");
		
		Criteria c = getCurrentSession().createCriteria(MenusDTO.class);
//		c.createAlias("menuses", "usuario");
//		c.createAlias("perfiles.aplicaciones", "aplicacion");
		c.createAlias("aplicaciones", "aplicacion");
		c.createAlias("perfiles", "perfiles");
		c.createAlias("perfiles.perfiles", "perfil");
		c.createAlias("perfil.aplicaciones", "saplicacion");
		
 		c.add(Restrictions.eq("perfil.idPerfil", perfilId));
		c.add(Restrictions.eq("aplicacion.cdAplicacion", codeApplication));
		c.add(Restrictions.eq("saplicacion.cdAplicacion", codeApplication));
 		c.add(Restrictions.eq("stActivo", 1));
 		c.add(Restrictions.eq("perfiles.stActivo", 1));
 		c.add(Restrictions.eq("perfil.stActivo", 1));
 		c.add(Restrictions.eq("aplicacion.stActivo", 1));
 		c.addOrder(Order.asc("nuMenuOrden"));
 		return c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewPaginaServicioDTO> buscarPrivilegios(Long perfilId, String codeApplication) {

		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT * from V_SEG_PAGINA_SERVICIO  ");
		sql.append("  WHERE   PERFIL_ID = :perfilId  AND CD_APLICACION = :codeApplication");
		Query query = getCurrentSession().createSQLQuery(sql.toString()).addEntity(ViewPaginaServicioDTO.class);
		query.setParameter("perfilId", perfilId);
		query.setParameter("codeApplication", codeApplication);
 
		return query.list();
		
 	}

	@Override
	public MenusDTO getMenuById(Long idMenu) {
		Criteria c = getCurrentSession().createCriteria(MenusDTO.class);
		c.add(Restrictions.eq("idMenu", idMenu));
		return (MenusDTO)c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenusDTO> buscarMenuUsuario(Long idPerfil, Long idUsuario, String cdApp) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ");
		sql.append(" 	*  ");
		sql.append(" FROM  ");
		sql.append(" 	(  ");
		sql.append(" 	SELECT  ");
		sql.append(" 		md.*  ");
		sql.append(" 	FROM  ");
		sql.append(" 		TAQ030C_SE_MENUS md  ");
		sql.append(" 	JOIN TAQ035D_SE_PERFIL_MENU pm ON  ");
		sql.append(" 		md.ID_MENU = pm.ID_MENU  ");
		sql.append(" 	JOIN TAQ028C_SE_APLICACIONES app ON  ");
		sql.append(" 		md.ID_APLICACION = app.ID_APLICACION  ");
		sql.append(" 	WHERE  ");
		sql.append(" 		pm.ID_PERFIL = :perfilId  ");
		sql.append(" 		AND app.CD_APLICACION = :codeApplication  ");
		sql.append(" 		AND MD.ST_ACTIVO = 1  ");
		sql.append(" 		AND md.ID_MENU NOT IN (  ");
		sql.append(" 			SELECT ID_MENU  ");
		sql.append(" 		FROM  ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU  ");
		sql.append(" 		WHERE  ");
		sql.append(" 			ST_ADICION = 0  ");
		sql.append(" 			AND ID_PERFIL = :perfilId  ");
		sql.append(" 			AND ID_USUARIO = :empId)  ");
		sql.append(" UNION ALL  ");
		sql.append(" 	SELECT  ");
		sql.append(" 		md.*  ");
		sql.append(" 	FROM  ");
		sql.append(" 		TAQ030C_SE_MENUS md  ");
		sql.append(" 	JOIN TAQ028C_SE_APLICACIONES app ON  ");
		sql.append(" 		md.ID_APLICACION = app.ID_APLICACION  ");
		sql.append(" 	WHERE  ");
		sql.append(" 		app.CD_APLICACION = :codeApplication  ");
		sql.append(" 		AND md.ID_MENU IN (  ");
		sql.append(" 			SELECT ID_MENU  ");
		sql.append(" 		FROM  ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU  ");
		sql.append(" 		WHERE  ");
		sql.append(" 			ST_ADICION = 1  ");
		sql.append(" 			AND ID_PERFIL = :perfilId  ");
		sql.append(" 			AND ID_USUARIO = :empId))  ");
		sql.append(" ORDER BY  ");
		sql.append(" 	NU_MENU_ORDEN  ");
		
		Query query = getCurrentSession().createSQLQuery(sql.toString()).addEntity(MenusDTO.class);
		query.setParameter("perfilId", idPerfil);
		query.setParameter("empId", idUsuario);
		query.setParameter("codeApplication", cdApp);
		return query.list();
	}

	 

	 
}

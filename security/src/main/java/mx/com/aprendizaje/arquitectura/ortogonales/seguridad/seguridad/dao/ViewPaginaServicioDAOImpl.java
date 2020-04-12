package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;

@Repository
public class ViewPaginaServicioDAOImpl extends BaseDaoHibernate<ViewPaginaServicioDTO> implements ViewPaginaServicioDAO {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId, String appCode){
		Criteria c = getCurrentSession().createCriteria(ViewPaginaServicioDTO.class);
		c.add(Restrictions.eq("id.perfilId", perfilId));
		c.add(Restrictions.eq("id.cdAplicacion", appCode));
		return (List<ViewPaginaServicioDTO>) c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId, Long idUser, String appCode) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT   ");
		sql.append(" 	ID,   ");
		sql.append(" 	MENU_URI,   ");
		sql.append(" 	SERVICIO_NOMBRE,   ");
		sql.append(" 	ID_MENU_PRINCIPAL,   ");
		sql.append(" 	CD_APLICACION,   ");
		sql.append(" 	PERFIL_ID   ");
		sql.append(" FROM   ");
		sql.append(" 	(   ");
		sql.append(" 	SELECT   ");
		sql.append(" 		ms.ID_MENU AS ID,   ");
		sql.append(" 		md.NB_MENU_URI AS MENU_URI,   ");
		sql.append(" 		sr.NB_SERVICIO AS SERVICIO_NOMBRE,   ");
		sql.append(" 		TO_NUMBER (md.NU_MENU_SUPERIOR) AS ID_MENU_PRINCIPAL,   ");
		sql.append(" 		ap.CD_APLICACION AS CD_APLICACION,   ");
		sql.append(" 		pm.ID_PERFIL AS PERFIL_ID   ");
		sql.append(" 	FROM   ");
		sql.append(" 		TAQ033D_SE_MENU_SERVICIO ms   ");
		sql.append(" 	LEFT JOIN TAQ030C_SE_MENUS md ON   ");
		sql.append(" 		(ms.ID_MENU = md.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ032C_SE_SERVICIO_REST sr ON   ");
		sql.append(" 		(ms.ID_SERVICIO = sr.ID_SERVICIO)   ");
		sql.append(" 	LEFT JOIN TAQ035D_SE_PERFIL_MENU pm ON   ");
		sql.append(" 		(ms.ID_MENU = pm.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ028C_SE_APLICACIONES ap ON   ");
		sql.append(" 		(md.ID_APLICACION = ap.ID_APLICACION)   ");
		sql.append(" 	WHERE   ");
		sql.append(" 		md.NU_MENU_SUPERIOR != 0   ");
		sql.append(" 		AND pm.ID_PERFIL = :perfilId   ");
		sql.append(" 		AND ap.CD_APLICACION = :codeApplication   ");
		sql.append(" 		AND ms.ID_MENU NOT IN (   ");
		sql.append(" 			SELECT ID_MENU   ");
		sql.append(" 		FROM   ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU   ");
		sql.append(" 		WHERE   ");
		sql.append(" 			ST_ADICION = 0   ");
		sql.append(" 			AND ID_PERFIL = :perfilId   ");
		sql.append(" 			AND ID_USUARIO = :empId)   ");
		sql.append(" UNION ALL   ");
		sql.append(" 	SELECT   ");
		sql.append(" 		ms.ID_MENU AS ID,   ");
		sql.append(" 		md.NB_MENU_URI AS MENU_URI,   ");
		sql.append(" 		sr.NB_SERVICIO AS SERVICIO_NOMBRE,   ");
		sql.append(" 		TO_NUMBER (md.NU_MENU_SUPERIOR) AS ID_MENU_PRINCIPAL,   ");
		sql.append(" 		ap.CD_APLICACION AS CD_APLICACION,   ");
		sql.append(" 		NVL(pm.ID_PERFIL, :perfilId) AS PERFIL_ID   ");
		sql.append(" 	FROM   ");
		sql.append(" 		TAQ033D_SE_MENU_SERVICIO ms   ");
		sql.append(" 	LEFT JOIN TAQ030C_SE_MENUS md ON   ");
		sql.append(" 		(ms.ID_MENU = md.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ032C_SE_SERVICIO_REST sr ON   ");
		sql.append(" 		(ms.ID_SERVICIO = sr.ID_SERVICIO)   ");
		sql.append(" 	LEFT JOIN TAQ035D_SE_PERFIL_MENU pm ON   ");
		sql.append(" 		(ms.ID_MENU = pm.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ028C_SE_APLICACIONES ap ON   ");
		sql.append(" 		(md.ID_APLICACION = ap.ID_APLICACION)   ");
		sql.append(" 	WHERE   ");
		sql.append(" 		md.NU_MENU_SUPERIOR != 0   ");
		sql.append(" 		AND ap.CD_APLICACION = :codeApplication   ");
		sql.append(" 		AND ms.ID_MENU IN (   ");
		sql.append(" 			SELECT ID_MENU   ");
		sql.append(" 		FROM   ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU   ");
		sql.append(" 		WHERE   ");
		sql.append(" 			ST_ADICION = 1   ");
		sql.append(" 			AND ID_PERFIL = :perfilId   ");
		sql.append(" 			AND ID_USUARIO = :empId)   ");
		sql.append(" UNION ALL   ");
		sql.append(" 	SELECT   ");
		sql.append(" 		ps.ID_PAGINA,   ");
		sql.append(" 		pw.NB_URI_PAGINA,   ");
		sql.append(" 		sr.NB_SERVICIO,   ");
		sql.append(" 		ps.ID_MENU,   ");
		sql.append(" 		ap.CD_APLICACION AS CD_APLICACION,   ");
		sql.append(" 		pm.ID_PERFIL   ");
		sql.append(" 	FROM   ");
		sql.append(" 		TAQ034D_SE_PAGINA_SERVICIO ps   ");
		sql.append(" 	LEFT JOIN TAQ032C_SE_SERVICIO_REST sr ON   ");
		sql.append(" 		(ps.ID_SERVICIO = sr.ID_SERVICIO)   ");
		sql.append(" 	LEFT JOIN TAQ030C_SE_MENUS md ON   ");
		sql.append(" 		(ps.ID_MENU = md.ID_MENU   ");
		sql.append(" 		AND md.NU_MENU_SUPERIOR != 0)   ");
		sql.append(" 	LEFT JOIN TAQ031C_SE_PAGINAS pw ON   ");
		sql.append(" 		(ps.ID_PAGINA = pw.ID_PAGINA)   ");
		sql.append(" 	LEFT JOIN TAQ035D_SE_PERFIL_MENU pm ON   ");
		sql.append(" 		(ps.ID_MENU = pm.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ028C_SE_APLICACIONES ap ON   ");
		sql.append(" 		(md.ID_APLICACION = ap.ID_APLICACION)   ");
		sql.append(" 	WHERE   ");
		sql.append(" 		md.NU_MENU_SUPERIOR != 0   ");
		sql.append(" 		AND pm.ID_PERFIL = :perfilId   ");
		sql.append(" 		AND ap.CD_APLICACION = :codeApplication   ");
		sql.append(" 		AND pm.ID_MENU NOT IN (   ");
		sql.append(" 			SELECT ID_MENU   ");
		sql.append(" 		FROM   ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU   ");
		sql.append(" 		WHERE   ");
		sql.append(" 			ST_ADICION = 0   ");
		sql.append(" 			AND ID_PERFIL = :perfilId   ");
		sql.append(" 			AND ID_USUARIO = :empId)   ");
		sql.append(" UNION ALL   ");
		sql.append(" 	SELECT   ");
		sql.append(" 		ps.ID_PAGINA,   ");
		sql.append(" 		pw.NB_URI_PAGINA,   ");
		sql.append(" 		sr.NB_SERVICIO,   ");
		sql.append(" 		ps.ID_MENU,   ");
		sql.append(" 		ap.CD_APLICACION AS CD_APLICACION,   ");
		sql.append(" 		NVL(pm.ID_PERFIL, :perfilId)   ");
		sql.append(" 	FROM   ");
		sql.append(" 		TAQ034D_SE_PAGINA_SERVICIO ps   ");
		sql.append(" 	LEFT JOIN TAQ032C_SE_SERVICIO_REST sr ON   ");
		sql.append(" 		(ps.ID_SERVICIO = sr.ID_SERVICIO)   ");
		sql.append(" 	LEFT JOIN TAQ030C_SE_MENUS md ON   ");
		sql.append(" 		(ps.ID_MENU = md.ID_MENU   ");
		sql.append(" 		AND md.NU_MENU_SUPERIOR != 0)   ");
		sql.append(" 	LEFT JOIN TAQ031C_SE_PAGINAS pw ON   ");
		sql.append(" 		(ps.ID_PAGINA = pw.ID_PAGINA)   ");
		sql.append(" 	LEFT JOIN TAQ035D_SE_PERFIL_MENU pm ON   ");
		sql.append(" 		(ps.ID_MENU = pm.ID_MENU)   ");
		sql.append(" 	LEFT JOIN TAQ028C_SE_APLICACIONES ap ON   ");
		sql.append(" 		(md.ID_APLICACION = ap.ID_APLICACION)   ");
		sql.append(" 	WHERE   ");
		sql.append(" 		md.NU_MENU_SUPERIOR != 0   ");
		sql.append(" 		AND ap.CD_APLICACION = :codeApplication   ");
		sql.append(" 		AND pm.ID_MENU IN (   ");
		sql.append(" 			SELECT ID_MENU   ");
		sql.append(" 		FROM   ");
		sql.append(" 			TAQ063D_SE_USUARIO_MENU   ");
		sql.append(" 		WHERE   ");
		sql.append(" 			ST_ADICION = 1   ");
		sql.append(" 			AND ID_PERFIL = :perfilId   ");
		sql.append(" 			AND ID_USUARIO = :empId))   ");
		
		Query query = getCurrentSession().createSQLQuery(sql.toString()).addEntity(ViewPaginaServicioDTO.class);
		query.setParameter("perfilId", perfilId);
		query.setParameter("empId", idUser);
		query.setParameter("codeApplication", appCode);

		return query.list();
	}
}

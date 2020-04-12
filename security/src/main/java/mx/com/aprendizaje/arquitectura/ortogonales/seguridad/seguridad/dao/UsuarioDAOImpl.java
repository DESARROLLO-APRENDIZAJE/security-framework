package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.PerfilUsuarioDTO;

@Repository
public class UsuarioDAOImpl extends BaseDaoHibernate<PerfilUsuarioDTO> implements UsuarioDAO {

	@Override
	public PerfilUsuarioDTO findByUsername(String username, String codeApplication) {

		Criteria c = getCurrentSession().createCriteria(PerfilUsuarioDTO.class);
		c.createAlias("usuarios", "usuario");
		c.createAlias("perfiles", "perfil");
		c.createAlias("perfil.aplicaciones", "aplicacion");
 		c.add(Restrictions.eq("usuario.cdUsuario", username));
 		c.add(Restrictions.eq("usuario.stActivo", 1));
 		c.add(Restrictions.eq("aplicacion.cdAplicacion", codeApplication));
 		c.add(Restrictions.eq("aplicacion.stActivo", 1));
 		c.add(Restrictions.eq("perfil.stActivo", 1));
 		c.add(Restrictions.eq("stActivo", 1));
 		
		
		final PerfilUsuarioDTO perfilUsuarioDTO = (PerfilUsuarioDTO) c.uniqueResult();
 		if (perfilUsuarioDTO == null) {
			return null;
		}
		final String pwd = perfilUsuarioDTO.getUsuarios().getNbContrasenia();
		getCurrentSession().doWork(new Work() {
			  public void execute(Connection connection) throws SQLException {
			    CallableStatement call = connection.prepareCall("{ ? = call pkg_encripcion.desencripta(?) }");
			    call.registerOutParameter( 1, Types.LONGNVARCHAR ); // or whatever it is
			    call.setString(2, pwd);
			    call.execute();
			    String result = call.getString(1); // propagate this back to enclosing class
			    perfilUsuarioDTO.getUsuarios().setNbContraseniaBackup(result);
			  }
		});
		return perfilUsuarioDTO;
	}
	
 
}
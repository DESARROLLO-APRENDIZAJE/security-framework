package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.AplicacionVersionDTO;

public interface AplicacionVersionDAO extends BaseDao<AplicacionVersionDTO> {

	/**
	 * @Descripci�n: M�todo para consultar en BD la versi�n actual 
	 * del sistema usando como restricci�n su estatus 
	 * @author Jorge Luis
	 * @param cdApp
	 * @return AplicacionVersionDTO
	 */
	public AplicacionVersionDTO getCurrentVersion(String cdApp);
	
	/**
	 * @Descripci�n: M�todo para consultar en BD el historial de 
	 * versiones del sistema ignorando el estatus del registro
	 * @author Jorge Luis
	 * @param cdApp
	 * @return List<AplicacionVersionDTO>
	 */
	public List<AplicacionVersionDTO> getVersion(String cdApp);
	
	/**
	 * @Descripci�n: M�todo para consultar en BD una versi�n por su
	 * identificador
	 * @author Jorge Luis
	 * @param idVersion
	 * @return AplicacionVersionDTO
	 */
	public AplicacionVersionDTO getVersion(Long idVersion);

}

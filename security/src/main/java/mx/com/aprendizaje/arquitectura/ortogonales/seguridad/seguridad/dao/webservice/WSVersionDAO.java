package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WSVersionDTO;

public interface WSVersionDAO extends BaseDao<WSVersionDTO> {
	
	/**
	 * @author Kevin Ojeda
	 * @param wSCode
	 * @return WSVersionDTO
	 */
	public WSVersionDTO currentVersion(String wSCode);
	
	/**
	 * @author Kevin Ojeda
	 * @param wSCode
	 * @return List<WSVersionDTO>
	 */
	public List<WSVersionDTO> recordVersions(String wSCode);
}

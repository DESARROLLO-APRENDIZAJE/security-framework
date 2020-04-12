package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WebServiceDTO;

public interface WebServiceDAO extends BaseDao<WebServiceDTO> {
	
	/**
	 * @author Kevin Ojeda
	 * @param contextPath
	 * @return WebServiceDTO
	 */
	public WebServiceDTO byContextPath(String contextPath);
	
	/**
	 * @author Kevin Ojeda
	 * @param cdWebService
	 * @return WebServiceDTO
	 */
	public WebServiceDTO byCode(String cdWebService);

}

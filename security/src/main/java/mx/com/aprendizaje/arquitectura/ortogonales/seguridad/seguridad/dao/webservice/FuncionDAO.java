package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.FuncionDTO;

public interface FuncionDAO extends BaseDao<FuncionDTO> {
	/**
	 * @author Kevin Ojeda
	 * @param code
	 * @return FunctionDTO
	 */
	public FuncionDTO activoByCode(String code);

	/**
	 * @author Kevin Ojeda
	 * @param contextPath
	 * @param endPoint
	 * @return FunctionDTO
	 */
	public FuncionDTO byContextPathAndEndPoint(String contextPath, String endPoint);

	/**
	 * Descripci�n: Obtener el servicio por el c�digo y unirlo con las funciones
	 * 
	 * @author Jorge Luis
	 * @param cdServiceWeb
	 * @return List<FunctionDTO>
	 */
	public List<FuncionDTO> byCodeService(String cdServiceWeb);
}

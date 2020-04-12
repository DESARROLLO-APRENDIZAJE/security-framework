package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.service.webservice;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.NewTokenDataVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.TokenUsuarioFuncionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.WSInfoVO;



public interface WSService {

	/**
	 * @author Kevin Ojeda
	 * @param data
	 * @return JoinTokenVO
	 * @throws Exception
	 */
	public TokenUsuarioFuncionVO newTokenData(NewTokenDataVO data) throws Exception;

	/**
	 * @author Kevin Ojeda
	 * @param contextPath
	 * @return String
	 */
	public String serviceCode(String contextPath);

	/**
	 * @author Kevin Ojeda
	 * @param contextPath
	 * @param endPoint
	 * @return String
	 */
	public String functionIdentifierCode(String contextPath, String endPoint);

	/**
	 * Descripci�n: Obtener el servicio por el c�digo y unirlo con las funciones
	 * @author Jorge Luis
	 * Modificado por Kevin Ojeda
	 * @param cdServiceWeb
	 * @return List<FuncionVO>
	 */
	public WSInfoVO webServiceInfo(String cdServiceWeb);

}

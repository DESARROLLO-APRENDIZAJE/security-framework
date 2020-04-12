package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;

public interface TokenUsuarioFuncionDAO extends BaseDao<TokenUsuarioFuncionDTO> {
	
	/**
	 * @author Kevin Ojeda
	 * @param funcionPassword
	 * @param userName
	 * @param uri
	 * @return TokenUsuarioFuncionDTO
	 */
	public TokenUsuarioFuncionDTO byInnerPasswordUserNameAndUri(String funcionPassword, String userName, String uri);

	/**
	 * @author Kevin Ojeda
	 * @param userName
	 * @param codigoFuncion
	 * @return TokenUsuarioFuncionDTO
	 */
	public TokenUsuarioFuncionDTO byUserNameAndFunctionCode(String userName, String codigoFuncion);
}

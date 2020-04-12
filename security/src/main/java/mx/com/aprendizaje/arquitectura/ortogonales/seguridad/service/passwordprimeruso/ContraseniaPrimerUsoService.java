package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.passwordprimeruso;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;

public interface ContraseniaPrimerUsoService {

	/**
	 * Descripci�n: M�todo para comprobar el la contrase�a de primer uso
	 * @author Jorge Luis
	 * @param cdApp
	 * @param user
	 * @return Boolean
	 */
	public Boolean checkPwdFirstChange(String cdApp, UsuarioFirmadoVO user)throws BusinessException;
	
	
}

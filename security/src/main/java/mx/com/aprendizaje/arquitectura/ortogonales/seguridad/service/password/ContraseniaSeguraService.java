package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.password;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ResponseVO;

public interface ContraseniaSeguraService {

	/**
     * @Descripci�n: Cambio de contrase�a para determinados usuarios .
     * @author Jorge Luis
     * @param username
     * @param password
     * @param repetir
     * @param oldPassword
     * */
	public ResponseVO updatePassword(String password, String repetir, String oldPassword);
	
}

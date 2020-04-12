package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.passwordprimeruso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro.ParametroDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.CodigoParametros;

@Service
public class ContraseniaPrimerUsoServiceImpl implements ContraseniaPrimerUsoService{

	@Autowired
	private ParametroDAO parametroDAO;

	@Transactional
	@Override
	public Boolean checkPwdFirstChange(String cdApp, UsuarioFirmadoVO usr) throws BusinessException{
		ParametroDTO pDTO = parametroDAO.getParameterByAplicationAndCod(cdApp, CodigoParametros.CPU.getCodigo());
		// Si el par�metro el null entonces retornamos el valor false 
		// lo cual significa que no se valida la contrase�a del primero uso
		if(pDTO == null)
			return false;
		// Si el par�metro existe u el valor es diferente de null y y valor convertido a
		// entero e igual a 1, entonces se valida el primer uso
		if(pDTO.getNbValor() != null && Integer.parseInt(pDTO.getNbValor()) == 1) {
			if(usr == null)
				throw new BusinessException("El token ha expirado, favor de validar.");
			if(usr.getStContrasenia() != null && usr.getStContrasenia()) {
				return false;
			}else {
				return true;
			}
		}else {
		// Si el valor existe pero es 0 entonces se retorna false 
			return false;
		}
	}
	
	
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.password;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro.ParametroDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.UsuariosDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ResponseVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.UsuariosDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.comun.UsuarioFirmadoService;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.CodigoParametros;

@Service
public class ContraseniaSeguraServiceImpl implements ContraseniaSeguraService{

	@Autowired
	private UsuarioFirmadoService userSession;
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	/*@Autowired
	private ContraseniaHistDAO contraseniaHistDAO;*/
	
	@Value("${app.config.codigo}")
	private String cdApp;
	
	@Transactional
	@Override
	public ResponseVO updatePassword(String password, String repetir, String oldPassword){
		if(userSession.getUsuarioFirmadoVO() == null)
			return new ResponseVO(401, "Su sesi�n se ha agotado, favor de validar.");
		
		UsuarioFirmadoVO user = userSession.getUsuarioFirmadoVO();
		ParametroDTO pDTO = parametroDAO.getParameterByAplicationAndCod(cdApp, CodigoParametros.PCNTRASAS.getCodigo());
		String resultMethod = null;
		
		try {
			resultMethod = pwdIsEqualToCurrent(password, user.getPassword());
			resultMethod = pwdCurrentIsIncorrect(user.getPassword(), oldPassword);
			resultMethod = pwdNotEquals(password, repetir);
			if(pDTO != null) {				
				resultMethod = pwdIsWrong(password, pDTO.getNbValor());
			}
		}catch (BusinessException ex) {
			return new ResponseVO(409, ex.getMessage());
		}
		
		// DESPUES DE HABER VALIDADO EL ESTATUS DE LAS CLAVES
		// DEBEMOS VALIDAR EL HISTORIAL DE CLAVES
		/*try{
			canRepeatPwd(user, password);
		}catch(BusinessException ex) {
			return new ResponseVO(409, ex.getMessage());
		}*/
		
		
		// Despu�s de pasar todos los filtros actualizsr el usuario actual
		UsuariosDTO uDTO = usuariosDAO.findOne(user.getId());
		
		//final String pwdBackup = uDTO.getNbContrasenia(); 
		
		final String newPwd = usuariosDAO.encriptarCampo(password);
		uDTO.setNbContrasenia(newPwd);
		uDTO.setStContrasenia(true);
		uDTO.setFhModificacion(new Date());
		uDTO.setFhModifContrasenia(new Date());
		usuariosDAO.update(uDTO);
		
		// DEBEMOS GUARDAR EL HISTORIAL DE ESTA CLAVE
		/*ContraseniaHistDTO chDTO = new ContraseniaHistDTO();
		chDTO.setUsuario(uDTO);
		chDTO.setNbContrasenia(pwdBackup);
		chDTO.setFhCambio(new Date());
		chDTO.setStActivo(1);
		chDTO.setIdUsrCreacion(user.getId());
		chDTO.setFhCreacion(new Date());
		chDTO.setIdUsrModifica(user.getId());
		chDTO.setFhModificacion(new Date());
		contraseniaHistDAO.save(chDTO);*/
		
		
		if(resultMethod == null)
			return new ResponseVO(200, "La contrase�a se cambi� correctamente.");
		return new ResponseVO(409, "Error general de actualizaci�n de contrase�a.");
	}
	
	
	/*private String canRepeatPwd (UsuarioFirmadoVO user, String password) throws BusinessException{
		ParametroDTO pDTONRP = parametroDAO.getParameterByAplicationAndCod(cdApp, CodigoParametros.NRP.getCodigo());
		ParametroDTO pDTOADV = parametroDAO.getParameterByAplicationAndCod(cdApp, CodigoParametros.NVRC.getCodigo());
		// VALIDAMOS SI EL PAR�METRO ES NULL ENTONCES RETORNAMOS NULL PORQUE NO HAY VALOR QUE VALIDAR
		if(pDTONRP == null)
			return null;
		// SI EL VALOR DEL PAR�METRO ACTUAL ES 1, SIGNIFICA QUE EL PASSWORD SE PUEDE REPETIR
		// EN CASO CONTRARIO SE DEBER� VALIDAR EN EL TABLA TAQ060 PARA VERIFICAR QUE NO HAYA
		// UNA CLAVE IDENTICA A LA NUEVA QUE SE GUARDAR�
		
		// LISTA DE HISTORIAL DE CLAVES DEL USUARIO
		List<ContraseniaHistDTO> chListDTO = contraseniaHistDAO.getPwdHist(user.getId());
		if(pDTONRP.getNbValor().equals("1")) {
			// VALIMOS EL PAR�METTRO DE N�MERO DE VECES QUE SE PUEDE REPETIR UN PAR�METRO
			String searchSamePwd =  searchSamePwd(password, chListDTO, pDTOADV);
			if(searchSamePwd == null)
				return null;
			return null;
		}else {
			if(chListDTO.isEmpty()) {
				// SI LA LISTA ES VAC�A SIGNIFICA QUE NO EXISTEN REGISTROS DE HISTORIAL DE CLAVES
				return null;
			}else{
				// VALIDAR SI YA SE HA UTILIZADO ESTA MISMA CLLAVE EN DIFERENTES OCACIONES
				// VALIDAR SI ES REUTILIZABLE Y CUANTAS VECES SE PUEDE USAR
				for(ContraseniaHistDTO chDTO: chListDTO){
					final String pwd = parametroDAO.desencriptarCampo(chDTO.getNbContrasenia());
					if(pwd.equals(password))
						throw new BusinessException("La clave nueva ya fue utilizada anteriormente.");
				}
			}
		}
		
		return null;
	}
	
	@Transactional
	private String searchSamePwd (String currentPwd, List<ContraseniaHistDTO> chListDTO, ParametroDTO pDTOADV) throws BusinessException{
		if(chListDTO.isEmpty())
			return null;
		
		// VALIDAMOS EL VALOR DEL PAR�METRO DEL NUMERO DE VECES QUE SE PUEDE REPETIR EL PARAMETRO
		if(pDTOADV == null)
			return null;
		
		Integer nu = Integer.parseInt(pDTOADV.getNbValor());
		Integer nuRepeated = 0;
		
		for(ContraseniaHistDTO chDTO: chListDTO) {
			String pwd = parametroDAO.desencriptarCampo(chDTO.getNbContrasenia());
			if(pwd != null && pwd.equals(currentPwd)) {
				nuRepeated ++;
			}
		}
		// VALIDAMOS EL N�MERO DE VECES QUE SE REPETIDO LA CLAVE
		if(nuRepeated >= nu)
				throw new BusinessException("La clave que est� tratando de actulizar ya fue utilizada "+ nuRepeated +" veces anteriormente.");
		return null;
	}*/
	
	private String pwdNotEquals(String newPwd,  String newPwdRepit) throws BusinessException{
		if(!newPwd.equals(newPwdRepit))
			throw new BusinessException("La contrase�a de confirmaci�n no coincide.");
		return null;
	}

	private String pwdIsEqualToCurrent(String newPwd, String current) throws BusinessException{
		if(newPwd.equals(current))
			throw new BusinessException("La contrase�a introducida no puede ser igual a la actual.");
		return null;
	}
	
	private String pwdCurrentIsIncorrect(String current, String currentFromWeb) throws BusinessException{
		if(!currentFromWeb.equals(current))
			throw new BusinessException("La contrase�a actual que introdujo es incorrecta.");
		return null;
	}
	
	private String pwdIsWrong(String newPwd, String stringToRegex) throws BusinessException{
		if(stringToRegex == null)
			throw new BusinessException("No existe ninguna expresi�n a evaluar, favor de validar.");
		Pattern regex = Pattern.compile(stringToRegex);
		Matcher pivote = regex.matcher(newPwd);
		if ((!pivote.find()) || (pivote.group(0) == null))
			throw new BusinessException("La contrase�a introducida no cumple con los requisitos de seguridad m�nimos.");
		return null;
	}
	
	
}

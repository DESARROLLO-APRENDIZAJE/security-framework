package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;

public interface ParametroDAO extends BaseDao<ParametroDTO> {


	/**
	 * Descripci�n: M�todo para consultar el par�metro 
	 * por codigo de aplicaci�n
	 * @author Jorge Luis
	 * @param cdAplicacion
	 * @return List<ParametroDTO>
	 */
	public List<ParametroDTO> getParamsByAplication(String cdAplicacion);
	
	/**
	 * Descripci�n: M�todo para consultar el par�metro 
	 * por codigo de aplicaci�n y adicial por sus 
	 * banderas de internos o externos
	 * @author Jorge Luis
	 * @param cdAplicacion
	 * @param interno
	 * @return List<ParametroDTO>
	 */
	public List<ParametroDTO> getParamsInterByAplication(String cdAplicacion, Integer interno);
	
	/**
	 * Descripci�n: M�todo para consultar el par�metro 
	 * por codigo de aplicaci�n y adicial por el c�digo 
	 * del par�metro
	 * @author Jorge Luis
	 * @param cdAplicacion
	 * @param cdParameter
	 * @return List<ParametroDTO>
	 */
	public ParametroDTO getParameterByAplicationAndCod(String cdAplicacion,String cdParameter);
	
	/**
	 * Descripci�n: M�todo para consultar el par�metro 
	 * mediante su identificador unico 
	 * del par�metro
	 * @author Jorge Luis
	 * @param idParametro
	 * @return ParametroDTO
	 */
	public ParametroDTO restrictionById(Long idParametro);
	
	/**
	 * Descripci�n: M�todo para consultar el par�metro mediante su estatus 
	 * del par�metro
	 * @author Jorge Luis
	 * @param cdAplicacion
	 * @return ParametroDTO
	 */
	public List<ParametroDTO> getRestrictions(String cdAplicacion);
}

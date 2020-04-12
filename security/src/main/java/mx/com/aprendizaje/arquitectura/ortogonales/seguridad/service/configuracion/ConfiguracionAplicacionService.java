package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.exception.NotFoundException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.AmbienteVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.AplicacionVersionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ConfiguracionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.MenuOrientacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ParametroVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ResolucionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TemaVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TipoNavegacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TipoParametroVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: ConfiguracionAplicacionService
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Sep/2017
 */ 

public interface ConfiguracionAplicacionService {
	
	/**
     * Obtiene una lista de configuraciones de la aplicacion
     * 
     * @param codAplicacion  Entidad a persistir
     * @return ConfiguracionVO Entidad encontrada
   	 */
	
	ConfiguracionVO buscarConfiguracionXAplicacion(String codAplicacion);
	
	/**
	 *{@inheritDoc}
     * Guarda un objeto de tipo ConfiguracionVO para la configuraci�n de las aplicaciones web
     * 
     * @param ConfiguracionVO  Entidad a persisitir     
     * @param UsuarioFirmadoVO  Usuario firmado para obtener informaci�n de bit�cora de tabla
     * @return ConfiguracionVO Entidad persistida 
   	 */
	ConfiguracionVO saveConfiguracion(ConfiguracionVO configuracionVO, String codAplicacion, UsuarioFirmadoVO  usuarioFirmadoVO);
	
	
	/**
	 * Descripci�n: M�todo para actualizar todos los datos de la configuraci�n
	 * de la aplicaci�n
	 * @author Jorge Luis
	 * @return ConfiguracionVO
	 */
	public ConfiguracionVO saveConfiguracion(ConfiguracionVO configuracionVO) throws BusinessException;
	
	

	/**
	 * 
     * Obtiene una lista de temas por c�digo de  aplicaci�n
     * 
     * @param codAplicacion  C�digo de la aplicaci�n a buscar
     * @return List<TemaVO>   Entidades encontradas 
     
   	 */
	
	List<TemaVO> obtenerTemasXAplicacion(String codAplicacion);

	/**
     * Guarda un objeto de tipo TemaVO por   aplicaci�n
     * 
     * @param TemaVO  Entidad a persisitir
     * @param String  C�digo de la aplicaci�n
     * @param UsuarioFirmadoVO  Usuario firmado para obtener informaci�n de bit�cora de tabla
     * @return TemaVO Entidad persistida 
     * {@inheritDoc}
   	 */
	TemaVO saveTema(TemaVO temaVO,String codAplicacion ,UsuarioFirmadoVO usuarioFirmadoVO );

	
	/**
     * Obtiene una lista de  entidades de tipo  ResolucionVO 
     * 
      * @return List<ResolucionVO> Lista de Resoluciones encontradas
     * {@inheritDoc}
   	 */
	List<ResolucionVO> obtenerListaResoluciones();

	/**
     * Obtiene un Objeto del código del ambiente
     * @author 						: cgomez
     * @param codAplicacion  Entidad a persistir
     * @return AmbienteVO Entidad encontrada
   	 */
	
	AmbienteVO getCdAmbienteXAplication(String codAplicacion);

	/**
	 * Descripci�n: M�todo para consultar todos los registro de
	 * orientaci�n de menu en BD
	 * @author Jorge Luis
	 * @return List<MenuOrientacionVO>
	 */
	public List<MenuOrientacionVO> getMenuOrientation() throws NotFoundException;
	
	/**
	 * Descripci�n: M�todo para consultar todos los registro de
	 * tipo de navegaci�n en BD
	 * @author Jorge Luis
	 * @return List<TipoNavegacionVO>
	 */
	public List<TipoNavegacionVO> getNavigationType() throws NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para consultar todos las versiones 
	 * historicas de la aplicaci�n
	 * @author Jorge Luis
	 * @return List<AplicacionVersionVO>
	 */
	public List<AplicacionVersionVO> version() throws NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para guardar nueva versi�n de sistema
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean version(AplicacionVersionVO vo)throws NotFoundException, BusinessException;
	
	/**
	 * @Descripci�n: M�todo para actualizar versi�n de sistema
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean versionUpdate(AplicacionVersionVO vo)throws NotFoundException, BusinessException;
	
	/**
	 * @Descripci�n: M�todo para eliminar una versi�n del sistema
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean versionDelete(Long idVersion)throws NotFoundException, BusinessException;
	
	/**
	 * @Descripci�n: M�todo para actualizar el estatus 
	 * del registro de la versi�n
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean versionStatus(AplicacionVersionVO vo)throws NotFoundException, BusinessException;
	
	/**
	 * @Descripci�n: M�todo para consultar todos los par�metros registros 
	 * del sistema mediante el codigo de aplicaci�n
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public List<ParametroVO> restriction() throws NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para consultar todas las
	 * clasificaciones de los par�metros
	 * @author Jorge Luis
	 * @return List<TipoParametroVO>
	 */
	public List<TipoParametroVO> typeRestriction() throws NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para guardar un nuevo par�metro en BD
	 * @author Jorge Luis
	 * @param ParametroVO
	 * @return Boolean
	 */
	public Boolean restriction(ParametroVO vo)throws BusinessException;
	
	/**
	 * @Descripci�n: M�todo para actualizar los datos del par�metro
	 * @author Jorge Luis
	 * @param ParametroVO
	 * @return Boolean
	 */
	public Boolean restrictionUpdate(ParametroVO vo)throws BusinessException, NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para actualizar los datos del par�metro
	 * @author Jorge Luis
	 * @param idParametro
	 * @return Boolean
	 */
	public Boolean restrictionDelete(Long idParametro)throws BusinessException, NotFoundException;
	
	/**
	 * @Descripci�n: M�todo para actualizar el estatus 
	 * del registro
	 * @author Jorge Luis
	 * @return Boolean
	 */
	public Boolean restrictionStatus(ParametroVO vo)throws NotFoundException, BusinessException;
}

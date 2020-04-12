package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: ConfiguracionDAO
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
public interface ConfiguracionDAO extends BaseDao<ConfiguracionDTO>{
	
	/**
     * Obtiene una lista de configuraciones de la aplicaci�n
     * 
     * @param codAplicacion  c�digo de la aplicaci�n a buscar
     * @return ConfiguracionDTO Entidad encontrada 
     * {@inheritDoc}
   	 */
	
	ConfiguracionDTO buscarConfiguracionXAplicacion(String codAplicacion);
	
	/**
     * Guarda un objeto de tipo configuracionDTO para la configuraci�n de las aplicaciones web
     * 
     * @param ConfiguracionDTO  Entidad a persisitir
     * @return ConfiguracionDTO Entidad persistida 
     * {@inheritDoc}
   	 */
	ConfiguracionDTO saveConfiguracion(ConfiguracionDTO configuracionDTO);

	/**
	 * Descripci�n: M�todo para consultar la configuraci�nb 
	 * actual de la aplicaci�n
	 * @author Jorge Luis
	 * @return ConfiguracionDTO
	 */
	public ConfiguracionDTO getConfigurationById(Long idConfiguracion);
}

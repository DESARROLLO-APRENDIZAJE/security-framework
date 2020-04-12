package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: AplicacionDAO
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
public interface AplicacionDAO extends BaseDao<AplicacionesDTO>{
	
	/**
     * Obtiene una entidad de tipo  AplicacionDTO por c�digo de aplicaci�n
     * 
     * @param codAplicacion  c�digo de la aplicaci�n
     * @return AplicacionDTO Entidad encontrada 
     * {@inheritDoc}
   	 */
	AplicacionesDTO getAplicacionByCode(String codAplicacion);

}

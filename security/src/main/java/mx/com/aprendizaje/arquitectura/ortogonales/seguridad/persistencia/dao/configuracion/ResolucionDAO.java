package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ResolucionDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: ResolucionDAO 
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
public interface ResolucionDAO extends BaseDao<ResolucionDTO>{
	 

	/**
     * Obtiene una lista de  entidades de tipo  ResolucionDTO 
     * 
      * @return List<ResolucionDTO> Lista de Resoluciones encontradas
     * {@inheritDoc}
   	 */
	List<ResolucionDTO> obtenerListaResoluciones();
	

	

}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TemasDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: TemaDAO
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
public interface TemaDAO extends BaseDao<TemasDTO>{
	/**
     * Obtiene una lista de temas por aplicaci�n
     * 
     * @param codAplicacion  c�digo de la aplicaci�n a buscar
     * @return List<TemaDTO>  Entidades encontradas 
     * {@inheritDoc}
   	 */
	
	List<TemasDTO> obtenerTemasXAplicacion(String codAplicacion);
	
	/**
     * Guarda un objeto de tipo TemaDTO por   aplicaci�n
     * 
     * @param TemaDTO  Entidad a persisitir
     * @return TemaDTO Entidad persistida 
     * {@inheritDoc}
   	 */
	TemasDTO saveTema(TemasDTO temaDTO );

	 

	

}

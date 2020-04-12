package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.menus;

import java.util.List;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosService
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017
 */ 

public interface MenusService {
 
	public List<MenusDTO> buscarMenuUsuario(Long perfilId,  String codeApplication);
	
	/**
	 * @Descripci�n: M�todo para consultar los men�s por usuario
	 * @author jorgeluis
	 * @param perfilId
	 * @param idUsuario
	 * @param appCode
	 * @return List<ViewPaginaServicioDTO>
	 * */
	public List<MenusDTO> buscarMenuUsuario(Long perfilId, Long idUsuario, String codeApplication);
 
	/**
	 * @Descripci�n: M�todo para consultar todos los men�s del usuario
	 * @author jorgeluis
	 * @param perfilId
	 * @param appCode
	 * @return List<ViewPaginaServicioDTO>
	 * */	
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId,Long idUsr, String appCode);
}

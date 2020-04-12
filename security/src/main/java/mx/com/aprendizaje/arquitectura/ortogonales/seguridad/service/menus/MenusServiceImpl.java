package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.menus;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro.ParametroDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.ViewPaginaServicioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.MenusDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.ViewPaginaServicioDAO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosServiceImpl
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017 
 */
 
@Service
public class MenusServiceImpl implements MenusService {

	@Autowired
	private MenusDAO  menusDAO;
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private ViewPaginaServicioDAO viewPaginaServicioDAO;
	
	@Value("${app.config.codigo}")
    private String cdApp;
	
	@Override
	@Transactional
	public List<MenusDTO> buscarMenuUsuario(Long perfilId, String codeApplication) {
			return menusDAO.buscarMenuUsuario(perfilId,  codeApplication);
	}

	@Override
	@Transactional
	public List<ViewPaginaServicioDTO> byAppCodeAndPerfil(Long perfilId, Long idUsr , String appCode) {
		// Debemos consultar el par�metro de MPU (Menus Por Usuario)
		ParametroDTO pDTO = parametroDAO.getParameterByAplicationAndCod(cdApp, "MPU");
		if(pDTO != null && pDTO.getNbValor().equals("1")) {
			return viewPaginaServicioDAO.byAppCodeAndPerfil(perfilId, idUsr,  appCode);	
		}else {
			return viewPaginaServicioDAO.byAppCodeAndPerfil(perfilId, appCode);
		}
	}


	@Transactional
	@Override
	public List<MenusDTO> buscarMenuUsuario(Long perfilId, Long idUsuario, String codeApplication) {
		ParametroDTO pDTO = parametroDAO.getParameterByAplicationAndCod(cdApp, "MPU");
		if(pDTO != null && pDTO.getNbValor().equals("1")) {
			return menusDAO.buscarMenuUsuario(perfilId, idUsuario, codeApplication);
		}else {
			return menusDAO.buscarMenuUsuario(perfilId, codeApplication);
		}
	}
	
	 	
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TemasDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: TemaDAOImpl
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
@Repository 
public 	class  TemaDAOImpl extends BaseDaoHibernate<TemasDTO> implements TemaDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public List<TemasDTO> obtenerTemasXAplicacion(String codAplicacion) {
		
		Criteria criteria = getCurrentSession().createCriteria(TemasDTO.class);
		criteria.createAlias("aplicaciones", "aplicacion");
 		criteria.add(Restrictions.eq("aplicacion.cdAplicacion", codAplicacion));
		criteria.add(Restrictions.eq("stActivo", 1));
 		
		return criteria.list();
	}

	@Override
	public TemasDTO saveTema(TemasDTO temaDTO) {
 		return saveOrUpdate(temaDTO);
	}

 
	 
	
 
}

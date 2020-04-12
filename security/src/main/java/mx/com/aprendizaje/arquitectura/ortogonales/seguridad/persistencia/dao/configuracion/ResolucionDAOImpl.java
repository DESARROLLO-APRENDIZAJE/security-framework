package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ResolucionDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: ResolucionDAOImpl
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
@Repository 
public 	class  ResolucionDAOImpl extends BaseDaoHibernate<ResolucionDTO> implements ResolucionDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public List<ResolucionDTO> obtenerListaResoluciones() {
 		
		Criteria criteria = getCurrentSession().createCriteria(ResolucionDTO.class);
 		criteria.add(Restrictions.eq("stActivo", 1L));
		return  criteria.list();
	}
 
}

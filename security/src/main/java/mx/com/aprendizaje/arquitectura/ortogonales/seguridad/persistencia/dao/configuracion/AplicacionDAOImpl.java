package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: AplicacionDAOImpl
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 
 
@Repository 
public 	class  AplicacionDAOImpl extends BaseDaoHibernate<AplicacionesDTO> implements AplicacionDAO 
{

	@Override
	public AplicacionesDTO getAplicacionByCode(String codAplicacion) {

		Criteria criteria = getCurrentSession().createCriteria(AplicacionesDTO.class);
  		criteria.add(Restrictions.eq("cdAplicacion", codAplicacion));
  		
		return (AplicacionesDTO) criteria.uniqueResult();
	}
 
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
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
 
@Repository 
public 	class  ConfiguracionDAOImpl extends BaseDaoHibernate<ConfiguracionDTO> implements ConfiguracionDAO
{
	
	@Override
	public ConfiguracionDTO buscarConfiguracionXAplicacion(String codAplicacion) {
				
		Criteria criteria = getCurrentSession().createCriteria(ConfiguracionDTO.class);
		criteria.createAlias("aplicaciones", "aplicacion");
		criteria.createAlias("resoluciones", "resolucion");
		criteria.add(Restrictions.eq("aplicacion.cdAplicacion", codAplicacion));
		criteria.add(Restrictions.eq("stActivo", 1));
		criteria.add(Restrictions.eq("resolucion.stActivo", 1L));

		return (ConfiguracionDTO) criteria.uniqueResult();
	
	}

	@Override
	public ConfiguracionDTO saveConfiguracion(ConfiguracionDTO configuracionDTO) {
		return saveOrUpdate(configuracionDTO);
	}

	@Override
	public ConfiguracionDTO getConfigurationById(Long idConfiguracion) {
		Criteria c = getCurrentSession().createCriteria(ConfiguracionDTO.class);
		c.add(Restrictions.eq("stActivo", 1));
		c.add(Restrictions.eq("idConfiguracion", idConfiguracion));
		return (ConfiguracionDTO) c.uniqueResult();
	}
}

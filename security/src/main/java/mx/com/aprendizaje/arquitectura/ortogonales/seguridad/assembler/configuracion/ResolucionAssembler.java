package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ResolucionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ResolucionVO;

public class ResolucionAssembler {
	
	public static ResolucionVO toResolucionVO(ResolucionDTO source){
		if(source == null) return null;
		ResolucionVO vo = new ResolucionVO();
		vo.setIdResolucion(source.getIdResolucion());
		vo.setCdResolucion(source.getCdResolucion());
		vo.setNbResolucion(source.getNbResolucion());
		vo.setNuPixelesBase(source.getNuPixelesBase().toString());
		vo.setTxResolucion(source.getTxResolucion());
		vo.setStActivo((int)(long)source.getStActivo());
		return vo;
	}
	
	public static ResolucionDTO fromResolucionDTOtoResolucionVO(ResolucionVO source){
		if(source == null) return null;
		ResolucionDTO dto = new ResolucionDTO();
		dto.setIdResolucion(source.getIdResolucion());
		dto.setCdResolucion(source.getCdResolucion());
		dto.setNbResolucion(source.getNbResolucion());
		dto.setNuPixelesBase(Long.parseLong(source.getNuPixelesBase()));
		dto.setTxResolucion(source.getTxResolucion());
		dto.setStActivo((long)source.getStActivo());
		return dto;
	}
}

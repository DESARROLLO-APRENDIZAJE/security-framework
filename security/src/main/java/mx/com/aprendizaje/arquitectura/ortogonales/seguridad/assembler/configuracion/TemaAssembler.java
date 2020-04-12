package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TemasDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TemaVO;

public class TemaAssembler {
	
	public static TemaVO toTemaVO(TemasDTO source){
		if(source == null) return null;
		TemaVO vo = new TemaVO();
		vo.setIdTema(source.getIdTema());
		vo.setNbTema(source.getNbTema());
		vo.setCdTema(source.getCdTema());
		vo.setStActivo(source.getStActivo());
		return vo;
	}
	
	public static TemasDTO fromTemaVOtoTemasDTO( TemaVO source){
		if(source == null) return null;
		TemasDTO dto = new TemasDTO();
		dto.setIdTema(source.getIdTema());
		dto.setNbTema(source.getNbTema());
		dto.setCdTema(source.getCdTema());
		dto.setStActivo(source.getStActivo());
		return dto;
	}
}

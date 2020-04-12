package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.AplicacionVO;

public class AplicacionAssembler {

	public static AplicacionVO toAplicacionVO(AplicacionesDTO source){
		if(source == null) return null;
		AplicacionVO vo = new AplicacionVO();
		vo.setIdAplicacion((int)(long)source.getIdAplicacion());
		vo.setCodigo(source.getCdAplicacion());
		vo.setNombre(source.getNbAplicacion());
		vo.setDescripcion(source.getTxAplicacion());
		vo.setAmbiente(source.getAmbiente());
		return vo;
	}
	
	public static AplicacionesDTO fromAplicacionVOtoAplicacionesDTO(AplicacionVO  source){
		if(source == null) return null;
		AplicacionesDTO dto = new AplicacionesDTO();
		dto.setIdAplicacion((long)source.getIdAplicacion());
		dto.setCdAplicacion(source.getCodigo());
		dto.setNbAplicacion(source.getNombre());
		dto.setTxAplicacion(source.getDescripcion());
		dto.setAmbiente(source.getAmbiente());
		return dto;
	}
}

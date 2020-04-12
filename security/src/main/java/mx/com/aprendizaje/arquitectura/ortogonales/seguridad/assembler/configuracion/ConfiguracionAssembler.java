package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.configuracion;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ConfiguracionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.MenuOrientacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TipoNavegacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.ResponseConverter;

public class ConfiguracionAssembler {

	public static ConfiguracionVO toConfiguracionVO(ConfiguracionDTO source){
		if(source == null) return null;
		ConfiguracionVO vo = new ConfiguracionVO();
		vo.setIdConfiguracion(source.getIdConfiguracion());
		vo.setResolucion(ResolucionAssembler.toResolucionVO(source.getResoluciones()));
		vo.setTema(TemaAssembler.toTemaVO(source.getTemas()));
		vo.setAplicacion(AplicacionAssembler.toAplicacionVO(source.getAplicaciones()));
		vo.setLogoMenuPrincipal(source.getLbMenuPricipal());
		vo.setLogoMenuSecundario(source.getLbMenuSecundario());
		vo.setLogoHeader(source.getLbHeader());
		vo.setLogoIndex(source.getLbIndex());
		vo.setStActivo(source.getStActivo());
		vo.setStMenuFijo((int)(long)source.getStMenuFijo());
		vo.setStHeaderFijo((int)(long)source.getStHeaderFijo());
		vo.setStMenuDesplegable((int)(long)source.getStMenuDesplegado());
		vo.setTxFooterLogin(source.getTxFooterLogin());
		vo.setTxFooterMain(source.getTxFooterMain());
		if(source.getStFooterFijo() == null) {
			vo.setStFooterFijo(0);
		}else {			
			vo.setStFooterFijo((int)(long)source.getStFooterFijo());
		}
		if(source.getMenuOrientacion() != null) {
			MenuOrientacionVO menuOrientacionVO = new MenuOrientacionVO();
			ResponseConverter.copiarPropriedades(menuOrientacionVO, source.getMenuOrientacion());
			vo.setMenuOrientacion(menuOrientacionVO);
		}
		
		if(source.getTipoNavegacion() != null) {
			TipoNavegacionVO tipoNavegacionVO = new TipoNavegacionVO();
			ResponseConverter.copiarPropriedades(tipoNavegacionVO, source.getTipoNavegacion());
			vo.setTipoNavegacion(tipoNavegacionVO);
		}
		
		return vo;
	}
	
	public static ConfiguracionDTO fromConfiguracionVOtoConfiguracionDTO(ConfiguracionVO source){
		if(source == null) return null;
		ConfiguracionDTO dto = new ConfiguracionDTO();
		dto.setIdConfiguracion(source.getIdConfiguracion());
		dto.setResoluciones( ResolucionAssembler.fromResolucionDTOtoResolucionVO(source.getResolucion()));
		dto.setTemas(TemaAssembler.fromTemaVOtoTemasDTO(source.getTema()));
		dto.setAplicaciones(AplicacionAssembler.fromAplicacionVOtoAplicacionesDTO(source.getAplicacion()));
		dto.setLbMenuPricipal(source.getLogoMenuPrincipal());
		dto.setLbMenuSecundario(source.getLogoMenuSecundario());
		dto.setLbHeader(source.getLogoHeader());
		dto.setLbIndex(source.getLogoIndex());
		dto.setStActivo(source.getStActivo());
		dto.setStMenuFijo((long)source.getStMenuFijo());
		dto.setStHeaderFijo((long)source.getStHeaderFijo());
		dto.setStMenuDesplegado((long)source.getStMenuDesplegable());
		return dto;
	}
}

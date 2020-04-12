package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.menu;

import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.lang.Collections;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.MenuDinamicoVO;

public class MenuAssembler {
	
	public static MenuDinamicoVO toMenuDinamicoVO(MenusDTO source){
		if(source == null) return null;
		MenuDinamicoVO vo = new MenuDinamicoVO();
		vo.setId((int)(long)source.getIdMenu());
		vo.setMenuTexto(source.getTxMenu());
		vo.setMenuTextoEn(source.getTxMenuEn());
		vo.setMenuSuperior((int)(long)source.getNuMenuSuperior());
		vo.setMenuUri(source.getNbMenuUri());
		vo.setMenuIcono(source.getNbMenuIcono());
		return vo;
	}
	
	public static List<MenuDinamicoVO> listMenuDinamicoVO(List<MenusDTO> source){
		List<MenuDinamicoVO> lVO = new ArrayList<MenuDinamicoVO>();
		if(source == null || Collections.isEmpty(source)) return lVO;
		for(MenusDTO dto : source){
			lVO.add(toMenuDinamicoVO(dto));
		}
		return lVO;
	}
}

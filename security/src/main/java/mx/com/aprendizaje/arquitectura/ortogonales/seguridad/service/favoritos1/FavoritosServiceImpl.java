package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.favoritos1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.exception.NotFoundException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.AplicacionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.ConfiguracionFavoritosDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionFavoritosDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.MenusDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.UsuariosDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.MenusDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.UsuariosDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.comun.UsuarioFirmadoService;

@Service
public class FavoritosServiceImpl implements FavoritosService {

	@Autowired
	private UsuarioFirmadoService userInSession;

	@Autowired
	private UsuariosDAO usuariosDAO;

	@Autowired
	private AplicacionDAO aplicacionDAO;

	@Autowired
	private MenusDAO menusDAO;
	
	@Autowired
	private ConfiguracionFavoritosDAO configuracionFavoritosDAO;

	@Value("${app.config.codigo}")
	private String cdApp;

	@Transactional
	@Override
	public Boolean favoriteSetting(List<Long> idMenu) throws BusinessException, NotFoundException {
		if (userInSession.getUsuarioFirmadoVO() == null)
			throw new BusinessException("Su sesi�n se ha agotado, favor de validar.");
		List<ConfiguracionFavoritosDTO> cfListDTO = configuracionFavoritosDAO.getAllFavoritesByUsr(userInSession.getUsuarioFirmadoVO().getId(), cdApp);
		
		Set<Long> idBD = idDTO(cfListDTO);
		Set<Long> idVO = idVO(idMenu);

		Set<Long> toDelete = Sets.difference(idBD, idVO);
		Set<Long> toSave = Sets.difference(idVO, idBD);
		Set<Long> toSame = Sets.intersection(idVO, idBD);
		
		List<Long> listMerged = new ArrayList<>();
		if(!toSave.isEmpty())
			for (Long id : toSave) {
				listMerged.add(id);
			}
		if(!toSame.isEmpty())
			for (Long id : toSame) {
				listMerged.add(id);
			}
		
		
		if (!toDelete.isEmpty()) {
			for (Long id : toDelete) {
				for (ConfiguracionFavoritosDTO cfDTO : cfListDTO) {
					if (id.equals(cfDTO.getMenu().getIdMenu())) {
						cfDTO.setStActivo(0);
						cfDTO.setFhModificacion(new Date());
						cfDTO.setIdUsrModifica(userInSession.getUsuarioFirmadoVO().getId());
						configuracionFavoritosDAO.update(cfDTO);
					}
				}
			}
		}
		
		AplicacionesDTO aDTO = aplicacionDAO.getAplicacionByCode(cdApp);
		UsuariosDTO uDTO = usuariosDAO.findOne(userInSession.getUsuarioFirmadoVO().getId());
		
		 Map<Long, Long> mapOne = getIdUniques(listMerged,cfListDTO);
		 if(!mapOne.isEmpty()) {
			 for(Entry<Long, Long> ma: mapOne.entrySet()) {
				 Boolean save = saveNewElement(ma.getKey(), aDTO, uDTO);
					if(save)
						continue;
			 }
		 }
		return true;
	}
	
	@Transactional
	private Map<Long, Long> getIdUniques (List<Long> toSave, List<ConfiguracionFavoritosDTO> cfListDTO){
		Map<Long, Long> map = new HashMap<>();
		if(toSave.isEmpty())
			return map;
		for (Long id : toSave) {
			if(!cfListDTO.isEmpty()) {
				Boolean b = false;
				for (ConfiguracionFavoritosDTO cfDTO : cfListDTO) {
					if(id.equals(cfDTO.getMenu().getIdMenu()) && cfDTO.getStActivo() == 0) {
						cfDTO.setStActivo(1);
						cfDTO.setFhModificacion(new Date());
						cfDTO.setIdUsrModifica(userInSession.getUsuarioFirmadoVO().getId());
						configuracionFavoritosDAO.update(cfDTO);
						b = true;
						break;
					}else if(id.equals(cfDTO.getMenu().getIdMenu()) && cfDTO.getStActivo() == 1) {
						b = true;
						break;
					}else {
						b = false;
					}
				}
				if(!b)
					map.put(id, id);
			}else {				
				map.put(id, id);
			}
		}
		return map;
	}
	
	@Transactional
	private Boolean saveNewElement(Long idMenu, AplicacionesDTO aDTO, UsuariosDTO uDTO) {
		ConfiguracionFavoritosDTO cfDTO = new ConfiguracionFavoritosDTO();
		cfDTO.setUsuario(uDTO);
		MenusDTO mDTO = menusDAO.getMenuById(idMenu);
		cfDTO.setMenu(mDTO);
		cfDTO.setAplicacion(aDTO);
		cfDTO.setStActivo(1);
		cfDTO.setIdUsrCreacion(userInSession.getUsuarioFirmadoVO().getId());
		cfDTO.setIdUsrModifica(userInSession.getUsuarioFirmadoVO().getId());
		cfDTO.setFhCreacion(new Date());
		cfDTO.setFhModificacion(new Date());
		configuracionFavoritosDAO.save(cfDTO);
		return true;
	} 

	private Set<Long> idDTO(List<ConfiguracionFavoritosDTO> l) {
		Set<Long> idsReturn = new HashSet<>();
		if (l.isEmpty())
			return idsReturn;
		for (ConfiguracionFavoritosDTO dto : l) {
			idsReturn.add(dto.getMenu().getIdMenu());
		}
		return idsReturn;
	}

	private Set<Long> idVO(List<Long> l) {
		Set<Long> idsReturn = new HashSet<>();
		if (l.isEmpty())
			return idsReturn;
		for (Long num : l) {
			idsReturn.add(num);
		}
		return idsReturn;
	}

	@Transactional
	@Override
	public List<Long> getFavorites() {
		List<Long> listReturn = new ArrayList<>();
		List<ConfiguracionFavoritosDTO> cfListDTO = configuracionFavoritosDAO.getFavoritesByUsr(userInSession.getUsuarioFirmadoVO().getId(), cdApp);
		if(cfListDTO.isEmpty())
			return listReturn;
		for (ConfiguracionFavoritosDTO dto : cfListDTO) {
			listReturn.add(dto.getMenu().getIdMenu());
		}
		return listReturn;
	}
}

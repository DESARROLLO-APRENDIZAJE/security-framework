package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.configuracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Collections;
import mx.com.aprendizaje.arquitectura.ortogonales.exception.BusinessException;
import mx.com.aprendizaje.arquitectura.ortogonales.exception.NotFoundException;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.assembler.configuracion.ConfiguracionAssembler;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.AplicacionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.AplicacionVersionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.ConfiguracionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.MenuOrientacionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.ResolucionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.TemaDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.configuracion.TipoNavegacionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro.ParametroDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.parametro.TipoParametroDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.AplicacionVersionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ConfiguracionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.MenuOrientacionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.ResolucionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TemasDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.configuracion.TipoNavegacionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.ParametroDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.parametro.TipoParametroDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad.AplicacionesDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.AmbienteVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.AplicacionVersionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ConfiguracionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.MenuOrientacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ParametroVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ResolucionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TemaVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TipoNavegacionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.TipoParametroVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.comun.UsuarioFirmadoService;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.ResponseConverter;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: ConfiguracionAplicacionServiceImpl
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Sep/2017
*/ 

@Service
public class ConfiguracionAplicacionServiceImpl implements ConfiguracionAplicacionService {

	@Autowired
	private ConfiguracionDAO configuracionDAO;
	
	@Autowired
	private TemaDAO temaDAO;
	
	@Autowired
	private ResolucionDAO resolucionDAO;
	
	@Autowired
	private AplicacionDAO aplicacionDAO;
	
	@Autowired
	private MenuOrientacionDAO menuOrientacionDAO;
	
	@Autowired
	private TipoNavegacionDAO tipoNavegacionDAO;
	
	@Autowired
	private UsuarioFirmadoService usrSession;
	
	@Autowired
	private AplicacionVersionDAO aplicacionVersionDAO;
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private TipoParametroDAO tipoParametroDAO;
	
	@Value("${app.config.codigo}")
    private String cdApp;
	
	@Override
	@Transactional
	public ConfiguracionVO buscarConfiguracionXAplicacion(String codAplicacion) {
		
		ConfiguracionVO configuracionVO = null;
		ConfiguracionDTO configuracionDTO  = configuracionDAO.buscarConfiguracionXAplicacion(codAplicacion);
		if(configuracionDTO!=null)
			configuracionVO =  ConfiguracionAssembler.toConfiguracionVO(configuracionDTO);
 
		// consultamos la versi�n actual del sistema
		AplicacionVersionDTO avDTO = aplicacionVersionDAO.getCurrentVersion(cdApp);
		AplicacionVersionVO avVO = null;
		if(avDTO != null) {
			avVO = new AplicacionVersionVO();
			ResponseConverter.copiarPropriedades(avVO, avDTO);
			configuracionVO.setVersion(avVO);
		}else {
			// Sea gregar una versi�n por defecto del sistema
			avVO = new AplicacionVersionVO();
			avVO.setIdVersion(0L);
			avVO.setTxVersion("No definido en el sistema");
			avVO.setTxValor("1.0.0");
			configuracionVO.setVersion(avVO);
		}
		
	 return configuracionVO;
	}

	@Override
	@Transactional
	public ConfiguracionVO saveConfiguracion(ConfiguracionVO configuracionVO,String codAplicacion, UsuarioFirmadoVO usuarioFirmadoVO) {
		
		ConfiguracionVO responseConfiguracionVO = null;
		//ConfiguracionDTO configuracionDTO = ResponseConverter.copiarPropiedadesFull(configuracionVO, ConfiguracionDTO.class);
		ConfiguracionDTO configuracionDTO = ConfiguracionAssembler.fromConfiguracionVOtoConfiguracionDTO(configuracionVO);
		AplicacionesDTO aplicacionDTO = aplicacionDAO.getAplicacionByCode(codAplicacion);
		aplicacionDTO.setTxAplicacion(configuracionVO.getAplicacion().getDescripcion());
		aplicacionDTO.setNbAplicacion(configuracionVO.getAplicacion().getNombre());
		aplicacionDTO.setFhModificacion(new Date());
 
		aplicacionDAO.saveOrUpdate(aplicacionDTO);
		
		configuracionDTO.setAplicaciones(aplicacionDTO);
		configuracionDTO.setIdUsrCreacion(usuarioFirmadoVO.getId());
		configuracionDTO.setIdUsrModifica(usuarioFirmadoVO.getId());
		configuracionDTO.setStActivo(new Integer(1));
		configuracionDTO.setFhCreacion( new Date());
		configuracionDTO.setFhModificacion( new Date());

		configuracionDAO.saveConfiguracion(configuracionDTO);
		responseConfiguracionVO = ResponseConverter.copiarPropiedadesFull(configuracionDTO, ConfiguracionVO.class);	
		
		return responseConfiguracionVO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaVO> obtenerTemasXAplicacion(String codAplicacion) {
		
		List<TemaVO> listTemaVO = null;
		List<TemasDTO> listTemaDTO= temaDAO.obtenerTemasXAplicacion(codAplicacion);
		listTemaVO = ResponseConverter.converterLista(new ArrayList<>(), listTemaDTO, TemaVO.class);
		
 		return listTemaVO;
	}

	@Override
	@Transactional
	public TemaVO saveTema(TemaVO temaVO, String codAplicacion,UsuarioFirmadoVO usuarioFirmadoVO) {

		TemaVO responseTemaVO = null;
		
		TemasDTO temasDTO = ResponseConverter.copiarPropiedadesFull(responseTemaVO, TemasDTO.class);
		AplicacionesDTO aplicacionDTO = aplicacionDAO.getAplicacionByCode(codAplicacion);
		temasDTO.setAplicaciones(aplicacionDTO);
		temasDTO.setIdUsrCreacion(usuarioFirmadoVO.getId());
		temasDTO.setIdUsrModifica(usuarioFirmadoVO.getId());
		temasDTO.setStActivo(new Integer(1));
		temasDTO.setFhCreacion( new Date());
		temasDTO.setFhModificacion( new Date());

		temaDAO.saveTema(temasDTO);
		responseTemaVO = ResponseConverter.copiarPropiedadesFull(temasDTO, TemaVO.class);

		return responseTemaVO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionVO> obtenerListaResoluciones() {
		
		List<ResolucionVO> listResolucionVO = null;
		List<ResolucionDTO> listResolucionDTO = resolucionDAO.obtenerListaResoluciones();
		if(!Collections.isEmpty(listResolucionDTO))
		listResolucionVO = ResponseConverter.converterLista(new ArrayList<>(), listResolucionDTO, ResolucionVO.class);
		
 		return listResolucionVO;
	}
	
	@Override
	@Transactional
	public AmbienteVO getCdAmbienteXAplication(String codAplicacion) {
		
		AmbienteVO ambienteVO = null;
		AplicacionesDTO aplicacionDTO  = aplicacionDAO.getAplicacionByCode(codAplicacion);
		ambienteVO =  ResponseConverter.copiarPropiedadesFull(aplicacionDTO, AmbienteVO.class);
		
		return ambienteVO;
	}

	@Transactional
	@Override
	public List<MenuOrientacionVO> getMenuOrientation() throws NotFoundException{
		List<MenuOrientacionVO> listReturn = new ArrayList<>();
		List<MenuOrientacionDTO> moListDTO = menuOrientacionDAO.getMenuOrientation();
		if(moListDTO.isEmpty())
			return listReturn;
		listReturn = ResponseConverter.converterLista(new ArrayList<>(), moListDTO, MenuOrientacionVO.class);
		return listReturn;
	}

	@Transactional
	@Override
	public List<TipoNavegacionVO> getNavigationType() throws NotFoundException{
		List<TipoNavegacionVO> listReturn = new ArrayList<>();
		List<TipoNavegacionDTO> tnListDTO = tipoNavegacionDAO.getNavigationType();
		if(tnListDTO.isEmpty())
			return listReturn;
		listReturn = ResponseConverter.converterLista(new ArrayList<>(), tnListDTO, TipoNavegacionVO.class);
		return listReturn;
	}

	@Transactional
	@Override
	public ConfiguracionVO saveConfiguracion(ConfiguracionVO vo) throws BusinessException{
		ConfiguracionDTO dtoToUpdate = configuracionDAO.getConfigurationById(vo.getIdConfiguracion());
		if(dtoToUpdate == null) { // No existe una configuraci�n actual
			UsuarioFirmadoVO userInSession = usrSession.getUsuarioFirmadoVO();
			return saveConfiguracion(vo, cdApp, userInSession);
		}
		switch (vo.getStrSectionToModif()) {
		case "UNO":
			if(vo.getMenuOrientacion() != null) {
				MenuOrientacionDTO moDTO = new MenuOrientacionDTO();
				ResponseConverter.copiarPropriedades(moDTO, vo.getMenuOrientacion());
				dtoToUpdate.setMenuOrientacion(moDTO);
			}
			if(vo.getTipoNavegacion() != null) {
				TipoNavegacionDTO tpDTO = new TipoNavegacionDTO();
				ResponseConverter.copiarPropriedades(tpDTO, vo.getTipoNavegacion());
				dtoToUpdate.setTipoNavegacion(tpDTO);
			}
			dtoToUpdate.setStHeaderFijo((long)vo.getStHeaderFijo());
			dtoToUpdate.setStFooterFijo((long)vo.getStFooterFijo());
			dtoToUpdate.setStMenuFijo((long)vo.getStMenuFijo());
			break;
		case "DOS":
			// Debemos obtener la aplicaci�n actual para su axtualizaci�n
			Long idApp = new Long(vo.getAplicacion().getIdAplicacion());
			AplicacionesDTO aDTO = aplicacionDAO.findOne(idApp);
			if(aDTO != null) {
				aDTO.setNbAplicacion(vo.getAplicacion().getNombre());
				aDTO.setTxAplicacion(vo.getAplicacion().getDescripcion());
			}
			dtoToUpdate.setAplicaciones(aDTO);
			aplicacionDAO.saveOrUpdate(aDTO);
			break;
		case "TRES":
			// Validar el tema actual y actualizar
			TemasDTO tDTO = new TemasDTO();
			ResponseConverter.copiarPropriedades(tDTO, vo.getTema());
			dtoToUpdate.setTemas(tDTO);
			break;
		case "CUATRO":
			// Validar la resolucaci�n actual
			ResolucionDTO rDTO = new ResolucionDTO();
			ResponseConverter.copiarPropriedades(rDTO, vo.getResolucion());
			dtoToUpdate.setResoluciones(rDTO);
			break;
		case "CINCO":
			// Validar las imagenes de la aplicaci�n y actualizar
			dtoToUpdate.setLbMenuPricipal(vo.getLogoMenuPrincipal());
			dtoToUpdate.setLbMenuSecundario(vo.getLogoMenuSecundario());
			dtoToUpdate.setLbHeader(vo.getLogoHeader());
			dtoToUpdate.setLbIndex(vo.getLogoIndex());
			break;
		case "SEIS":
			// Actualizaci�n de los texto del footer de la aplicaci�n
			dtoToUpdate.setTxFooterLogin(vo.getTxFooterLogin());
			dtoToUpdate.setTxFooterMain(vo.getTxFooterMain());
			break;
		default:
			throw new BusinessException("En necesario especificar una secci�n a actualizar");
		}
		configuracionDAO.update(dtoToUpdate);
		return vo;
	}

	@Transactional
	@Override
	public List<AplicacionVersionVO> version() throws NotFoundException{
		List<AplicacionVersionDTO> avListDTO = aplicacionVersionDAO.getVersion(cdApp);
		if(avListDTO.isEmpty())
			throw new NotFoundException("No se econtraron registros de versiones del sistema");
		List<AplicacionVersionVO> avListVO = ResponseConverter.converterLista(new ArrayList<>(), avListDTO, AplicacionVersionVO.class);	
		return avListVO;
	}
	
	@Transactional
	@Override
	public Boolean version(AplicacionVersionVO vo) throws NotFoundException, BusinessException{
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		if(vo == null)
			throw new BusinessException("En necesario agregar los datos para guardar una nueva versi�n");
		AplicacionVersionDTO avDTO = new AplicacionVersionDTO();
		avDTO.setTxVersion(vo.getTxVersion());
		avDTO.setTxValor(vo.getTxValor());
		AplicacionesDTO aDTO = aplicacionDAO.getAplicacionByCode(cdApp);
		avDTO.setAplicacion(aDTO);
		avDTO.setIdUsrCreacion(idUsr);
		avDTO.setIdUsrModifica(idUsr);
		avDTO.setFhCreacion( new Date());
		avDTO.setFhModificacion( new Date());
		avDTO.setStActivo(vo.getStActivo() == null ? 0: vo.getStActivo());
		aplicacionVersionDAO.save(avDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean versionUpdate(AplicacionVersionVO vo) throws NotFoundException, BusinessException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		// Buscar la vsrsi�n actual del sistrema para actualizar
		if(vo == null)
			throw new BusinessException("En necesario agregar los datos para guardar una nueva versi�n");
		AplicacionVersionDTO avDTO = aplicacionVersionDAO.getVersion(vo.getIdVersion());
		if(avDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		avDTO.setTxVersion(vo.getTxVersion());
		avDTO.setTxValor(vo.getTxValor());
		avDTO.setIdUsrModifica(idUsr);
		avDTO.setFhModificacion( new Date());
		aplicacionVersionDAO.update(avDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean versionDelete(Long idVersion) throws NotFoundException, BusinessException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		AplicacionVersionDTO avDTO = aplicacionVersionDAO.getVersion(idVersion);
		if(avDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		avDTO.setStActivo(2);
		avDTO.setIdUsrModifica(idUsr);
		avDTO.setFhModificacion( new Date());
		aplicacionVersionDAO.update(avDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean versionStatus(AplicacionVersionVO vo) throws NotFoundException, BusinessException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		AplicacionVersionDTO avDTO = aplicacionVersionDAO.getVersion(vo.getIdVersion());
		if(avDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		avDTO.setStActivo(vo.getStActivo());
		avDTO.setFhModificacion( new Date());
		avDTO.setIdUsrModifica(idUsr);
		aplicacionVersionDAO.update(avDTO);
		return true;
	}

	@Transactional
	@Override
	public List<ParametroVO> restriction() throws NotFoundException{
		List<ParametroDTO> pListDTO = parametroDAO.getRestrictions(cdApp);
		if(pListDTO.isEmpty())
			throw new NotFoundException("No se econtraron registros de par�metros");
		List<ParametroVO> pListVO = ResponseConverter.converterLista(new ArrayList<>(), pListDTO, ParametroVO.class);	
		return pListVO;
	}

	@Transactional
	@Override
	public List<TipoParametroVO> typeRestriction() throws NotFoundException {
		List<TipoParametroDTO> tpListDTO = tipoParametroDAO.typeRestriction();
		if(tpListDTO.isEmpty())
			throw new NotFoundException("No se econtraron registros de par�metros");
		List<TipoParametroVO> pListVO = ResponseConverter.converterLista(new ArrayList<>(), tpListDTO, TipoParametroVO.class);
		return pListVO;
	}

	@Transactional
	@Override
	public Boolean restriction(ParametroVO vo) throws BusinessException{
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		if(vo == null)
			throw new BusinessException("En necesario agregar los datos para guardar un nuevo par�metro");
		ParametroDTO pDTO = ResponseConverter.copiarPropiedadesFull(vo, ParametroDTO.class);
		pDTO.setIdUsrCreacion(idUsr);
		pDTO.setIdUsrModifica(idUsr);
		pDTO.setFhCreacion( new Date());
		pDTO.setFhModificacion( new Date());
		pDTO.setStBandera(vo.getStBandera());
		pDTO.setStActivo(1);
		// Agregar aplicaci�n
		AplicacionesDTO aDTO = aplicacionDAO.getAplicacionByCode(cdApp);
		pDTO.setAplicacion(aDTO);
		
		parametroDAO.save(pDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean restrictionUpdate(ParametroVO vo) throws BusinessException, NotFoundException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		// Buscar la vsrsi�n actual del sistrema para actualizar
		if(vo == null)
			throw new BusinessException("En necesario agregar los datos para actualizar el par�metro");
		ParametroDTO pDTO = parametroDAO.restrictionById(vo.getIdParametro());
		if(pDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		pDTO.setNbParametro(vo.getNbParametro());
		pDTO.setNbValor(vo.getNbValor());
		pDTO.setTxParametro(vo.getTxParametro());
		pDTO.setStParametroInterno(vo.getStParametroInterno());
		pDTO.setStBandera(vo.getStBandera());
		if(vo.getTipoParametro() != null) {
			TipoParametroDTO tpDTO = new TipoParametroDTO();
			ResponseConverter.copiarPropriedades(tpDTO, vo.getTipoParametro());
			pDTO.setTipoParametro(tpDTO);
		}
		pDTO.setIdUsrModifica(idUsr);
		pDTO.setFhModificacion( new Date());
		parametroDAO.update(pDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean restrictionDelete(Long idParametro) throws BusinessException, NotFoundException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		ParametroDTO pDTO = parametroDAO.restrictionById(idParametro);
		if(pDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		pDTO.setStActivo(2);
		pDTO.setIdUsrModifica(idUsr);
		pDTO.setFhModificacion( new Date());
		parametroDAO.update(pDTO);
		return true;
	}

	@Transactional
	@Override
	public Boolean restrictionStatus(ParametroVO vo) throws NotFoundException, BusinessException {
		Long idUsr = usrSession.getUsuarioFirmadoVO() == null ? 0L: usrSession.getUsuarioFirmadoVO().getId();
		ParametroDTO pDTO = parametroDAO.restrictionById(vo.getIdParametro());
		if(pDTO == null)
			throw new NotFoundException("No se encontr� el registro a actualizar");
		pDTO.setStActivo(vo.getStActivo());
		pDTO.setFhModificacion( new Date());
		pDTO.setIdUsrModifica(idUsr);
		parametroDAO.update(pDTO);
		return true;
	}
}

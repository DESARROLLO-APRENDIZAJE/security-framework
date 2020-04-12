package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.service.webservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Collections;
import mx.com.aprendizaje.arquitectura.ortogonales.responsehttp.ConflictHttpResponse;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.FuncionNoWebServiceVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.NewTokenDataVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.TokenUsuarioFuncionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.WSInfoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.WSVersionVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws.WebServiceVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.FuncionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.TokenUsuarioFuncionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.UsuarioDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.WSVersionDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dao.webservice.WebServiceDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.FuncionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionIdDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.UsuarioDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WSVersionDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.WebServiceDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util.PasswordUtils;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util.TokenUtils;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.Codigos;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.Mensajes;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.ResponseConverter;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.Servicios;

@Service
public class WSServiceImpl implements WSService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private FuncionDAO funcionDAO;
	
	@Autowired
	private TokenUsuarioFuncionDAO tokenUsuarioFuncionDAO;
	
	@Autowired
	private WebServiceDAO webServiceDAO;
	
	@Autowired
	private PasswordUtils passwordUtils;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private WSVersionDAO wSVersionDAO;
	
	@Value("${app.config.codigo}")
	private String codeApplicationn;
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public TokenUsuarioFuncionVO newTokenData(NewTokenDataVO data) throws Exception, ConflictHttpResponse{
		
		UsuarioDTO usuario = usuarioDAO.activoByUserName(data.getCodigoUsuario());
		FuncionDTO funcion =funcionDAO.activoByCode(data.getCodigoFuncion());
		
		validateNewDataToken(usuario, funcion);
		TokenUsuarioFuncionDTO newToken = tokenUsuarioFuncionDAO.byUserNameAndFunctionCode(data.getCodigoUsuario(), data.getCodigoFuncion());
		if(newToken != null) throw new ConflictHttpResponse(Mensajes.MSJ_TOKEN_ALREADY_PERSISTED.getMensaje() + " Estatus: " + (newToken.getActivo() == 1 ? "Activo" : "Inactivo"), Codigos.CONFLICT.getCodigo() + Servicios.NEW_TOKEN.getService(), ResponseConverter.copiarPropiedadesFull(newToken, TokenUsuarioFuncionVO.class));
		newToken = new TokenUsuarioFuncionDTO();
		newToken.setUsuario(usuario);
		newToken.setFuncion(funcion);
		TokenUsuarioFuncionIdDTO id = new TokenUsuarioFuncionIdDTO();
		id.setUsuarioId(usuario.getUsuarioId());
		id.setFuncionId(funcion.getFuncionId());
		newToken.setId(id);
		newToken.setFuncionPassword(passwordUtils.randomPassword(8));
		newToken.setToken(tokenUtils.generateClientToken(newToken));
		newToken.setFechaCreacion(Calendar.getInstance().getTime());
		newToken.setFechaModificacion(newToken.getFechaCreacion());
		newToken.setActivo(1);
		newToken.setCreadoPor(1L);
		newToken.setModificadoPor(newToken.getCreadoPor());
		tokenUsuarioFuncionDAO.save(newToken);
		return ResponseConverter.copiarPropiedadesFull(newToken, TokenUsuarioFuncionVO.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public String serviceCode(String contextPath){
		WebServiceDTO dto = webServiceDAO.byContextPath(contextPath);
		if(dto == null) return Servicios.SERVICE_NOT_FOUND.getService();
		return dto.getCodigoServicio();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public String functionIdentifierCode(String contextPath, String endPoint){
		FuncionDTO dto = funcionDAO.byContextPathAndEndPoint(contextPath, endPoint);
		if(dto == null) return Servicios.SERVICE_NOT_FOUND.getService();
		return dto.getNumeroFuncion();
	}
	
	@Override
	@Transactional
	public WSInfoVO webServiceInfo(String cdWebService) {
		WebServiceDTO ws = webServiceDAO.byCode(cdWebService);
		if(ws == null) return null;
		WSInfoVO response = new WSInfoVO();
		response.setWebService(ResponseConverter.copiarPropiedadesFull(ws, WebServiceVO.class));
		List<FuncionDTO> funciones = funcionDAO.byCodeService(cdWebService);
		if(Collections.isEmpty(funciones))
			response.setFunciones(new ArrayList<FuncionNoWebServiceVO>());
		else
			response.setFunciones(ResponseConverter.converterLista(new ArrayList<FuncionNoWebServiceVO>(), funciones, FuncionNoWebServiceVO.class));
		WSVersionDTO currentVersionDTO = wSVersionDAO.currentVersion(cdWebService);
		if(currentVersionDTO != null)
			response.setVersion(ResponseConverter.copiarPropiedadesFull(currentVersionDTO, WSVersionVO.class));
		List<WSVersionDTO> versiones = wSVersionDAO.recordVersions(cdWebService);
		if(!Collections.isEmpty(versiones))
			response.setVersiones(ResponseConverter.converterLista(new ArrayList<WSVersionVO>(), versiones, WSVersionVO.class));
		return response;
	}
	
	public void validateNewDataToken(UsuarioDTO usuario, FuncionDTO funcion) throws ConflictHttpResponse{
		if(usuario == null) throw new ConflictHttpResponse(Mensajes.MSJ_WRONG_USER.getMensaje(),Codigos.CONFLICT.getCodigo() + Servicios.NEW_TOKEN.getService(), null);
		if(funcion == null) throw new ConflictHttpResponse(Mensajes.MSJ_WRONG_FUNCTION.getMensaje(),Codigos.CONFLICT.getCodigo() + Servicios.NEW_TOKEN.getService(), null);
		if(!funcion.getServicio().getCodigoServicio().equals(codeApplicationn)) throw new ConflictHttpResponse(Mensajes.MSJ_WRONG_FUNCTION_SERVICE.getMensaje(),Codigos.CONFLICT.getCodigo() + Servicios.NEW_TOKEN.getService(), null);
		if(!usuario.getCliente().getCodigoCliente().equals(funcion.getServicio().getCliente().getCodigoCliente()))throw new ConflictHttpResponse(Mensajes.MSJ_WRONG_USER_CLIENT.getMensaje(),Codigos.CONFLICT.getCodigo() + Servicios.NEW_TOKEN.getService(), null);	
	}
	
}

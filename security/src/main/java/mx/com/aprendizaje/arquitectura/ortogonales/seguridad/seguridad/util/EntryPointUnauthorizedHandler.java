package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.service.webservice.WSService;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.Codigos;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util.Mensajes;
import mx.com.aprendizaje.arquitectura.ortogonales.vo.Response;
import mx.com.aprendizaje.arquitectura.ortogonales.vo.Status;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private WSService wService;
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acceso no permitido a el recurso solicitado.");
		httpServletResponse.addHeader("Content-Type", "application/json;charset=UTF-8");
	    // set the response status code
		httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    // set up the response body
		Response unauthorized = 
				new Response(new Status(Codigos.UNAUTHORIZED.getCodigo() + wService.functionIdentifierCode(httpServletRequest.getContextPath(),httpServletRequest.getPathInfo()),Mensajes.MSJ_UNAUTHORIZED.getMensaje()), null);
	    // write the response body
	    objectMapper.writeValue(httpServletResponse.getOutputStream(), unauthorized);
	    // commit the response
	    httpServletResponse.flushBuffer();
	}
}

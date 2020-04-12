package mx.com.aprendizaje.arquitectura.ortogonales.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (c) 2016, Teclo Mexicana.
 * Descripcion					: ControllerExceptionHandler
 * Historial de Modificaciones	:
 * Descripcion del Cambio		: Creacion
 * @author 						: fjmb 
 * @version 					: 1.0
 * Fecha						: 03/Julio/2017
*/ 


@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ControllerExceptionHandler  {
	
	@Autowired
	private ExceptionLogger exceptionLogger;

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorMessage handleBusinessException(BusinessException exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return errorMessage;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorMessage handleException(Exception exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorMessage.setMessage(exception.getMessage());
		exceptionLogger.sendLog(exception);
		return errorMessage;
	}
	
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleInternalAuthenticationServiceException(Exception exception, HttpServletRequest request) {
		exception.getCause();
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage("No se pudo establecer conexi�n.");
		return errorMessage;
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleAuthenticationException(Exception exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage("Usuario o contrase�a incorrecto");
		return errorMessage;
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ErrorMessage handleAccessDeniedException(Exception exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorMessage.setMessage("Acesso no permitido a el recurso solicitado");
		return errorMessage;
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleNotFoundException(NotFoundException exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage(exception.getMessage());
		return errorMessage;
	}
	
	
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handleUsernameNotFoundException(Exception exception, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage(exception.getMessage());
		return errorMessage;
	}
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<UsernameNotFoundException> notFoundException(HttpServletRequest request,
//	                HttpMessageNotReadableException e) {
//
//
//		UsernameNotFoundException myException = new UsernameNotFoundException("CustomMessage");
//	    logger.error("An constrain voilation occured reason {}", e);
//	    return new ResponseEntity<>(myException , HttpStatus.BAD_REQUEST);
//	}
}
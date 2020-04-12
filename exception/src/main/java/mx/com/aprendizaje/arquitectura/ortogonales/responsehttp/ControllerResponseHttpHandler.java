package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.com.aprendizaje.arquitectura.ortogonales.vo.Response;
import mx.com.aprendizaje.arquitectura.ortogonales.vo.Status;
 
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerResponseHttpHandler {

 	
	@ExceptionHandler(NotFoundHttpResponse.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Response handlerNotFoundHttpResponse(NotFoundHttpResponse exception, HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());

		return response;
	}
	
	//Se agrega para el manejo de erroes en el servØidor
	@ExceptionHandler(BusinessHttpResponse.class)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response handlerBusinessHttpResponse(BusinessHttpResponse exception,HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
 
	@ExceptionHandler(ConflictHttpResponse.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody Response handlerConflictHttpResponse(ConflictHttpResponse exception,HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
	
	
	@ExceptionHandler(OKHttpResponse.class)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response handlerOkHttpResponse(OKHttpResponse exception,HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
	
 	@ExceptionHandler(CreateHttpResponse.class)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Response handlerCreateHttpResponse(CreateHttpResponse exception, HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException .class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody Response handlerInvalidFormatHttpResponse(HttpMessageNotReadableException exception,HttpServletRequest request ) {
		Response response = new Response();
		response.setStatus(new Status("TCL400", "La solicitud no pudo ser procesada, contiene sintaxis err�nea."));
		response.setData(null);
		return response;
	}
 	
//	@ExceptionHandler(ForbiddenHttpResponse.class)
//	@ResponseStatus(HttpStatus.FORBIDDEN)
//	public @ResponseBody Response handlerForbiddenHttpResponse(ForbiddenHttpResponse exception, HttpServletRequest request) {
//		Response response = new Response();
//		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
//		response.setData(exception.getData());
//		return response;
//	}
 	

	@ExceptionHandler(UnauthorizedHttpResponse.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody Response handlerUnauthorizedHttpResponse(UnauthorizedHttpResponse exception, HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
 
	@ExceptionHandler(BadRequestHttpResponse.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody Response handlerBadRequestHttpResponse(BadRequestHttpResponse exception, HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
	
	@ExceptionHandler(AcceptedHttpResponse.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody Response handleAcceptedException(AcceptedHttpResponse exception, HttpServletRequest request) {
		Response response = new Response();
		response.setStatus(new Status(exception.getCodigo(), exception.getMessage()));
		response.setData(exception.getData());
		return response;
	}
}
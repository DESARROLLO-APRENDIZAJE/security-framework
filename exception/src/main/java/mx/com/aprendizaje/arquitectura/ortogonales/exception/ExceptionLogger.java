package mx.com.aprendizaje.arquitectura.ortogonales.exception;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.aprendizaje.arquitectura.ortogonales.mensajeria.EnvioEmailService;

/**
 * Servicio que maneja las exepciones de las aplicaciones por medio de Aspectos.
 *
 * @author jorgeluis
 *
 */
@Component
public class ExceptionLogger {
	
	private static final Logger logger = Logger.getLogger(ExceptionLogger.class);
	
	@Autowired
	private EnvioEmailService exceptionMailService;

	public void setExceptionMailService(EnvioEmailService exceptionMailService) {
		this.exceptionMailService = exceptionMailService;
	}

	public ExceptionLogger() {
	}

	public void sendLog(Throwable throwable) {
		if (!(throwable instanceof BusinessException)) {
			logger.error("*********** Interceptando excepción dentro de la aplicación de 'APRENDIZAJE DE IDIOMAS': -------> " + new java.util.Date());
			logger.error("\n*********** ERROR **************: ---->" + throwable.getMessage());
			StringBuffer body = new StringBuffer("");
			try {
				body.append("<br>Surgió un error en la aplicación: ").append(new java.util.Date());
				body.append("<br><br>********  ERROR ************** ");
				body.append("<br><br>").append("Mensaje --> ").append(throwable.getMessage());
				body.append("<br><br>").append("Causa --> ");
				logger.error("*********** CAUSA **************: ---->");
				for (int i = 0; i < throwable.getStackTrace().length; i++) {
					body.append("<br>").append(throwable.getStackTrace()[i]);
					logger.error("\n" + throwable.getStackTrace()[i]);
				}
				exceptionMailService.sendMail("darkangel1992get@gmail.com", "darkangel1992get@gmail.com", "-- ERROR --", body.toString());

			} catch (Exception e) {
				logger.error("*********** Error al mandar Correo Electrónico de la falla: -------> " + new java.util.Date());
				logger.error("\n*********** ERROR **************: ---->" + e.getMessage());
				for (int i = 0; i < e.getStackTrace().length; i++) {
					logger.error(e.getStackTrace()[i] + "\n");
				}
			}
		}
	}
}

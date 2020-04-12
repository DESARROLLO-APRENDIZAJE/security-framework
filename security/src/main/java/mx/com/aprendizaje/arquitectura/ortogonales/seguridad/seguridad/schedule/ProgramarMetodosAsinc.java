package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.schedule;



import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;




@Configuration
@EnableAsync
@EnableScheduling
public class ProgramarMetodosAsinc {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ProgramarMetodosAsinc.class);
	
	/*@Scheduled(fixedDelay=5000)
	public void doSomething() {
	    // something that should execute periodically
		logger.info("PROCESO ASINCRONO QUE SE EJECUTA CADA 5 SEGUNDOS ::::::::::::");
	}*/

}

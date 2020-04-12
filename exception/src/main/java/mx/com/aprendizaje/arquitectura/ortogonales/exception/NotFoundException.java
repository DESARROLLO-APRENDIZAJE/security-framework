package mx.com.aprendizaje.arquitectura.ortogonales.exception;

public class NotFoundException extends Exception {
	/**
	 * MANEJO DE EXCEPCIONES CUANDO NO SE ENCUENTRA EL RECURSO SOLICITADO
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String exception){
		super(exception);
	}
}

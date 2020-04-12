package mx.com.aprendizaje.arquitectura.ortogonales.exception;

public class BusinessException extends Exception{
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE NEGOCIO
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String exception){
		super(exception);
	}

}

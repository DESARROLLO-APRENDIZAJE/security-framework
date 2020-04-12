package mx.com.aprendizaje.arquitectura.ortogonales.exception;

public class ControllerException extends Exception {
	
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE PRESENTACION
	 */
	private static final long serialVersionUID = 1L;

	public ControllerException(String exception){
		super("DESDE PRESENTACION EXCEPTION ::: " + exception);
	}

}

package mx.com.aprendizaje.arquitectura.ortogonales.exception;

public class SeguridadException extends Exception {
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE NEGOCIO
	 */
	private static final long serialVersionUID = 1L;

	public SeguridadException(String exception){
		super("DESDE SEGURIDAD EXCEPTION ::: " + exception);
	}


}

package mx.com.aprendizaje.arquitectura.ortogonales.exception;

public class PersistenceException extends Exception{
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE PERSISTENCIA
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String exception){
		super("PRESISTENCE EXCEPTION: " + exception);
		
		
		
	}
	
}

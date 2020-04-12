package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class SeguridadHttpResponse extends Exception {
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE NEGOCIO
	 */
	private static final long serialVersionUID = 1L;

	public SeguridadHttpResponse(String exception){
		super("DESDE SEGURIDAD EXCEPTION ::: " + exception);
	}


}

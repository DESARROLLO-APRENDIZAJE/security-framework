package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class ControllerException extends Exception {
	
 
	private static final long serialVersionUID = 1L;

	public ControllerException(String exception){
		super("DESDE PRESENTACION EXCEPTION ::: " + exception);
	}

}

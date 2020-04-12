package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

import org.springframework.security.access.AccessDeniedException;

public class AccesDeniedHttpRespone extends AccessDeniedException {
	 
	private static final long serialVersionUID = 1L;
	private String codigo;
	
	public AccesDeniedHttpRespone(String exception,String codigo){
		super(exception);
		this.codigo=codigo;
	}
	
	public AccesDeniedHttpRespone(String exception){
		super(exception);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}

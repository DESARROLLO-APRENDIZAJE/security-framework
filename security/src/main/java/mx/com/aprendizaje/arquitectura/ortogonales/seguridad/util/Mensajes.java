package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

public enum Mensajes {
	
	MSJ_UNAUTHORIZED("Acceso no permitido a el recurso solicitado."),
	MSJ_TOKEN_ALREADY_PERSISTED("Token dado de alta anteriormente."),
	MSJ_WRONG_USER("Usuario inexistente."),
	MSJ_WRONG_FUNCTION("Funci�n inexistente."),
	MSJ_WRONG_USER_CLIENT("Se ha intentado dar de alta un token de acceso a un usuario de un cliente ajeno."),
	MSJ_WRONG_FUNCTION_SERVICE("Se ha intentado dar de alta un token de acceso a una funcion de un WS ajeno.");
	
	
	private String mensaje;

	
	private Mensajes(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	static Mensajes getMensajeTipo(String x) {
		for (Mensajes currentType : Mensajes.values()) {
			if (x.equals(currentType.getMensaje())) {
				return currentType;
			}
		}
		return null;
	}
}

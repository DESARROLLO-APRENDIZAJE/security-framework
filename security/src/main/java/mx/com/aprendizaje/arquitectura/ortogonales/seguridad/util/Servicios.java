package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

public enum Servicios {
	
	SERVICE_NOT_FOUND("00"),
	NEW_TOKEN("NT");
	
	String service;

	private Servicios(String service) {
		this.service = service;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
}

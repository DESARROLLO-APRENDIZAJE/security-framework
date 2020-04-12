package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

public enum StatusClientResponse {
	TCL200(200 ,"Todo funcion� correctamente."),
	TCL201(201 ,"Fue creado un nuevo recurso."),
	TCL202(202 ,"La petici�n ha sido aceptada para procesamiento, pero este no ha sido completado."),
	TCL400(400 ,"La petici�n es inv�lida o no puede ser procesada."),
	TCL401(401 ,"La petici�n requiere autenticaci�n."),
	TCL403(403 ,"El servidor entiende la petici�n, pero la rechaza o el acceso no est� permitido."),
	TCL404(404 ,"No existe el recurso para la URI especificada."),
	TCL500(500 ,"Falla en el servidor."),
	TCL503(503 ,"El servidor no puede responder a la petici�n del navegador porque est� congestionado o est� realizando tareas de mantenimiento.");
	
	private Integer status;
	private String message;
	
	private StatusClientResponse(Integer status, String message) {
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

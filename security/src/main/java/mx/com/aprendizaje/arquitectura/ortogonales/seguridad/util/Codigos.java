package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

public enum Codigos {
	
	UNAUTHORIZED("TCL401"),
	CONFLICT("TCL409");
	String codigo;

	private Codigos(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	static Codigos getCodigoTipo(String x) {
		for (Codigos currentType : Codigos.values()) {
			if (x.equals(currentType.getCodigo())) {
				return currentType;
			}
		}
		return null;
	}
}

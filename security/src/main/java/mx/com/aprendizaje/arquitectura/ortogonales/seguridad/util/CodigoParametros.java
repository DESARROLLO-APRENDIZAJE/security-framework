package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

public enum CodigoParametros {

	CPU("CPU"), // CONTRAE�A PRIMERO USO
	PCNTRASAS("PCNTRASAS"), // EXPRESI�N REGULAR PARA EVALUAR CONTRASE�A SEGURA
	NRP("NRP"), // NO REPETIR PASSWORD
	ADV("ADV"), // NUMERO DE DIAS PARA NOTIFICAR AL USUARIO DEL VENCIMIENTO DE SU CLAVE
	NVRC("NVRC")
	;

	String codigo;

	private CodigoParametros(String codigo) {
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

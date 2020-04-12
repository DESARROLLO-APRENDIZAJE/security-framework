package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class CreateHttpResponse extends Exception {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private Object data;

	public CreateHttpResponse(String descripcion) {
		super(descripcion);
	}

	public CreateHttpResponse(String descripcion, String codigo, Object data) {
		super(descripcion);
		this.codigo = codigo;
		this.data = data;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

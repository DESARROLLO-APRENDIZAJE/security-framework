package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class PersistenceHttpResponse extends Exception {
	
 
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Object data;

	public PersistenceHttpResponse(String exception, String codigo, Object data) {
		super(exception);
		this.codigo = codigo;
		this.data = data;
	}

	public PersistenceHttpResponse(String exception) {
		super(exception);
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

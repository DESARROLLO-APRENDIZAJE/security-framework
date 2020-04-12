package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class ConflictHttpResponse extends Exception {
	 
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Object data;
	
	public ConflictHttpResponse(String descripcion,String codigo,Object data){
		super(descripcion);
		this.codigo = codigo;
		this.data = data;
	}
	
	public ConflictHttpResponse(String descripcion){
		super(descripcion);
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

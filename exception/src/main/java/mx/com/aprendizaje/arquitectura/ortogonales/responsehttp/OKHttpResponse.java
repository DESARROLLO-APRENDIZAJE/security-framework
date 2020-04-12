package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

public class OKHttpResponse extends Exception {
	 
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Object data;
	
	public OKHttpResponse(String descripcion,String codigo, Object data){
		super(descripcion);
		this.codigo = codigo;
		this.data = data;
	}

	public OKHttpResponse(String codigo, Object data){
		super("OK");
 		this.codigo = codigo;
		this.data = data;
	}

	
	public OKHttpResponse( Object data){
		this.data = data;
	}
	
	public OKHttpResponse(String descripcion){
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

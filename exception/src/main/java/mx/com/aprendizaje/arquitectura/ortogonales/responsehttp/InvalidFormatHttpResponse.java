package mx.com.aprendizaje.arquitectura.ortogonales.responsehttp;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class InvalidFormatHttpResponse  extends HttpMessageNotReadableException{
	 
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Object data;
	

	public InvalidFormatHttpResponse(String msg, String codigo, Object data) {
		super(msg);
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

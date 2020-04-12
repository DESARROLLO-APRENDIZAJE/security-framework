package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class ResponseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5649397518618414988L;

	private Integer code;
	private String message;

	public ResponseVO () {}
	
	public ResponseVO (Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseVO: [code: "+code+", message: "+message+"]";
	}
	
}

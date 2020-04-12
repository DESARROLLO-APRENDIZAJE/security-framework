package mx.com.aprendizaje.arquitectura.ortogonales.vo;

public class Response {

	private Status status;
 	private Object data;
 	
 	
 	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Response(Status status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

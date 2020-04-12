package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

public class AuthenticationRequestVO {

	private String username;
	private String password;
	private String tokenGcm;

	public AuthenticationRequestVO() {
		
	}

	
	public AuthenticationRequestVO(String username, String password, String tokenGcm) {
		super();
		this.username = username;
		this.password = password;
		this.tokenGcm = tokenGcm;
	}


	public AuthenticationRequestVO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTokenGcm() {
		return tokenGcm;
	}

	public void setTokenGcm(String tokenGcm) {
		this.tokenGcm = tokenGcm;
	}

 
	
	
}

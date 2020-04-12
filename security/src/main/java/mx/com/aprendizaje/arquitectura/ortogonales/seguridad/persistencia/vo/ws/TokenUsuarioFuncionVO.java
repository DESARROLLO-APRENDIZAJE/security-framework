package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws;

public class TokenUsuarioFuncionVO {

	private FuncionVO funcion;
	private UsuarioVO usuario;
	private String token;
	
	/**
	 * @return the funcion
	 */
	public FuncionVO getFuncion() {
		return funcion;
	}
	/**
	 * @param funcion the funcion to set
	 */
	public void setFuncion(FuncionVO funcion) {
		this.funcion = funcion;
	}
	/**
	 * @return the usuario
	 */
	public UsuarioVO getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}

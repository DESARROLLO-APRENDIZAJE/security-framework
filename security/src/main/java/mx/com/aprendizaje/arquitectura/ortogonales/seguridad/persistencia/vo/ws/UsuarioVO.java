package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws;

public class UsuarioVO {
	
	private Long usuarioId;
	private ClienteVO cliente;
	private String usuario;
	
	/**
	 * @return the usuarioId
	 */
	public Long getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	/**
	 * @return the cliente
	 */
	public ClienteVO getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}

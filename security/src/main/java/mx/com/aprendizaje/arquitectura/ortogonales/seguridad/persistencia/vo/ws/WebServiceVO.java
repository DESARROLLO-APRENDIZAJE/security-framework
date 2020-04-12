package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws;

public class WebServiceVO {
	
	private Long servicioId;
	private ClienteVO cliente;
	private String nombreServicio;
	private String codigoServicio;
	private String descripcionServicio;
	private String contexto;

	/**
	 * @return the servicioId
	 */
	public Long getServicioId() {
		return servicioId;
	}
	/**
	 * @param servicioId the servicioId to set
	 */
	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
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
	 * @return the nombreServicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}
	/**
	 * @param nombreServicio the nombreServicio to set
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	/**
	 * @return the codigoServicio
	 */
	public String getCodigoServicio() {
		return codigoServicio;
	}
	/**
	 * @param codigoServicio the codigoServicio to set
	 */
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	/**
	 * @return the descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}
	/**
	 * @param descripcionServicio the descripcionServicio to set
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	/**
	 * @return the contexto
	 */
	public String getContexto() {
		return contexto;
	}
	/**
	 * @param contexto the contexto to set
	 */
	public void setContexto(String contexto) {
		this.contexto = contexto;
	}
	
}

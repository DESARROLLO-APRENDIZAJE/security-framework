package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TokenUsuarioFuncionIdDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 906657761818190921L;

	@Basic(optional = false)
	@Column(name = "ID_USUARIO", nullable = false)
	private Long usuarioId;
	
	@Basic(optional = false)
	@Column(name = "ID_FUNCION", nullable = false)
	private Long funcionId;

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
	 * @return the funcionId
	 */
	public Long getFuncionId() {
		return funcionId;
	}

	/**
	 * @param funcionId the funcionId to set
	 */
	public void setFuncionId(Long funcionId) {
		this.funcionId = funcionId;
	}

}

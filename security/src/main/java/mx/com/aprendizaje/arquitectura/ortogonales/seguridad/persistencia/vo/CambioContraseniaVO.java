package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;

public class CambioContraseniaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1922514381608424818L;
	
	private String password;
	private String newPassword;
	private String newPasswordRepeat;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	@Override
	public String toString() {
		return "CambioContraseniaVO[password: "+password+", newPassword: "+newPassword+", newPasswordRepeat: "+newPasswordRepeat+"]";
	}
}

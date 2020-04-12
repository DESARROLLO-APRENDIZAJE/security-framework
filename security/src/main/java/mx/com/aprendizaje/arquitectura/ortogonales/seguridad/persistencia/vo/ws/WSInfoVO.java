package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ws;

import java.util.List;

/**
 * @author Kevin Ojeda
 *
 */
public class WSInfoVO {
	
	private WebServiceVO webService;
	private List<FuncionNoWebServiceVO> funciones;
	private WSVersionVO version;
	private List<WSVersionVO> versiones;
	
	public WebServiceVO getWebService() {
		return webService;
	}
	public void setWebService(WebServiceVO webService) {
		this.webService = webService;
	}
	public List<FuncionNoWebServiceVO> getFunciones() {
		return funciones;
	}
	public void setFunciones(List<FuncionNoWebServiceVO> funciones) {
		this.funciones = funciones;
	}
	public WSVersionVO getVersion() {
		return version;
	}
	public void setVersion(WSVersionVO version) {
		this.version = version;
	}
	
	public List<WSVersionVO> getVersiones() {
		return versiones;
	}
	public void setVersiones(List<WSVersionVO> versiones) {
		this.versiones = versiones;
	}
	@Override
	public String toString() {
		return "WSInfoVO [webService=" + webService + ", funciones=" + funciones + ", version=" + version
				+ ", versiones=" + versiones + "]";
	}
	
}

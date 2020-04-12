package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad;
 
import javax.persistence.Column;
import javax.persistence.Embeddable;

 
@Embeddable
public class ViewPaginaServicioId implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007432057249031819L;
	private Long id;
	private String menuUri;
	private String servicioNombre;
	private Long idMenuPrincipal;
	private String cdAplicacion;
	private Long perfilId;

	public ViewPaginaServicioId() {
	}

	public ViewPaginaServicioId(String cdAplicacion) {
		this.cdAplicacion = cdAplicacion;
	}

	public ViewPaginaServicioId(Long id, String menuUri, String servicioNombre, Long idMenuPrincipal,
			String cdAplicacion, Long perfilId) {
		this.id = id;
		this.menuUri = menuUri;
		this.servicioNombre = servicioNombre;
		this.idMenuPrincipal = idMenuPrincipal;
		this.cdAplicacion = cdAplicacion;
		this.perfilId = perfilId;
	}

	@Column(name = "ID", precision = 11, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "MENU_URI", length = 90)
	public String getMenuUri() {
		return this.menuUri;
	}

	public void setMenuUri(String menuUri) {
		this.menuUri = menuUri;
	}

	@Column(name = "SERVICIO_NOMBRE", length = 45)
	public String getServicioNombre() {
		return this.servicioNombre;
	}

	public void setServicioNombre(String servicioNombre) {
		this.servicioNombre = servicioNombre;
	}

	@Column(name = "ID_MENU_PRINCIPAL", precision = 22, scale = 0)
	public Long getIdMenuPrincipal() {
		return this.idMenuPrincipal;
	}

	public void setIdMenuPrincipal(Long idMenuPrincipal) {
		this.idMenuPrincipal = idMenuPrincipal;
	}

	@Column(name = "CD_APLICACION", nullable = false, length = 15)
	public String getCdAplicacion() {
		return this.cdAplicacion;
	}

	public void setCdAplicacion(String cdAplicacion) {
		this.cdAplicacion = cdAplicacion;
	}

	@Column(name = "PERFIL_ID", precision = 22, scale = 0)
	public Long getPerfilId() {
		return this.perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}

	@Override
	public String toString() {
		return "ViewPaginaServicioId [id=" + id + ", menuUri=" + menuUri + ", servicioNombre=" + servicioNombre
				+ ", idMenuPrincipal=" + idMenuPrincipal + ", cdAplicacion=" + cdAplicacion + ", perfilId=" + perfilId
				+ "]";
	}

}

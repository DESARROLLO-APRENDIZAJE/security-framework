package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="V_SE_PAGINA_SERVICIO")
public class ViewPaginaServicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ViewPaginaServicioId id;

	public ViewPaginaServicioDTO() {
	}

	public ViewPaginaServicioDTO(ViewPaginaServicioId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ID", precision = 11, scale = 0)),
			@AttributeOverride(name = "menuUri", column = @Column(name = "MENU_URI", length = 90)),
			@AttributeOverride(name = "servicioNombre", column = @Column(name = "SERVICIO_NOMBRE", length = 45)),
			@AttributeOverride(name = "idMenuPrincipal", column = @Column(name = "ID_MENU_PRINCIPAL", precision = 22, scale = 0)),
			@AttributeOverride(name = "idAplicacion", column = @Column(name = "ID_APLICACION", precision = 11, scale = 0)),
			@AttributeOverride(name = "perfilId", column = @Column(name = "PERFIL_ID", precision = 22, scale = 0)) })
	public ViewPaginaServicioId getId() {
		return this.id;
	}

	public void setId(ViewPaginaServicioId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ViewPaginaServicioDTO [id=" + id + "]";
	}
	
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.seguridad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "TAQ032C_SE_SERVICIO_REST")
public class ServicioRestDTO implements Serializable, GrantedAuthority  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2396188251933895495L;

	@Id
	@Column(name = "ID_SERVICIO", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idServicio;

	@Column(name = "NB_SERVICIO", nullable = false, length = 100)
	private String nbServicio;

	@Column(name = "CD_SERVICIO", nullable = false, length = 15)
	private String cdServicio;

	@Column(name = "TX_DESCRIPCION", length = 250)
	private String txDescripcion;

	@Column(name = "ST_ACTIVO", nullable = false, length = 1)
	private Long stActivo;

	@Column(name = "ID_USR_CREACION", nullable = false, length = 11)
	private Long idUsrCreacion;

	@Column(name = "FH_CREACION", nullable = false, length = 7)
	private Date fhCreacion;

	@Column(name = "ID_USR_MODIFICA", nullable = false, length = 11)
	private Long idUsrModifica;

	@Column(name = "FH_MODIFICACION", nullable = false, length = 7)
	private Date fhModificacion;

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNbServicio() {
		return nbServicio;
	}

	public void setNbServicio(String nbServicio) {
		this.nbServicio = nbServicio;
	}

	public String getCdServicio() {
		return cdServicio;
	}

	public void setCdServicio(String cdServicio) {
		this.cdServicio = cdServicio;
	}

	public String getTxDescripcion() {
		return txDescripcion;
	}

	public void setTxDescripcion(String txDescripcion) {
		this.txDescripcion = txDescripcion;
	}

	public Long getStActivo() {
		return stActivo;
	}

	public void setStActivo(Long stActivo) {
		this.stActivo = stActivo;
	}

	public Long getIdUsrCreacion() {
		return idUsrCreacion;
	}

	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	public Date getFhCreacion() {
		return fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getIdUsrModifica() {
		return idUsrModifica;
	}

	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	public Date getFhModificacion() {
		return fhModificacion;
	}

	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nbServicio;
	}

}

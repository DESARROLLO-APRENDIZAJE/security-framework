package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;
import java.util.Date;

public class BitacoraCambiosVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long cambioId;
	private Long componenteId;
	private Long conceptoId;
	private String valorOriginal;
	private String valorFinal;
	private Date fechaCreacion;
	private Long creadoPor;
	private String idRegistro;
	private String idRegistroDescripcion;
	private String origen;
	private Date fechaEnvioSf;
	private String table;
	
	public BitacoraCambiosVO(){
		super();
		
	}

	public BitacoraCambiosVO(String table, Long componenteId, Long conceptoId, String valorOriginal, String valorFinal,Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen) {
		super();
 		this.componenteId = componenteId;
		this.conceptoId = conceptoId;
		this.valorOriginal = valorOriginal;
		this.valorFinal = valorFinal;
		this.creadoPor = creadoPor;
		this.idRegistro = idRegistro;
		this.idRegistroDescripcion = idRegistroDescripcion;
		this.origen = origen;
		this.table = table;
	}

	public BitacoraCambiosVO(Long cambioId, Long componenteId, Long conceptoId, String valorOriginal, String valorFinal,
			Date fechaCreacion, Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen,
			Date fechaEnvioSf, String table) {
		super();
		this.cambioId = cambioId;
		this.componenteId = componenteId;
		this.conceptoId = conceptoId;
		this.valorOriginal = valorOriginal;
		this.valorFinal = valorFinal;
		this.fechaCreacion = fechaCreacion;
		this.creadoPor = creadoPor;
		this.idRegistro = idRegistro;
		this.idRegistroDescripcion = idRegistroDescripcion;
		this.origen = origen;
		this.fechaEnvioSf = fechaEnvioSf;
		this.table = table;
	}

	public Long getCambioId() {
		return cambioId;
	}

	public void setCambioId(Long cambioId) {
		this.cambioId = cambioId;
	}

	public Long getComponenteId() {
		return componenteId;
	}

	public void setComponenteId(Long componenteId) {
		this.componenteId = componenteId;
	}

	public Long getConceptoId() {
		return conceptoId;
	}

	public void setConceptoId(Long conceptoId) {
		this.conceptoId = conceptoId;
	}

	public String getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(String valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}
	

	public String getIdRegistroDescripcion() {
		return idRegistroDescripcion;
	}

	public void setIdRegistroDescripcion(String idRegistroDescripcion) {
		this.idRegistroDescripcion = idRegistroDescripcion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Date getFechaEnvioSf() {
		return fechaEnvioSf;
	}

	public void setFechaEnvioSf(Date fechaEnvioSf) {
		this.fechaEnvioSf = fechaEnvioSf;
	}

}
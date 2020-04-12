package mx.com.aprendizaje.arquitectura.ortogonales.reporte.vo;

import java.util.List;

public class PeticioReporteVO {

	private PropiedadesReporte propiedadesReporte;
	private List<Object> encabezado;
	private List<Object> contenido;
	private String parametro;

	public PeticioReporteVO(){}
	
	public PeticioReporteVO(PropiedadesReporte propiedadesReporte,List<Object> encabezado,List<Object> contenido){
		this.propiedadesReporte = propiedadesReporte;
		this.encabezado = encabezado;
		this.contenido = contenido;
	}
	
	public PropiedadesReporte getPropiedadesReporte() {
		return propiedadesReporte;
	}

	public void setPropiedadesReporte(PropiedadesReporte propiedadesReporte) {
		this.propiedadesReporte = propiedadesReporte;
	}

	public List<Object> getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(List<Object> encabezado) {
		this.encabezado = encabezado;
	}

	public List<Object> getContenido() {
		return contenido;
	}

	public void setContenido(List<Object> contenido) {
		this.contenido = contenido;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	

}

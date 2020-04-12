package mx.com.aprendizaje.arquitectura.ortogonales.reporte.genera;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aprendizaje.arquitectura.ortogonales.reporte.componente.StyleComponenteExcel;
import mx.com.aprendizaje.arquitectura.ortogonales.reporte.service.AbstractReporteService;
import mx.com.aprendizaje.arquitectura.ortogonales.reporte.vo.PeticioReporteVO;

@Service("reporteExcel")
public class ReporteExcel extends AbstractReporteService {

	public static int DEFAULT_WINDOW_SIZE = 50000;
	public static int LIMITE_HOJA = 64980;
	
	@Autowired
	private StyleComponenteExcel estilo;

	@Override
	public ByteArrayOutputStream generaReporte(PeticioReporteVO voPeticion) throws IOException {
		int windowSize = 50000;
		if(voPeticion.getParametro() != null)
			windowSize = Integer.parseInt(voPeticion.getParametro());
		Workbook  libroExcel = new SXSSFWorkbook(windowSize);
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		estilo.formato(libroExcel);
		
		if(voPeticion.getPropiedadesReporte().isStMultiplehoja()){
			estilo.generarHojasPaginable(libroExcel, voPeticion);
		}else{
			estilo.generarHojas(libroExcel, voPeticion);
		}
		libroExcel.write(response);
		response.flush();
		return response;
		//incializr libro		
	}
	
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.bitacora;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.bitacora.BitacoraCambiosDAO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.BitacoraCambiosVO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosServiceImpl
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017 
 */
 
@Service("bitacoraCambiosService")
public class BitacoraCambiosServiceImpl implements BitacoraCambiosService {
	
	@Autowired
	private BitacoraCambiosDAO bitacoraCambiosDAO;

	@Override
	@Transactional
	public int guardarBitacoraCambios(BitacoraCambiosVO bitacoraCambiosVO) {
		 return guardarBitacoraCambiosParametros(bitacoraCambiosVO.getTable(), bitacoraCambiosVO.getComponenteId(), bitacoraCambiosVO.getConceptoId(), bitacoraCambiosVO.getValorOriginal()
				, bitacoraCambiosVO.getValorFinal(), bitacoraCambiosVO.getCreadoPor(), bitacoraCambiosVO.getIdRegistro(),bitacoraCambiosVO.getIdRegistroDescripcion(), bitacoraCambiosVO.getOrigen());
	
  	}

	@Override
	@Transactional
	public Map<Integer, BitacoraCambiosVO> guardarListaBitacoraCambios(List<BitacoraCambiosVO> listaBitacoraCambiosVO) {
 
		 Map<Integer, BitacoraCambiosVO> map = new HashMap<Integer, BitacoraCambiosVO>();
		 Integer resultado;
		for (BitacoraCambiosVO bitacoraCambiosVO : listaBitacoraCambiosVO) {
			
			
			resultado = guardarBitacoraCambiosParametros(bitacoraCambiosVO.getTable(), bitacoraCambiosVO.getComponenteId(), bitacoraCambiosVO.getConceptoId(), bitacoraCambiosVO.getValorOriginal()
						, bitacoraCambiosVO.getValorFinal(), bitacoraCambiosVO.getCreadoPor(), bitacoraCambiosVO.getIdRegistro(),bitacoraCambiosVO.getIdRegistroDescripcion(), bitacoraCambiosVO.getOrigen());

			map.put(resultado, bitacoraCambiosVO);

		}
	
		return map;
	}
 
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public int guardarBitacoraCambiosParametros(String tabla, Long componenteId, Long conceptoId, String valorOriginal,
			String valorFinal, Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen) {
		 
		return bitacoraCambiosDAO.guardarBitacoraCambiosParametros(tabla, componenteId, conceptoId, valorOriginal, valorFinal, creadoPor, idRegistro,idRegistroDescripcion, origen);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public int guardarBitacoraCambiosParametrosFinanzas(String tabla, Long componenteId, Long conceptoId,
			String valorOriginal, String valorFinal, Long creadoPor, String idRegistro,  String idRegistroDescripcion, String origen,
			Date fechaEnvioSf) {
		return bitacoraCambiosDAO.guardarBitacoraCambiosParametrosFinanzas(tabla, componenteId, conceptoId, valorOriginal, valorFinal, creadoPor, idRegistro, idRegistroDescripcion, origen,fechaEnvioSf);
 	}
//	
//	/**
//	 * {@inheritDoc}
//	 */
//	@Transactional
//	public int guardarBitacoraCambiosParametros(String tabla, Long componenteId, Long conceptoId, String valorOriginal,
//			String valorFinal, Long modificadoPor, Long idRegistro, String idRegistroDescripcion, String origen) {
//		return bitacoraCambiosDAO.guardarBitacoraCambiosParametros(tabla, componenteId, conceptoId, valorOriginal, valorFinal, modificadoPor, idRegistro,idRegistroDescripcion, origen);
// 	}
//	
//	/**
//	 * {@inheritDoc}
//	 */
//	@Transactional
//	public int guardarBitacoraCambiosParametrosFinanzas(String tabla, Long componenteId, Long conceptoId,
//			String valorOriginal, String valorFinal, Long modificadoPor, Long idRegistro, String idRegistroDescripcion, String origen,
//			Date fechaEnvioSf) {
// 		return bitacoraCambiosDAO.guardarBitacoraCambiosParametrosFinanzas(tabla, componenteId, conceptoId, valorOriginal, valorFinal, modificadoPor, idRegistro, idRegistroDescripcion, origen, fechaEnvioSf);
//	}




	
}

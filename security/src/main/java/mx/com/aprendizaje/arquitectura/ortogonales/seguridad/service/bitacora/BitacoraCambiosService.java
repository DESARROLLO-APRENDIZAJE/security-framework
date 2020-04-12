package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.service.bitacora;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.BitacoraCambiosVO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosService
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017
 */ 

public interface BitacoraCambiosService {
 
	/**
	 * {@inheritDoc}
     * Guarda un objeto en bitacora Cabios de tipo BitacoraCambiosDTO.
     * 
     * @param BitacoraCambiosVO  Entidad a persistir
     * @return int 
     */
	int guardarBitacoraCambios(BitacoraCambiosVO bitacoraCambiosVO);
	
	/**
	 *{@inheritDoc}
     * Guarda una lista de  objetos de tipo BitacoraCambiosVO ,   donde la tabla puede ser cualquier nombre con la misma estructura
     * 
     * @param List<BitacoraCambiosVO>
     * @return int  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	Map<Integer, BitacoraCambiosVO> guardarListaBitacoraCambios(List<BitacoraCambiosVO> listaBitacoraCambiosVO);

 
    /**
     *{@inheritDoc}
     * Guarda en tablas de tipo Bitacora_Cambios de forma dinamica. T+CODIGO_APLICACI�N+BITACORA_CAMBIOS]
     * 
     * @param tabla 		  	Nombre de la tabla en donde se va a persistir la informaci�n.
     * @param componenteId  	Id del componente.
     * @param conceptoId  		Id del concepto.
     * @param valorOriginal 	Valor Original del registro. 
     * @param valorFinal  		Valor final del registro.
     * @param creadoPor  	  	Id del usuario que  realiza el cambio, en caso de no tener usuario firmado guardar 0
     * @param idRegistro    	Id del registro al que se realiz� el cambio.
     * @param idRegistroDescripcion Descripcion del registro modificado.
     * @param origen      		Origen del bitacoreo, [W - Aplicaciones web, Web Service, H - Hand Held]
      * @return  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosParametros(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen );


	
	/**
	 *{@inheritDoc}
     * Guarda en tablas de tipo Bitacora_Cambios de forma dinamica. T+CODIGO_APLICACI�N+BITACORA_CAMBIOS], metodo con parametro para guardar fecha envio a finanzas
     * 
     * @param  tabla 		  	Nombre de la tabla en donde se va a persistir la informaci�n.
     * @param  componenteId  	Id del componente. 
     * @param  conceptoId  		Id del concepto. 
     * @param  valorOriginal 	Valor Original del registro. 
     * @param  valorFinal  		Valor final del registro.
     * @param  creadoPor  	  	Id que realiza el cambio. 
     * @param  idRegistro    	Id de registro que se va a bitacorear.
     * @param idRegistroDescripcion Descripcion del registro modificado.
     * @param  origen      		Origen del bitacoreo.
     * @param  fechaEnvioSf   	Fecha de envio a finanzas en caso de ser necesario.
      * @return  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosParametrosFinanzas(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long creadoPor, String idRegistro,  String idRegistroDescripcion, String origen, Date fechaEnvioSf);

	
	
	/**
     * Guarda en tabla actual  BITACORA_CAMBIOS

     * 
     * @param tabla 		  	Nombre de la tabla en donde se va a persistir la informaci�n.
     * @param componenteId  	Id del componente. 
     * @param conceptoId  		Id del concepto. 
     * @param valorOriginal 	Valor Original del registro. 
     * @param valorFinal  		Valor final del registro.
     * @param modificadoPor  	Id del usuario que  realiza el cambio, en caso de no tener usuario firmado guardar 99.
     * @param idRegistroDescripcion Descripcion del registro modificado.
     * @param idRegistro    	Id del registro que se realiz� el cambio.
     * @param origen      		Origen del bitacoreo, [W - Aplicaciones web, Web Service, H - Hand Held].
 
     * @return   [1 si se persiste correctamente , 0 si no se persiste la entidad].
     */
	 
//	int guardarBitacoraCambiosParametros(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long modificadoPor, Long idRegistro,  String idRegistroDescripcion, String origen );

	
	
	
	/**
     * Guarda en tabla actual  BITACORA_CAMBIOS,  metodo con parametro para guardar fecha envio a finanzas

     * 
     * @param tabla 		  	Nombre de la tabla en donde se va a persistir la informaci�n.
     * @param componenteId  	Id del componente. 
     * @param conceptoId  		Id del concepto. 
     * @param valorOriginal 	Valor Original del registro. 
     * @param valorFinal  		Valor final del registro.
     * @param modificadoPor  	Id del usuario que  realiza el cambio, en caso de no tener usuario firmado guardar 99. 
     * @param idRegistroDescripcion Descripcion del registro modificado.
     * @param idRegistro    	Id del registro que se realiz� el cambio.
     * @param origen      		Origen del bitacoreo, [W - Aplicaciones web, Web Service, H - Hand Held].
 
     * @return   [1 si se persiste correctamente , 0 si no se persiste la entidad].
     */
//	int guardarBitacoraCambiosParametrosFinanzas(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long modificadoPor, Long idRegistro,  String idRegistroDescripcion,  String origen,Date fechaEnvioSf );

	
	
	
}

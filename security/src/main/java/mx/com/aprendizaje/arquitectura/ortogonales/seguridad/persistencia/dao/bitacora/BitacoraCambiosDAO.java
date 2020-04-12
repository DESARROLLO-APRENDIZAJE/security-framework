package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.bitacora;

import java.util.Date;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDao;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.bitacora.BitacoraCambiosDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.BitacoraCambiosVO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosDAO
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017
 */
 
public interface BitacoraCambiosDAO extends BaseDao<BitacoraCambiosDTO>{
	
	/**
     * Busca una entidad de tipo bitacora por medio de IdBitacoraCambio.
     * 
     * @param Long  idBitacoraCambio
     * @return BitacoraCambiosDTO Entidad encontrada. 
     */ 
    BitacoraCambiosDTO buscarBitacoraCambios(Long idBitacoraCambio);
    
    /**
     * Guarda un objeto en bitacora Cabios de tipo BitacoraCambiosDTO.
     * 
     * @param ConfiguracionDTO  bitacoraCambiosDTO
     * @return BitacoraCambiosDTO Entidad persitida 
     */
    
	BitacoraCambiosDTO guardarBitacoraCambios(BitacoraCambiosDTO bitacoraCambiosDTO);	
	
	/**
     * Guarda un objeto de tipo BitacoraCambios , de manera dinamico , donde la tabla puede ser cualquier nombre con la misma estructura
     * 
     * @param   bitacoraCambiosVO
     * @return   [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosDinamico(BitacoraCambiosVO bitacoraCambiosVO);
	
	
	/**
     * Guarda un objeto de tipo BitacoraCambios , de manera dinamica , donde la tabla puede ser cualquier nombre con la misma estructura
     * 
     * @param  tabla 		  	Nombre de la tabla en donde se va a persistir la informacion
     * @param  componenteId  	Id del componente 
     * @param  conceptoId  		Id del concepto 
     * @param  valorOriginal	Valor Original del registro 
     * @param  valorFinal  		Valor final del registro
     * @param  creadoPor  	  	Id que realiza el cambio 
     * @param  idRegistro    	Id de registro que se va a bitacorear
     * @param  origen      		Origen del bitacoreo
     * @param  fechaEnvioSf   	Fecha de envio a finanzas en caso de ser necesario.
 
     * @return int  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosParametros(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long creadoPor, String idRegistro,String idRegistroDescripcion, String origen );

	/**
     * Guarda un objeto de tipo BitacoraCambios , de manera dinamica , donde la tabla puede ser cualquier nombre con la misma estructura,  metodo adecuado para guardar fecha envio a fnanzas
     * 
     * @param  tabla 		  	Nombre de la tabla en donde se va a persistir la informacion
     * @param  componenteId  	Id del componente 
     * @param  conceptoId  		Id del concepto 
     * @param  valorOriginal 	Valor Original del registro 
     * @param  valorFinal  		Valor final del registro
     * @param  creadoPor  	  	Id que realiza el cambio 
     * @param  idRegistro    	Id de registro que se va a bitacorear
     * @param  origen      		Origen del bitacoreo
     * @param  fechaEnvioSf   	Fecha de envio a finanzas en caso de ser necesario.
 
     * @return int  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosParametrosFinanzas(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long creadoPor, String idRegistro, String idRegistroDescripcion,String origen, Date fechaEnvioSf);

	
	/**
     *Guarda en tabla actual  BITACORA_CAMBIOS 
     * 
     * @param  tabla 		  	Nombre de la tabla en donde se va a persistir la informacion
     * @param  componenteId  	Id del componente 
     * @param  conceptoId  	Id del concepto 
     * @param  valorOriginal Valor Original del registro 
     * @param  valorFinal  	Valor final del registro
     * @param  modificadoPor  	Id que realiza el cambio 
     * @param  idRegistro    	Id de registro que se va a bitacorear
     * @param  origen      	Origen del bitacoreo
     * @param  fechaEnvioSf   	Fecha de envio a finanzas en caso de ser necesario.
 
     * @return int  [1 si se persiste correctamente , 0 si no se persiste la entidad]
     */
	int guardarBitacoraCambiosParametros(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long modificadoPor, Long idRegistro, String  idRegistroDescripcion, String origen );

	
	

	/**
     * Guarda en tabla actual  BITACORA_CAMBIOS,  metodo con parametro para guardar fecha envio a finanzas

     * 
     * @param tabla 		  	Nombre de la tabla en donde se va a persistir la informaci�n.
     * @param componenteId  	Id del componente. 
     * @param conceptoId  		Id del concepto. 
     * @param valorOriginal 	Valor Original del registro. 
     * @param valorFinal  		Valor final del registro.
     * @param modificadoPor  	Id del usuario que  realiza el cambio, en caso de no tener usuario firmado guardar 99. 
     * @param idRegistro    	Id del registro que se realiz� el cambio.
     * @param origen      		Origen del bitacoreo, [W - Aplicaciones web, Web Service, H - Hand Held].
 
     * @return   [1 si se persiste correctamente , 0 si no se persiste la entidad].
     */
	int guardarBitacoraCambiosParametrosFinanzas(String tabla,Long componenteId,Long conceptoId, String valorOriginal, String valorFinal,Long modificadoPor, Long idRegistro,String idRegistroDescripcion, String origen,Date fechaEnvioSf );

	
	
	
	
}

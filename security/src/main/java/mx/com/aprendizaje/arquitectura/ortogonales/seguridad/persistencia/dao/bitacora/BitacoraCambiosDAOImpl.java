package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dao.bitacora;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao.BaseDaoHibernate;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.dto.bitacora.BitacoraCambiosDTO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.BitacoraCambiosVO;

/**
	 * Copyright (c) 2016, Teclo Mexicana.
	 * Descripcion					: BitacoraCambiosDAOImpl
	 * Historial de Modificaciones	:
	 * Descripcion del Cambio		: Creacion
	 * @author 						: fjmb 
	 * @version 					: 1.0
	 * Fecha						: 03/Julio/2017
 */
 
@Repository("bitacoraCambiosDAO")
public 	class  BitacoraCambiosDAOImpl extends BaseDaoHibernate<BitacoraCambiosDTO> implements 	BitacoraCambiosDAO
{
	private static final Logger logger = Logger.getLogger(BitacoraCambiosDAOImpl.class);
	
	 
	@Override
	public BitacoraCambiosDTO buscarBitacoraCambios(Long idBitacoraCambio) 
	{
		logger.info("Buscado Bit�cora con el id: "+ idBitacoraCambio);
		BitacoraCambiosDTO bitacoraCambiosDTO =null;
 		bitacoraCambiosDTO = findById(idBitacoraCambio);
		
 		return bitacoraCambiosDTO;
	}
	
 
	@Override
	public BitacoraCambiosDTO guardarBitacoraCambios(BitacoraCambiosDTO bitCambiosDTO) 
	{
		logger.info("Guardando Bitacora : "+ bitCambiosDTO.toString());

		BitacoraCambiosDTO bitacoraCambiosDTO=null;
  		bitacoraCambiosDTO =saveOrUpdate(bitCambiosDTO);
 		
		return   bitacoraCambiosDTO;
	}
	
	@Override
	public int guardarBitacoraCambiosDinamico(BitacoraCambiosVO bitacoraCambiosVO)
	{
			logger.info("Guardando Bitacora Dinamica en la tabla  : "+ bitacoraCambiosVO.getTable());

   		    SQLQuery sql = getSession().createSQLQuery("insert into " + bitacoraCambiosVO.getTable() + " (componente_id, concepto_id,valor_original, valor_final, creado_por, id_registro,origen,fecha_envio_sf) values (?,?,?,?,?,?,?,?)");
   		   
   		    sql.setLong(   0, bitacoraCambiosVO.getComponenteId());
  		    sql.setLong(   1, bitacoraCambiosVO.getConceptoId());
  		    sql.setString( 2, bitacoraCambiosVO.getValorOriginal());
  		    sql.setString( 3, bitacoraCambiosVO.getValorFinal());
   		    sql.setLong(   4, bitacoraCambiosVO.getCreadoPor());
  		    sql.setString(   5, bitacoraCambiosVO.getIdRegistro());
  		    sql.setString( 6, bitacoraCambiosVO.getOrigen());
  		    sql.setDate(   7, bitacoraCambiosVO.getFechaEnvioSf());
  		    
  		  int result =sql.executeUpdate();	
  		  
  		  return  result;
  		  
	}


	@Override
	public int guardarBitacoraCambiosParametros(String tabla,Long componenteId, Long conceptoId, String valorOriginal,
			String valorFinal, Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen ) {
 
		    SQLQuery sql = getSession().createSQLQuery("insert into " + tabla + " (componente_id, concepto_id,valor_original, valor_final, creado_por, id_registro, id_registro_descripcion, origen ) values (?,?,?,?,?,?,?,?)");
		   
		    sql.setLong(   0, componenteId);
		    sql.setLong(   1, conceptoId);
		    sql.setString( 2, valorOriginal);
		    sql.setString( 3, valorFinal);
 		    sql.setLong(   4, creadoPor);
		    sql.setString( 5, idRegistro);
		    sql.setString( 6, idRegistroDescripcion);
		    sql.setString( 7, origen);
 		    
		  int result =sql.executeUpdate();	
		  
		  return  result;		 
	}
	
	@Override
	public int guardarBitacoraCambiosParametrosFinanzas(String tabla,Long componenteId, Long conceptoId, String valorOriginal,
			String valorFinal, Long creadoPor, String idRegistro, String idRegistroDescripcion, String origen, Date fechaEnvioSf) {
 
		    SQLQuery sql = getSession().createSQLQuery("insert into " + tabla + " (componente_id, concepto_id,valor_original, valor_final, creado_por, id_registro, id_registro_descripcion, origen, fecha_envio_sf) values (?,?,?,?,?,?,?,?,?)");
		   
		    sql.setLong(   0, componenteId);
		    sql.setLong(   1, conceptoId);
		    sql.setString( 2, valorOriginal);
		    sql.setString( 3, valorFinal);
 		    sql.setLong(   4, creadoPor);
		    sql.setString( 5, idRegistro);
		    sql.setString( 6, idRegistroDescripcion);
		    sql.setString( 7, origen);
		    sql.setDate(   8, fechaEnvioSf);
		    
		  int result =sql.executeUpdate();	
		  
		  return  result;		 
	}


	@Override
	public int guardarBitacoraCambiosParametros(String tabla, Long componenteId, Long conceptoId, String valorOriginal,
			String valorFinal, Long modificadoPor, Long idRegistro, String idRegistroDescripcion,String origen) {
		 
			 
	    SQLQuery sql = getSession().createSQLQuery("insert into " + tabla + " (componente_id, concepto_id,valor_original, valor_final, modificado_por, id_registro,id_registro_descripcion,origen ) values (?,?,?,?,?,?,?,?)");
		   
		    sql.setLong(   0, componenteId);
		    sql.setLong(   1, conceptoId);
		    sql.setString( 2, valorOriginal);
		    sql.setString( 3, valorFinal);
 		    sql.setLong(   4, modificadoPor);
		    sql.setLong(   5, idRegistro);
		    sql.setString( 6, idRegistroDescripcion);
		    sql.setString( 7, origen);
		    
		  int result =sql.executeUpdate();	
		  
		  return  result;		
	}
	
	@Override
	public int guardarBitacoraCambiosParametrosFinanzas(String tabla, Long componenteId, Long conceptoId, String valorOriginal,
			String valorFinal, Long modificadoPor, Long idRegistro,String idRegistroDescripcion, String origen, Date fechaEnvioSf) {
		 
			 
	    SQLQuery sql = getSession().createSQLQuery("insert into " + tabla + " (componente_id, concepto_id,valor_original, valor_final, modificado_por, id_registro,id_registro_descripcion ,origen,fecha_envio_sf ) values (?,?,?,?,?,?,?,?,?)");
		   
		    sql.setLong(   0, componenteId);
		    sql.setLong(   1, conceptoId);
		    sql.setString( 2, valorOriginal);
		    sql.setString( 3, valorFinal);
 		    sql.setLong(   4, modificadoPor);
		    sql.setLong(   5, idRegistro);
		    sql.setString( 6, idRegistroDescripcion);
		    sql.setString( 7, origen);
		    sql.setDate(   8, fechaEnvioSf);

		  int result =sql.executeUpdate();	
		  
		  return  result;		
	}
}

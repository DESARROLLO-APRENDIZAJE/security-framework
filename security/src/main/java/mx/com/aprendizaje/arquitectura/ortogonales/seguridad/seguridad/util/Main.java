package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ClienteVO;

public class Main {

	public static void main(String[] args) throws Exception {
		final int MIN_LENGTH = 10;

		PasswordUtils main=new PasswordUtils();
		TokenUtils tu= new TokenUtils();
		String randomPassword =  main.randomPassword(MIN_LENGTH);
		ClienteVO usuarioFirmadoVO= new ClienteVO("TecloPruebas123", randomPassword);
		usuarioFirmadoVO.setTiempoExpiracion(100L);
		System.out.println("Usuario: " + usuarioFirmadoVO.getUsername() );
		System.out.println("Password Aleatorio Servicio: " + randomPassword );
		System.out.println(tu.generateClientToken(usuarioFirmadoVO));
 
		
	}
	
	
	 
	
}
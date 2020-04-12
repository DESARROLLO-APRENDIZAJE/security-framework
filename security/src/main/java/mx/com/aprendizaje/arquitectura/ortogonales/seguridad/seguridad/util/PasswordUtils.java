package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {
	
	/**
	 * Password generator function. it will return null if the input is lower or equals to 5
	 * @param passwordLength
	 * @return String
	 * @throws Exception
	 */
	public String randomPassword(int passwordLength) throws Exception{
		
		if(passwordLength<=5) return null;

		java.util.Random r = new java.util.Random();

		/*
		* Set of characters. This is limited to numbers and letters for error issues.
		*/
		char[] cadenaCaracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
		'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
		'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'2', '3', '4', '5', '6', '7', '8', '9','.', '-', '!', '?', '_','�','*','#','$','=' };

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < passwordLength; i++) {
			sb.append(cadenaCaracteres[r.nextInt(cadenaCaracteres.length)]);
		}

		return sb.toString();
	}
}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.ClienteVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo.UsuarioFirmadoVO;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.dto.webservice.TokenUsuarioFuncionDTO;

@Component
public class TokenUtils {

	private final String AUDIENCE_MOBILE = "mobile";
	private final String AUDIENCE_TABLET = "tablet";

	private String secret = "banana";

	public String getUserNameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			created = new Date((Long) claims.get("created"));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public String getFuncionPassword(String token) {
		String funcionPassword;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			funcionPassword = (String) claims.get("funcionPassword");
		} catch (Exception e) {
			funcionPassword = null;
		}
		return funcionPassword;
	}

	public String getUserNumFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			audience = (String) claims.get("userNum");
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			audience = (String) claims.get("audience");
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	private Date generateExpirationDate(Long tiempoExpiracion) {
		return new Date(System.currentTimeMillis() + tiempoExpiracion * 60000);
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(this.generateCurrentDate());
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	private Boolean ignoreTokenExpiration(String token) {
		String audience = this.getAudienceFromToken(token);
		return (this.AUDIENCE_TABLET.equals(audience) || this.AUDIENCE_MOBILE.equals(audience));
	}

	public String generateToken(UserDetails userDetails) {
		UsuarioFirmadoVO usuarioFirmadoVO = (UsuarioFirmadoVO) userDetails;
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", usuarioFirmadoVO.getLogin());
		claims.put("name", usuarioFirmadoVO.getUsername());
		claims.put("pages", usuarioFirmadoVO.getPaginasAcceso());
		claims.put("perfil", usuarioFirmadoVO.getPerfilNombre());
		claims.put("inactivity", usuarioFirmadoVO.getTiempoInactividad());
		claims.put("audience", "web");
		claims.put("email",usuarioFirmadoVO.getEmail());
		claims.put("created", this.generateCurrentDate());

		return this.generateToken(claims, usuarioFirmadoVO);
	}

	public String generateClientToken(UserDetails userDetails) {
		ClienteVO usuarioFirmadoVO = (ClienteVO) userDetails;
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", usuarioFirmadoVO.getUsername());
		claims.put("name", usuarioFirmadoVO.getUsername());
		claims.put("funcionPassword", usuarioFirmadoVO.getPassword());
		claims.put("created", this.generateCurrentDate());

		return this.generateToken(claims);
	}

	// Version 3.2.7
	public String generateClientToken(TokenUsuarioFuncionDTO dto) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", dto.getUsuario().getUsuario());
		// claims.put("name", dto.getCliente().getUsuarioCliente());
		claims.put("funcionPassword", dto.getFuncionPassword());
		claims.put("created", this.generateCurrentDate());

		return this.generateToken(claims);
	}

	private String generateToken(Map<String, Object> claims) {// , ClienteVO
																// usuarioFirmadoVO)
																// {
		return Jwts.builder().setClaims(claims)
				// .setExpiration(this.generateExpirationDate(usuarioFirmadoVO.getTiempoExpiracion()))
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}

	private String generateToken(Map<String, Object> claims, UsuarioFirmadoVO usuarioFirmadoVO) {
		return Jwts.builder().setClaims(claims)
				.setExpiration(this.generateExpirationDate(usuarioFirmadoVO.getTiempoExpiracion()))
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = this.getCreatedDateFromToken(token);
		return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset))
				&& (!(this.isTokenExpired(token)) || this.ignoreTokenExpiration(token)));
	}

	// Valida Token de las aplicaciones
	public String refreshToken(String token, UsuarioFirmadoVO usuarioFirmadoVO) {
		String refreshedToken;
		try {
			Claims claims = this.getClaimsFromToken(token);
			claims.put("created", this.generateCurrentDate());
			claims.put("inactivity", usuarioFirmadoVO.getTiempoInactividad());
			refreshedToken = this.generateToken(claims, usuarioFirmadoVO);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	// Valida Token de las aplicaciones
	public Boolean validateToken(String token, UserDetails userDetails) {
		UsuarioFirmadoVO user = (UsuarioFirmadoVO) userDetails;
		final String username = this.getUserNameFromToken(token);
		final Date created = this.getCreatedDateFromToken(token);
		return (username.equals(user.getLogin()) && !(this.isTokenExpired(token))
				&& !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
	}

	// Valida Token de web Service *Ignora el tiempo de expiracion
	public Boolean validateApiKey(String token, UserDetails userDetails) {
		ClienteVO user = (ClienteVO) userDetails;
		final String username = this.getUserNameFromToken(token);
		return (username.equals(user.getUsername()));
		// return (username.equals(user.getLogin()) &&
		// !(this.isCreatedBeforeLastPasswordReset(created,
		// user.getLastPasswordReset())));
	}

}

package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.filtro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util.TokenUtils;


public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

	public final String tokenHeader = "X-Auth-Token";
 
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	@Qualifier("customUserDetailService")
	private  UserDetailsService userDetailsService;
	
	@Value("${app.config.authType}")
	private String authType;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(tokenHeader);
		
		String username="";
		if (authType.equals("AUTH_NUM"))
			  username= this.tokenUtils.getUserNumFromToken(authToken);
		else
	 		  username = this.tokenUtils.getUserNameFromToken(authToken);

 
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (this.tokenUtils.validateToken(authToken, userDetails)) {

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}
	
 
}

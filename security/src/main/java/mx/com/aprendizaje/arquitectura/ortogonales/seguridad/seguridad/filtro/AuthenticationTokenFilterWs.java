package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.filtro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.facade.UserDetailsServiceCustom;
import mx.com.aprendizaje.arquitectura.ortogonales.seguridad.seguridad.util.TokenUtils;
 
public class AuthenticationTokenFilterWs extends UsernamePasswordAuthenticationFilter {

	public final String tokenHeader = "Authorization";

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	@Qualifier("userDetailsWebService")
	private UserDetailsServiceCustom userDetailsService;
	
 	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(tokenHeader);
		String username = this.tokenUtils.getUserNameFromToken(authToken);
		String innerToken = this.tokenUtils.getFuncionPassword(authToken);
		String serviceName = httpRequest.getPathInfo();	
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			try {
				UserDetails userDetails = null;
			 
				userDetails = this.userDetailsService.loadUserByUsername(innerToken, username, serviceName);
				if (this.tokenUtils.validateApiKey(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}catch(Exception e){
 			}
		}
		chain.doFilter(request, response);
	}
}

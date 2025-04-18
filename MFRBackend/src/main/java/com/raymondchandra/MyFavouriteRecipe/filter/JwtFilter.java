package com.raymondchandra.MyFavouriteRecipe.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.raymondchandra.MyFavouriteRecipe.service.JWTService;
import com.raymondchandra.MyFavouriteRecipe.service.UserDetailsServiceImplementation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// For every request, this filter should be executed once
@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	ApplicationContext context;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Get the Bearer token
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ") ) {
			// Get only the token value
			token = authHeader.split(" ")[1];
			
			// Calling the extractUserName() that we made
			username = jwtService.extractUserName(token);
		}
		
		// SecurityContextHolder.getContext().getAuthentication() is null because
		// it has not been authenticated yet
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			// Getting the userDetails
			UserDetails userDetails = context.getBean(UserDetailsServiceImplementation.class).loadUserByUsername(username);
			
			// Calling the validateToken() that we made
			if(jwtService.validateToken(token, userDetails)) {
				
				// Token will know the user but not the details
				UsernamePasswordAuthenticationToken authToken =
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				// Token will be inserted with the details
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// Adding the token to the chain
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		// 
		filterChain.doFilter(request, response);
	}

}

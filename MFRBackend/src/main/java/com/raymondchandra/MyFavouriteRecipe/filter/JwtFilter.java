package com.raymondchandra.MyFavouriteRecipe.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.raymondchandra.MyFavouriteRecipe.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// For every request, this filter should be executed once
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTService jwtService;
	
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
			
			username = jwtService.extractUserName(token);
		}
		
//		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			if(jwtService.) {
//				
//			}
//		}
	}

}

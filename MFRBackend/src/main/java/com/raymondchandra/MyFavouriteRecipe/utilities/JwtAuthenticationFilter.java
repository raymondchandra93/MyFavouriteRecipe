package com.raymondchandra.MyFavouriteRecipe.utilities;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		// Cast the request to HttpServletRequest to access headers
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		
//		// Extract the "Authorization" header from the request
//		String token = httpRequest.getHeader("Authorization");
//		
//		// If there's a token and it starts with "Bearer ", proceed with further checks
//		if (token != null && token.startsWith("Bearer ")) {
//			token = token.substring(7); // Remove "Bearer " prefix
//			
//			// Extract the username from the token
//			String username = JwtTokenUtility.extractUsername(token);
//			
//			// Check if the username is valid and if there's no existing authentication
//			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//				
//				// Validate the token
//				if (JwtTokenUtility.validateToken(token, username)) {
//					
//					// If the token is valid, set the authentication in the context
//					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//							username, null, new ArrayList<>());
//					SecurityContextHolder.getContext().setAuthentication(authentication);
//				}
//			}
//		}
//		
//		// Continue the filter chain, allowing the request to proceed
//		chain.doFilter(request, response);
//	}
}
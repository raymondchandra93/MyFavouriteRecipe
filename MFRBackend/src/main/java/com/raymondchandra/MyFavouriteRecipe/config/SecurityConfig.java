package com.raymondchandra.MyFavouriteRecipe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//  @Autowired
//  private JwtRequestFilter jwtRequestFilter;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// Disabling the csrf if using token, if session based, it needs to be enabled
        return http.csrf(customizer -> customizer.disable())
        
            .authorizeHttpRequests(request -> request
            		
            		// Permitting all request with this prefix
            		.requestMatchers(
            			"/api/v1/public/**", 
            			"/swagger-ui/**", 
            			"/v3/api-docs/**",
            			"/swagger", 
            			"/api-docs"
            		).permitAll()

//         			.requestMatchers("/admin/**").hasRole("ADMIN")
//    				.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")

            		// Others needs to be authenticated
            		.anyRequest().authenticated()
            		
            )
            
            // Enable basic authentication (uname & pass) but only for APIs, not recommended for web app (JWT is preferred)
            .httpBasic(Customizer.withDefaults())
            
            // Tells Spring Security not to create or use sessions. Important for JWT tokens
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // Build at the end
        	.build();
    }
	
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//		provider.setUserDetailsService(userDetailsService);
//		
//		return provider;
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}
}

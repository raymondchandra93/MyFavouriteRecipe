package com.raymondchandra.MyFavouriteRecipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.raymondchandra.MyFavouriteRecipe.utilities.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
	
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
	
	@Bean
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/public/**").permitAll() 			// Allow login and register endpoints
            .anyRequest().authenticated()  							// All other endpoints require authentication
            .and()
            .addFilter(new JwtAuthenticationFilter()); 				// Add the JWT filter
    }
}

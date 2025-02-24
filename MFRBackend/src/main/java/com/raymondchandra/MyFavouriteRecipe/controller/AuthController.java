package com.raymondchandra.MyFavouriteRecipe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raymondchandra.MyFavouriteRecipe.utilities.JwtTokenUtility;

public class AuthController {
	@PostMapping("/api/v1/public/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
        // You'd typically authenticate using a service, but this is a simplified example
        if ("user".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
            String token = JwtTokenUtility.generateToken(credentials.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

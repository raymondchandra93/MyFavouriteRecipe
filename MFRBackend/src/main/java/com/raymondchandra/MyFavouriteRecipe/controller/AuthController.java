package com.raymondchandra.MyFavouriteRecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
//	@PostMapping("/api/v1/public/login")
//    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
//        // You'd typically authenticate using a service, but this is a simplified example
//        if ("user".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
//            String token = JwtTokenUtility.generateToken(credentials.getUsername());
//            return ResponseEntity.ok(new AuthResponse(token));
//        } else {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }
//    }
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
		
		return ResponseEntity.ok(userService.verify(userDTO));
	}
}

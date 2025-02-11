package com.raymondchandra.MyFavouriteRecipe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.MyFavouriteRecipe.model.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/public/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	// Get test
	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
		
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
	// Get all users
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	// Get a user
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		
		return ResponseEntity.ok(userService.getUser(id));
	}
}

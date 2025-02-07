package com.raymondchandra.MyFavouriteRecipe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// Get all recipes
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllRecipes() {
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
}

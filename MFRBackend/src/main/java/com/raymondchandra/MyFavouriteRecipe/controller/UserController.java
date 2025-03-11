package com.raymondchandra.MyFavouriteRecipe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
	
	// GET a user
	@Operation(summary = "Getting a User", description = "Getting a user from the DB")
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(
			@Parameter(description = "User ID to fetch the details", example = "1")
			@PathVariable Long id
	) {
		
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	// REGISTER User
	@Operation(summary = "Create User", description = "Creating a new user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully retrieved message") 
	})
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
    	UserDTO user = userService.createUser(userDTO);
        
        return ResponseEntity.ok(user);
    }



    // UPDATE User
	@Operation(summary = "Update User", description = "Updating a user from the DB")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
    		@Parameter(description = "User ID to fetch the details", example = "1")
    		@PathVariable Long id, 
    		
    		@RequestBody UserDTO userDTO
    ) {
    	UserDTO updatedUser = userService.updateUser(id, userDTO);
    	
        return ResponseEntity.ok(updatedUser);
    }

    // DELETE User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}

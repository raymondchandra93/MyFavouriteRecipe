package com.raymondchandra.MyFavouriteRecipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.exceptions.UserNotFoundException;
import com.raymondchandra.MyFavouriteRecipe.mapper.UserMapper;
import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final AuthenticationManager authManager;
	private final JWTService jwtService;
	
	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder(12);
	
	// Get all users as DTOs
	public List<UserDTO> getAllUsers() {
		List<User> users = Optional.ofNullable(userRepository.findAll())
				.orElseThrow(() -> new UserNotFoundException("Entity not found"));

		return users.stream()
				.map(userMapper::toUserDTO) // Using the mapper to convert entities to DTOs
				.toList();  
	}

	// Get a users as DTO
	public UserDTO getUser(Long id) {
		User user = userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException("User not found"));
		
		return userMapper.toUserDTO(user);
	}
	
	// Create User
    public UserDTO createUser(UserDTO userDTO) {
    	
    	// Throw an exception if user is exist already
        if (userRepository.findByUsername(userDTO.getUserUname()).isPresent()) {
            throw new UserNotFoundException("Username already exists!");
        }
        
        // Hash the password
        String hashedPassword = passEncoder.encode(userDTO.getUserPassword());
        
        // Create a user object
        User user = new User();
        user.setUsername(userDTO.getUserUname());
        user.setPassword(hashedPassword); // Ideally, encrypt the password
        
        return userMapper.toUserDTO(userRepository.save(user));
    }

    // Update User
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        existingUser.setUsername(userDTO.getUserUname());
        existingUser.setPassword(userDTO.getUserPassword()); // Ideally, encrypt password
        
        return userMapper.toUserDTO(userRepository.save(existingUser));
    }

    // Delete User
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        
        userRepository.deleteById(id);
    }
    
    // Verify when user login
	public String verify(UserDTO userDTO) {
		// We will do authentication
		UsernamePasswordAuthenticationToken cred = 
			new UsernamePasswordAuthenticationToken(userDTO.getUserUname(), userDTO.getUserPassword());
		
		Authentication authentication = 
			authManager.authenticate(cred);
		
		// Check whether successfully authenticated or not
		// If yes, generateToken
		if(authentication.isAuthenticated()) 
			return jwtService.generateToken(userDTO.getUserUname());
		
		return "Not Success";
	}
}

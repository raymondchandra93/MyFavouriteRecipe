package com.raymondchandra.MyFavouriteRecipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.raymondchandra.MyFavouriteRecipe.exceptions.UserNotFoundException;
import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.model.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.model.mapper.UserMapper;
import com.raymondchandra.MyFavouriteRecipe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

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
}

package com.raymondchandra.MyFavouriteRecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	// Get all recipes as DTOs
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();

		return users.stream()
				.map(userMapper::toUserDTO) // Using the mapper to convert entities to DTOs
				.toList();  
	}
}

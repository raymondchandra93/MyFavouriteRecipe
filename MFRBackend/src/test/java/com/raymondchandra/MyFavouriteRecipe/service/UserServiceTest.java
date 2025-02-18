package com.raymondchandra.MyFavouriteRecipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.exceptions.UserNotFoundException;
import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockitoSpyBean
	private UserRepository userRepository;
	
	private User user1;
	private List<User> users;
	
	@BeforeEach
	void setup() {
		user1 = new User(1, "uname1", "upassword1");		
		users = new ArrayList<>(Arrays.asList(user1));
	}
	
	@Test
	void getAllUsers_WhenUsersExist_ReturnsUserList() {
		// Arrange
		when(userRepository.findAll()).thenReturn(users);
		
		// Act
		List<UserDTO> usersDTO = userService.getAllUsers();
		
		// Assert
		assertNotNull(usersDTO);
	}
	
	@Test
	void getUser_WhenUserExist_ReturnsUser() {
		// Arrange
		when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
		
		// Act
		UserDTO user = userService.getUser(1L);
		
		// Assert
		assertNotNull(user);
		assertEquals("uname1", user.getUserUname());
	}
	
	@Test
	void getUser_WhenNoUserExist_ThrowsException() {
		// Get the exception and assert Throws
		UserNotFoundException e = assertThrows(UserNotFoundException.class,
			() -> userService.getUser(0L));
		
		// Assert the message
		assertEquals("User not found", e.getMessage());
	}
}

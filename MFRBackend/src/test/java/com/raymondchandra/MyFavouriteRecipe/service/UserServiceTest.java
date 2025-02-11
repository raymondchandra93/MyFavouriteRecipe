package com.raymondchandra.MyFavouriteRecipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raymondchandra.MyFavouriteRecipe.exceptions.UserNotFoundException;
import com.raymondchandra.MyFavouriteRecipe.model.dto.UserDTO;

@SpringBootTest
public class UserServiceTest {
	
	private UserService userService;
	
	@Autowired
	public UserServiceTest(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@Test
	void getAllUsers_WhenUsersExist_ReturnsUserList() {
		List<UserDTO> users = userService.getAllUsers();
		assertNotNull(users);
	}
	
	@Test
	void getUser_WhenUserExist_ReturnsUser() {
		UserDTO user = userService.getUser(1L);
		assertNotNull(user);
		assertEquals("john_doe", user.getUserUname());
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

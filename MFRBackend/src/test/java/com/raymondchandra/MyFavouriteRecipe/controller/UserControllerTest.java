package com.raymondchandra.MyFavouriteRecipe.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.service.UserService;

@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
//	@Autowired
//    private MockMvc mockMvc; 				// MockMvc to simulate HTTP requests
//
//	@MockitoBean
//    private UserService userService; 		// Mocked service
//	
////	@MockitoBean
////	private UserRepository userRepository;
////
//    @Autowired
//    private ObjectMapper objectMapper; 		// For converting objects to JSON
//
////	private UserMapper userMapper;
////    private User createdUser;
////    private User updatedUser;
////	
////	@BeforeEach
////	void setup() {
////		// Arrange
////		createdUser = new User(11L, "john_doe", "password123");
////		updatedUser = new User(11L, "updated_user", "newpassword");
////	}
//    
//    @Test
//    void testGetAllUsers() throws Exception {
//    	
//    	// Arrange
////    	User user1 = new User(11L, "john_doe", "password123");
////    	User user2 = new User(12L, "jane_doe", "password456");
////    	List<User> userList = Arrays.asList(user1, user2);
////
////    	when(userRepository.findAll())
////    		.thenReturn(userList);
//
//    	UserDTO userDTO1 = new UserDTO("john_doe", "password123");
//    	UserDTO userDTO2 = new UserDTO("john_doe", "password123");
//    	List<UserDTO> listUserDTO = Arrays.asList(userDTO1, userDTO2);
//    	
//    	when(userService.getAllUsers())
//    		.thenReturn(listUserDTO);    	
//    	
//    	// Act & Assert
//        mockMvc.perform(get("/api/v1/public/users")
//        			.contentType("application/json"))
//        		.andDo(print())
//        		.andExpect(status().isOk());
//    }
//    
//    @Test
//    void testCreateUser() throws Exception {
//    	
//    	// Arrange
//    	UserDTO userDTO = userMapper.toUserDTO(createdUser);
//    	when(userService.createUser(any(UserDTO.class)))
//    		.thenReturn(userDTO);    	
//    	
//    	// Act & Assert
//        mockMvc.perform(post("/api/v1/public/users")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(userDTO))) 					// Send JSON body
//                .andExpect(status().isOk()) 											// Expect HTTP 200 OK
//                .andExpect(jsonPath("$.username").value(createdUser.getUsername()))		// Assert response JSON
//        		.andExpect(jsonPath("$.password").value(updatedUser.getPassword()));
//    }

//    @Test
//    void testUpdateUser() throws Exception {
//        // Arrange
//    	UserDTO userDTO = userMapper.toUserDTO(updatedUser);
//        when(userService.updateUser(11L, any(UserDTO.class))).thenReturn(userDTO);
//
//        // Act & Assert
//        mockMvc.perform(put("/api/v1/public/users/11")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(userDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.username").value(updatedUser.getUsername()))
//                .andExpect(jsonPath("$.password").value(updatedUser.getPassword()));
//    }
//
//    @Test
//    void testDeleteUser() throws Exception {
//    	// Arrange
//        doNothing().when(userService).deleteUser(1L);
//
//        // Act & Assert
//        mockMvc.perform(delete("/api/v1/public/users/11"))
//                .andExpect(status().isOk());
//    }
}

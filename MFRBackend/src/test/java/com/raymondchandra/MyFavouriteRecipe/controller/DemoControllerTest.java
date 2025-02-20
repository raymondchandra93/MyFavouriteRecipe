package com.raymondchandra.MyFavouriteRecipe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DemoController.class)
@AutoConfigureMockMvc(addFilters = false)
public class DemoControllerTest {
	@Autowired
    private MockMvc mockMvc; 				// MockMvc to simulate HTTP requests

    @Autowired
    private ObjectMapper objectMapper; 		// For converting objects to JSON
    
    @Test
    void testGetDemo() throws Exception {
    	
    	// Arrange
    	
    	// Act & Assert
        mockMvc.perform(get("/api/v1/public/demo"))
        	.andDo(print())
        	.andExpect(status().isOk());
    }
}

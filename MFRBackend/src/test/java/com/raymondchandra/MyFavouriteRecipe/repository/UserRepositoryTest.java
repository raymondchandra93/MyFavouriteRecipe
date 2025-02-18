package com.raymondchandra.MyFavouriteRecipe.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.raymondchandra.MyFavouriteRecipe.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
    public void testFindByUsername() {
        // Arrange
        User user = new User(0L, "jane_doe", "password123");

        // Act
        User result = userRepository.save(user);

        // Assert
        assertTrue(userRepository.existsById(user.getId()));
        assertEquals(user.getUsername(), result.getUsername());
    }
}

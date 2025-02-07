package com.raymondchandra.MyFavouriteRecipe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data 					// Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor 		// Generates a no-args constructor
@AllArgsConstructor 	// Generates an all-args constructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long id;
	
	@Column(name = "user_uname", nullable = false, length = 255)
	private String username;

	@Column(name = "user_password", nullable = false, length = 255)
	private String password;
}

package com.raymondchandra.MyFavouriteRecipe.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredient")
@Data 					// Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor 		// Generates a no-args constructor
@AllArgsConstructor 	// Generates an all-args constructor
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private long id;
	
	@Column(name = "ingredient_name", nullable = false, length = 255)
	private String recipeName;
	
	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private Set<RecipeIngredient> recipeIngredients;
}

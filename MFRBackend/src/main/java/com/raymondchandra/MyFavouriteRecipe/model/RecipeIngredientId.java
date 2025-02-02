package com.raymondchandra.MyFavouriteRecipe.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data 					// Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor 		// Generates a no-args constructor
@AllArgsConstructor 	// Generates an all-args constructor
public class RecipeIngredientId {
	private Long recipeId;
    private Long ingredientId;
}

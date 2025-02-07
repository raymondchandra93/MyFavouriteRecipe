package com.raymondchandra.MyFavouriteRecipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "recipeIngredient")
@Data 					// Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor 		// Generates a no-args constructor
@AllArgsConstructor 	// Generates an all-args constructor
public class RecipeIngredient {
	@EmbeddedId
	private RecipeIngredientId id = new RecipeIngredientId();
	
	@ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
	@JsonBackReference
	@ToString.Exclude
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    @JsonBackReference
    @ToString.Exclude
    private Ingredient ingredient;
}

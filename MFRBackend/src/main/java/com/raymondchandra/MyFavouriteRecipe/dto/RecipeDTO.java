package com.raymondchandra.MyFavouriteRecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
	private String recipeName;
	private String recipeDescription;
}

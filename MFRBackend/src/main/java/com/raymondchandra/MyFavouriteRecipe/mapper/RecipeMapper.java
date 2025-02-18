package com.raymondchandra.MyFavouriteRecipe.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.raymondchandra.MyFavouriteRecipe.dto.RecipeDTO;
import com.raymondchandra.MyFavouriteRecipe.model.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
	
	@Mapping(source = "recipeName", target = "recipeName")
	@Mapping(source = "recipeDescription", target = "recipeDescription")
	RecipeDTO toRecipeDTO(Recipe recipe);
	
	@Mapping(target = "recipeName", source = "recipeName")
	@Mapping(target = "recipeDescription", source = "recipeDescription")
	Recipe toRecipe(RecipeDTO recipeDTO);
}

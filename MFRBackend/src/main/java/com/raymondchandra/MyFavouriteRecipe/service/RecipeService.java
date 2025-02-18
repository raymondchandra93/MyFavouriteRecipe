package com.raymondchandra.MyFavouriteRecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raymondchandra.MyFavouriteRecipe.dto.RecipeDTO;
import com.raymondchandra.MyFavouriteRecipe.mapper.RecipeMapper;
import com.raymondchandra.MyFavouriteRecipe.mapper.UserMapper;
import com.raymondchandra.MyFavouriteRecipe.model.Recipe;
import com.raymondchandra.MyFavouriteRecipe.repository.RecipeRepository;
import com.raymondchandra.MyFavouriteRecipe.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeMapper recipeMapper;
	
	// Get all recipes as DTOs
	public List<RecipeDTO> getAllRecipes() {
		List<Recipe> recipes = recipeRepository.findAll();

		System.out.println("Hello Start ----");
		System.out.println(recipes.toString());
		System.out.println("Hello End ----");
		
		return recipes.stream()
				.map(recipeMapper::toRecipeDTO) // Using the mapper to convert entities to DTOs
				.toList();  
	}

	// Get a single recipe by ID as DTO
	public RecipeDTO getRecipeById(Long recipeId) {
		Recipe recipe = recipeRepository
			.findById(recipeId)
			.orElseThrow(() -> new RuntimeException("Recipe not found"));
		
		return recipeMapper.toRecipeDTO(recipe); // Convert to DTO
	}

	// Save a recipe from DTO
	public RecipeDTO saveRecipe(RecipeDTO recipeDTO) {
		Recipe recipe = recipeMapper.toRecipe(recipeDTO); // Convert DTO to entity
		Recipe savedRecipe = recipeRepository.save(recipe); // Save entity to DB
		
		return recipeMapper.toRecipeDTO(savedRecipe); // Convert back to DTO
	}
}

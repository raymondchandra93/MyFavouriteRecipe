package com.raymondchandra.MyFavouriteRecipe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.MyFavouriteRecipe.dto.RecipeDTO;
import com.raymondchandra.MyFavouriteRecipe.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

	private final RecipeService recipeService;
	
	// Get test
	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
		
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	
	// Get all recipes
	@GetMapping
	public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
		
		return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
	}

	// Get recipe by ID
	@GetMapping("/{id}")
	public RecipeDTO getRecipeById(@PathVariable Long id) {
		return recipeService.getRecipeById(id);
	}

	// Save a new recipe
	@PostMapping
	public RecipeDTO saveRecipe(@RequestBody RecipeDTO recipeDTO) {
		return recipeService.saveRecipe(recipeDTO);
	}
}

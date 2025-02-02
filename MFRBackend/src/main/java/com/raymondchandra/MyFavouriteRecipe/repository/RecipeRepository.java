package com.raymondchandra.MyFavouriteRecipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raymondchandra.MyFavouriteRecipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}

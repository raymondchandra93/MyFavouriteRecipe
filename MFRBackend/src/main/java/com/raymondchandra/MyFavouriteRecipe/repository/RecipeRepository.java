package com.raymondchandra.MyFavouriteRecipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raymondchandra.MyFavouriteRecipe.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	@Query(value = "SELECT r.recipe_id, r.recipe_name, r.recipe_description FROM recipe r", nativeQuery = true)
    List<Recipe> findRecipes();
}

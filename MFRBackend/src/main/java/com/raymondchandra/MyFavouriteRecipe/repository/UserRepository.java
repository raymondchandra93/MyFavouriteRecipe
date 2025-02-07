package com.raymondchandra.MyFavouriteRecipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raymondchandra.MyFavouriteRecipe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}

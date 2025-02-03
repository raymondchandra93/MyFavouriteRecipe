package com.raymondchandra.MyFavouriteRecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.raymondchandra.MyFavouriteRecipe")
public class MyFavouriteRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFavouriteRecipeApplication.class, args);
	}

}

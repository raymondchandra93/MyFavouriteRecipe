package com.raymondchandra.MyFavouriteRecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.raymondchandra.MyFavouriteRecipe", excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
//		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public class MyFavouriteRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFavouriteRecipeApplication.class, args);
	}

}

package com.raymondchandra.MyFavouriteRecipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public/demo")
public class DemoController {
	// Get test
	@GetMapping
	public ResponseEntity<String> getDemo() {
		
		return new ResponseEntity<>("Hello from Demo Controller", HttpStatus.OK);
	}
}

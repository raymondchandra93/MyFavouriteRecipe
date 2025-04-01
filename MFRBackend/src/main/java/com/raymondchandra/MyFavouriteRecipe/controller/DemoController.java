package com.raymondchandra.MyFavouriteRecipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/public/demo")
public class DemoController {

	@Operation(summary = "Get hello message", description = "Returns a simple greeting message.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved message", content = @Content(schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping
	public ResponseEntity<String> getDemo() {

		return new ResponseEntity<>("Welcome to the My Favourite Recipe!", HttpStatus.OK);
	}
}

package com.raymondchandra.MyFavouriteRecipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@Schema(description = "Username of the user", example = "john_doe")
	private String userUname;
	
	@Schema(description = "Password of the user")
	private String userPassword;
}

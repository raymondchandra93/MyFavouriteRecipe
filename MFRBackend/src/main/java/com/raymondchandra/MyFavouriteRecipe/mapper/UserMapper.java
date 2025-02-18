package com.raymondchandra.MyFavouriteRecipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.raymondchandra.MyFavouriteRecipe.dto.UserDTO;
import com.raymondchandra.MyFavouriteRecipe.model.User;

@Mapper(componentModel = "spring") 
public interface UserMapper {
	
	@Mapping(source = "username", target = "userUname")
	@Mapping(source = "password", target = "userPassword")
	UserDTO toUserDTO(User user);
	
	@Mapping(target = "username", source = "userUname")
	@Mapping(target = "password", source = "userPassword")
	User toRecipe(UserDTO userDTO);
}

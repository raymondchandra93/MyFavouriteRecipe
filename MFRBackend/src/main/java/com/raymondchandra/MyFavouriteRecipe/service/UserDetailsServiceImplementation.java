package com.raymondchandra.MyFavouriteRecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raymondchandra.MyFavouriteRecipe.model.User;
import com.raymondchandra.MyFavouriteRecipe.model.UserPrincipal;
import com.raymondchandra.MyFavouriteRecipe.repository.UserRepository;

// This service implements the UserDetailsService
// UserDetailsSercice has a method names loadUserByUsername()
// this is use to fetch user details from DB
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
        		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return new UserPrincipal(user);
    }
}

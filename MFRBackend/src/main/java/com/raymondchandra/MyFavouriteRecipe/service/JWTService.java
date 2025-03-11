package com.raymondchandra.MyFavouriteRecipe.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JWTService {
	
	private String secretKey;
	
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
			.claims()
			.add(claims)
			.subject(username)														// Username
			.issuedAt(new Date(System.currentTimeMillis()))							// Current time in millis
			.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 30)))	// Last for 30 minutes
			.and()
			.signWith(getKey())														// Sign in with key of your choice
			.compact();																// Done and generate
	}

	private Key getKey() {
		// Generate a secret key
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// Convert key back to bytes by decode it back to byte
		byte[] keyBites = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBites);
	}
}

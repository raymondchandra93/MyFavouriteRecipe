package com.raymondchandra.MyFavouriteRecipe.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
public class JWTService {

	private String secretKey;

	public JWTService() {
		// Generate a secret key
		
		// This is generate when we initialize the Service
		// that way, the secret key is the same thorough the entire app running time
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	// Generate Token
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().claims().add(claims).subject(username) // Username
				.issuedAt(new Date(System.currentTimeMillis())) // Current time in millis
				.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 30))) // Last for 30 minutes
				.and().signWith(getKey()) // Sign in with key of your choice
				.compact(); // Done and generate
	}

	// Generating key for the token that will be generated
	private SecretKey getKey() {
		// Convert key back to bytes by decode it back to byte
		byte[] keyBites = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBites);
	}

	public String extractUserName(String token) {
		// Extract the claim first because username is part of the claim
		return extractClaim(token, Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		// Getting all the claims
		final Claims claims = extractAllClaims(token);

		// Applying all the claims to the claimResolver function
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		// Extract the body of the claims using the same key
		return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		// Extract the username first
		final String username = extractUserName(token);

		// Return true if the username from token same from userDetail's and not expired
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {

		// Extract the expiration
		Date expDate = extractClaim(token, Claims::getExpiration);

		// Check if expiration is before today's date or not
		// Before today's date = expired -> return true
		return expDate.before(new Date());
	}
}

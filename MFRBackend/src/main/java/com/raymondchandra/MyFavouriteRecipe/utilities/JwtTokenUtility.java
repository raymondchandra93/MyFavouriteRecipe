package com.raymondchandra.MyFavouriteRecipe.utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureAlgorithm;

public class JwtTokenUtility {
//	private static final String SECRET_KEY = "your-secret-key";
//    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 60 mins * 60 seconds * 1000 ms = 1 hour
//
//    // Create the JWT token
//    public static String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    // Extract username from JWT token
//    public static String extractUsername(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    // Extract all claims from JWT token
//    private static Claims extractClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    // Check if token is expired
//    private static boolean isTokenExpired(String token) {
//        return extractClaims(token).getExpiration().before(new Date());
//    }
//
//    // Validate the token
//    public static boolean validateToken(String token, String username) {
//        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
//    }
}

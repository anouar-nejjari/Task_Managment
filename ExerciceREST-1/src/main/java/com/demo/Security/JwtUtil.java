package com.demo.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "very_secret_key";  

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1 heure
                .sign(Algorithm.HMAC256(secretKey));  // Signature avec la clé secrète
    }

    // Extraire le nom d'utilisateur à partir du token
    public String extractUsername(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token)
                .getExpiresAt();
    }
}

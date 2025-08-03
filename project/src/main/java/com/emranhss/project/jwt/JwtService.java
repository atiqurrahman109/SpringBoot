package com.emranhss.project.jwt;

import com.emranhss.project.entity.User;
import com.emranhss.project.repository.ITokenRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Autowired
    private ITokenRepo tokenRepo;

    private final String SECURITY_KEY = "mbLjS4vRvuC5KWQjbH87jAx4Vzq0plcCGv19T4Juy4Xg3y1IGa";

    //get all part from token
    private Claims extractAllClaims(String token) {

        return Jwts
                .parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECURITY_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

public String generateToken(User user) {
return  Jwts
        .builder()
        .setSubject(user.getEmail()) //set Email as subject
        .claim("role",user.getRole()) //Add user role to payload
        .setIssuedAt(new Date(System.currentTimeMillis())) //token issue time
        .setExpiration(new Date(System.currentTimeMillis()+   2 * 60 * 60 * 1000)) // 24 hours
        .signWith(getSigningKey()) //sign the token with secreat key
        .compact();

}
public String extractUserName(String token) {

        return extractClaim(token,Claims::getSubject);
}

// extract a specific claims from the token claims
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {

        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails user) {
        String username = extractUserName(token);
        boolean validToken= tokenRepo
                .findByToken(token)
                .map( t->!t.isLogOut())
                .orElse(false);

        return (username.equals(user.getUsername()) && !isTokenExpired(token) && validToken);


    }
    //get user role from token
    public String extractUserRole(String token) {

        return extractClaim(token,claims -> claims.get("role",String.class));
    }

}

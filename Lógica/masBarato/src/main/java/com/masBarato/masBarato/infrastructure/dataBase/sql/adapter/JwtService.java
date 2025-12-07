package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
@Service
public class JwtService {
    private static final String key="586E3273257538782F413F4428472B4B6250655368566B597033733676397924";
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }
    public String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey() {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public String getUsernamefromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernamefromToken(token);
        return username.equals(userDetails.getUsername()) && !hasExpired(token);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token, Claims::getExpiration);
    }
    private boolean hasExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }
}
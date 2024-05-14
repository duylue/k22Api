package com.k22Api.controller;

import com.k22Api.model.UserSecurityDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final String secretKey = "javak12";

    public String createToken(Authentication authentication) {

        UserSecurityDetail detail = (UserSecurityDetail) authentication.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("a",detail.getPassword());
        map.put("b", detail.getAuthorities());
        String token = Jwts.builder()
                .setSubject(detail.getUsername())
                .addClaims(map)
                .setExpiration(new Date(new Date().getTime() + 100000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;
    }

    public boolean validToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getUsername(String token){
        return  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}

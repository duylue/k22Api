package com.k22Api.service.impl;

import com.k22Api.model.User;
import com.k22Api.model.UserSecurityDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final String privateKey = "javak22";
    public String genToken(Authentication authentication){
        Map<String,Object> map = new HashMap<>();
        UserSecurityDetail userSecurityDetail = (UserSecurityDetail) authentication.getPrincipal();
        map.put("roles",userSecurityDetail.getAuthorities());
        String token  = Jwts.builder()
                .setId("Java K22")
                .setExpiration(new Date(new Date().getTime() + 1000000))
                .setSubject(userSecurityDetail.getUsername())
                .addClaims(map)
                .signWith(SignatureAlgorithm.HS512,privateKey)
                .compact();
        return token;

    }
    public Boolean validateToken(String token){

        try {
            Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public String getUserNameFromToken (String token){
        return  Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody().getSubject();
    }
}

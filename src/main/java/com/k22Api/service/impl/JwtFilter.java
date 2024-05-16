package com.k22Api.service.impl;

import com.k22Api.model.UserSecurityDetail;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProvider provider;
    @Autowired
    private UserSecurityDetailService userSecurityDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null) {
            token = token.replace("Bearer", "");
            if (provider.validateToken(token)){
                String username = provider.getUserNameFromToken(token);
                UserDetails userDetails =  userSecurityDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken
                        ath = new UsernamePasswordAuthenticationToken(userDetails,null,
                        userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(ath);

            }
        }
        filterChain.doFilter(request,response);
    }
}

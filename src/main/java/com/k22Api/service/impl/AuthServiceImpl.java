package com.k22Api.service.impl;

import com.k22Api.model.BaseResponse;
import com.k22Api.model.User;
import com.k22Api.repository.UserRepository;
import com.k22Api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends BaseResponse implements AuthorService {
    @Autowired
    private JwtProvider provider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> login(User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token  = provider.genToken(authentication);
        return getResponseEntity(token);
    }

    @Override
    public ResponseEntity<?> register(User user) {
       userRepository.save(user);
        return getResponseEntity(user);
    }
}

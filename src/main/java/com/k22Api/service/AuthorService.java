package com.k22Api.service;

import com.k22Api.model.LoginDto;
import com.k22Api.model.User;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    ResponseEntity<?> login(User user);
    ResponseEntity<?> register(User user);
}

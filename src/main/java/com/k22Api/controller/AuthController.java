package com.k22Api.controller;

import com.k22Api.model.User;
import com.k22Api.service.AuthorService;
import com.k22Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserService userService;

    @GetMapping("/findId")
    public ResponseEntity<?> find(@RequestParam int id) {
        return userService.findById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return authorService.login(user);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return authorService.register(user);
    }
}

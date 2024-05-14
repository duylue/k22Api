package com.k22Api.service.impl;

import com.k22Api.controller.JwtProvider;
import com.k22Api.model.BaseResponse;
import com.k22Api.repository.RoleRepository;
import com.k22Api.repository.UserRepository;
import com.k22Api.service.UserService;

import com.k22Api.model.Role;
import com.k22Api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseResponse implements UserService  {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Role findRoleById(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> getListRole() {
        return roleRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User u) {
        userRepository.save(u);
    }

    @Override
    public ResponseEntity<?> login(String username, String password) {
     return null;
    }


}

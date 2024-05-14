package com.k22Api.service;

import com.k22Api.model.Role;
import com.k22Api.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    void saveRole(Role role);
    Role findRoleById(int id);
   List<Role> getListRole();
   User findUserByUsername(String username);
   void saveUser(User u);
   ResponseEntity<?> login(String username, String password);

}

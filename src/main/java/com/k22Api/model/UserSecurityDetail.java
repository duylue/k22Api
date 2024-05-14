package com.k22Api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserSecurityDetail  implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> roles;
    public UserSecurityDetail( User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream()
                .map((s)-> new SimpleGrantedAuthority(s.getRname())).collect(Collectors.toList());

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

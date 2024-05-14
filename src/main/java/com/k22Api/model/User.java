package com.k22Api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Users_Roles",joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns ={@JoinColumn(name = "rid")})
    private List<Role> roles;
}

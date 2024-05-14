package com.k22Api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String rname;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<User> users;

}

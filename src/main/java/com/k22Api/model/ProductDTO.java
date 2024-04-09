package com.k22Api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductDTO {
    @Id
    private int pid;
    private String pname;
    private float price;
    private String cname;
}

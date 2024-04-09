package com.k22Api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
//    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "sai dinh dang")
    private String pname;
    private int sid;
    private int cid;
    private float price;

}

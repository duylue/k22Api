package com.k22Api.service;

import com.k22Api.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getList();
    ResponseEntity<?> save(Product product);
    ResponseEntity<?> delete( int pid);
    ResponseEntity<?> findById(int id);
    ResponseEntity<?> findByName(String name);

}

package com.k22Api.controller;
import com.k22Api.model.Product;
import com.k22Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class RestProductController {
    @Autowired
    private ProductService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_USER')")
    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return service.getList();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        return service.save(product);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/del")
    public ResponseEntity<?> del(@RequestParam int id){
        return service.delete(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name){
        return service.findByName(name);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam int pid){
        return service.findById(pid);
    }


}

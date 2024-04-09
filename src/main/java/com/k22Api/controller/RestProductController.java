package com.k22Api.controller;
import com.k22Api.model.Product;
import com.k22Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class RestProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return service.getList();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        return service.save(product);
    }
    @GetMapping("/del")
    public ResponseEntity<?> del(@RequestParam int id){
        return service.delete(id);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> del(@RequestParam String name){
        return service.findByName(name);
    }
}

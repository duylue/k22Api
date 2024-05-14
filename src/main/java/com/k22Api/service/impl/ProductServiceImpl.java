package com.k22Api.service.impl;

import com.k22Api.model.BaseResponse;
import com.k22Api.model.Product;
import com.k22Api.repository.ProductRepository;
import com.k22Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public ResponseEntity<?> getList() {

        return getResponseEntity(repository.getlist());
    }

    @Override
    public ResponseEntity<?> getList(int p, int t) {
        Pageable pageable = PageRequest.of(p,t);
        return getResponseEntity(repository.getlist(pageable));
    }

    @Override
    public ResponseEntity<?> save(Product product) {
        return getResponseEntity(repository.save(product));
    }

    @Override
    public ResponseEntity<?> delete(int pid) {
        repository.deleteById(pid);
        return getResponseEntity("Da xoa thanh san pham co id  la  : " +pid);
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        return getResponseEntity(repository.findById(id).get());
    }

    @Override
    public ResponseEntity<?> findByName(String name) {
        return getResponseEntity(repository.findProductByPname(name));
    }
}

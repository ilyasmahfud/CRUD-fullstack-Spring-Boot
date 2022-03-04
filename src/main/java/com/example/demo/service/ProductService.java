package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProduct();
    ResponseEntity<Object> getDetailProduct(Long number);
    ResponseEntity<Object> createNewProduct(Product product);
    ResponseEntity<Object> updateProduct(Long number, Product product);
    ResponseEntity<Object> deleteProduct(Long number);
}

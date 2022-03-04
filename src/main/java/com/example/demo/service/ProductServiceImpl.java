package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public ResponseEntity<Object> getDetailProduct(Long number) {
        Product product_detail = productRepository.findById(number)
                .orElseThrow(()->new ResourceNotFoundException("Product not Found"));
        return new ResponseEntity<>(product_detail, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> createNewProduct(Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProduct(Long number, Product product) {
        Product product_detail = productRepository.findById(number)
                .orElseThrow(()->new ResourceNotFoundException("produck not found"));
        product_detail.setProductName(product.getProductName());
        product_detail.setProductQty(product.getProductQty());
        productRepository.save(product_detail);
        return new ResponseEntity<>(product_detail, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteProduct(Long number) {
        Product product_detail = productRepository.findById(number)
                .orElseThrow(()->new ResourceNotFoundException("product not found"));
        productRepository.delete(product_detail);
        return new ResponseEntity<>(product_detail, HttpStatus.OK);
    }
}

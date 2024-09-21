package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.lang.Long;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }    

    public List<Object[]> getProductWithOptions(Long productId) {
        return productRepository.findProductWithOptionsById(productId);
    }    
}

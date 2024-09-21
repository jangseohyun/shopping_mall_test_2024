package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 상품 ID로 상품 상세 정보를 조회하는 API
    // @GetMapping("/{productId}")
    // public ResponseEntity<List<Product>> getProductDetailsByProductId(@PathVariable Long productId) {
    //     log.info("상품 번호: "+productId);
    //     List<Product> products = productService.getProductsByProductId(productId);
    //     return ResponseEntity.ok(products);
    // }

    // 상품 ID로 상품 옵션을 포함한 상품 상세 정보를 조회하는 API
    @GetMapping("/{productId}")
    public ResponseEntity<List<Object[]>> getProductWithOptions(@PathVariable Long productId) {
        log.info("상품 번호: "+productId);
        List<Object[]> productWithOptions = productService.getProductWithOptions(productId);
        return ResponseEntity.ok(productWithOptions);
    }
}

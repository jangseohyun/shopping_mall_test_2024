package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // productId를 기준으로 상품 데이터를 가져오는 메소드
    List<Product> findByProductId(Long productId);
}



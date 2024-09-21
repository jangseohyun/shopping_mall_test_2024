package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // productId를 기준으로 상품 데이터를 가져오는 메소드
    List<Product> findByProductId(Long productId);

    // productId를 기준으로 상품 옵션을 포함한 데이터를 가져오는 메소드
    @Query(value = "SELECT A.PRODUCT_ID, A.DESCRIPTION, A.NAME, A.PRICE, B.OPTION " +
                   "FROM PRODUCT A " +
                   "JOIN PRODUCT_OPTION B ON A.PRODUCT_ID = B.PRODUCT_ID " +
                   "WHERE A.PRODUCT_ID = :productId", nativeQuery = true)
    List<Object[]> findProductWithOptionsById(@Param("productId") Long productId);

}



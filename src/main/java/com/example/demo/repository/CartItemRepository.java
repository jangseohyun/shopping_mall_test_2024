package com.example.demo.repository;

import com.example.demo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT COUNT(c.quantity) FROM CartItem c WHERE c.productId = :productId")
    Integer getTotalQuantityByProductId(@Param("productId") Long productId);
}

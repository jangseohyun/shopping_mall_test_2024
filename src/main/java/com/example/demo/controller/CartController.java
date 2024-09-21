package com.example.demo.controller;

import com.example.demo.dto.CartItemDto;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")  // CORS 설정 필요 시 추가
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public String addToCart(@RequestBody CartItemDto cartItem) {
        cartService.addToCart(cartItem);
        log.info("Product ID: " + cartItem.getProductId());
        log.info("Quantity: " + cartItem.getQuantity());
        return "Item added to cart!";
    }

    @GetMapping("/count/{productId}")
    public ResponseEntity<Integer> getCartItemCount(@PathVariable Long productId) {
        Integer totalQuantity = cartService.getTotalQuantityByProductId(productId);
        log.info("장바구니 담긴 횟수: "+totalQuantity);
        return ResponseEntity.ok(totalQuantity);
    }
}

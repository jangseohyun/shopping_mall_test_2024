package com.example.demo.service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.CartItem;
import com.example.demo.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    // 장바구니에 아이템을 추가하는 메서드
    public void addToCart(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(cartItemDto.getProductId());
        cartItem.setProductName(cartItemDto.getProductName());
        cartItem.setQuantity(cartItemDto.getQuantity());

        // 장바구니에 아이템 저장
        cartItemRepository.save(cartItem);
    }

    // 상품번호에 따른 장바구니 담긴 횟수 총합 조회
    public Integer getTotalQuantityByProductId(Long productId) {
        return cartItemRepository.getTotalQuantityByProductId(productId);
    }
}

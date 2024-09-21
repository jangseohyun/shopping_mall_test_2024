package com.example.demo.service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.CartItem;
import com.example.demo.repository.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class CartServiceTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addToCart_shouldSaveCartItem() {
        // given: 테스트에 사용할 CartItemDto 준비
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(0L);
        cartItemDto.setProductName("Test Product");
        cartItemDto.setOption("M");
        cartItemDto.setQuantity(2);

        // when: addToCart 메서드 호출
        cartService.addToCart(cartItemDto);

        // then: CartItemRepository의 save 메서드가 한 번 호출되었는지 검증
        verify(cartItemRepository, times(1)).save(org.mockito.ArgumentMatchers.any(CartItem.class));
    }
    
    @Test
    public void getTotalQuantityByProductId_shouldGetTotalQuantity() {
        // given: 테스트에 사용할 productId 준비
        Long productId = 0L;

        // when: getTotalQuantityByProductId 메서드 호출
        cartService.getTotalQuantityByProductId(productId);

        // then: CartItemRepository의 getTotalQuantityByProductId 메서드가 한 번 호출되었는지 검증
        verify(cartItemRepository, times(1)).getTotalQuantityByProductId(productId);
    }
}

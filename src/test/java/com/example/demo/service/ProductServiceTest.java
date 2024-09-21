package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void getProductWithOptions_shouldGetProductWithOptions() {
        // given: 테스트에 사용할 productId 준비
        Long productId = 0L;

        // when: getProductWithOptions 메서드 호출
        productService.getProductWithOptions(productId);

        // then: productRepository findProductWithOptionsById 메서드가 한 번 호출되었는지 검증
        verify(productRepository, times(1)).findProductWithOptionsById(productId);
    }
}

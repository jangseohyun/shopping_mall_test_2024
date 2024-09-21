package com.example.demo.dto;

public class CartItemDto {

    private Long productId;
    private String productName;
    private String option;
    private int quantity;

    // 기본 생성자
    public CartItemDto() {}

    // 모든 필드를 포함하는 생성자
    public CartItemDto(Long productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.option = option;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

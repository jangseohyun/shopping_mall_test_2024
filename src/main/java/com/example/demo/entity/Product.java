package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private Double price;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY) // ProductOption과 1:N 관계 설정
    private List<ProductOption> options;  // 상품의 옵션 리스트

}

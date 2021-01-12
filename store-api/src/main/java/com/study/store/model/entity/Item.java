package com.study.store.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private Integer price;
    private String brandName;
    private String registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long partnerId;


    // LAZY = 지연로딩, EAGER = 즉시로딩

    // LAZY = SELECT * FROM item where id = ? : 연관관계가 설정된 테이블에 대해서 select를 하지 않는다

    // EAGER = : 연관관계가 설정된 모든 테이블에 대해서 join하여 가져옴 (1:1 에서 추천 다른경우는 LAZY 추천)
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;
}

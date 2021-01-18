package com.study.store.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {
    ALL(0, "묶음", "주문 상품 묶음 발송"),
    EACH(1, "개별", "주문 상품 개별 발송");
    private Integer id;
    private String title;
    private String description;

}

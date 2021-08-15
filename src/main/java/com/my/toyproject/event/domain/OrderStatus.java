package com.my.toyproject.event.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PAYMENT_WAITING("결제 대기 중"),
    PREPARING("상품 준비 중"),
    DELIVERING("배송 중"),
    DELIVERY_COMPLETE("배송 완료"),
    CANCELED("주문 취소");


    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}

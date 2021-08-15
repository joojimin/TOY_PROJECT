package com.my.toyproject.event.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus statue = OrderStatus.PAYMENT_WAITING;

    @Column(name = "item_id", nullable = false)
    private long itemId;


    public Order(long itemId) {
        this.itemId = itemId;
    }

    public void pay() {
        statue = OrderStatus.PREPARING;
    }

    public void delivering() {
        statue = OrderStatus.DELIVERING;
    }
}

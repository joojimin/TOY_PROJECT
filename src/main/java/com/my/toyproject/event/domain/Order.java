package com.my.toyproject.event.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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

    @Transient
    private String message = "asdasdasdasd";


    public Order(long itemId) {
        this.itemId = itemId;
    }

    public Order(Long id, long itemId, String message) {
        this.id = id;
        this.itemId = itemId;
        this.message = message;
    }

    public void pay() {
        statue = OrderStatus.PREPARING;
    }

    public void delivering() {
        statue = OrderStatus.DELIVERING;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return itemId == order.itemId && Objects.equals(id, order.id)
            && statue == order.statue && Objects.equals(message, order.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statue, itemId, message);
    }
}

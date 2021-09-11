package com.my.toyproject.event.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class OrderTest {


    @Test
    void test() {
        Order order1 = new Order(1L, 100, "123123");
        Order order2 = new Order(1L, 100, "123123");

        assertThat(order1).isEqualTo(order2);
    }


    @Test
    void test2() {
        Map<Order, String> a = new HashMap<>();
        Order order1 = new Order(1L, 100, "123123");
        Order order2 = new Order(1L, 100, "123123");

        a.put(order1, "1");
        a.put(order2, "2");

        assertThat(a).hasSize(1);
    }

    @Test
    void test3() {
        Set<Order> a = new HashSet<>();
        Order order1 = new Order(1L, 100, "123123");
        Order order2 = new Order(1L, 100, "123123");

        a.add(order1);
        a.add(order2);

        assertThat(a).hasSize(1);
    }

    @Test
    void test4() {
        List<Order> a = new ArrayList<>();
        Order order1 = new Order(1L, 100, "123123");
        Order order2 = new Order(1L, 100, "123123");

        a.add(order1);
//        a.add(order2);

        assertThat(a.contains(order2)).isTrue();
    }
}

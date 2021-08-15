package com.my.toyproject.event.infrastructure;

import com.my.toyproject.event.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}

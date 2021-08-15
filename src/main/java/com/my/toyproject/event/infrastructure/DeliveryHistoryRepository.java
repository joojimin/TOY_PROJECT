package com.my.toyproject.event.infrastructure;

import com.my.toyproject.event.domain.OrderDeliveryHistory;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryHistoryRepository extends CrudRepository<OrderDeliveryHistory, Long> {

}

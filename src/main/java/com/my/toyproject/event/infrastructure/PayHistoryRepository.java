package com.my.toyproject.event.infrastructure;

import com.my.toyproject.event.domain.PayHistory;
import org.springframework.data.repository.CrudRepository;

public interface PayHistoryRepository extends CrudRepository<PayHistory, Long> {

}

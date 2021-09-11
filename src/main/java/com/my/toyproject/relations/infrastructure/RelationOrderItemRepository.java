package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationOrderItemRepository extends JpaRepository<RelationOrderItem, Long> {

}

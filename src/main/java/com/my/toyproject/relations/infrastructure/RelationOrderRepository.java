package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationOrderRepository extends JpaRepository<RelationOrder, Long> {

}

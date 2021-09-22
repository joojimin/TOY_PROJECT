package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationDelivery;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationDeliveryRepository extends JpaRepository<RelationDelivery, Long> {
    List<RelationDelivery> findByIdIn(Collection<Long> ids);
}

package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationOrderRepository extends JpaRepository<RelationOrder, Long> {

    @Query("SELECT o FROM RelationOrder o "
        + "JOIN FETCH o.user "
        + "JOIN FETCH o.delivery "
        + "WHERE o.id = :id")
    Optional<RelationOrder> findById(Long id);

    @Query("SELECT o FROM RelationOrder o "
        + "JOIN FETCH o.user "
        + "JOIN FETCH o.delivery")
    List<RelationOrder> findAllWithUserDelivery();
}

package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationItemRepository extends JpaRepository<RelationItem, Long> {

}

package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationItemRepository extends JpaRepository<RelationItem, Long> {


    @Query(value = "SELECT i FROM RelationItem i WHERE i.id IN :ids")
    List<RelationItem> findByIds(List<Long> ids);


    List<RelationItem> findDistinctByName(String name);
}

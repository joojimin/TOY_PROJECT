package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationItemRepository extends JpaRepository<RelationItem, Long> {


    @Query(value = "SELECT i FROM RelationItem i WHERE i.id IN :ids")
    List<RelationItem> findByIds(List<Long> ids);


    List<RelationItem> findDistinctByName(String name);

    @Query(value = "SELECT DISTINCT i FROM RelationItem i WHERE i.name = :name")
    List<RelationItem> findDistinctByNameWithJPQL(String name);

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM relation_item WHERE name = :name")
    List<RelationItem> findDistinctByNameWithNativeQuery(String name);


    List<RelationItem> findByNameAndPrice(String name, Long price);

    @Query(value = "SELECT i FROM RelationItem i WHERE i.name = :name AND i.price = :price")
    List<RelationItem> findByNameAndPriceWithJPQL(String name, Long price);

    @Query(nativeQuery = true, value = "SELECT * FROM relation_item WHERE name = :name AND price = :price")
    List<RelationItem> findByNameAndPriceWithNativeQuery(String name, Long price);
}

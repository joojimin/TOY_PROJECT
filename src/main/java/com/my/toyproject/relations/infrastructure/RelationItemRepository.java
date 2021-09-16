package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationItem;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationItemRepository extends JpaRepository<RelationItem, Long> {


    @Query(value = "SELECT i FROM RelationItem i WHERE i.id IN :ids")
    List<RelationItem> findByIds(List<Long> ids);


    // DISTINCT
    List<RelationItem> findDistinctByName(String name);

    @Query(value = "SELECT DISTINCT i FROM RelationItem i WHERE i.name = :name")
    List<RelationItem> findDistinctByNameWithJPQL(String name);

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM relation_item WHERE name = :name")
    List<RelationItem> findDistinctByNameWithNativeQuery(String name);


    // AND
    List<RelationItem> findByNameAndPrice(String name, Long price);

    @Query(value = "SELECT i FROM RelationItem i WHERE i.name = :name AND i.price = :price")
    List<RelationItem> findByNameAndPriceWithJPQL(String name, Long price);

    @Query(nativeQuery = true, value = "SELECT * FROM relation_item WHERE name = :name AND price = :price")
    List<RelationItem> findByNameAndPriceWithNativeQuery(String name, Long price);


    // OR
    List<RelationItem> findByNameOrPrice(String name, Long price);

    @Query(value = "SELECT i FROM RelationItem i WHERE i.name = :name OR i.price = :price")
    List<RelationItem> findByNameOrPriceWithJPQL(String name, Long price);

    @Query(nativeQuery = true, value = "SELECT * FROM relation_item WHERE name = :name OR price = :price")
    List<RelationItem> findByNameOrPriceWithNativeQuery(String name, Long price);


    // IS, EQUALS
    List<RelationItem> findByName(String name);
    List<RelationItem> findByNameIs(String name);
    List<RelationItem> findByNameEquals(String name);

    // BETWEEN
    List<RelationItem> findByPriceBetween(Long start, Long end);


    // LESS THAN, GREATER THAN
    List<RelationItem> findByPriceLessThan(Long price);
    List<RelationItem> findByPriceLessThanEqual(Long price);
    List<RelationItem> findByPriceGreaterThan(Long price);
    List<RelationItem> findByPriceGreaterThanEqual(Long price);

    // AFTER, BEFORE
    List<RelationItem> findByPriceAfter(Long price);
    List<RelationItem> findByRegisterTimeAfter(LocalDateTime registerTime);
}

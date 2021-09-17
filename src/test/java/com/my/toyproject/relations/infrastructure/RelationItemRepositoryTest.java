package com.my.toyproject.relations.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import com.my.toyproject.relations.domain.RelationItem;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@SpringBootTest
class RelationItemRepositoryTest {

    @Autowired
    private RelationItemRepository relationItemRepository;


    @Test
    void orTest() {
        List<RelationItem> relationItems = relationItemRepository.findByNameOrPrice("테스트1 아이템", 1000L);
        relationItems.forEach(System.out::println);
    }

    @Test
    void orTestWithJPQL() {
        relationItemRepository.findByNameOrPriceWithJPQL("테스트1 아이템", 1000L)
                              .forEach(System.out::println);
    }

    @Test
    void orTestWithNativeQuery() {
        relationItemRepository.findByNameOrPriceWithNativeQuery("테스트1 아이템", 1000L)
                              .forEach(System.out::println);
    }

    @Test
    void isEqualsTest() {
        relationItemRepository.findByName("테스트1 아이템").forEach(System.out::println);
        relationItemRepository.findByNameIs("테스트1 아이템").forEach(System.out::println);
        relationItemRepository.findByNameEquals("테스트1 아이템").forEach(System.out::println);
//        select
//        relationit0_.id as id1_7_,
//            relationit0_.name as name2_7_,
//        relationit0_.price as price3_7_
//            from
//        relation_item relationit0_
//        where
//        relationit0_.name=?
    }

    @Test
    void betweenTest() {
        relationItemRepository.findByPriceBetween(1000L, 2000L).forEach(System.out::println);
    }

    @Test
    void lessThanTest() {
        relationItemRepository.findByPriceLessThan(1000L)
                              .forEach(System.out::println);
    }

    @Test
    void lessThanEqualTest() {
        relationItemRepository.findByPriceLessThanEqual(1000L)
                              .forEach(System.out::println);
    }

    @Test
    void afterTest() {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(5);
        relationItemRepository.findByRegisterTimeAfter(localDateTime).forEach(System.out::println);
    }

    @Test
    void nullTest() {
        relationItemRepository.findByUpdateTimeNull().forEach(System.out::println);
    }

    @Test
    void notNullTest() {
        relationItemRepository.findByUpdateTimeNotNull().forEach(System.out::println);
    }

    @Test
    void likeTest() {
        relationItemRepository.findByNameLike("테스트1\\%\\% 아이템").forEach(System.out::println);
    }

    @Test
    void startingWithTest() {
        relationItemRepository.findByNameStartingWith("테스트1").forEach(System.out::println);
    }

    @Test
    void endingWithTest() {
        relationItemRepository.findByNameEndingWith("테스트1").forEach(System.out::println);
    }

    @Test
    void containingTest() {
        relationItemRepository.findByNameContaining("테스트1").forEach(System.out::println);
    }

    @Test
    void orderByTest() {
        relationItemRepository.findByOrderByRegisterTimeDesc().forEach(System.out::println);
    }

    @Test
    void notTest() {
        relationItemRepository.findByNameNot("테스트1").forEach(System.out::println);
    }

    @Test
    void inTest() {
        relationItemRepository.findByPriceIn(List.of(1000L, 2000L)).forEach(System.out::println);
    }

    @Test
    void ignoreCaseTest() {
        relationItemRepository.findByNameIgnoreCase("테스트1 HIHIHIHI").forEach(System.out::println);
    }
}

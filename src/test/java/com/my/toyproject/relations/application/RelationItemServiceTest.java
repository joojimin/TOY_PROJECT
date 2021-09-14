package com.my.toyproject.relations.application;

import static org.junit.jupiter.api.Assertions.*;

import com.my.toyproject.relations.domain.RelationItem;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class RelationItemServiceTest {

    @Autowired
    private RelationItemService relationItemService;

    @Test
    void distinctTest() {
        List<RelationItem> relationItems = relationItemService.distinct();

        for (RelationItem relationItem : relationItems) {
            System.out.println(relationItem.toString());
        }
    }

    @Test
    void distinctWithJPQLTest() {
        List<RelationItem> relationItems = relationItemService.distinctWithJPQL();

        for (RelationItem relationItem : relationItems) {
            System.out.println(relationItem.toString());
        }
    }

    @Test
    void distinctWithNativeQueryTest() {
        List<RelationItem> relationItems = relationItemService.distinctWithNativeQuery();

        for (RelationItem relationItem : relationItems) {
            System.out.println(relationItem.toString());
        }
    }

    @Test
    void andTest() {
        List<RelationItem> relationItems = relationItemService.and();
        relationItems.forEach(System.out::println);
    }

    @Test
    void andWithJPQLTest() {
        relationItemService.andWithJPQL().forEach(System.out::println);
    }

    @Test
    void andWithNativeQueryTest() {
        relationItemService.andWithNativeQuery().forEach(System.out::println);
    }
}

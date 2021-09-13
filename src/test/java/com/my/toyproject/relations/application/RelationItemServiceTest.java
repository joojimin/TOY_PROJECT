package com.my.toyproject.relations.application;

import static org.junit.jupiter.api.Assertions.*;

import com.my.toyproject.relations.domain.RelationItem;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
}

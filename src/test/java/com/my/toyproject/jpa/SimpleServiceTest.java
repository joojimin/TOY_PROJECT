package com.my.toyproject.jpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SimpleServiceTest {

    @Autowired
    private SimpleService simpleService;

    @Test
    void saveTest() {
        simpleService.saveTest();
    }
}

package com.my.toyproject.multitransaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("transaction")
@SpringBootTest
class MultiTransactionServiceTest {

    @Autowired
    private MultiTransactionService multiTransactionService;


    @Test
    void test() {
        multiTransactionService.save();
    }
}

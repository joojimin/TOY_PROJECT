package com.my.toyproject.shop.service;

import com.my.toyproject.shop.mapper.ShopMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChildTransactionService {

    private final ShopMapper shopMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertMember() {
        shopMapper.insertMember("childTest1", "구로구", LocalDateTime.now());
        log.error("===================================================");
        log.error("================ CHILD EXCEPTION =================");
        log.error("===================================================");
        throw new RuntimeException();
    }
}

package com.my.toyproject.shop.application;

import com.my.toyproject.shop.domain.Member;
import com.my.toyproject.shop.domain.ShopRepository;
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

    private final ShopRepository shopRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void insertMember() {
        shopRepository.save(Member.builder()
                                  .name("childTest1")
                                  .address("구로구")
                                  .registerTime(LocalDateTime.now())
                                  .build());
        log.error("===================================================");
        log.error("================ CHILD EXCEPTION =================");
        log.error("===================================================");
        throw new RuntimeException();
    }
}

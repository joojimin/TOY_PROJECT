package com.my.toyproject.async;

import com.my.toyproject.shop.domain.Member;
import com.my.toyproject.shop.domain.ShopRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyAsyncChildService {

    private final ShopRepository shopRepository;

    @Async
    @Transactional
    public void test(Member savedMember) {
        System.out.println("CHILD THREAD NAME = " + Thread.currentThread().getName());
        savedMember.setAddress("CHILD UPDATE");
    }

}

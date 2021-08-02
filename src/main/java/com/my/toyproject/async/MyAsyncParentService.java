package com.my.toyproject.async;


import com.my.toyproject.shop.domain.Member;
import com.my.toyproject.shop.domain.ShopRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyAsyncParentService {

    private final MyAsyncChildService myAsyncChildService;
    private final ShopRepository shopRepository;

    @Transactional
    public void test() {
        System.out.println("THREAD NAME = " + Thread.currentThread().getName());
        Member savedMember = shopRepository.save(Member.builder()
                                                       .name("async-test-parent")
                                                       .address("구로구")
                                                       .registerTime(LocalDateTime.now())
                                                       .build());
        myAsyncChildService.test(savedMember);
    }
}

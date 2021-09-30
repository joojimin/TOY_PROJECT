package com.my.toyproject.shop.application;

import com.my.toyproject.shop.domain.Member;
import com.my.toyproject.shop.domain.ShopRepository;
import com.my.toyproject.shop.dto.MemberDto;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ChildTransactionService childTransactionService;

    @Override
    public List<MemberDto> selectMembers() {
        return shopRepository.findAll()
                             .stream()
                             .map(MemberDto::createMemberDto)
                             .collect(Collectors.toList());
    }

    @Override
    public void exceptionTest() throws NullPointerException {
        throw new NullPointerException("test");
    }

    /**
     * https://skyblue300a.tistory.com/15
     */
    @Override
    public void transactionTest() {
        // runtime Exception
        try {
            shopRepository.save(Member.builder()
                                      .name("exceptionLog1")
                                      .address("구로구")
                                      .registerTime(LocalDateTime.now())
                                      .build());
            childTransactionService.insertMember();
            sameMethodTest();
        } catch (RuntimeException ex) {
            log.error("parentTransactionService.insertMember() exception occur");
        } finally {
            // 자식에서 rollback mark
            shopRepository.save(Member.builder()
                                      .name("exceptionLog2")
                                      .address("구로구")
                                      .registerTime(LocalDateTime.now())
                                      .build());
//            throw new RuntimeException("parent runtime exception");
        }
    }

    @Transactional(readOnly = true)
    public void sameMethodTest() {
        shopRepository.save(Member.builder()
                                  .name("parentTest1")
                                  .address("구로구")
                                  .registerTime(LocalDateTime.now())
                                  .build());
        log.error("===================================================");
        log.error("================ PARENT EXCEPTION =================");
        log.error("===================================================");
    }
}

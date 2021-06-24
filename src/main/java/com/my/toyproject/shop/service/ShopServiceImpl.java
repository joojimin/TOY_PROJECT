package com.my.toyproject.shop.service;

import com.my.toyproject.shop.mapper.ShopMapper;
import com.my.toyproject.shop.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;
    private final ChildTransactionService childTransactionService;

    @Override
    public List<MemberDto> selectMembers() {
        return shopMapper.selectMembers();
    }

    @Override
    public void exceptionTest() throws NullPointerException {
        throw new NullPointerException("test");
    }

    /**
     * https://skyblue300a.tistory.com/15
     */
    @Override
    @Transactional
    public void transactionTest() {
        // runtime Exception
        try {
            childTransactionService.insertMember();
//            sameMethodTest();
        } catch (RuntimeException ex) {
            log.error("parentTransactionService.insertMember() exception occur");
        } finally {
            shopMapper.insertMember("exceptionLog", "구로구", LocalDateTime.now());
        }
    }

    @Transactional
    public void sameMethodTest() {
        shopMapper.insertMember("parentTest1", "구로구", LocalDateTime.now());
        log.error("===================================================");
        log.error("================ PARENT EXCEPTION =================");
        log.error("===================================================");
        throw new RuntimeException();
    }
}

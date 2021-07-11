package com.my.toyproject.shop.service;

import com.my.toyproject.shop.mapper.ShopMapper;
import com.my.toyproject.shop.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
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
    public void transactionTest() {
        // runtime Exception
        try {
            shopMapper.insertMember("exceptionLog1", "구로구", LocalDateTime.now());
//            childTransactionService.insertMember();
            sameMethodTest();
        } catch (RuntimeException ex) {
            log.error("parentTransactionService.insertMember() exception occur");
        } finally {
            // 자식에서 rollback mark
            shopMapper.insertMember("exceptionLog2", "구로구", LocalDateTime.now());
//            throw new RuntimeException("parent runtime exception");
        }
    }

    @Transactional(readOnly = true)
    public void sameMethodTest() {
        shopMapper.insertMember("parentTest1", "구로구", LocalDateTime.now());
        log.error("===================================================");
        log.error("================ PARENT EXCEPTION =================");
        log.error("===================================================");
    }
}

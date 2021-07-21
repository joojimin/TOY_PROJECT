package com.my.toyproject.shop.ui;

import java.util.Collections;
import java.util.List;

import com.my.toyproject.dblog.application.EnableDataBaseLog;
import com.my.toyproject.shop.dto.MemberDto;
import com.my.toyproject.shop.application.ShopService;
import com.my.toyproject.common.ApiVersion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.my.toyproject.common.ApiVersionType.VERSION_1_0;
import static com.my.toyproject.common.ApiVersionType.VERSION_2_0;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopServiceImpl;

    @ApiVersion(VERSION_1_0)
    @GetMapping("/members")
    @EnableDataBaseLog
    public List<MemberDto> getMemberAll(){
        List<MemberDto> list = shopServiceImpl.selectMembers();
        log.debug("[shopService] selectMember call. result={}", list);
        return list;
    }

    @ApiVersion(VERSION_2_0)
    @GetMapping("/members")
    public List<MemberDto> getMemberAllV2_0(){
        // empty result
        return Collections.emptyList();
    }

    @GetMapping("/exception-test")
    public List<MemberDto> exceptionTest(){
        shopServiceImpl.exceptionTest();

        return shopServiceImpl.selectMembers();
    }

    @GetMapping("/transaction-test")
    public ResponseEntity<Void> transactionTest() {
        shopServiceImpl.transactionTest();
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return ResponseEntity.badRequest().build();
    }
}

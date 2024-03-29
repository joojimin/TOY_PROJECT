package com.my.toyproject.shop.ui;

import java.util.Collections;
import java.util.List;

import com.my.toyproject.dblog.application.EnableDataBaseLog;
import com.my.toyproject.shop.dto.MemberDto;
import com.my.toyproject.shop.application.ShopService;
import com.my.toyproject.common.ApiVersion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.my.toyproject.common.ApiVersionType.VERSION_1_0;
import static com.my.toyproject.common.ApiVersionType.VERSION_2_0;

@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopService;

    @ApiVersion(VERSION_1_0)
    @GetMapping("/members")
    @EnableDataBaseLog
    public List<MemberDto> getMemberAll() {
        List<MemberDto> list = shopService.selectMembers();
        log.debug("[shopService] selectMember call. result={}", list);
        return list;
    }

    @ApiVersion(VERSION_2_0)
    @GetMapping("/members")
    public List<MemberDto> getMemberAllV2_0() {
        // empty result
        return Collections.emptyList();
    }

    @GetMapping("/exception-test")
    public List<MemberDto> exceptionTest() {
        shopService.exceptionTest();

        return shopService.selectMembers();
    }

    @GetMapping("/transaction-test")
    public ResponseEntity<Void> transactionTest() {
        shopService.transactionTest();
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/sleep")
    public ResponseEntity<Void> longSleepHandler() {
        try {
            Thread.sleep(20 * 1000L); // 따른 쓰레드 작업
            log.info("sleep END!!!!!!!!");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return ResponseEntity.ok().build();
    }


}

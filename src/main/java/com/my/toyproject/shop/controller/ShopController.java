package com.my.toyproject.shop.controller;

import java.util.Collections;
import java.util.List;

import com.my.toyproject.dblog.annotation.EnableDataBaseLog;
import com.my.toyproject.shop.dto.MemberDto;
import com.my.toyproject.shop.service.ShopService;
import com.my.toyproject.spring.annotation.ApiVersion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.my.toyproject.spring.type.ApiVersionType.VERSION_1_0;
import static com.my.toyproject.spring.type.ApiVersionType.VERSION_2_0;

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
}

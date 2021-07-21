package com.my.toyproject.shop.application;

import com.my.toyproject.shop.dto.MemberDto;

import java.util.List;

public interface ShopService {
    List<MemberDto> selectMembers();
    void exceptionTest();
    void transactionTest();
}

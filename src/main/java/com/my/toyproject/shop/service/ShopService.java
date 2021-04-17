package com.my.toyproject.shop.service;

import com.my.toyproject.shop.dto.MemberDto;

import java.util.List;

public interface ShopService {
    List<MemberDto> selectMembers();
}

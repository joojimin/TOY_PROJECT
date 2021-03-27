package com.my.toyproject.shop.service;

import com.my.toyproject.shop.vo.MemberVo;

import java.util.List;

public interface ShopService {
    List<MemberVo> selectMembers();
}

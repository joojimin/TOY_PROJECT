package com.my.toyproject.shop.service;

import com.my.toyproject.shop.mapper.ShopMapper;
import com.my.toyproject.shop.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;

    @Override
    public List<MemberVo> selectMembers() {
        return shopMapper.selectMembers();
    }
}

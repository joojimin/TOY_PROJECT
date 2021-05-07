package com.my.toyproject.shop.service;

import com.my.toyproject.shop.mapper.ShopMapper;
import com.my.toyproject.shop.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;

    @Override
    public List<MemberDto> selectMembers() {
        return shopMapper.selectMembers();
    }

    @Override
    public void exceptionTest() throws NullPointerException {
        throw new NullPointerException("test");
    }
}

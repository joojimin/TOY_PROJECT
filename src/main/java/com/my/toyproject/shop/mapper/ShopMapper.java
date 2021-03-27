package com.my.toyproject.shop.mapper;

import com.my.toyproject.shop.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    List<MemberVo> selectMembers();
}

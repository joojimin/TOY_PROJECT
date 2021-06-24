package com.my.toyproject.shop.mapper;

import com.my.toyproject.shop.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    List<MemberDto> selectMembers();
    void insertMember(String memberName, String memberAddress, LocalDateTime registerTime);
}

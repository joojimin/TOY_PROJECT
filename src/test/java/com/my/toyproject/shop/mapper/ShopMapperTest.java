package com.my.toyproject.shop.mapper;

import com.my.toyproject.shop.vo.MemberVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ShopMapperTest {

	@Autowired
	ShopMapper shopMapper;

	@Test
	void selectMembersTest(){
		// given

		// when
		List<MemberVo> results = shopMapper.selectMembers();

		// then
		Assert.noNullElements(results, "result element is null");
	}

}

package com.my.toyproject.shop.mapper;

import com.my.toyproject.shop.dto.MemberDto;
import com.my.toyproject.test.config.CustomMapperConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

class ShopMapperTest extends CustomMapperConfig {

	@Autowired
	ShopMapper shopMapper;

	@Test
	void selectMembersTest(){
		// given

		// when
		List<MemberDto> results = shopMapper.selectMembers();

		// then
		Assert.noNullElements(results, "result element is null");
	}

}

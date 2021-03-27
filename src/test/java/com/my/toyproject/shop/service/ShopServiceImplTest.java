package com.my.toyproject.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ShopServiceImplTest {

	@MockBean ShopService shopServiceImpl;

	@Test
	void selectMembersTest(){
		System.out.println(shopServiceImpl.selectMembers());
	}
}

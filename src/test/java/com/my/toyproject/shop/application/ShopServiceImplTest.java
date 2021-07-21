package com.my.toyproject.shop.application;

import com.my.toyproject.shop.dto.MemberDto;
import com.my.toyproject.shop.domain.ShopRepository;
import com.my.toyproject.test.config.CustomMockitoTester;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

class ShopServiceImplTest extends CustomMockitoTester {

	@Mock
	ShopRepository shopRepository;

	@InjectMocks ShopServiceImpl shopServiceImpl;

	@Override
	protected Class getTestClass() {
		return this.getClass();
	}

	@Test
	void selectMembersTest(){
		// given
		List<MemberDto> testMemberList = List.of(makeTestMemberDto(1, "서울시 구로구", "tester1")
												,makeTestMemberDto(2, "서울시 광진구", "tester2")
												,makeTestMemberDto(3, "강원도 춘천시", "tester3"));
		when(shopRepository.findAll()).thenReturn(testMemberList);

		// when
		List<MemberDto> results = shopServiceImpl.selectMembers();

		// then
		assertThat(results).isNotEmpty();
		assertThat(results).hasSize(testMemberList.size());
		assertThat(results).containsSequence(testMemberList);

		verify(shopRepository, times(1)).findAll();
	}

	private MemberDto makeTestMemberDto(int id, String address, String name){
		return MemberDto.builder()
						.memberId(id)
						.memberAddress(address)
						.memberName(name)
						.build();
	}
}
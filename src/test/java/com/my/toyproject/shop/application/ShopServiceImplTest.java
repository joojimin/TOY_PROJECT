package com.my.toyproject.shop.application;

import com.my.toyproject.shop.domain.Member;
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

    @InjectMocks
    ShopServiceImpl shopServiceImpl;

    @Override
    protected Class getTestClass() {
        return this.getClass();
    }

    @Test
    void selectMembersTest() {
        // given
        List<Member> testMemberList = List.of(makeTestMember("서울시 구로구", "tester1"),
											  makeTestMember("서울시 광진구", "tester2"),
											  makeTestMember("강원도 춘천시", "tester3"));
        when(shopRepository.findAll()).thenReturn(testMemberList);

        // when
        List<MemberDto> results = shopServiceImpl.selectMembers();

        // then
        assertThat(results).isNotEmpty();
        assertThat(results).hasSize(testMemberList.size());

        verify(shopRepository, times(1)).findAll();
    }

    private Member makeTestMember(String address, String name) {
        return Member.builder()
                     .address(address)
                     .name(name)
                     .build();
    }
}

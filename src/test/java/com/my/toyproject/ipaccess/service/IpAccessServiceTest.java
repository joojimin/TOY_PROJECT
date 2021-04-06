package com.my.toyproject.ipaccess.service;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import com.my.toyproject.ipaccess.mapper.IpAccessMapper;
import com.my.toyproject.test.config.CustomMockitoTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class IpAccessServiceTest extends CustomMockitoTester {

	@Mock IpAccessMapper ipAccessMapper;
	@InjectMocks IpAccessService ipAccessService;


	@Override
	protected Class getTestClass() {
		return this.getClass();
	}

	@DisplayName("로컬 IP를 이용해 ip filterMap이 제대로 로드되었는지 확인")
	@ParameterizedTest
	@ValueSource(strings = {
		"0.0.0.0",
		"127.0.0.1"
	})
	public void isAccess(String ip){
		// given
		// include parameter
		when(ipAccessMapper.selectAll()).thenReturn(List.of(new IpAccessUserDto().setIp("0.0.0.0"),
															new IpAccessUserDto().setIp("127.0.0.1")));
		ipAccessService.reload();

		// when
		boolean result = assertDoesNotThrow(() -> ipAccessService.isAccess(ip));

		// then
		assertThat(result).isTrue();
	}
}

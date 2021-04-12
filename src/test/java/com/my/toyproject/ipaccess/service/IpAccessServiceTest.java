package com.my.toyproject.ipaccess.service;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import com.my.toyproject.ipaccess.factory.IpAccessUserFactory;
import com.my.toyproject.ipaccess.mapper.IpAccessMapper;
import com.my.toyproject.ipaccess.type.IpAccessType;
import com.my.toyproject.test.config.CustomMockitoTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.*;

class IpAccessServiceTest extends CustomMockitoTester {

	@Mock IpAccessMapper ipAccessMapper;
	@Mock IpAccessUserFactory ipAccessUserFactory;
	@Spy @InjectMocks IpAccessService ipAccessService;


	@Override
	protected Class getTestClass() {
		return this.getClass();
	}

	@DisplayName("로컬 IP를 이용해 access ip filterMap이 제대로 로드되었는지 확인")
	@ParameterizedTest
	@ValueSource(strings = {
		"0.0.0.0",
		"127.0.0.1"
	})
	public void isAccess(String ip){
		// given
		// include parameter
		when(ipAccessUserFactory.getIpAccessUserDto(eq(ip))).thenReturn(Optional.of(new IpAccessUserDto().setIp(ip)
																										 .setOpenYN(1)
																										 .setType(IpAccessType.ACCESS)));


		// when
		boolean result = assertDoesNotThrow(() -> ipAccessService.isAccess(ip));

		// then
		assertThat(result).isTrue();
	}

	@DisplayName("로컬 IP를 이용해 block ip filterMap이 제대로 로드되었는지 확인")
	@ParameterizedTest
	@ValueSource(strings = {
		"0.0.0.0",
		"127.0.0.1"
	})
	public void isBlock(String ip){
		// given
		// include parameter
		when(ipAccessUserFactory.getIpAccessUserDto(eq(ip))).thenReturn(Optional.of(new IpAccessUserDto().setIp(ip)
																										 .setOpenYN(1)
																										 .setType(IpAccessType.BLOCK)));


		// when
		boolean result = assertDoesNotThrow(() -> ipAccessService.isBlock(ip));

		// then
		assertThat(result).isTrue();
	}
}

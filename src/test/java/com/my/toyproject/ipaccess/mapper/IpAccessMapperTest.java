package com.my.toyproject.ipaccess.mapper;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import com.my.toyproject.test.config.CustomMapperTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IpAccessMapperTest extends CustomMapperTester {

	@Autowired
	IpAccessMapper ipAccessMapper;

	@Test
	public void selectAll(){
		// given

		// when
		List<IpAccessUserDto> ipAccessUserDtoList = ipAccessMapper.selectAll();

		// then
		assertThat(ipAccessUserDtoList).isNotEmpty();
	}

}

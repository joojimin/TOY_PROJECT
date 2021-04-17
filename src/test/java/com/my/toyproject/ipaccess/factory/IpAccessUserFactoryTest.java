package com.my.toyproject.ipaccess.factory;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;

class IpAccessUserFactoryTest {

	private IpAccessUserFactory ipAccessUserFactory;

	@BeforeEach
	void setUpInstacne(){
		ipAccessUserFactory = new IpAccessUserFactory();
	}

	@Test
	void loadTest(){
		//given
		List<IpAccessUserDto> ipAccessUserDtoList = List.of(new IpAccessUserDto().setIp("127.0.0.1").setOpenYN(1),
															new IpAccessUserDto().setIp("0.0.0.0").setOpenYN(1),
															new IpAccessUserDto().setIp("1.2.3.4").setOpenYN(0));

		// when
 		assertDoesNotThrow(() -> ipAccessUserFactory.load(ipAccessUserDtoList));

 		// then
		assertThat(ipAccessUserFactory.getIpAccessUserDto("127.0.0.1")).isPresent();
		assertThat(ipAccessUserFactory.getIpAccessUserDto("0.0.0.0")).isPresent();
		assertThat(ipAccessUserFactory.getIpAccessUserDto("1.2.3.4")).isEmpty();
		assertThat(ipAccessUserFactory.getIpAccessUserDto("5.6.7.8")).isEmpty();
	}


}

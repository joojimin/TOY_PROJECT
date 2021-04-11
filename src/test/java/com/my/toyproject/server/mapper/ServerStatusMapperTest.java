package com.my.toyproject.server.mapper;

import com.my.toyproject.server.vo.ServerStatusVo;
import com.my.toyproject.test.config.CustomMapperTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ServerStatusMapperTest extends CustomMapperTester {

	@Autowired
	private ServerStatusMapper serverStatusMapper;

	@DisplayName("등록된 서버 테이블 전체 조회, ServerStatusTypeHandler도 같이 테스트됨")
	@Test
	public void selectAllTest(){
		List<ServerStatusVo> results = assertDoesNotThrow(()->serverStatusMapper.selectAll());

		assertThat(results).isNotEmpty();
	}
}

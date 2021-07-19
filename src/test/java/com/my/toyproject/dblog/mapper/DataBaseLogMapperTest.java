package com.my.toyproject.dblog.mapper;

import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.dblog.application.DataBaseLogType;
import com.my.toyproject.test.config.CustomMapperTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DataBaseLogMapperTest extends CustomMapperTester {

	@Autowired DataBaseLogMapper dataBaseLogMapper;

	@DisplayName("필수 조건값들을 정의한 insert 테스트, 정상")
	@Test
	void insertTest(){
		DataBaseLogDto dataBaseLogDto = new DataBaseLogDto()
			.setType(DataBaseLogType.PRE)
			.setUrl("/test")
			.setRequest("test request")
			.setServerIp("127.0.0.1")
			.setServerPort(8080);

		assertDoesNotThrow(()-> dataBaseLogMapper.insertLog(dataBaseLogDto));
	}

	@DisplayName("Type 조건을 정의하지 않은 insert 테스트, Exception")
	@Test
	void insertTestfailed_1() {
		DataBaseLogDto dataBaseLogDto = new DataBaseLogDto()
			.setUrl("/test")
			.setRequest("test request")
			.setServerIp("127.0.0.1")
			.setServerPort(8080);

		Exception ex = assertThrows(Exception.class, () -> dataBaseLogMapper.insertLog(dataBaseLogDto));

		assertThat(ex).hasMessageContaining("type");
	}

	@DisplayName("Url 조건을 정의하지 않은 insert 테스트, Exception")
	@Test
	void insertTestfailed_2() {
		DataBaseLogDto dataBaseLogDto = new DataBaseLogDto()
			.setType(DataBaseLogType.PRE)
			.setRequest("test request")
			.setServerIp("127.0.0.1")
			.setServerPort(8080);

		Exception ex = assertThrows(Exception.class, () -> dataBaseLogMapper.insertLog(dataBaseLogDto));

		assertThat(ex).hasMessageContaining("url");
	}

	@DisplayName("Server 조건을 정의하지 않은 insert 테스트, Exception")
	@Test
	void insertTestfailed_3() {
		DataBaseLogDto dataBaseLogDto = new DataBaseLogDto()
			.setType(DataBaseLogType.PRE)
			.setUrl("/test")
			.setRequest("test request");

		Exception ex = assertThrows(Exception.class, () -> dataBaseLogMapper.insertLog(dataBaseLogDto));

		assertThat(ex)
			.hasMessageContaining("serverIp")
			.hasMessageContaining("serverPort");
	}
}

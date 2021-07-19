package com.my.toyproject.dblog.service;

import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.dblog.mapper.DataBaseLogMapper;
import com.my.toyproject.dblog.application.DataBaseLogType;
import com.my.toyproject.test.config.CustomMockitoTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseLogServiceTest extends CustomMockitoTester {

	@Mock private DataBaseLogMapper dataBaseLogMapper;
	@InjectMocks private DataBaseLogServiceImpl dataBaseLogServiceImpl;

	@Override
	protected Class getTestClass() {
		return this.getClass();
	}

	@DisplayName("Service내 정상 insert 테스트")
	@Test
	public void insertTest(){
		// given
		DataBaseLogDto dataBaseLogDto = new DataBaseLogDto().setType(DataBaseLogType.PRE)
			.setUrl("/test")
			.setRequest("{\"TestKey\":\"Hello World\"}")
			.setResponse("{\"TestKey\":\"Hello World\"}")
			.setServerIp("127.0.0.1")
			.setServerPort(8080)
			.setEtc("test")
			.setRegisterTime(LocalDateTime.now());

		assertDoesNotThrow(()-> dataBaseLogServiceImpl.insertLog(dataBaseLogDto));
	}
}

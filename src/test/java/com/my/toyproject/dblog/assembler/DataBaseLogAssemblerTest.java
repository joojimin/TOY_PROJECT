package com.my.toyproject.dblog.assembler;

import com.fasterxml.jackson.databind.JsonNode;
import com.my.toyproject.dblog.application.DataBaseLogAssembler;
import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.dblog.application.DataBaseLogType;
import com.my.toyproject.server.application.ServerStatusFactory;
import com.my.toyproject.server.domain.ServerStatusType;
import com.my.toyproject.server.vo.ServerStatusVo;
import com.my.toyproject.test.config.CustomMockitoTester;
import com.my.toyproject.common.ByteArrayToJsonConverter;
import com.my.toyproject.common.TypeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DataBaseLogAssemblerTest extends CustomMockitoTester {

	@Spy TypeConverter<byte[], JsonNode> byteArrayToJsonConverter = new ByteArrayToJsonConverter();
	@Mock ServerStatusFactory serverStatusFactory;
	@InjectMocks
	DataBaseLogAssembler dataBaseLogAssembler;

	private final static String TEST_IP = "127.0.0.1";
	private final static Integer TEST_PORT = 8080;


	@Override
	protected Class getTestClass() {
		return this.getClass();
	}

	@BeforeEach
	void setUp(){
		when(serverStatusFactory.getMyStatus()).thenReturn(new ServerStatusVo(TEST_IP,
																			  TEST_PORT,
																			  "test",
																			  ServerStatusType.PUBLIC,
																			  true,
																			  "test",
																			  LocalDateTime.now(),
																			  "test",
																			  LocalDateTime.now()));
	}

	@Test
	void requestToDataBaseLogDtoTest() throws IOException {
		// given
		ContentCachingRequestWrapper request = Mockito.mock(ContentCachingRequestWrapper.class);
		when(request.getContentAsByteArray()).thenReturn("{\"TestKey\":\"HelloWorld\"}".getBytes("UTF-8"));


		// when
		DataBaseLogDto dataBaseLogDto = assertDoesNotThrow(()->dataBaseLogAssembler.requestToDataBaseLogDto(DataBaseLogType.PRE, request, "test"));

		// then
		assertThat(dataBaseLogDto).isNotNull();
		assertThat(dataBaseLogDto.getType()).isEqualTo(DataBaseLogType.PRE);
		assertThat(dataBaseLogDto.getRequest())
			.isNotEmpty()
			.isEqualTo("{\"TestKey\":\"HelloWorld\"}");
		assertThat(dataBaseLogDto.getServerIp()).isEqualTo(TEST_IP);
		assertThat(dataBaseLogDto.getServerPort()).isEqualTo(TEST_PORT);
		assertThat(dataBaseLogDto.getEtc()).isEqualTo("test");

	}

	@Test
	void requestResponseToDataBaseLogDtoTest() throws UnsupportedEncodingException {
		// given
		ContentCachingRequestWrapper request = Mockito.mock(ContentCachingRequestWrapper.class);
		ContentCachingResponseWrapper response = Mockito.mock(ContentCachingResponseWrapper.class);
		when(request.getContentAsByteArray()).thenReturn("{\"TestKey\":\"HelloWorld\"}".getBytes("UTF-8"));
		when(response.getContentAsByteArray()).thenReturn("{\"TestKey\":\"HelloWorld!!\"}".getBytes("UTF-8"));


		// when
		DataBaseLogDto dataBaseLogDto = assertDoesNotThrow(
			()->dataBaseLogAssembler.requestResponseToDataBaseLogDto(DataBaseLogType.POST, request, response, "test"));

		// then
		assertThat(dataBaseLogDto).isNotNull();
		assertThat(dataBaseLogDto.getType()).isEqualTo(DataBaseLogType.POST);
		assertThat(dataBaseLogDto.getRequest())
			.isNotEmpty()
			.isEqualTo("{\"TestKey\":\"HelloWorld\"}");
		assertThat(dataBaseLogDto.getResponse())
			.isNotEmpty()
			.isEqualTo("{\"TestKey\":\"HelloWorld!!\"}");
		assertThat(dataBaseLogDto.getServerIp()).isEqualTo(TEST_IP);
		assertThat(dataBaseLogDto.getServerPort()).isEqualTo(TEST_PORT);
		assertThat(dataBaseLogDto.getEtc()).isEqualTo("test");
	}

}

package com.my.toyproject.dblog.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.server.application.ServerStatusFactory;
import com.my.toyproject.common.TypeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class DataBaseLogAssembler {

	private final ServerStatusFactory serverStatusFactory;
	private final TypeConverter<byte[], JsonNode> byteArrayToJsonConverter;

	public DataBaseLogDto requestToDataBaseLogDto(DataBaseLogType type, HttpServletRequest request, String etc) throws IOException {
		return new DataBaseLogDto()
			.setType(type)
			.setUrl(requestToUrl(request))
			.setRequest(requestToRequest(request))
			.setEtc(etc)
			.setServerIp(serverStatusFactory.getMyStatus().getIp())
			.setServerPort(serverStatusFactory.getMyStatus().getPort())
			.setRegisterTime(LocalDateTime.now());
	}

	public DataBaseLogDto requestResponseToDataBaseLogDto(DataBaseLogType type,
														  HttpServletRequest request,
														  HttpServletResponse response,
														  String etc) throws IOException {
		return new DataBaseLogDto()
			.setType(type)
			.setUrl(requestToUrl(request))
			.setRequest(requestToRequest(request))
			.setResponse(responseToResponse(response))
			.setEtc(etc)
			.setServerIp(serverStatusFactory.getMyStatus().getIp())
			.setServerPort(serverStatusFactory.getMyStatus().getPort())
			.setRegisterTime(LocalDateTime.now());
	}

	private String requestToUrl(HttpServletRequest request){
		return request.getRequestURI();
	}

	private String requestToRequest(HttpServletRequest request) throws IOException {
		ContentCachingRequestWrapper wrappingRequest = (ContentCachingRequestWrapper)request;
		return byteArrayToJsonConverter.convert(wrappingRequest.getContentAsByteArray()).toString();
	}

	private String responseToResponse(HttpServletResponse response) throws IOException {
		ContentCachingResponseWrapper wrappingResponse = (ContentCachingResponseWrapper)response;
		return byteArrayToJsonConverter.convert(wrappingResponse.getContentAsByteArray()).toString();
	}
}

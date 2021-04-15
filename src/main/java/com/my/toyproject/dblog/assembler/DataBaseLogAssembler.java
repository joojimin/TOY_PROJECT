package com.my.toyproject.dblog.assembler;

import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.server.factory.ServerStatusFactory;
import com.my.toyproject.util.converter.JsonNodeConverter;
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
	private final JsonNodeConverter<byte[]> ByteArrayToJsonConverter;

	public DataBaseLogDto requestToDataBaseLogDto(HttpServletRequest request, String etc) throws IOException {
		return new DataBaseLogDto()
			.setUrl(requestToUrl(request))
			.setRequest(requestToRequest(request))
			.setEtc(etc)
			.setServerIp(serverStatusFactory.getMyStatus().getIp())
			.setServerPort(serverStatusFactory.getMyStatus().getPort())
			.setRegisterTime(LocalDateTime.now());
	}

	public DataBaseLogDto requestResponseToDataBaseLogDto(HttpServletRequest request, HttpServletResponse response, String etc) throws IOException {
		return new DataBaseLogDto()
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
		return ByteArrayToJsonConverter.convert(wrappingRequest.getContentAsByteArray()).toString();
	}

	private String responseToResponse(HttpServletResponse response) throws IOException {
		ContentCachingResponseWrapper wrappingResponse = (ContentCachingResponseWrapper)response;
		return ByteArrayToJsonConverter.convert(wrappingResponse.getContentAsByteArray()).toString();
	}
}

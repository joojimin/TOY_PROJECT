package com.my.toyproject.web.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;


import static org.assertj.core.api.Assertions.assertThat;

class CachingServletReqResFilterTest {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void contentCachingRequestWrapperTest() throws Exception {

		// given
		byte[] source = "{\"TestKey\":\"Hello World\"}".getBytes("UTF-8");

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");
		request.setCharacterEncoding("UTF-8");
		request.setContent(source);

		// when
		ContentCachingRequestWrapper wrapper = new ContentCachingRequestWrapper(request);

		// then
		byte[] response = FileCopyUtils.copyToByteArray(wrapper.getInputStream());
		JsonNode json = objectMapper.readTree(response);

		assertThat(response)
			.isNotEmpty()
			.isEqualTo(source);

		assertThat(json).isNotEmpty();
		assertThat(json.get("TestKey")).isNotNull();
		assertThat(json.get("TestKey").asText()).isEqualTo("Hello World");
	}

}

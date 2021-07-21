package com.my.toyproject.web.filter;

import com.my.toyproject.configuration.IpAccessFilter;
import com.my.toyproject.ipaccess.application.IpAccessService;
import com.my.toyproject.server.application.FindServerStatusService;
import com.my.toyproject.test.config.CustomMockMvcTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

class IpAccessFilterTest extends CustomMockMvcTester {

	private static final String TEST_URL = "/ip-access/test";

	@Autowired private IpAccessService ipAccessService;
	@Autowired private FindServerStatusService findServerStatusServiceImpl;

	@Override
	protected Filter[] addFilters() {
		return new Filter[]{
			new IpAccessFilter(ipAccessService, findServerStatusServiceImpl)
		};
	}

	@Test
	public void successFilterTest() throws Exception {
		assertDoesNotThrow(()-> mockMvc
			.perform(get(TEST_URL+"/successFilterTest"))
			.andExpect(status().isOk())
			.andExpect(content().string(String.format("Hello filter test [successFilterTest]"))));
	}
}

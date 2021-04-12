package com.my.toyproject.spring.filter;

import com.my.toyproject.ipaccess.service.IpAccessService;
import com.my.toyproject.server.service.FindServerStatusService;
import com.my.toyproject.test.config.CustomMockMvcTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.Filter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

class IpAccessFilterTest extends CustomMockMvcTester {

	private static final String TEST_URL = "/ip-access/test";

	@Autowired private IpAccessService ipAccessService;
	@Autowired private FindServerStatusService findServerStatusServiceImpl;

	@Autowired MockMvc mockMvc;

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

package com.my.toyproject.shop.controller;

import com.my.toyproject.spring.filter.CachingServletReqResFilter;
import com.my.toyproject.spring.filter.IpAccessFilter;
import com.my.toyproject.test.config.CustomMockMvcTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class ShopControllerTest extends CustomMockMvcTester {

	private static final String GET_V1_0_MEMBERS = "/v1.0/members";
	private static final String GET_V2_0_MEMBERS = "/v2.0/members";

	@Override
	protected Filter[] addFilters() {
		return new Filter[]{
			new CachingServletReqResFilter()
		};
	}

	@Test
	void getMemberAll() throws Exception {
		super.mockMvc.perform(get(GET_V1_0_MEMBERS))
			   .andExpect(status().isOk())
			   .andDo(print());
	}

	@Test
	void getMemberAllV2_0() throws Exception {
		super.mockMvc.perform(get(GET_V2_0_MEMBERS))
			   .andExpect(status().isOk())
			   .andDo(print());
	}
}

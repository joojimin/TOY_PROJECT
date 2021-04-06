package com.my.toyproject.shop.controller;

import com.my.toyproject.test.config.CustomMockMvcTester;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class ShopControllerTest extends CustomMockMvcTester {

	@Test
	void getMemberAll() throws Exception {
		super.mockMvc.perform(get("/v1.0/members"))
			   .andExpect(status().isOk())
			   .andDo(print());
	}

	@Test
	void getMemberAllV2_0() throws Exception {
		super.mockMvc.perform(get("/v2.0/members"))
			   .andExpect(status().isOk())
			   .andDo(print());
	}
}

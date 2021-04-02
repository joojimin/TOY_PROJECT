package com.my.toyproject.shop.controller;

import com.my.toyproject.test.config.CustomMockMvcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class ShopControllerTest extends CustomMockMvcConfig {

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

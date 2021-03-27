package com.my.toyproject.test.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
public class CustomMockMvcConfig {

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Autowired
	protected MockMvc mockMvc;

	@Order(0)
	@BeforeEach
	protected void setUp(){
		this.mockMvc = MockMvcBuilders
			.webAppContextSetup(webApplicationContext)
			.addFilter(new CharacterEncodingFilter("UTF-8", true)) // Character Encoding
			.alwaysDo(print())
			.build();
	}
}

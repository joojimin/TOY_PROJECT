package com.my.toyproject.test.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.Ordered;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("local")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CustomMockMvcTester {

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Autowired
	protected MockMvc mockMvc;

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@BeforeEach
	protected void setUp(){
		this.mockMvc = MockMvcBuilders
			.webAppContextSetup(webApplicationContext)
			.addFilter(new CharacterEncodingFilter("UTF-8", true)) // Character Encoding
			.addFilters(addFilters())
			.alwaysDo(print())
			.build();
	}

	protected Filter[] addFilters() {
		return new Filter[0];
	}
}

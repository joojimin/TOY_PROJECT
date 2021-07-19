package com.my.toyproject.shop.controller;

import com.my.toyproject.shop.service.ShopServiceImpl;
import com.my.toyproject.configuration.CachingServletReqResFilter;
import com.my.toyproject.test.config.CustomMockMvcTester;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.servlet.Filter;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MockitoControllerTest extends CustomMockMvcTester {

	private static final String EXCEPTION_TEST = "/exceptionTest";

	@MockBean private ShopServiceImpl shopServiceImpl;

	@Override
	protected Filter[] addFilters() {
		return new Filter[]{
			new CachingServletReqResFilter()
		};
	}


	@Test
	public void test() throws Exception {
		Mockito.doThrow(new NullPointerException()).when(shopServiceImpl);

		super.mockMvc.perform(get(EXCEPTION_TEST))
					 .andExpect(status().isOk())
					 .andDo(print());

		Mockito.verify(shopServiceImpl, Mockito.times(1)).selectMembers();
	}
}

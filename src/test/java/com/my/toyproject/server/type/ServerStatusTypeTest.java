package com.my.toyproject.server.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerStatusTypeTest {

	@Test
	public void privateTypeTest(){
		// given
		int code = 1;

		// when
		ServerStatusType serverStatusType = assertDoesNotThrow(()->ServerStatusType.valueOf(code));

		// then
		assertEquals(serverStatusType, ServerStatusType.PRIVATE);
	}

	@Test
	public void publicTypeTest(){
		// given
		int code = 2;

		// when
		ServerStatusType serverStatusType = assertDoesNotThrow(()->ServerStatusType.valueOf(code));

		// then
		assertEquals(serverStatusType, ServerStatusType.PUBLIC);
	}

	@Test
	public void noneTest(){
		// given
		int code = 3;

		// when
		ServerStatusType serverStatusType = assertDoesNotThrow(()->ServerStatusType.valueOf(code));

		// then
		assertEquals(serverStatusType, ServerStatusType.NONE);
	}

}

package com.my.toyproject.dblog.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DataBaseLogTypeTest {

	@DisplayName("Success case")
	@ParameterizedTest
	@ValueSource(strings = {
		"PRE",
		"POST",
		"AFTER_COMPLETE",
	})
	void getInstanceTest(final String value){

		DataBaseLogType type = DataBaseLogType.getInstance(value);

		assertThat(type).isNotNull();
		assertThat(type).isNotEqualTo(DataBaseLogType.NONE);
	}

	@DisplayName("None case")
	@ParameterizedTest
	@ValueSource(strings = {
		"test",
		"",
		"NONE"
	})
	void getInstanceTestNone(final String value){

		DataBaseLogType type = DataBaseLogType.getInstance(value);

		assertThat(type).isNotNull();
		assertThat(type).isEqualTo(DataBaseLogType.NONE);
	}

	@Test
	void isPreTest(){
		// when
		DataBaseLogType type = DataBaseLogType.getInstance("PRE");
		DataBaseLogType type1 = DataBaseLogType.getInstance("pre");

		// then
		assertThat(type).isNotNull();
		assertThat(type1).isNotNull();
		assertThat(DataBaseLogType.isPre(type)).isTrue();
		assertThat(DataBaseLogType.isPre(type1)).isTrue();
		assertThat(DataBaseLogType.isPre(DataBaseLogType.PRE_HANDLE)).isTrue();
		assertThat(DataBaseLogType.isPre(DataBaseLogType.POST_HANDLE)).isFalse();
		assertThat(DataBaseLogType.isPre(DataBaseLogType.NONE)).isFalse();
	}

	@Test
	void isPostTest(){
		// when
		DataBaseLogType type = DataBaseLogType.getInstance("POST");
		DataBaseLogType type1 = DataBaseLogType.getInstance("post");

		// then
		assertThat(type).isNotNull();
		assertThat(type1).isNotNull();
		assertThat(DataBaseLogType.isPost(type)).isTrue();
		assertThat(DataBaseLogType.isPost(type1)).isTrue();
		assertThat(DataBaseLogType.isPost(DataBaseLogType.POST_HANDLE)).isTrue();
		assertThat(DataBaseLogType.isPost(DataBaseLogType.PRE_HANDLE)).isFalse();
		assertThat(DataBaseLogType.isPost(DataBaseLogType.NONE)).isFalse();
	}

	@Test
	void isAfterComplete(){
		// when
		DataBaseLogType type = DataBaseLogType.getInstance("AFTER_COMPLETE");
		DataBaseLogType type1 = DataBaseLogType.getInstance("after_complete");

		// then
		assertThat(type).isNotNull();
		assertThat(type1).isNotNull();
		assertThat(DataBaseLogType.isAfterComplete(type)).isTrue();
		assertThat(DataBaseLogType.isAfterComplete(type1)).isTrue();
		assertThat(DataBaseLogType.isAfterComplete(DataBaseLogType.AFTER_COMPLETE_HANDLE)).isTrue();
		assertThat(DataBaseLogType.isAfterComplete(DataBaseLogType.PRE_HANDLE)).isFalse();
		assertThat(DataBaseLogType.isAfterComplete(DataBaseLogType.NONE)).isFalse();
	}

}

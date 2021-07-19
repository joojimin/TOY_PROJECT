package com.my.toyproject.dblog.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum DataBaseLogType {
	NONE,
	PRE,
	POST,
	AFTER_COMPLETE,
	;

	public static DataBaseLogType getInstance(final String code){
		return Arrays.stream(values())
					 .filter(value -> value.name().equalsIgnoreCase(code))
					 .findFirst()
					 .orElse(NONE);
	}

	public static boolean isPre(final DataBaseLogType type){
		return PRE == type;
	}

	public static boolean isPost(final DataBaseLogType type){
		return POST == type;
	}

	public static boolean isAfterComplete(final DataBaseLogType type){
		return AFTER_COMPLETE == type;
	}


}

package com.my.toyproject.dblog.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum DataBaseLogType {

	NONE(""),
	PRE_HANDLE("PRE"),
	POST_HANDLE("POST"),
	AFTER_COMPLETE_HANDLE("AFTER_COMPLETE"),
	;

	private final String name;

	public static DataBaseLogType getInstance(final String code){
		return Arrays.stream(values())
					 .filter(value -> value.getName().equalsIgnoreCase(code))
					 .findFirst()
					 .orElseGet(()->NONE);
	}

	public static boolean isPre(final String value){
		return PRE_HANDLE.name.equalsIgnoreCase(value);
	}

	public static boolean isPre(final DataBaseLogType type){
		return PRE_HANDLE == type;
	}

	public static boolean isPost(final String value){
		return POST_HANDLE.name.equalsIgnoreCase(value);
	}

	public static boolean isPost(final DataBaseLogType type){
		return POST_HANDLE == type;
	}

	public static boolean isAfterComplete(final String value){
		return AFTER_COMPLETE_HANDLE.name.equalsIgnoreCase(value);
	}

	public static boolean isAfterComplete(final DataBaseLogType type){
		return AFTER_COMPLETE_HANDLE == type;
	}


}

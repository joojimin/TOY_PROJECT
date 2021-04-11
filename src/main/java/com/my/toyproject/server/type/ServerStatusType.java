package com.my.toyproject.server.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum ServerStatusType {
	NONE(0),
	PRIVATE(1),
	PUBLIC(2),
	;

	private final int code;

	public static ServerStatusType valueOf(final int code){
		return Arrays.stream(values())
			  .filter(value -> value.getCode() == code)
			  .findFirst()
			  .orElseGet(()->NONE);
	}


	public static boolean isPublic(final int code){
		return PUBLIC.getCode() == code;
	}

	public static boolean isPublic(final ServerStatusType serverStatusType){
		return PUBLIC == serverStatusType;
	}
}

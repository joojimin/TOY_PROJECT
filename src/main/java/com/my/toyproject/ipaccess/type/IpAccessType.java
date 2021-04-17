package com.my.toyproject.ipaccess.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum IpAccessType {

	NONE(0),
	ACCESS(1),
	BLOCK(2),
	;

	private final int code;

	public static IpAccessType valueOf(final int code){
		return Arrays.stream(values())
					 .filter(value -> value.getCode() == code)
					 .findFirst()
					 .orElseGet(()->NONE);
	}

	public static boolean canAccess(final int code){
		return ACCESS.getCode() == code;
	}

	public static boolean canAccess(final IpAccessType ipAccessType){
		return ACCESS == ipAccessType;
	}

	public static boolean isBlock(final int code){
		return BLOCK.getCode() == code;
	}

	public static boolean isBlock(final IpAccessType ipAccessType){
		return BLOCK == ipAccessType;
	}
}

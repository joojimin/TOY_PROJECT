package com.my.toyproject.spring.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ApiVersionType {

	NONE(""),
	VERSION_1_0("1.0"),
	VERSION_2_0("2.0"),
	;

	private final String value;
}

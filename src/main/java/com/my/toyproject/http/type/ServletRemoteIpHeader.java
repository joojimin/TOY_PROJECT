package com.my.toyproject.http.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ServletRemoteIpHeader {

	X_FORWARDED_FOR("X-FORWARDED-FOR"),
	PROXY_CLIENT_IP("Proxy-Client-IP"), // Proxy 서버인 경우
	WL_PROXY_CLIENT_IP("WL-Proxy-Client-IP"), // Weblogic 서버인 경우
	HTTP_CLIENT_IP("HTTP_CLIENT_IP"),
	HTTP_X_FORWARDED_FOR("HTTP_X_FORWARDED_FOR"),
	;

	private final String text;

}

package com.my.toyproject.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcRegistrations{

	@Override
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		return new VersionRequestMappingHandlerMapping("v");
	}
}

package com.my.toyproject.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcRegistrations, WebMvcConfigurer {

	private final DataBaseLogInterceptor dataBaseLogInterceptor;

	@Override
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		return new VersionRequestMappingHandlerMapping("v");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// @EnableDataBaseLog interceptor
		registry.addInterceptor(dataBaseLogInterceptor).addPathPatterns("/**");
	}
}

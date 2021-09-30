package com.my.toyproject.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@Configuration
public class PrintRequestMappingConfig {

	private final RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Bean
	public CommandLineRunner run(){
		return args -> requestMappingHandlerMapping.getHandlerMethods().forEach(this::printRequestMappingInfo);
	}

	private void printRequestMappingInfo(RequestMappingInfo key, HandlerMethod value){
		String msg = new StringBuilder()
			.append(key.getPatternsCondition())
			.append("[")
			.append(key.getMethodsCondition())
			.append("]")
			.append(value)
			.toString();
		log.info(msg);
	}
}

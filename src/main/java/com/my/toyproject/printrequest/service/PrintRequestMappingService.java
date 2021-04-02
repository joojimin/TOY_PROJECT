package com.my.toyproject.printrequest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrintRequestMappingService {

	private final RequestMappingHandlerMapping requestMappingHandlerMapping;

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
		log.debug(msg);
	}
}

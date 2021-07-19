package com.my.toyproject.web.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpAcessFilterTestController {

	@GetMapping("/ip-access/test/{parameter}")
	public String testMethod(@PathVariable final String parameter){
		return String.format("Hello filter test [%s]", parameter);
	}

}

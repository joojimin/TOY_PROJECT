package com.my.toyproject.common;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StringToJsonConverter extends JsonNodeConverter<String>{

	@Override
	public JsonNode convert(String s) throws IOException {
		return objectMapper.readTree(s);
	}
}

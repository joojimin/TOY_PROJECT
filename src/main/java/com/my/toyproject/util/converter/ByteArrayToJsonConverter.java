package com.my.toyproject.util.converter;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ByteArrayToJsonConverter extends JsonNodeConverter<byte[]>{

	@Override
	public JsonNode convert(byte[] bytes) throws IOException {
		return objectMapper.readTree(bytes);
	}
}

package com.my.toyproject.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonNodeConverter<T> implements TypeConverter<T, JsonNode>{
	protected static final ObjectMapper objectMapper = new ObjectMapper();


}

package com.my.toyproject.util.converter;

import java.io.IOException;

public interface TypeConverter<T, F> {
	F convert(T t) throws IOException;
}

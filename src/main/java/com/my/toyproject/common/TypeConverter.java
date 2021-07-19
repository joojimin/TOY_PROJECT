package com.my.toyproject.common;

import java.io.IOException;

public interface TypeConverter<T, F> {
	F convert(T t) throws IOException;
}

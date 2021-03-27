package com.my.toyproject.spring.annotation;

import com.my.toyproject.spring.type.ApiVersionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {
	ElementType.TYPE,
	ElementType.METHOD
})
public @interface ApiVersion {
	ApiVersionType value() default ApiVersionType.NONE;
}

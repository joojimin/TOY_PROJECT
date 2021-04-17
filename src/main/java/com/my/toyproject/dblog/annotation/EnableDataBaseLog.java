package com.my.toyproject.dblog.annotation;

import com.my.toyproject.dblog.type.DataBaseLogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {
	ElementType.TYPE,
	ElementType.METHOD
})
public @interface EnableDataBaseLog {
	DataBaseLogType[] value() default { DataBaseLogType.POST_HANDLE };
}

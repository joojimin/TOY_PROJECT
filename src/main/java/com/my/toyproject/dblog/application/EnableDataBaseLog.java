package com.my.toyproject.dblog.application;

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
	DataBaseLogType[] value() default { DataBaseLogType.POST};
}

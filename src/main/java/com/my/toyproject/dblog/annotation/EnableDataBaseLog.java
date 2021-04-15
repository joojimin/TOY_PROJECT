package com.my.toyproject.dblog.annotation;

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
	boolean enablePreHandle() default false;
	boolean enablePostHandle() default true;
	boolean enableAfterComplete() default false;
}

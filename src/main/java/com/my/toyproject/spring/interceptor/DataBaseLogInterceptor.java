package com.my.toyproject.spring.interceptor;

import com.my.toyproject.dblog.annotation.EnableDataBaseLog;
import com.my.toyproject.dblog.assembler.DataBaseLogAssembler;
import com.my.toyproject.dblog.service.DataBaseLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataBaseLogInterceptor implements HandlerInterceptor {

	private final DataBaseLogService dataBaseLogServiceImpl;
	private final DataBaseLogAssembler dataBaseLogAssembler;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		EnableDataBaseLog enableDataBaseLog = getAnnotation(handler);
		if(Objects.isNull(enableDataBaseLog)
			|| false == enableDataBaseLog.enablePreHandle()){
			return true; // skip
		}

		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestToDataBaseLogDto(request, ""));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		EnableDataBaseLog enableDataBaseLog = getAnnotation(handler);
		if(Objects.isNull(enableDataBaseLog)
		   || false == enableDataBaseLog.enablePostHandle()){
			return;
		}

		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestResponseToDataBaseLogDto(request, response, ""));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		EnableDataBaseLog enableDataBaseLog = getAnnotation(handler);
		if(Objects.isNull(enableDataBaseLog)
		   || false == enableDataBaseLog.enableAfterComplete()){
			return;
		}

		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestResponseToDataBaseLogDto(request, response, ""));
	}

	private EnableDataBaseLog getAnnotation(Object handler) {
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Method method = handlerMethod.getMethod();

			// METHOD
			EnableDataBaseLog annotation = method.getAnnotation(EnableDataBaseLog.class);
			if(Objects.isNull(annotation)){
				// TYPE ( Class )
				annotation = method.getDeclaringClass().getAnnotation(EnableDataBaseLog.class);
			}
			return annotation;
		}
		return null;
	}
}

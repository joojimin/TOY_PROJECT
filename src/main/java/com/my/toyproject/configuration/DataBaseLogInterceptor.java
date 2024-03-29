package com.my.toyproject.configuration;

import com.my.toyproject.dblog.application.EnableDataBaseLog;
import com.my.toyproject.dblog.application.DataBaseLogAssembler;
import com.my.toyproject.dblog.service.DataBaseLogService;
import com.my.toyproject.dblog.application.DataBaseLogType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@Component
public class DataBaseLogInterceptor implements HandlerInterceptor {

	private final DataBaseLogService dataBaseLogServiceImpl;
	private final DataBaseLogAssembler dataBaseLogAssembler;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Optional<DataBaseLogType> logType = getAnnotation(handler).stream()
																  .flatMap(annotation-> Arrays.stream(annotation.value()))
																  .filter(DataBaseLogType::isPre)
																  .findFirst();
		if(logType.isEmpty()){
			return true;
		}

		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestToDataBaseLogDto(DataBaseLogType.PRE, request, ""));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Optional<DataBaseLogType> logType = getAnnotation(handler).stream()
																  .flatMap(annotation-> Arrays.stream(annotation.value()))
																  .filter(DataBaseLogType::isPost)
																  .findFirst();
		if(logType.isEmpty()){
			return;
		}


		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestResponseToDataBaseLogDto(DataBaseLogType.POST,
																			request,
																			response,
																			""));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Optional<DataBaseLogType> logType = getAnnotation(handler).stream()
																  .flatMap(annotation-> Arrays.stream(annotation.value()))
																  .filter(DataBaseLogType::isAfterComplete)
																  .findFirst();
		if(logType.isEmpty()){
			return;
		}


		dataBaseLogServiceImpl
			.insertLog(dataBaseLogAssembler.requestResponseToDataBaseLogDto(DataBaseLogType.AFTER_COMPLETE,
																			request,
																			response,
																			""));
	}

	private Optional<EnableDataBaseLog> getAnnotation(Object handler) {
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Method method = handlerMethod.getMethod();

			// METHOD
			EnableDataBaseLog annotation = method.getAnnotation(EnableDataBaseLog.class);
			if(Objects.isNull(annotation)){
				// TYPE ( Class )
				annotation = method.getDeclaringClass().getAnnotation(EnableDataBaseLog.class);
			}
			return Optional.ofNullable(annotation);
		}
		return Optional.empty();
	}
}

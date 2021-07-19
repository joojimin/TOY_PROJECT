package com.my.toyproject.configuration;

import com.my.toyproject.common.ApiVersion;
import com.my.toyproject.common.ApiVersionType;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Objects;

@RequiredArgsConstructor
public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

	private final String prefix;

	/**
	 * Custom mapping using @ApiVersion
	 * @param method
	 * @param handlerType
	 * @return
	 */
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
		if (Objects.isNull(requestMappingInfo)) {
			return null;
		}

		ApiVersion particularMethodApiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
		if(Objects.isNull(particularMethodApiVersion)
			|| Objects.equals(particularMethodApiVersion.value(), ApiVersionType.NONE)){
			return requestMappingInfo;
		}

		return createRequestMappingInfo(particularMethodApiVersion.value(), requestMappingInfo, handlerType);
	}

	private RequestMappingInfo createRequestMappingInfo(ApiVersionType apiVersionType, RequestMappingInfo requestMappingInfo, Class<?> handlerType) {
		RequestCondition<?> requestCondition = super.getCustomTypeCondition(handlerType);
		String[] patterns = new String[]{String.format("%s%s",prefix,apiVersionType.getValue())};
		return this.createApiVersionInfo(patterns, requestCondition).combine(requestMappingInfo);
	}

	private RequestMappingInfo createApiVersionInfo(String[] patterns, RequestCondition<?> requestCondition) {
		PatternsRequestCondition patternsRequestCondition = new PatternsRequestCondition(patterns, this.getUrlPathHelper(), this.getPathMatcher(), this.useSuffixPatternMatch(), this.useTrailingSlashMatch(), this.getFileExtensions());
		return new RequestMappingInfo(patternsRequestCondition, new RequestMethodsRequestCondition(new RequestMethod[0]), new ParamsRequestCondition(new String[0]), new HeadersRequestCondition(new String[0]), new ConsumesRequestCondition(new String[0]), new ProducesRequestCondition(new String[0]), requestCondition);
	}

}

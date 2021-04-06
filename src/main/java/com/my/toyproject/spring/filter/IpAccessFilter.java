package com.my.toyproject.spring.filter;

import com.my.toyproject.http.type.ServletRemoteIpHeader;
import com.my.toyproject.ipaccess.service.IpAccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
@WebFilter(urlPatterns = "/*")
public class IpAccessFilter extends OncePerRequestFilter {

	private final IpAccessService ipAccessService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse,
									FilterChain filterChain) throws ServletException, IOException {
		String ip = getIp(httpServletRequest);
		if(false == ipAccessService.isAccess(ip)){
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private String getIp(HttpServletRequest httpServletRequest){
		return Arrays.stream(ServletRemoteIpHeader.values())
			  	.map(header -> httpServletRequest.getHeader(header.getText()))
			  	.filter(value -> false == isEmptyOrUnknown(value))
			  	.findFirst()
			  	.orElseGet(httpServletRequest::getRemoteAddr);
	}

	private boolean isEmptyOrUnknown(final String value){
		return StringUtils.isEmpty(value)|| "unknown".equalsIgnoreCase(value);
	}
}

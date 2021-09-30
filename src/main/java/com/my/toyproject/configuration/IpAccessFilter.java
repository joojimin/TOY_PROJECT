package com.my.toyproject.configuration;

import com.my.toyproject.common.ServletRemoteIpHeaderType;
import com.my.toyproject.ipaccess.application.IpAccessService;
import com.my.toyproject.server.application.FindServerStatusService;
import com.my.toyproject.server.domain.ServerStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Profile("dev")
@RequiredArgsConstructor
@WebFilter(urlPatterns = "/*")
public class IpAccessFilter extends OncePerRequestFilter {

	private final IpAccessService ipAccessService;
	private final FindServerStatusService findServerStatusServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse,
									FilterChain filterChain) throws ServletException, IOException {
		String ip = getIp(httpServletRequest);
		if(canAccess(ip)){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else{
			// 접근불가
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	private boolean canAccess(final String ip){
		if(ServerStatusType.isPublic(findServerStatusServiceImpl.getMyServerStatusVo().getType())){
			// public 서버일경우 block 계정만 차단
			return false == ipAccessService.isBlock(ip);
		}else{
			// private 서버일경우 access 계정만 접근허용
			return ipAccessService.isAccess(ip);
		}
	}

	private String getIp(HttpServletRequest httpServletRequest){
		return Arrays.stream(ServletRemoteIpHeaderType.values())
			  	.map(header -> httpServletRequest.getHeader(header.getText()))
			  	.filter(value -> false == isEmptyOrUnknown(value))
			  	.findFirst()
			  	.orElseGet(httpServletRequest::getRemoteAddr);
	}

	private boolean isEmptyOrUnknown(final String value){
		return StringUtils.isEmpty(value)|| "unknown".equalsIgnoreCase(value);
	}
}

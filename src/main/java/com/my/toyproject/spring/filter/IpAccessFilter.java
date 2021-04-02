package com.my.toyproject.spring.filter;

import com.my.toyproject.ipaccess.service.IpAccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@WebFilter
public class IpAccessFilter extends OncePerRequestFilter {

	private final IpAccessService ipAccessService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse,
									FilterChain filterChain) throws ServletException, IOException {
		if(false == ipAccessService.isAccess(httpServletRequest.getRemoteAddr())){
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}

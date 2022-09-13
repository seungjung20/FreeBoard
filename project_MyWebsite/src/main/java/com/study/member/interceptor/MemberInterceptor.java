package com.study.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 이용하지 않음
public class MemberInterceptor extends HandlerInterceptorAdapter implements SessionNames {

	@Override
	// preHandle : 클라이언트에서 컨트롤러로 요청할 때 가로채는 것. 즉, 컨트롤러가 호출되기 전에 실행되는 메서드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return super.preHandle(request, response, handler);
	}

	@Override
	// postHandle : 컨트롤러에서 클라이언트로 요청할 때 가로채는 것. 즉, 컨트롤러가 호출되고 난 후에 실행되는 메서드
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	
	
}

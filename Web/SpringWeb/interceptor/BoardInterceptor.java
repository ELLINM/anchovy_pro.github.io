package com.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		//request를 통해 getSession을 갖고온다
		Object obj = session.getAttribute("userid");
		//Service에서 입력한 userid가 존재하는지 판단
		if(obj == null){
			response.sendRedirect("/web/member/loginForm");
			//화면 전환을 위한 method
			return false;
		}
		return true;
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	}
	
	
}

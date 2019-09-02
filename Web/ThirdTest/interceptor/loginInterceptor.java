package com.sesoc.moneybook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class loginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String userid = (String)request.getSession().getAttribute("userid");
		if(userid == null){
			response.sendRedirect("/moneybook/login/moveLogin");
			return false;
		}

		return true;
	}
}

package com.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//login 처리 담당
public class GuestbookInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("게스츠북 afterHandle");
		//모든 로직이 실행되고 나오는 메서드
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//컨트롤러를 실행한 후에 호출되는 메서드
		System.out.println("게스츠북 postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//controller가 실행되기 전에 불러옴
		//true가 반환 되면 이후 로직이 차례대로 수행됨
		//false가 반환되면 이후 로직이 무시됨 con - ser - dao
		HttpSession session = request.getSession();
		//login 처리를 담당하는 사용자 정보를 담고  있는 객체를 갖고옴
		Object obj = session.getAttribute("userid");
		if(obj == null){
			//login이 안되어 있는 상태임으로 loginForm으로 돌려보냄(redirect)
			response.sendRedirect("/web/member/loginForm");
			return false;
		}
		return true;
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	}
}

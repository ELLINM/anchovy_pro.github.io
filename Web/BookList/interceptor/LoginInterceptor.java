package global.sesoc.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		//HttpServletRequest에 저장되어 있는 session을 갖고옴
		String loginId = (String)session.getAttribute("loginId");
		//login이 되어 있다면 login되어 있는 id를 String값으로 갖고와서 저잘
		
		// 로그인을 안했으면 로그인 화면으로 리다이렉트
		if(loginId == null) {
			//loginId에 값이 들어있지 않는다면
			String contextPath = request.getContextPath();
			//String 값으로 저장
			response.sendRedirect(contextPath+"/login");
			//요청 응답으로 response로 담아서 보냄 login이 안되기 때문에 값이 들어있지 않음
			return false;
		}
		
		// 로그인을 했으면 true, 
		return true;
	}

}

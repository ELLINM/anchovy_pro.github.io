package com.sesoc.moneybook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.moneybook.dao.MemberDAO;
import com.sesoc.moneybook.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping(value = "/movelogin", method = RequestMethod.GET)
	public String moveLogin(){
		return "loginForm";
	}
	
	@RequestMapping(value = "/goLogout", method = RequestMethod.GET)
	public String goLogout(HttpSession session){
		session.invalidate();
		return "redirect:/goMain";
	}
	
	@RequestMapping(value = "/goLogin", method = RequestMethod.POST)
	public String goLogin(MemberVO member, HttpSession session){
		MemberVO resultVo = memberDao.selectMember(member);
		if (resultVo == null){
			return "redirect:/goMain";
		}
		
		session.setAttribute("userid", resultVo.getUserid());
		return "redirect:/goMain";
	}
}

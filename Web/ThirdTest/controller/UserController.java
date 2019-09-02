package com.sesoc.moneybook.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.moneybook.dao.MemberDAO;
import com.sesoc.moneybook.vo.MemberVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping(value = "/moveSignup", method = RequestMethod.GET)
	public String moveSignup(){
		return "signupForm";
	}
	
	@RequestMapping(value = "/goSignup", method = RequestMethod.POST)
	public String goSignup(MemberVO member, HttpSession session){
		int result = memberDao.insertMember(member);
		if(result == 0){
			return "redirect:/user/moveSignup";
		}
		
		MemberVO resultVo = memberDao.selectMember(member);
		session.setAttribute("userid", resultVo.getUserid());
		return "redirect:/goMain";
	}
}

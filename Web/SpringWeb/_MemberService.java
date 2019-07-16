//MemberService

package com.test.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.MemberDAO;
import com.test.web.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	// 회원가입 처리
	public boolean signup(MemberVO vo) {
		if(dao.signup(vo) != 1) return false;
		//Controller에서 넘어온 값을 받아서 dao로 넘기고 return값으로 true, false를 
		return true;
	}
	
	// 로그인 처리
	public boolean login(MemberVO vo, HttpSession session) {
		if(dao.login(vo) == null) return false;
		session.setAttribute("userid", vo.getUserid());
		return true;
	}
	
	// 로그아웃 처리
	public boolean logout(HttpSession session) {
		session.invalidate();
		return true;
	}
}

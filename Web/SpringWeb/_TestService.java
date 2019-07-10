//TestService

package com.test.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.TestDAO;
import com.test.web.vo.TestVO;

@Service
public class TestService {
	
	@Autowired
	private TestDAO dao;
	
	public void testInsert(TestVO vo) {
		int result = dao.testInsert(vo);
		System.out.println("testInsert 결과 : " + result);
	}
}


//MemberService
package com.test.web.service;
//service에서 값을 저장하는 비지니스 로직을 수행함

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
		return true;
	}
	
	//로그인 처리
	public boolean login(MemberVO vo, HttpSession session) {
		if(dao.login(vo) == null) return false;
		session.setAttribute("userid", vo.getUserid());
		return true;
	}
	
	//로그아웃 처리
		public void logout(HttpSession session) {
			session.invalidate();
			//객체 하나만 삭제하고 싶은 경우 session.removeAttribute
		}
}


//GuestbookService

package com.test.web.service;
//service에서 값을 저장하는 비지니스 로직을 수행함

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.GuestbookDAO;
import com.test.web.dao.MemberDAO;
import com.test.web.vo.GuestbookVO;
import com.test.web.vo.MemberVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDAO dao;
	
	// 회원가입 처리
	public ArrayList<GuestbookVO> guestbookList() {
		return dao.guestbookList();
	
	}
}

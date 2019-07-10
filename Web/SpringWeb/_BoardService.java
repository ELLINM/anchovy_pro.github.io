package com.test.web.service;
//service에서 값을 저장하는 비지니스 로직을 수행함

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDAO;
import com.test.web.dao.GuestbookDAO;
import com.test.web.dao.MemberDAO;
import com.test.web.vo.BoardVO;
import com.test.web.vo.GuestbookVO;
import com.test.web.vo.MemberVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	// 회원가입 처리
	public ArrayList<BoardVO> boardList() {
		return dao.boardList();
	
	}
}

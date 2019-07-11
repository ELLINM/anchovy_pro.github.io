//BoardService

package com.test.web.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDAO;
import com.test.web.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public ArrayList<BoardVO> boardList() {
		return dao.boardList();
	}
	
	public BoardVO boardRead(int boardNum) {
		return dao.boardRead(boardNum);
	}
	
	public void boardDelete(BoardVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		dao.boardDelete(vo);
	}
}



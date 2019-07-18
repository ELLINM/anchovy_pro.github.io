//BoardService

package com.test.web.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDAO;
import com.test.web.vo.BoardVO;
import com.test.web.vo.ReplyVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public ArrayList<BoardVO> boardList(String searchItem, String searchKeyword, PageNavigator navi) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		return dao.boardList(map, navi.getStartRecord(), navi.getCountPerPage());
	}
	
	public BoardVO boardRead(int boardNum) {
		return dao.boardRead(boardNum);
	}
	
	public void replyWrite(ReplyVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		dao.replyWrite(vo);
	}
	
	public boolean boardDelete(BoardVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		if(dao.boardDelete(vo) != 1) return false;
		return true;
	}
	
	public boolean boardUpadte(BoardVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		if(dao.boardUpdate(vo) != 1) return false;
		return true;
	}
	
	public boolean boardWrite(BoardVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		if(dao.boardWrite(vo) != 1) return false;
		return true;
	}
	
	public ArrayList<ReplyVO> replyList(int boardNum){
		return dao.replyList(boardNum);
	}

	public void replyUpdate(ReplyVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		dao.replyUpdate(vo); 
	}

	public boolean replyDelete(ReplyVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		if(dao.replyDelete(vo) != 1) return false;
		return true;
	}
	
	public PageNavigator getNavi(int currentPage, String searchItem, String searchKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchKeyword", searchKeyword);
		map.put("searchItem", searchItem);
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator Navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		return Navi;
	}
}

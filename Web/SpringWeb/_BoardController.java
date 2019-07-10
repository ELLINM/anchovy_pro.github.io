package com.test.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.service.BoardService;
import com.test.web.service.GuestbookService;
import com.test.web.service.MemberService;
import com.test.web.vo.BoardVO;
import com.test.web.vo.GuestbookVO;
import com.test.web.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(Model model) {
		ArrayList<BoardVO> list = service.boardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}

}

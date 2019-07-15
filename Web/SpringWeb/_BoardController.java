//BoardController

package com.test.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.web.service.BoardService;
import com.test.web.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "boardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(Model model) {
		ArrayList<BoardVO> list = service.boardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}
	
	@RequestMapping(value = "boardRead", method = RequestMethod.GET)
	public String boardRead(int boardNum, Model model) {
		BoardVO vo = service.boardRead(boardNum);
		model.addAttribute("vo", vo);
		return "/board/boardRead";
	}
	
	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public String boardDelete(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = service.boardDelete(vo, session);
		rttr.addFlashAttribute("deleteResult", result);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = service.boardUpadte(vo, session);
		rttr.addFlashAttribute("updateResult", result);
		return "redirect:/board/boardRead?boardNum=" + vo.getBoardNum();
		//boardRead로 넘어갈때 boardNum을 갖고가지 않기 때문에 같이 넘겨줘야 한다.
	}
	
	@RequestMapping(value = "boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm(int boardNum, Model model) {
		BoardVO vo = service.boardRead(boardNum);
		//특정글에 대한 정보를 가져오면 되기 대문에 boardRead를 불러온다.
		model.addAttribute("vo", vo);
		return "/board/boardUpdateForm";
	}
	
	@RequestMapping(value = "boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "/board/boardWriteForm";
	}
	
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWriteForm(BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = service.boardWrite(vo, session);
		rttr.addFlashAttribute("writeResult", result);
		return "redirect:/board/boardList";
	}
}

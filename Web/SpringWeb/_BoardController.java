//BoardController

package com.test.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.web.service.BoardService;
import com.test.web.vo.BoardVO;
import com.test.web.vo.ReplyVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(
			Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchItem", defaultValue="title") String searchItem,
			@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword
			) {
		PageNavigator navi = service.getNavi(currentPage, searchItem, searchKeyword);
		ArrayList<BoardVO> list = service.boardList(searchItem, searchKeyword, navi);
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchKeyword", searchKeyword);
		return "/board/boardList";
	}
	
	@RequestMapping(value = "boardRead", method = RequestMethod.GET)
	public String boardRead(int boardNum, Model model) {
		BoardVO vo = service.boardRead(boardNum);
		ArrayList<ReplyVO> replyList = service.replyList(boardNum);
		model.addAttribute("vo", vo);
		model.addAttribute("replyList", replyList);
		return "/board/boardRead";
	}
	
	@RequestMapping(value = "replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVO vo, HttpSession session, RedirectAttributes rttr) {
		service.replyWrite(vo, session);
		rttr.addAttribute("boardNum", vo.getBoardNum());
		return "redirect:/board/boardRead";
	}
	
	@RequestMapping(value = "replyUpdate", method = RequestMethod.GET)
	public String replyUpdate(ReplyVO vo, HttpSession session) {
		service.replyUpdate(vo, session);
		return "redirect:/board/boardRead?boardNum="+vo.getBoardNum();
	}
	
	@RequestMapping(value = "replyDelete", method = RequestMethod.GET)
	public String replyDelete(ReplyVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = service.replyDelete(vo, session);
		rttr.addFlashAttribute("deleteResult", result);
		return "redirect:/board/boardRead?boardNum=" + vo.getBoardNum();
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
	}
	
	@RequestMapping(value = "boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm(int boardNum, Model model) {
		BoardVO vo = service.boardRead(boardNum);
		model.addAttribute("vo", vo);
		return "/board/boardUpdateForm";
	}
	
	@RequestMapping(value = "boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "/board/boardWriteForm";
	}
	
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWriteForm(BoardVO vo, HttpSession session, RedirectAttributes rttr, MultipartFile uploadFile) {
		boolean result = service.boardWrite(vo, session, uploadFile);
		rttr.addFlashAttribute("writeResult", result);
		return "redirect:/board/boardList";
	}
}

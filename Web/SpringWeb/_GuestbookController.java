//GuestbookController
package com.test.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.web.service.GuestbookService;
import com.test.web.vo.GuestbookVO;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService service;
	
	// 방명록 리스트 화면 이동
	@RequestMapping(value = "guestbookList", method = {RequestMethod.GET, RequestMethod.POST})
	public String guestbookList(
			@RequestParam(value="searchItem", defaultValue="name") String searchItem
			, @RequestParam(value="searchKeyword", defaultValue="") String searchKeyword, Model model) {
		ArrayList<GuestbookVO> list = service.guestbookList(searchItem, searchKeyword);
		model.addAttribute("list", list);
		return "/guestbook/guestbookList";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(GuestbookVO vo, Model model) {
		boolean result = service.write(vo);
		model.addAttribute("writeResult", result);
		return "forward:/guestbook/guestbookList";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(GuestbookVO vo, Model model, RedirectAttributes attr) {
		boolean result = service.delete(vo);
		model.addAttribute("deleteResult", result);
		return "forward:/guestbook/guestbookList";
	}	
}

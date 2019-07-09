//GuestbookController
package com.test.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.service.GuestbookService;
import com.test.web.service.MemberService;
import com.test.web.vo.GuestbookVO;
import com.test.web.vo.MemberVO;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService service;
	
	@RequestMapping(value = "guestbookList", method = RequestMethod.GET)
	public String guestbookList(Model model) {
		ArrayList<GuestbookVO> list = service.guestbookList();
		model.addAttribute("list", list);
		return "/guestbook/guestbookList";
	}

}

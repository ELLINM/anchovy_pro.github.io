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
	//guestbookList -> localhost8989/web/guestbook/guestbookList 즉, value = "write"에서 return한 주소값으로 연결된다.
	public String guestbookList(
			@RequestParam(value="searchItem", defaultValue="name") String searchItem
		//GuestbookList.jsp에서 searchItem , searchKeyword 라는 이름의 파라미터가 전달되지 않을 경우
		//String 변수 searchItem 에 “name” , String 변수 searchKeyword 에 “” 를 대입함
			, @RequestParam(value="searchKeyword", defaultValue="") String searchKeyword, Model model) {
		ArrayList<GuestbookVO> list = service.guestbookList(searchItem, searchKeyword);
		model.addAttribute("list", list);
		//model에 저장된 list는 jsp로 return하여 출력
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

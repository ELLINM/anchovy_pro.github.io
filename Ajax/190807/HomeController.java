package com.todoList.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todoList.web.vo.TestVO;

@Controller
public class HomeController {
	
	// 메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "ajaxTest", method = RequestMethod.GET)
	public String ajaxTest() {
		return "ajaxTest";
	}
	
	@RequestMapping(value = "test1", method = RequestMethod.GET)
	@ResponseBody
	public void test1(String id, String name) {
		System.out.println(id);
		System.out.println(name);
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.POST)
	@ResponseBody
	public void test2(TestVO vo) {
		System.out.println(vo);
	}
}

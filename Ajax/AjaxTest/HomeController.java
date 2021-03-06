package com.todoList.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "test3", method = RequestMethod.POST)
	@ResponseBody
	public void test3(@RequestBody TestVO vo) {
	//post 방식으로 전송된 json 데이터를 받음
	//・화면으로부터 값을 전달받는 매개변수에 @RequestBody 를 붙일 것
		System.out.println(vo);
	}
	
	@RequestMapping(value = "test4", method = RequestMethod.POST)
	@ResponseBody
	public void test4(TestVO vo) {
		System.out.println(vo);
	}
	
	@RequestMapping(value = "test5", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<TestVO> test5() {
		ArrayList<TestVO> list = new ArrayList<>();
		list.add(new TestVO("아이디1", "이름1"));
		list.add(new TestVO("아이디2", "이름2"));
		list.add(new TestVO("아이디3", "이름3"));
		list.add(new TestVO("아이디4", "이름4"));
		
		return list;
	}
	
	@RequestMapping(value = "test6", method = RequestMethod.POST)
	@ResponseBody
	public void test6(@RequestBody ArrayList<String>list) {
		//post 방식으로 전송된 json 데이터를 받음
		System.out.println(list);
	}
	
	@RequestMapping(value = "test7", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> test7() {
		HashMap<String, String> map = new HashMap<>(); 
		map.put("id", "아이디");
		map.put("name", "이름");
		return map;
	}
	
	@RequestMapping(value = "test8", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<HashMap<String, String>> test8() {
		ArrayList<HashMap<String, String>> list = new ArrayList<>(); 
		HashMap<String, String> map1 = new HashMap<>(); 
		HashMap<String, String> map2 = new HashMap<>(); 
		map1.put("id", "아이디1");
		map1.put("name", "이름1");
		map2.put("id", "아이디2");
		map2.put("name", "이름2");
		list.add(map1);
		list.add(map2);
		return list;
	}@RequestMapping(value = "test9", method = RequestMethod.POST)
	@ResponseBody
	public void test9(TestVO vo, MultipartFile uploadFile) {
		System.out.println(vo);
		System.out.println(uploadFile.getOriginalFilename());
	}
	
	@RequestMapping(value = "test9", method = RequestMethod.POST)
	@ResponseBody
	public void test9(TestVO vo, MultipartFile uploadFile) {
		System.out.println(vo);
		System.out.println(uploadFile.getOriginalFilename());
	}
}

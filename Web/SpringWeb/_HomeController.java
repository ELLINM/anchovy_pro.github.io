//HomeController

package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.web.vo.TestVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	//처음 프로젝트가 구동되면 해당 Method를 먼저 찾아 return값으로 첫 화면이 나온다
	}
	
	@RequestMapping(value = "send1", method = RequestMethod.GET)
	public String send1(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	//index.jsp의 send1에서 Parameter값을 받아옴
	}
	
	@RequestMapping(value = "send2", method = RequestMethod.GET)
	public String send2(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	//index.jsp의 send2에서 Parameter값을 받아옴
	}
	
	@RequestMapping(value = "send3", method = RequestMethod.POST)
	public String send3(String a, int b) {
		System.out.println(a);
		System.out.println(b);
		return "index";
	//index.jsp의 send3에서 Parameter값을 받아옴
	}
	
	@RequestMapping(value = "send4", method = {RequestMethod.GET, RequestMethod.POST})
	public String send4(TestVO vo) {
		System.out.println(vo);
		return "index";
	//index.jsp의 send4에서 Parameter값을 vo를 생성하여 vo로 
	}
}

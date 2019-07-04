//HomeController

package com.sesoc.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web.vo.TestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "send1", method = RequestMethod.GET)
	public String send1(String a, int b) {

		System.out.println("a : " + a);
		System.out.println("b : " + b);

		return "index";
	}
	
	@RequestMapping(value = "send2", method = RequestMethod.GET)
	public String send2(String a, int b) {

		System.out.println("a : " + a);
		System.out.println("b : " + b);

		return "index";
	}
	
	@RequestMapping(value = "send3", method = RequestMethod.POST)
	public String send3(String a, int b) {

		System.out.println("a : " + a);
		System.out.println("b : " + b);

		return "index";
	}
	
	@RequestMapping(value = "send4", method = RequestMethod.GET)
	public String send4(TestVO vo) {

		System.out.println(vo);

		return "index";
	}
	
	@RequestMapping(value = "send5", method = RequestMethod.GET)
	public String send5(Model model) {
		
		model.addAttribute("data", "테스트테스트");
		model.addAttribute("vo", new TestVO("aaa", 2222));

		return "index";
	}
}

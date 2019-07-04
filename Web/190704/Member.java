//vo

package com.sesoc.vo;

public class MemberVO {

	private String userid;
	private String userpwd;
	private String username;
	private String phone;
	private String address;
	private String hobby;
	private String marital;
	private String joinpath;
	
	public MemberVO() {
	}

	public MemberVO(String userid, String userpwd, String username, String phone, String address, String hobby,
			String marital, String joinpath) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.marital = marital;
		this.joinpath = joinpath;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getJoinpath() {
		return joinpath;
	}

	public void setJoinpath(String joinpath) {
		this.joinpath = joinpath;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", phone=" + phone
				+ ", address=" + address + ", hobby=" + hobby + ", marital=" + marital + ", joinpath=" + joinpath + "]";
	}
}


//controller

package com.sesoc.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.member.HomeController;
import com.sesoc.vo.MemberVO;


@Controller
public class MemberController {

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

		return "home";
	}
	
	@RequestMapping(value = "signupForm", method = RequestMethod.GET)
	public String signupForm(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "signupForm";
	}
	
	@RequestMapping(value = "signupaction", method = RequestMethod.POST)
	public String signupaction(MemberVO vo, Model model) {
		
		System.out.println(vo);
		
		model.addAttribute("vo", vo);
		
		return "home";
	}
}

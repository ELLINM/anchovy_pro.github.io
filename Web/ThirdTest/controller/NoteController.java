package com.sesoc.moneybook.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sesoc.moneybook.dao.MoneybookDAO;
import com.sesoc.moneybook.vo.MoneybookVO;

@Controller
@RequestMapping
public class NoteController {
	
	@Autowired
	private MoneybookDAO moneybookDao;
	
	@RequestMapping(value = "/moveNote", method = RequestMethod.GET)
	public String moveNote(){
		return "moneybook";
	}
	
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<MoneybookVO> getInfo(String date){
		return moneybookDao.selectInfosByDate(date);
	}
	
	@RequestMapping(value = "/registerInfo", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<MoneybookVO> registerInfo(MoneybookVO vo){
		moneybookDao.insertInfo(vo);
		return moneybookDao.selectInfosByDate(vo.getInputdate());
	}
	
	@RequestMapping(value = "/deleteInfo", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<MoneybookVO> deleteInfo(MoneybookVO vo){
		MoneybookVO resultVo = moneybookDao.selectInfoByInfonum(vo.getInfonum());
		if(resultVo != null) {
			moneybookDao.deleteInfo(vo);
		}
		return moneybookDao.selectInfosByDate(vo.getInputdate());
	}

	
}

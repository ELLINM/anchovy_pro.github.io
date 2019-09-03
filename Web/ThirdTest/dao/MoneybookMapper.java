package com.sesoc.moneybook.dao;

import java.util.ArrayList;

import com.sesoc.moneybook.vo.MoneybookVO;

public interface MoneybookMapper {

	MoneybookVO selectInfoByinfonum(String infonum);

	ArrayList<MoneybookVO> selectInfosByinfonum(String date);

	int insertInfo(MoneybookVO vo);

	int deleteIno(MoneybookVO vo);

}

package com.sesoc.moneybook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.moneybook.vo.MoneybookVO;

@Repository
public class MoneybookDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public ArrayList<MoneybookVO> selectInfosByDate(String date) {
		MoneybookMapper mapper = sqlSession.getMapper(MoneybookMapper.class);
		return mapper.selectInfosByinfonum(date);
	}

	public int insertInfo(MoneybookVO vo) {
		MoneybookMapper mapper = sqlSession.getMapper(MoneybookMapper.class);
		return mapper.insertInfo(vo);
	}

	public MoneybookVO selectInfoByInfonum(String infonum) {
		MoneybookMapper mapper = sqlSession.getMapper(MoneybookMapper.class);
		return mapper.selectInfoByinfonum(infonum);
	}

	public int deleteInfo(MoneybookVO vo) {
		MoneybookMapper mapper = sqlSession.getMapper(MoneybookMapper.class);
		return mapper.deleteIno(vo);
	}


}

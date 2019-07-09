//GeustbookMapper

package com.test.web.dao;

import java.util.ArrayList;

import com.test.web.vo.GuestbookVO;

public interface GuestbookMapper {
	public ArrayList<GuestbookVO> guestbookList();
	
}


//GuestbookDao

package com.test.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.GuestbookVO;
import com.test.web.vo.MemberVO;

@Repository
public class GuestbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 처리
	public ArrayList<GuestbookVO> guestbookList() {
		GuestbookMapper mapper = sqlSession.getMapper(GuestbookMapper.class);
		return mapper.guestbookList();
	}
	
}

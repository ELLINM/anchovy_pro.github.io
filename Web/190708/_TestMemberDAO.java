//MemberDAO
package com.test.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 처리
	public int signup(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.signup(vo);
	}
	
	//로그인 처리
	public MemberVO login(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		System.out.println(vo);
		return mapper.login(vo);
	}
}



//MamberMapper
package com.test.web.dao;

import com.test.web.vo.MemberVO;

public interface MemberMapper {
	public int signup(MemberVO vo);
	public MemberVO login(MemberVO vo);
	//mapper에있는 입력값이랑 같은 값을 받아온다
}



package com.test.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.TestVO;

@Repository
public class TestDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int testInsert(TestVO vo) {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		return mapper.testInsert(vo);
	}
}


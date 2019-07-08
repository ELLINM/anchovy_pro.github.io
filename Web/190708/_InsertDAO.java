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
}


//MamberMapper
package com.test.web.dao;

import com.test.web.vo.MemberVO;

public interface MemberMapper {
	public int signup(MemberVO vo);
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



//TestMapper
package com.test.web.dao;

import com.test.web.vo.TestVO;

public interface TestMapper {
	public int testInsert(TestVO vo);
}

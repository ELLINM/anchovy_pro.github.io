//MemberMapper

package com.test.web.dao;

import com.test.web.vo.MemberVO;

public interface MemberMapper {
	//MemberMapper는 memberMapper.xml의 namespace="com.test.dao.MemberMapper"를 가져옴 sql과 java를 연결해줌
	public int signup(MemberVO vo);
	public MemberVO login(MemberVO vo);
}

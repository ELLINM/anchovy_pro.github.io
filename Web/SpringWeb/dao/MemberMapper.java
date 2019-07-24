//MemberMapper

package com.test.web.dao;

import com.test.web.vo.MemberVO;

public interface MemberMapper {
	//MemberMapper는 memberMapper.xml의 namespace="com.test.dao.MemberMapper"를 가져옴 sql과 java를 연결해줌
	public int signup(MemberVO vo);
	//signup(MemberVO vo)으로 값을 받아서 memberMapper.xml의 signup으로 값을 입력하고 입력된 값에 대하여 1또는 0으로 입력 여부를 
	public MemberVO login(MemberVO vo);
}

package com.sesoc.moneybook.dao;

import com.sesoc.moneybook.vo.MemberVO;

public interface MemberMapper {

	MemberVO selectMember(MemberVO member);
	int insertMember(MemberVO member);

}

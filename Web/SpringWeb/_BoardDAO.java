//BoadMapper
package com.test.web.dao;

import java.util.ArrayList;

import com.test.web.vo.BoardVO;


public interface BoardMapper {
	public ArrayList<BoardVO> boardList();
}


//BoardDAO
package com.test.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardVO> boardList() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardList();
	}
	
}

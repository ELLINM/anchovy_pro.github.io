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
	
	public BoardVO boardRead(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.hitCount(boardNum);
		return mapper.boardRead(boardNum);
	}
	
	public void boardDelete(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.boardDelete(vo);
	}
}
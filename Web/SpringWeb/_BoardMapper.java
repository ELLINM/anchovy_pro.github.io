package com.test.web.dao;

import java.util.ArrayList;

import com.test.web.vo.BoardVO;

public interface BoardMapper {
	public ArrayList<BoardVO> boardList();
	public BoardVO boardRead(int boardNum);
	public void hitCount(int boardNum);
	public void boardDelete(BoardVO vo);
}

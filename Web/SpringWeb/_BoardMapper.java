package com.test.web.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.web.vo.BoardVO;

public interface BoardMapper {
	public ArrayList<BoardVO> boardList(HashMap<String, String> map);
	public BoardVO boardRead(int boardNum);
	public void hitCount(int boardNum);
	public int boardDelete(BoardVO vo);
	public int boardUpdate(BoardVO vo);
	public int boardWrite(BoardVO vo);
}

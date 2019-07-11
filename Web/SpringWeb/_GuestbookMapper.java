//GuestbookMapper

package com.test.web.dao;

import java.util.ArrayList;

import com.test.web.vo.GuestbookVO;

public interface GuestbookMapper {
	public ArrayList<GuestbookVO> guestbookList();
	public void write(GuestbookVO vo);
	public void delete(GuestbookVO vo);
}

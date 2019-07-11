//GuestbookService

package com.test.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.GuestbookDAO;
import com.test.web.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDAO dao;
	
	// 방명록 리스트
	public ArrayList<GuestbookVO> guestbookList() {
		return dao.guestbookList();
	}
	
	public void write(GuestbookVO vo) {
		dao.write(vo);
	}
	
	public void delete(GuestbookVO vo) {
		dao.delete(vo);
	}
}

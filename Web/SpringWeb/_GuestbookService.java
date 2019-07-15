//GuestbookService

package com.test.web.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.GuestbookDAO;
import com.test.web.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDAO dao;
	
	public boolean write(GuestbookVO vo) {
		if(dao.write(vo) != 1) return false;
		return true;
	}
	
	// 방명록 리스트
	public ArrayList<GuestbookVO> guestbookList(String searchItem, String searchKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		return dao.guestbookList(map);
	}
	
	
	public boolean delete(GuestbookVO vo) {
		if(dao.delete(vo) != 1) return false;
		return true;
	}
}

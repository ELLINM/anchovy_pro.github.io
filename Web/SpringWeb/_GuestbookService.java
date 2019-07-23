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
	
	public boolean write(GuestbookVO vo, MultipartFile uploadFile) {
		if(!uploadFile.isEmpty()){
			//첨부파일을 보냈는지 안보냈는지 판단 여부
			String savedFilename = UUID.randomUUID().toString();
			//randomUUID()는 숫자, 영어, 하이픈을 조합하여 36자의 랜덤값을 반환 
			String originalFilename = uploadFile.getOriginalFilename();
			vo.setOriginalFilename(originalFilename);
			vo.setSavedFilename(savedFilename);
			
			try {
				uploadFile.transferTo(new File("C:/test/" + savedFilename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(dao.write(vo) != 1) return false;
		return true;
	}
	
	// 방명록 리스트
	public ArrayList<GuestbookVO> guestbookList(String searchItem, String searchKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		//HashMap 객체에 Controller 로부터 전달받은 searchItem 과 searchKeyword 를 대입
		map.put("searchKeyword", searchKeyword);
		//HashMap 객체를 sql query 의 파라미터로 전달
		return dao.guestbookList(map);
	}
	
	public boolean delete(GuestbookVO vo) {
		String savedFilename = dao.read(vo.getSeq()).getSavedFilename();
		if(dao.delete(vo) != 1) return false;
		File file = new File("C:/test/" + savedFilename);
		if(file.exists()) file.delete();
		return true;
	}
	
	public void download(GuestbookVO vo, HttpServletResponse response) {
		File file = new File("C:/test/" + vo.getSavedFilename());
		String originalFilename = vo.getOriginalFilename();
		
		try {
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(originalFilename, "UTF-8"));
			/*response : client에 응답  header : 정보를 답고 있음 Content-Disposition : 응답의 정보
			attachment : 다운 로드받을것이 파일이다 ;filename= : 다운로드 파일명
			URLEncoder.encode(originalFilename, "UTF-8" : 파일명과 파일명이 한글일때 깨지지 않게하는 UTF-8*/
			response.setContentLength((int)file.length());
			//다운로드 받는 파일의 크기를 세팅
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
			//FileCopyUtils.copy : method호출 response.getOutputStream() :  링크를 클릭했을때 다운로드를 하는 통로 역할
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GuestbookVO read(int seq) {
		return dao.read(seq);
	}
}

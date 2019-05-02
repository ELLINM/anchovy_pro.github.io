//VO
//Board
package vo;

public class Board {

	private String seq;// 게시판일련번호
	private String title;// 글 제목
	private String content;// 글 내용
	private String indate;// 등록일
	private String id;// 게시자

	public Board(String seq, String title, String content, String indate, String id) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.id = id;
	}

	public Board() {
		super();
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "일련번호=" + seq + ", 제목=" + title + ", 내용=" + content + ", 등록일=" + indate + ", 게시자=" + id;
	}

}

//FileBoard
package vo;

import java.util.ArrayList;

public class FileBoard extends Board {

	private ArrayList<String> fileName = new ArrayList<>();

	public FileBoard(String seq, String title, String content, String indate, String id, ArrayList<String> fileName) {
		super(seq, title, content, indate, id);
		this.fileName = fileName;
	}

	public FileBoard() {
		super();
	}

	public ArrayList<String> getFileName() {
		return fileName;
	}

	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return super.toString()+", 파일경로=" + fileName;
	}

}

//ImageBoard
package vo;

import java.util.ArrayList;

public class ImageBoard extends Board{

	private ArrayList<String> imgUrl=new ArrayList<>();

	public ImageBoard(String seq, String title, String content, String indate, String id, ArrayList<String> imgUrl) {
		super(seq, title, content, indate, id);
		this.imgUrl = imgUrl;
	}

	public ImageBoard() {
		super();
	}

	public ArrayList<String> getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(ArrayList<String> imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return super.toString()+", 이미지경로=" + imgUrl;
	}
	
	
}



//Main
package main;

import ui.BoardUI;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardUI();
	}

}


//Interface
package Interface;

import vo.Board;

public interface ServiceInterface {

	public boolean insertBoard(Board b);//등록
	public String printAll();//전체출력
	public int searchIndex(String seq);//index 검색
	public String searchBoard(int index);//종류검색
	public void updBoard(Board b);//수정
	
}


//UI
package ui;

import java.util.ArrayList;
import java.util.Scanner;

import service.BoardService;
import vo.Board;
import vo.FileBoard;
import vo.ImageBoard;

public class BoardUI {

	private Scanner sc = new Scanner(System.in);
	private String seq, fileName, imgUrl, content, title, id, indate;
	private int choice;
	private ArrayList<String> iList = new ArrayList<String>();
	private ArrayList<String> fList = new ArrayList<String>();
	private boolean flag = true;
	private BoardService bs = new BoardService();

	public BoardUI() {

		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
			case 2:
			case 3:
				bs.insertBoard(makeBoard(choice));
				break;
			case 4:
				System.out.println(bs.printAll());
				break;
			case 5:
				System.out.println("삭제하시려는 글의 일련번호 : ");
				if (bs.deleteBoard(sc.next())) {
					System.out.println("삭제성공");
				} else {
					System.out.println("삭제실패");
				}
				break;
			case 6:
				System.out.println("수정하시려는 글의 일련번호 : ");
				String temp=sc.next();
				String kind=bs.searchBoard(bs.searchIndex(temp));
				
				switch(kind) {
				case "i":
					bs.updBoard(makeBoard(2,temp));
					break;
				case "f":
					bs.updBoard(makeBoard(3,temp));
					break;
				case "n":
					bs.updBoard(makeBoard(1,temp));
					break;
				}
				
				break;
			case 7:
				flag = false;
				break;
			}
		}

	}

	public void menu() {
		System.out.println("==============");
		System.out.println("1.일반게시글등록");
		System.out.println("2.이미지게시글등록");
		System.out.println("3.파일게시글등록");
		System.out.println("4.전체출력");
		System.out.println("5.게시글삭제");
		System.out.println("6.게시글수정");
		System.out.println("7.종료");
		System.out.println("==============");
	}

	public Board makeBoard(int choice) {
		System.out.println("일련번호 입력 : ");
		seq = sc.next();
		System.out.println("글 제목 입력 : ");
		title = sc.next();
		System.out.println("글 내용 입력 : ");
		content = sc.next();
		System.out.println("등록일 입력 : ");
		indate = sc.next();
		System.out.println("게시자 입력 : ");
		id = sc.next();

		switch (choice) {
		case 1:
			return new Board(seq, title, content, indate, id);
		case 2:
			iList = new ArrayList<>();
			System.out.println("이미지를 몇개 등록할까요");
			int num = sc.nextInt();

			for (int i = 0; i < num; i++) {
				System.out.println("경로 입력 : ");
				iList.add(sc.next());
			}

			return new ImageBoard(seq, title, content, indate, id, iList);
		case 3:
			fList = new ArrayList<>();
			System.out.println("파일를 몇개 등록할까요");
			num = sc.nextInt();

			for (int i = 0; i < num; i++) {
				System.out.println("경로 입력 : ");
				fList.add(sc.next());
			}

			return new FileBoard(seq, title, content, indate, id, fList);

		}

		return null;
	}
	
	public Board makeBoard(int choice, String seq) {
		System.out.println("글 제목 입력 : ");
		title = sc.next();
		System.out.println("글 내용 입력 : ");
		content = sc.next();
		System.out.println("등록일 입력 : ");
		indate = sc.next();
		System.out.println("게시자 입력 : ");
		id = sc.next();

		switch (choice) {
		case 1:
			return new Board(seq, title, content, indate, id);
		case 2:
			iList = new ArrayList<>();
			System.out.println("이미지를 몇개 등록할까요");
			int num = sc.nextInt();

			for (int i = 0; i < num; i++) {
				System.out.println("경로 입력 : ");
				iList.add(sc.next());
			}

			return new ImageBoard(seq, title, content, indate, id, iList);
		case 3:
			fList = new ArrayList<>();
			System.out.println("파일를 몇개 등록할까요");
			num = sc.nextInt();

			for (int i = 0; i < num; i++) {
				System.out.println("경로 입력 : ");
				fList.add(sc.next());
			}

			return new FileBoard(seq, title, content, indate, id, fList);

		}

		return null;
	}
}


//Service
package service;

import java.util.ArrayList;

import Interface.ServiceInterface;
import vo.Board;
import vo.FileBoard;
import vo.ImageBoard;

public class BoardService implements ServiceInterface {

	private ArrayList<Board> bList = new ArrayList<>();

	@Override
	public boolean insertBoard(Board b) {
		// TODO Auto-generated method stub
		boolean result = true;

		if (searchIndex(b.getSeq()) == -1) {
			bList.add(b);
		}

		return result;
	}

	@Override
	public String printAll() {
		// TODO Auto-generated method stub
		String result = "";

		for (Board b : bList) {
			result += b + "\n";
		}

		return result;
	}

	@Override
	public int searchIndex(String seq) {
		// TODO Auto-generated method stub
		int result = -1;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getSeq().equals(seq)) {
				result = i;
			}
		}
		return result;
	}

	public boolean deleteBoard(String seq) {
		boolean flag = false;
		int result = searchIndex(seq);
		if (result == -1) {
			return flag;
		} else {
			bList.remove(result);
			flag = true;
			return flag;
		}

	}

	@Override
	public String searchBoard(int index) {
		// TODO Auto-generated method stub
		if (bList.get(index) instanceof ImageBoard) {
			return "i";
		} else if (bList.get(index) instanceof FileBoard) {
			return "f";
		} else {
			return "n";
		}
	}

	@Override
	public void updBoard(Board b) {
		// TODO Auto-generated method stub
		bList.set(searchIndex(b.getSeq()), b);
	}

}

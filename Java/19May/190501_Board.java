//Vo

//Board
package VO;

public class Board {
	
	private String seq;
	private String title;
	private String content;
	private String indate;
	private String id;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(String seq, String title, String content, String indate, String id) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.id = id;
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
		return "게시물 번호 = " + seq + ", 제목 = " + title + ", 글 내용 = " + content + ", 등록일 = " + indate + ", 게시자 = " + id;
	}
}

//ImageBoard

package VO;

import java.util.ArrayList;

public class ImageBoard extends Board{
	private ArrayList<String> imageUrl = new ArrayList<>();

	public ImageBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageBoard(String seq, String title, String content, String indate, String id, ArrayList<String> imageUrl) {
		super(seq, title, content, indate, id);
		this.imageUrl = imageUrl;
	}
	

	public ArrayList<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(ArrayList<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return super.toString() + "이미지 경로 =" + imageUrl;
	}
}

//FileBoard

package VO;

import java.util.ArrayList;

public class FileBoard extends Board{
	private ArrayList <String> fileName = new ArrayList<>();

	public FileBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileBoard(String seq, String title, String content, String indate, String id, ArrayList<String> fileName) {
		super(seq, title, content, indate, id);
		this.fileName = fileName;
	}

	public ArrayList<String> getFileName() {
		return fileName;
	}

	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return super.toString() + "파일 이름 = " + fileName;
	}
}


//Main

package Main;

import UI.BoardUI;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardUI();

	}

}


//UI

package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Manager.BoardManager;
import VO.Board;
import VO.FileBoard;
import VO.ImageBoard;

public class BoardUI {
	
	private String seq, title, content, indate, id, url, name;
	private int choice, num;
	private ArrayList <String> imageUrl = new ArrayList<>();
	private ArrayList <String> fileName = new ArrayList<>();
	private boolean flag = true;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private BoardManager bm = new BoardManager();
	
	public BoardUI() {
		
		while(flag) {
			
			menu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				Board b = insertBoard();
				bm.insertBoard(b);
				break;
			case 2:
				ImageBoard ib = insertImage();
				bm.insertImage(ib);
				break;
			case 3:
				FileBoard fb = insertFile();
				bm.insertFile(fb);
				break;
			case 4:
				System.out.println("검색할 게시물 번호를 입력하세요");
				seq = sc.next();
				
				System.out.println(bm.searchSeq(seq));
				break;
			case 5:
				System.out.println("검색할 게시물 재목 입력하세요");
				title = sc.next();
				
				System.out.println(bm.searchTitle(title));
				break;
			case 6:
				System.out.println(bm.printAll());
				break;
			case 7:
				System.out.println("이미지 경로 입력");
				url = sc.next();
				
				System.out.println(bm.searchImage(url));
				break;
			case 8:
				System.out.println("파일명 입력");
				name = sc.next();
				
				System.out.println(bm.searchFile(name));
				break;
			case 9:
				deleteMenu();				
				break;
			case 10:
				repairBoard();
				if (bm.repairBoard(seq) == true) {
					System.out.println("게시번호 입력");
					seq = sc2.next();

					System.out.println("글 제목 입력");
					title = sc2.next();
					
					System.out.println("글 내용 입력");
					content = sc2.next();
					
					System.out.println("등록일 입력");
					indate = sc2.next();
					
					System.out.println("게시자 입력");
					id = sc2.next();
					
					b = new Board(seq, title, content, indate, id);
				}
				break;
			case 11:
				flag = false;
				break;	
			}			
		}
	}
	public void menu() {
		System.out.println("====================");
		System.out.println("1. 일반게시글 등록");
		System.out.println("2. 이미지게시글 등록");
		System.out.println("3. 파일게시글 등록");
		System.out.println("4. 게시글 검색(일련번호로)");
		System.out.println("5. 게시글 검색(제목으로)");
		System.out.println("6. 게시글 전체출력");
		System.out.println("7. 이미지경로 검색");
		System.out.println("8. 파일명 검색");
		System.out.println("9. 게시글 삭제");
		System.out.println("10. 게시글 수정(일련번호입력)");
		System.out.println("11. 프로그램 종료");
		System.out.println("====================");
	}
	
	public Board insertBoard() {
		System.out.println("게시번호 입력");
		seq = sc2.next();

		System.out.println("글 제목 입력");
		title = sc2.next();
		
		System.out.println("글 내용 입력");
		content = sc2.next();
		
		System.out.println("등록일 입력");
		indate = sc2.next();
		
		System.out.println("게시자 입력");
		id = sc2.next();
		
		Board b = new Board(seq, title, content, indate, id);
		return b;
	}
	public ImageBoard insertImage() {
		System.out.println("게시번호 입력");
		seq = sc2.next();

		System.out.println("글 제목 입력");
		title = sc2.next();
		
		System.out.println("글 내용 입력");
		content = sc2.next();
		
		System.out.println("등록일 입력");
		indate = sc2.next();
		
		System.out.println("게시자 입력");
		id = sc2.next();
		
		System.out.println("이미지를 몇개 등록하시겠습니까");
		num = sc.nextInt();
	
		for (int i = 0; i < num; i++) {
			System.out.println("이미지 경로 입력");
			url = sc2.next();
			imageUrl.add(url);
		}
		
		ImageBoard im = new ImageBoard(seq, title, content, indate, id, imageUrl);
		return im;
	}
	public FileBoard insertFile() {
		System.out.println("게시번호 입력");
		seq = sc2.next();

		System.out.println("글 제목 입력");
		title = sc2.next();
		
		System.out.println("글 내용 입력");
		content = sc2.next();
		
		System.out.println("등록일 입력");
		indate = sc2.next();
		
		System.out.println("게시자 입력");
		id = sc2.next();
		
		System.out.println("파일을 몇개 등록 하시겠습니까");
		num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			System.out.println("파일 이름 입력");
			name = sc2.next();
			fileName.add(name);
		}
		
		FileBoard fi = new FileBoard(seq, title, content, indate, id, fileName);
		return fi;
	}
	
	public void deleteMenu() {
		System.out.println("1. 일반게시물삭제");
		System.out.println("2. 이미지게시물삭제");
		System.out.println("3. 파일게시물삭제");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("게시 번호를 입력하셍요");
			seq = sc.next();
			bm.deleteBoard(seq);
			break;
		case 2:
			System.out.println("게시 번호를 입력하셍요");
			seq = sc.next();
			bm.deleteImage(seq);
			break;
		case 3:
			System.out.println("게시 번호를 입력하셍요");
			seq = sc.next();
			bm.deleteFile(seq);
			break;
		}
		
	}
	public void repairBoard() {
		System.out.println("수정할 게시물 번호를 입력하세요");
		seq = sc2.next();
	}

}


//Service

package Manager;

import java.util.ArrayList;

import VO.Board;
import VO.FileBoard;
import VO.ImageBoard;

public class BoardManager {
	private ArrayList <Board> bList = new ArrayList<>();
	private ArrayList <ImageBoard> iList = new ArrayList<>();
	private ArrayList <FileBoard> fList = new ArrayList<>();

	public void insertBoard(Board b) {
		boolean flag = true;
		for(int i=0;i<bList.size();i++) {
			if(bList.get(i).getSeq().equals(b.getSeq())) {
				System.out.println("중복된 값입니다");
				flag = false;
			}
		}
		if(flag) {
			bList.add(b);
		}
	}
	public void insertImage(ImageBoard ib) {
		boolean flag = true;
		for(int i=0;i<iList.size();i++) {
			if(iList.get(i).getSeq().equals(ib.getSeq())) {
				System.out.println("중복된 값입니다");
				flag = false;
			}
		}
		if(flag) {
			iList.add(ib);
		}
	}
	public void insertFile(FileBoard fb) {
		boolean flag = true;
		for(int i=0;i<fList.size();i++) {
			if(fList.get(i).getSeq().equals(fb.getSeq())) {
				System.out.println("중복된 값입니다");
				flag = false;
			}
		}
		if(flag) {
			fList.add(fb);
		}
	}
	public String searchSeq(String seq) {
		String result = "";
		for(Board b:bList) {
			if(b instanceof Board) {
				if(((Board)b).getSeq().equals(seq)) {
					result += b + "\n";
				}
			}
		}
		for (FileBoard fi : fList) {
			if(fi instanceof FileBoard) {
				if(((FileBoard)fi).getSeq().equals(seq)) {
					result += fi + "\n";
				}
			}
		}
		for(ImageBoard im : iList) {
			if(im instanceof ImageBoard) {
				if(((ImageBoard)im).getSeq().equals(seq)) {
					result += im + "\n";
				}
			}
		}
		return result;
	}
	public String searchTitle(String title) {
		String result = "";
		for(Board b:bList) {
			if(b instanceof Board) {
				if(((Board)b).getTitle().equals(title)) {
					result += b + "\n";
				}
			}
		}
		for (FileBoard fi : fList) {
			if(fi instanceof FileBoard) {
				if(((FileBoard)fi).getTitle().equals(title)) {
					result += fi + "\n";
				}
			}
		}
		for(ImageBoard im : iList) {
			if(im instanceof ImageBoard) {
				if(((ImageBoard)im).getTitle().equals(title)) {
					result += im + "\n";
				}
			}
		}
		return result;
	}
	public String printAll() {
		String result = "";
		for (Board b : bList) {
			result += b +"\n";
		}
		for(ImageBoard im : iList) {
			result += im + "\n";
		}
		for(FileBoard fi : fList) {
				result += fi + "\n";
		}
		return result;
	}
	public void deleteBoard(String seq) {
		for(int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getSeq().equals(seq)) {
				bList.remove(i);
			}
		}
	}
	public void deleteImage(String seq) {
		for(int i = 0; i < iList.size(); i++) {
			if (iList.get(i).getSeq().equals(seq)) {
				iList.remove(i);
			}
		}
	}
	public void deleteFile(String seq) {
		for(int i = 0; i < fList.size(); i++) {
			if (fList.get(i).getSeq().equals(seq)) {
				fList.remove(i);
			}
		}
	}
	public String searchImage(String url) {
		String result = "";
		for (ImageBoard ib : iList) {
			for(int i=0 ; i<ib.getImageUrl().size() ; i++) {
				if(url.equals(ib.getImageUrl().get(i))) {
					result +=iList.toString()+"\n";
					break;
				}
			}
		}
		return result;
	}
	public String searchFile(String name) {
		String result = "";
		for (FileBoard fb : fList) {
			for(int i=0 ; i<fb.getFileName().size() ; i++) {
				if(name.equals(fb.getFileName().get(i))) {
					result +=fList.toString()+"\n";
					break;
				}
			}
		}
		return result;
	}
	public boolean repairBoard(String seq) {
		boolean result = false;
		for (int i = 0; i < bList.size(); i++) {
			if(bList.get(i).getSeq().equals(seq)) {
				bList.remove(i);
				result = true;
			}
		}
		return result;
	}
}

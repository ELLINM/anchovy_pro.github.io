package Pattern;

import java.io.*;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		InputStream in = null;
		try {
			in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("text.txt")));
		//fileInputStream을 만들고 BufferedInputStream과 LowerCaseInputStream필터로 감쌈
			while((c = in.read()) >= 0) {
				System.out.println((char)c);
				//Stream을 써서 파일 끝까지 문자를 하나씩 출력하면서 처리
			}
			in.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	} 
}

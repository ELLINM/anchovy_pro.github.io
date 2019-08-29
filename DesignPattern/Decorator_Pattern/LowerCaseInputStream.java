package Pattern;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

//모든 InputStream의 추상 Decorator인 FileInputStream을 확장
public class LowerCaseInputStream extends FilterInputStream{
	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
	//두개의 read() Method를 구현 각각 byte값 하나, 또는 byte 배열을 읽고 각 byte를 검사하여 대문자이면 소문자로 변환
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}

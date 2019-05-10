package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calandar{
	
	public static void main(String [] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); //출력 format으로 들어감 연도/월/날짜
		Date d = new Date();
		
		String time = sdf.format(d);
		
		System.out.println(time);
		}
}



package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calandar{
	
	public static void main(String [] args) {
	
		Date d1 = new Date("2019/05/03");
		Date d2 = new Date("2019/05/05");
		Date d3 = new Date("2019/05/07");
		
		
		/*
		d1.after(d2); 앞 숫자가 뒤 숫자보다 뒤에 있는지 물음
		d1.before(d2); 앞 숫자가 뒤 숫자보다 앞에 있는지 물음
		*/
		
		System.out.println(d2.after(d1)&&d2.before(d3));
		//boolean 값으로 출력됨
	}
}

package Practice;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
	public static void main(String [] args) {
		
		Map<String, String> sMap = new HashMap<>();
      //key(중복 불가능 ex) 주민번호), Value(중복 가능(ex)사람의 이름))
      
    /*sMap.put("1", "고양이");
		put으로 입력
		sMap.put("1", "강아지");
		System.out.println(sMap.get("1"));
    처음 적은 고양이는 덮어쓰워져 사라지고 강아지만 출력*/
    
    /*sMap.put("1", "고양이");
		sMap.put("2", "강아지");
    sMap.remove("2");
		//key값을 삭제 => 삭제한 값음 null로 출력
		System.out.println(sMap.get("1"));*/
    
    sMap.put("1", "고양이");
		// put으로 입력
		sMap.put("2", "강아지");
		sMap.put("3", "팬더");
		
		Set<String> keys = sMap.keySet();
		
		for(String a : keys) {
			System.out.println("키값 : " + sMap.get(a) + "밸류값 : " + sMap.get(a));
      //전체 출력
		}
	}
}


public static void main(String [] args) {
	
		Set<String> sSet = new HashSet<>();
		
		sSet.add("가");
		sSet.add("나");
		sSet.add("다");
		sSet.add("라");
		sSet.add("마");
		//중복 값이 생기면 덮어 쓴다.
		for(String value : sSet) {
			System.out.println(value);
		}
	}

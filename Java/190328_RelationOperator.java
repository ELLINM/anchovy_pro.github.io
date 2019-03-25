//ex1

class Relation{
  
  public static void main(String [] args){
    
    boolean result = false;
    
    int a = 100;
    int b = 50;
    
    result = a<b;
    
    System.out.println(result);
  }
}

//ex2

class Relation{

	public static void main(String[] args){

		boolean result = false;

		String a = new String("가");
		String b = new String("가");
/*stack "가"라는 문자를 비교하게 되면 stack안의 실제값이 heap안의 메모리 주소로 연결하여 비교하기 때문에 
각기 다른 주소로 나오기 때문에 false가 나온다.
같은 값을 만들기 위해서는  b = a로 변경해주면 된다.*/
		result = a == b;
		System.out.println(result);
	}
}

//ex3

class Relation{

	public static void main(String[] args){

		boolean result = false;

		String a = new String("가");
		a = new String("나");
//가에서 나로 변경되면 사용하지 않는 "가"는 주소를 잃어버려 Garbage Collection이 가져간다.
		result = a == b;
		System.out.println(result);
	}
}
//(a.euqals(b)); 를 통하여 문자열 비교가 가능함

//ex4

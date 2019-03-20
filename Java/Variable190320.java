class Example {

	public static void main(String[] args) {
//변수의 8가지 종류, 변수는 소문자로 시작한다
		int number; //선언&대입
    
    number=24;
    
    System.out.println(number);

	}
}


class Example {

	public static void main(String[] args) {

		int number=5;

		System.out.println(number/2);
/*int&int 연산 = int
int&double 연산 = 더 큰 타입으로 연산값 출력
*/
	}
}

class Example {

	public static void main(String[] args) {

		int numberOne=5;
    int numberTwo=numberOne/2.0;
    //연산값이 double => double

		System.out.println(number);

	}
}

class Example {

	public static void main(String[] args) {

		int number=10;
		
		++number;
		
	System.out.println(number)

	}
}

class Example {

	public static void main(String[] args) {

		int number=10;

	System.out.println(number++);
	System.out.println(number++);
	System.out.println(++number);
	System.out.println(number);

	}
}
//선대입 후증가

//ex
class InDecrementOp
{
	public static void main(String[] args) {
		int cnt = 10;

		System.out.println("cnt : "+ cnt);
		System.out.println("cnt++ : "+ cnt++);
		System.out.println("cnt++ : "+ cnt);
		System.out.println("++cnt : "+ ++cnt);
	}
}

class  Math
{
	public static void main(String[] args){
		int price=4300;
		long number=2435398;
		int mart=13;
		
		long average=(price*number)/mart;
		
		System.out.println("1인 : "+average+"원");
	}
}

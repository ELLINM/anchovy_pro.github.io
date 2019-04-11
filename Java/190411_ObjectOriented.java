//ex1

class Human 
{
	String name;
	int age;
}

//ex2

class ObjectTest 
{
	public static void main(String[] args) 
	{
		Human h =new Human(); //같은 폴더의 Human Class를 가지고옴
    
    		System.out.println(h.age);
		System.out.println(h.name);
	}
}

//ex3
class ObjectTest 
{
	public static void main(String[] args) 
	{
		Human h = new Human(); //new하는 키워드가 중요 
		Human x = h;

		h.age = 25;
		h.name = "홍길동";
		x.age = 18;

		System.out.println(x==h);
	} //결과는 true 왜? 메모리 주소값이 같다고 판단하기 때문에 true가 나온다.
}

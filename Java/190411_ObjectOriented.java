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


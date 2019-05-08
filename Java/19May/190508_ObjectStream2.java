// VO

package main;

import java.io.Serializable;

public class Person implements Serializable{
	// Serializable 추가로 간단히 
	private String name;
	private int age;
	public Person() {
		super();
			// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
//직렬화를 해주지 않으면 알아볼수 없는 오류를 맛볼 수 있다.

//Main

package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjecTest {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:/test/Object.txt");
		ArrayList<Person> pList = new ArrayList<>();
		pList.add(new Person("강슬기" ,25));
		pList.add(new Person("손승완", 25));
		if (file.exists()) {
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(pList);
			oos.close();
			
			System.out.println("완료");
		
		}
	}
}

//결과문 : ы sr java.util.ArrayListx곏쇙a? I sizexp   w   sr main.Personk슋&?똾 I ageL namet Ljava/lang/String;xp   t 	媛뺤뒳湲컎q ~    t 	?먯듅?꼡

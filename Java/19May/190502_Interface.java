//Animal
package Animals;

public class Animal {
	String name;
	
	public void setName(String name) {
		this.name = name;
	}
}


//interface
package Animals;
/* Animal을 상속받는 Class가 계속 늘어난다면 interface가 없이는 계속해서 zooKeeper내에  method를 추가 해야함
public void feed(Crocodile crocodile) {
    System.out.println("feed strawberry");
}

public void feed(Leopard leopard) {
    System.out.println("feed orange");
}*/
public interface Predator {
  public String getFood();
}


//Tiger
package Animals;

public class Tiger extends Animal implements Predator{
	public String getFood() {
		return "apple";
    }
}


//Lion
package Animals;

public class Lion extends Animal implements Predator{
	public String getFood() {
		return "banana";
    }
}


//ZooKeeper
package Animals;

public class ZooKeeper {
	public void feed(Predator predator) {
		System.out.println("feed "+predator.getFood());
	}
  
  
  //before implements interface
		/*System.out.println("feed apple");
	}
  
	public void feed(Tiger tiger) {
		System.out.println("feed apple");
	}
	
	public void feed(Lion lion) {
		System.out.println("feed banana");
	}*/
	
	public static void main(String [] args) {
		ZooKeeper zooKeeper = new ZooKeeper();
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		zooKeeper.feed(tiger);
		zooKeeper.feed(lion);
	}
}


// before implements interface => running : feed apple \n feed banana
// after implements interface => running : feed apple \n feed banana
// 더 다양한 객체가 추가될 수록 간편함 

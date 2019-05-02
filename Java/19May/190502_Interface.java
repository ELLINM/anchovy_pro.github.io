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
// 더 다양한 객체가 추가될 수록 간편함이 

package Pattern;

public abstract class Beverage {
	//Beverage는 추상 class이며 getDescription() 과 cost라는 두개의 Method가 있음
	String description = "제목 없음";
	
	public String getDescription() {
		//getDescription은 이미 구현 되어 있지만 cost()는 subclass에서 구현 해야함
		return description;
	}
	
	public abstract double cost();
}

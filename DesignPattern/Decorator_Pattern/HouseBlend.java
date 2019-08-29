package Pattern;

public abstract class CondimentDecorator extends Beverage{
	//Beverage객체가 들어갈 자리에 들어갈 수 있어야 하므로 Beverage Class를 확장
	public abstract String getDescription();
	//모든 첨가물 Decorator에서  getDescription() Method를 구현하도록 함 -> 추상 Method 선언
}

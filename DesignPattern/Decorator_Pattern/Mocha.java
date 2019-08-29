package Pattern;

public class Mocha extends CondimentDecorator{
	//Mocha는 Decorator이기 때문에 CondimentDecorator를 확장
	Beverage beverage;
	//Mocha instance에는 Beverage에 대한 reference가 들어 있음
	// 감싸고자 하는 음료를 저장 하기 위한 instance변수
	// instance 변수를 감싸고자 하는 객체로 설정하기 위한 생성자 Decorator의 생성자에 감싸고자 하는 음료객체를 전달하는 방식 사용

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + "모카";
		//객체에 작업을 위임한다음 결과에 "모카"를 더한 결과를 return
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
		//음료 가격에 모카를 추가한 가격을 계산해야함 우선 장식하고 있는 객체에 가격을 구하는 작업을 위임하고 거기에 모카가격을 더하고 합을 return
	}
	
}

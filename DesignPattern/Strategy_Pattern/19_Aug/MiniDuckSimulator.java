
public class MiniDuckSimulator {
	public static void main(String [] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		//MallardDuck에서 상속받은 performQuack() Method가 호출
		//객체의 QuackBehavior에게 할 일을 위임
		//즉 quackBehavior reference의 quack() Method가 호출 
		mallard.performFly();
		//performFly() Method도 호출
		
		Duck model = new ModelDuck();
		model.performFly();
		//처음 호출하면 ModelDuck 생성자에서 설정되었던 flyBehavior, 즉 FlyNoWay인스턴스의 fly(0 Method가 호출
		model.setFlyBehavior(new FlyRocketPowered());
		//행동 setter Method가 호출 이제 모형 오리에 rocket의 추진력으로 날 수 있음
		model.performFly();
		//모형 오리는 동적으로 fly를 바꿀 수 있음 
	}
}

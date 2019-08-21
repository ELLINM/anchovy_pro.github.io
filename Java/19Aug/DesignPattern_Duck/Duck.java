
public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	/*행동 interface 형식의 reference 변수 두 개를 선언합니다.
	 * 모든 sub class에서 이 변수를 상속 받음*/
	
	public Duck() {
	}
	
	public abstract void display();
	
	public void performFly() {
		flyBehavior.fly();
		//행동 class에 위임
	}
	
	public void performQuack() {
		quackBehavior.quack();
		//행동 class에 위임
	}
	
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	
	public void swim() {
		System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
	}
}

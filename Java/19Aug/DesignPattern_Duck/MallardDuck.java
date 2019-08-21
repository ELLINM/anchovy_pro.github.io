
public class MallardDuck extends Duck{
	
	public MallardDuck() {
		//MallardDuck은 Duck Class에서 quackBehavior와 flyBehavior instance변수를 상속받음
		quackBehavior = new Quack();
		/*MallardDuck에서는 "꽥꽥"거리는 소리를 처리할때 Quack class를 사용 하기 때문에 performQuack()이 호출 되면
		꽥꽥거리는 행동은 Quack 객체에 위임됩니다.*/
		flyBehavior = new FlyWithWings();
		//flyBehavior형식으로는 FlyWithWings를 사용
	}
	
	public void display() {
		System.out.println("저는 물오리 입니다.");
	}
}

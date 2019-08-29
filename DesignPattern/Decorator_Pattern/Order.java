package Pattern;

public class Order {
	public static void main(String args []) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + "$" + beverage.cost());
		//아무것도 넣지 않은 에스프레소를 주문하고 음료에 ㄷ한 설명과 가격을 출력
		
		Beverage beverage2 = new DarkRoast();
		//DarkRoast 객체 생성
		beverage2 = new Mocha(beverage2);
		//Mocha로 감쌈
		beverage2 = new Mocha(beverage2);
		// 한번더
		beverage2 = new Whip(beverage2);
		//Whip로 감쌈
		System.out.println(beverage2.getDescription() + "$" + beverage2.cost());
		
		Beverage beverage3 = new HouseBlend();
		// 두유 모카 추가하고 휘핑크림을 얹은 하우스 블렌드 커피
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + "$" + beverage3.cost());
		
	}
}

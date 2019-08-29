package Pattern;

public class Espresso extends Beverage{

	public Espresso() {
		description = "에스프레소";
		//Class 생성자 부분에서 description 변수의 값을 설정
		//Beverage 부터 싱속받음
	}
	
	public double cost() {
		return 1.99;
	}

}

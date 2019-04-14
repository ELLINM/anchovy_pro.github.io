public class Method1
{
  public static void main(String[] args) //mainMethod에서 부터 프로그램이 실행
  {
    addHap2(1, 2); //addHap2( )Method를 호출 메소드 호출구문을 보면 1과 2를 인수로 가짐
    addHap2(3, 4); //addHap2( )Method를 한번더 호출

    int hap = addHap(1 ,2);  //addHap2( )Method를 한번더 실행하고 난뒤 이번엔 addHap( )Method를 호출

    System.out.println(hap);
  }

    int  addHap (int a, int b) //int a와 int b를 인수로 받으며 int형의 반환값
    {
	    int hap = a + b;
	    return hap; //int hap이라는 변수를 선언하고 리턴값을 hap이라는 변수에 받아내는 것
    } 
	void addHap2 (int a, int b)  //addHap2( )Method의 구현부를 보면 int a와 int b를 인수로 받으며 반환값이 없다
	{
		int hap  =  a  +  b;  //addHap2( )Method는 1과 2를 인수로 받아 그 합을 구하고 합을 출력
		System.out.println(a+" 와 "+b+"의 합은" + hap + "입니다."); //리턴값을 받은 hap을 프린트
	} 
}


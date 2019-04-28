ForEach
============

+ 기본구조
<pre>for (type var: iterate) {
    body-of-loop
}</pre>


+ ex)
<pre>String[] name = {"KIM","JACK","LEE","DACUYA"};
 for( String Nm : name ) {
	System.out.println("name is "+Nm );
    }
 System.out.println("END");</pre>


+ for( String Nm : name )
> String Nm = name 배열의 각 요소 값을 순차적으로 Nm에 전달 한다.
> name = iterator 즉 배열이나 컨테이너등 여러 데이터가 담겨져 있는 변수다.


+ 설명

1. name is KIM
name의 배열 값 수는 총 4개이다. 
그래서 for문은 총 4회 수행 되며 처음 수행 될 때 배열 값의 첫 번째 값인 KIM이 Nm에 전달 된다.

2. name is JACK
KIM 값 다음인 JACK이 Nm에 전달되어 출력 한다. 

3. name is LEE
JACK 값 다음인 LEE 이 Nm에 전달되어 출력 한다.

4. name is DACUYA
LEE 값 다음인 DACUYA 이 Nm에 전달되어 출력 한다.
배열을 선언 할 때 순으로 데이터가 출력 되는 것을 확인 할 수 있다.

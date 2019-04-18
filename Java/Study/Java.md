JAVA
===================

Class
------------------
+ 자바의 기본 단위 자바는 한번에 한개 혹은 여러개의 클래스로 구성되어있음
+ 클래스 내부에는 프로그램 실행에 필요한 변수와 메서드 등이 정의

Method 선언
---------------------
+ 기본 구조
<pre>(접근 지정자)return type(method name)parameter{
method body
}</pre>

Variable 선언
-----------------------
+ 기본 구조
<pre>(접근 지정자)(변수 타입)(변수 이름)[=<defalt value>]</pre>

생성자
------------------------
<pre>(class Name)parameter{
 생성자 body
 }</pre>
 
 Identifier(식별자)
 -------------------------
 + 식별자는 아무렇게나 붙이는 것이 아니기 때문에 규칙이 존재한다. 규칙은 다음과 같다.
 > 첫 문자는 숫자가 아니어야 하고 첫 문자 이후에는 문자와 숫자를 혼합해서 사용할 수 있다.
 > 첫 문자는 유니코드 문자,_ 혹은 $로 시작할 수 있다.
 > 길이 제한은 없으며 대소 문자를 구분한다.
 >유니코드를 기반으로 하므로 영문뿐만 아니라 한글, 한문도 사용할 수 있다.
 
 + 프로그래머들의 이름짓기 방식
 > 식별자는 영문자나 숫자로만 만든다.
 > 클래스의 이름은 대문자로, 메서드와 변수의 이름은 소문자로 시작한다.
 > 단어가 여러개로 되어 잇다면 두 번째 단어 부터 첫 문자를 대문자로 표현하여 구분한다.

Java Data Type
--------------------

+ 자료형
>기본 자료형 Primitive data type
= 정수형(byte, short, int, long), 실수형(float, double), 문자형(char=character), 논리형(boolean)
>참조 자료형 Reference data type
= 배열, 클래스 객체, 인터페이스

+ 기본값
>number라는 class를 만들고 아무것도 넣지 않는다면
default => int 0, double 0.0, boolean false

+ 자료의 크기
>1byte = 8bits 
>1bits = 4가지 숫자 표현

***

+ 참조형 자료타입은 new를 붙여준다. (예외적으로 String 뒤에는 제외 가장 많이 사용되기 때문에)
stack메모리 영역은 생성하지 않아도 사용이 가능함

+ 프로그래밍의 흐름은 위에서 아래로 진행 거슬러 올라오지 않는다.

![Java Data Size](https://t1.daumcdn.net/cfile/tistory/9941E63B5B42224F06?download)


관계 연산자(Relation Operator)
--------------------------------

+ 결과값은 True or False로 나옴
> a < b, a > b, a == b, a <= b, b >= a


단항 연산자
----------------------------
+ 가장 중요한건 ++, --
> ex) int i=2
j = ++i;  j = i++; 
앞 j는 i에 1을 더해서 j라는 저장공간에 값을 저장하기 때문에 j = 3, i = 3 이 됨
뒤 j는 i를 먼저 j에 저장하고 난뒤 1을 더해주는것 그래서 j = 2, i = 3 으로 저장


대입연산자
---------------------------
+ a = b 일때 b를 a라는 저장공간에 저장한다.
+ a += 2 는 a = a + 2 


논리 연산자(Logical Operator)
-----------------------------

+ 논리 연산자는 피연산자가 boolean값을 가진다.

+ And연산-> A 와 B 두개 모두 참일때 참
ex) 0 0 -> 0, 1 0 -> 0, 0 1-> 0, 1 1 -> 1
+ Or연산 -> A 와 B 둘중 하나가 참일때 참
ex) 0 0 -> 0, 1 0 -> 1, 0 1 -> 1, 1 1 -> 1


System
------------------------

![System](https://javainterviewpoint-7ac9.kxcdn.com/wp-content/uploads/2016/01/JVM-Architecture.png)


비트연산자(Bitwise Operator)
------------------------

+ 2진수에 대한 논리연산 각 자릿수마다 2의n승 2의8승의 값이 1일 결루 2의 보수로 표현된 음수 값이다.
> ex) a=20일때 ~a(NOT연산)을 하면 11110101 -> 0001011 2의 보수값 -11

+ OverFlow & UnderFlow => Civilization Gandhi 


혼합연산자
------------------

+ +=, -=, *=, /=, %= 등으로 사용


삼항연산자(conditional ternary operator)
-------------------

+ boolean 형 데이터를 반환함
> String a = true? "참":"거짓" ; 조건식이 true를 반환하게 되면 참이 나오고 false를 반환하면 거짓이 나옴


형 변환(TypeCasting)
--------------------------

+ 변수의 값을 대입하거나 연산하기위해서는 데이터의 형이 같아야함. 때문에 서로 다른 데이터 형을 연산하기 위해 데이터를 변환해줘야함.
+ 작은 type => 큰 type 자동 형 변환 가능 반대의 경우는 불가능
+ 큰 type => 작은 type 변환은 프로그래머가 직접 
> int a = (int)3.0;
+ 큰것에서 작은것으로 변환 될때는 데이터 손실이 일어난다.
![Type](http://cfs2.tistory.com/upload_control/download.blog?fhandle=YmxvZzg3MzAxQGZzMi50aXN0b3J5LmNvbTovYXR0YWNoLzQvNDE4LmdpZg%3D%3D)

JVM의 Garbage Collector
---------------------------
> Garbage는 '정리되지 않은 메모리', '유효하지 않은 메모리 주소'
+ Garbage Collector는 메모리가 부족할때 Garbage를 정리해주는 프로그램을 말한다.
+ 자바 어플리케이션의 응답 시간과 성능에 밀접한 관계를 가지게 된다
+ 더이상 사용되지 않는 인스턴스를 찾아 메모리에서 삭제하는 행위를 하게 된다.


제어문&반복문
--------------------------

+ 코딩의 효율성을 위해 일정 규칙을 통해 문장을 압축 if, swtich, for 등 다양한 문법들이 존재


If(제어문)
--------------------------

+ 영어 뜻 그대로 '만약에~한다면'
+ 연산의 순서를 제어 
> if구문에 비하면 삼항연산자는 가독성이 떨어짐 또한 여러가지 로직이 한번에 들어갈 수 있음
+ 괄호를 열고 닫는것에 주의 (기본)
+ 기본 구조

<pre>if(조건문){
}
else{
}</pre>

중첩 If문
--------------------------
+ 기본 구존
<pre>if(조건1){
     if(조건2){
              문장1
     }else{
               문장2
     }
}else{
      문장3
}</pre>

+ if와 else if 
> if는 위 조건이 참일때 실행되고 else if는 위 조건이 false이고 else if가 true일때 실행된다.


Switch
---------------------------
+ if 문은 switch 문으로 사용할 수있고 switch 문 또한 if 문으로 사용할 수있다.
+ switch문은 여러가지 조건을 처리하는데 프로그램 구조나 가독성 면에서 효율적이다.
+ 기본 구조

<pre>switch(조건값 : int,chr 등){ ->참조형은 올 수 없음(String가능)
  case1:연산자
     break;
  case2:
     break;</pre>
     
+ else if를 사용하게 되면 if를 충족하고 연산하지 않게된다.


 선언
 ----------------
 if 구문 작성시 변수를 선언하는것은 밖에서 출력 할 수 없다
 <pre>if(sc.nextInt()>100{
    int a = 100;
    }
    System.out.println(a);</pre>
> 오류가 뜨며 작동하지 않는다.
 <pre>int a;
 if(sc.nextInt()>100{
    a = 100;
    }
    System.out.println(a);</pre>
>처럼 선언을 해주고 들어오면 된다. 물론 이 구문은 작동하지 않는다. 


반복문
--------------------------
+ 반복문은 특정 조건을 만족하는 동안 혹은, 횟수를 정하여 동일한 작업을 반복하는 제어문
+ 동일한 문장을 반복해서 실행해야 할때 사용하며 이때 While, For, Do While 문 등을 사용한다.
+ While : 반복 횟수를 모르고 반복해야 할때 사용 (ex. 살이 1kg빠질때 까지 자전거페달을 돌려라)
+ For : 반복 횟수를 정확히 알고 있을때 사용 (ex. 운동장을 10바퀴 도세요)


While
----------------------
+ 조건이 성립하는 동안 Body에 정의된 문장을 반복적으로 실행 시키기 위한 제어문이다.
+ 기본 구조
<pre> while (조건식){
  문장
  }</pre>
+ True or False 값을 가진다.
+ True인 경우 문장을 반복수행하며 False인 경우 Loop에서 빠져나온다.


While 문의 사용
---------------------
+ While 문은 조건문이 참인 동안 계속해서 While문 안의 내용을 수행하게 된다. 
> 하지만 강제로 While문을 빠져나가고 싶을 때가 생기게 된다.
> While문을 강제로 멈추게 하는 것을 가능하게 해 주는 것이 바로 Break이다. (Switch에서의 Break와는 다름)
> While문 밖에서 조건식 Boolean값을 선언하여 무한Loop를 멈출수 있음 내부에서 선언 할수 없음
> Return은 나중에...
+ While문의 맨 처음(조건문)으로 돌아가게 하고 싶을 경우
> Continue문은 While문의 맨 처음으로 돌아가게 하는 명령어이다.
+ While문 내부에 If문을 통하여 특정 조건을 검색하여 제어가 가능하다.


Do While
------------------------
+ While문과 기능은 거의 같다.
+ 차이점은 While문은 조건을 먼저 검사하고 반복작업을 수행하는데, Do while문은 먼저 작업을 한번 수행하고 조건 검사를 한다
+ 기본 구조
<pre> do{
 statement
 }while(조건식)</pre>
+ 먼저 실행문이 수행하고 조건 값이 True이면 실행문을 반복 수행하며 거짓이 될때 Loop를 빠져나온다.


For
-------------------------
+ 정해진 수만큼 실행문을 반복하는 경우 사용
+ 기본구조
<pre> for(초기값; 조건식; 증감식){
    조건식이 true일때 반복되어 실행될 명령(반복문)
    }</pre>    
+ 초기값, 조건식, 증감식은 세미콜론(;)으로 구분
+ 초기값은 For문 밖에서 선언한 변수를 가져와도 되고 밖에서 초기화 까지 시킨후 초기값을 비워놓아도 오류는 없다 하지만 필요한 경우가 아니라면 For문 안에서 선언하고 초기화 시키자
+ 증감식은 대입연산자를 사용해 원하는 만큼 증감 시킬수 있다.
+ 다른 제어문과 마찬가지로 중첩하여 사용 


중첩 For문
--------------------------
+ For문이 중첩될 경우 각각 For문의 변수는 달라야 한다.
+ 안쪽 For문이 바깥쪽 For문보다 많이 반복하게됨 (안쪽 반복 횟수 * 바깥쪽 반복 횟수)


Break
--------------------------
+ Switch문과 For문에서의 Break의 사용이 다름
+ 해당 반복 문을 빠져 나오도록 해줌

<pre>ex)for (초기값; 조건식; 증감식){
if (조건식){
          break;
   }
   문장
}</pre>
> for문 안의 if문 조건식이 True일 경우 break문을 만나게 되면 For문을 완전히 빠져나온다.
+ 중첩 반복 문에서 Break를 사용 하면 Break문이 포함된 반복문만 빠져나오게된다.
+ For문 뿐만 아니라 While, Do While문에서도 동일한 작용을 한다.


Continue
---------------------
+ 반복문 안에서만 사용이 가능하다.
+ Continue문이 실행되면 아래의 다른 문장을 실행하지 않고 반복문의 처음부분으로 돌아가게 된다.
<pre>ex) while (조건식){
      if (조건){
              continue;
      }
      실행문
}</pre>
+ While문 안의 If문 조건이 True일때 Continue문을 실행하게 되면 Continue이하 실행문들이 모두 skip되면서 While문의 그 다음 순서가 반복된다.


Label
------------------
+ 두 개 이상 중첩된 반복문을 빠져나갈 수 없는데 빠져나가야 하는경우 사용한다.
+ Label은 Fo문이나While문 앞에 붙여 place holder와 같이 사용 가능
+ 특별한 문법적 동작을 하거나 로직이 있는 문장이 아니며 사용자가 변수의 이름을 정하듯 임의로 정할 수 있다.
+ Label 뒤에 (:)을 붙인다.
+ Break와 함께 사용할 때에는 반복문을 빠져나갈수 있음
+continue문과 함께 사용할 경우 바깥의 있는 반복문을 계속 실행하게 된다.


scan.nextLine();
-----------------------------
+ scan.nextInt(); or scan.nextDouble();를 입력후 scan.nextLine(); 을 입력하면 str이 제대로 출력되지 않는다.
> 즉, nextInt(); 는 엔터 즉, nextLine(); 을 입력받지 않기 때문에

> nextInt() 를 하고 nextLine(); 호출하면 nextInt()의 enter라고 생각하기 때문에 nextLine()이 skipped 된다.

> 해결법 : nextInt();와 nextLine(); 사이에 nextLine(); 을 추가하여 enter값을 받게 해준다
<pre>int num = scan.nextInt();
 scan.nextLine();
  String s = scan.nextLine();</pre>

+ next(); 문자 또는 문자열을 공백기준으로 한단어 또는 한 문자씩 입력 받는다.
+ nextLine(); 문자 또는 문장 한 라인 전체를 입력 받는다.


Print
-------------------
+ System.out.print(); 아무것도 적지 않으면 작동하지않음
+	System.out.println(); 줄바꿈 기능을 사용할 수 있어 작동함
+ \n을 추가하면 줄바꿈
<pre>System.out.print("c\n");</pre>

+  기능을 적고 출력을 하면 출력후 줄바꿈이 작동함 println은 자체적으로 줄바꿈기능을 포함
<pre>System.out.println();</pre>

+ printf(); 한줄 출력 줄바꿈 없음, 문장을 완성하고 무엇을 삽입하는 형태, 문장을 완성하고 기호를 통해서 완성한다.
<pre>System.out.printf("%s님 환영합니다.",t);</pre>
> s = string d = decimal %,d 를 사용하게 되면 세자리 마다 쉼표로 자릿수를 구분해줌

> 추가되는 요소에 ,를 붙여가면서 요소를 추가할 수 있음

> Scanner로 입력받은 값을 넣을 수 있음

> 소수점은 %f = float로 표현 소수점은 이하 6자리 까지 출력 %.2f로 표시할 경우 소수점 이하 두자리 까지 출력

> 0.016을 두자리수 까지 출력한다 했을때 0.02로 반올림 하여 출력함 0.014일경우 0.01로 출력

> %-15s %03d 와 같이 출력할 경우 정렬이 된다.


Coding의 순서
--------------------
1. Variable(변수) 준비
2. 메뉴 구성(메뉴 반복문, 선택입력 등)
3. 조건문 구성
4. 조건별로 알고리즘 만들기


Encapsulation(캡슐화)
-----------------
+ 내부 구현을 숨기고 사용자에게는 인터페이스만을 보여주는것
+ 외부에서 데이터에 접근하지 못하도록함
+ private을 사용 ex) private int XXX 멤버변수, 필드 라고 

Link
--------------
+유용한 깃허브
> https://github.com/cheese10yun/dev-info

+ 블로그
> https://hyeonstorage.tistory.com/136

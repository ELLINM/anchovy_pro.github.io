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


관계 연산자(Relation Operator)
--------------------------------

+ 결과값은 True or False로 나옴
> a < b, a > b, a == b, a <= b, b >= a


논리 연산자(Logical Operator)
-----------------------------

+ 논리 연산자는 피연산자가 boolean값을 가진다.

+ And연산-> A 와 B 두개 모두 참일때 참
ex) 0 0 -> 0, 1 0 -> 0, 0 1-> 0, 1 1 -> 1


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
       문장
     }
  }else{
     문장
  }</pre>

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

Java Data Type
==================

자료형
--------------------
>기본 자료형 Primitive data type
= 정수형(byte, short, int, long), 실수형(float, double), 문자형(char=character), 논리형(boolean)

>참조 자료형 Reference data type
= 배열, 클래스 객체, 인터페이스


기본값
------------------------------
>number라는 class를 만들고 아무것도 넣지 않는다면
default => int 0, double 0.0, boolean false

자료의 크기
-----------------------------

>1byte = 8bits 

>1bits = 4가지 숫자 표현

***

+ 참조형 자료타입은 new를 붙여준다. (예외적으로 String 뒤에는 제외 가장 많이 사용되기 때문에)
stack메모리 영역은 생성하지 않아도 사용이 가능함

+ 프로그래밍의 흐름은 위에서 아래로 진행 거슬러 올라오지 않는다.


Relation Operator
--------------------------------

+ 결과값은 True or False로 나옴
> a < b, a > b, a == b, a <= b, b >= a

Logical Operator
-----------------------------

+ 논리 연산자는 피연산자가 boolean값을 가진다.

+ And연산-> A 와 B 두개 모두 참일때 참
ex) 0 0 -> 0, 1 0 -> 0, 0 1-> 0, 1 1 -> 1


System
------------------------

![System](https://javainterviewpoint-7ac9.kxcdn.com/wp-content/uploads/2016/01/JVM-Architecture.png)

Bitwise Operator
------------------------

+ 2진수에 대한 논리연산 각 자릿수마다 2의n승 2의8승의 값이 1일 결루 2의 보수로 표현된 음수 값이다.
> ex) a=20일때 ~a(NOT연산)을 하면 11110101 -> 0001011 2의 보수값 -11

+ OverFlow & UnderFlow => Civilization Gandhi 

혼합연산자
------------------

+ +=, -=, *=, /=, %= 등으로 

Class
===========
+ Class는 Java의 기본 단위이며 Class는 Variable과 Method로 구성되어있다.
+ Object를 만들어내는 틀 또는 설계도와 같음
+ Object를 만들어 내기 위한 Member Variable과 Member Method를 포함.
+ Class 자체로는 Object가 될 수 없으며 생성과정을 통하여 메모리 공간을 할당받아 적재되는 작업 필요
+ 이러한 Class를 Object 또는 Instance라고 부른다.


Class의 설계와 기능
---------
+ Class는 Data(변수)와 Method(처리동작)를 하나로 모아놓은것
> 함수에서 값을 계산하여 변수로 저장
> 변수에서 값을 가져와서 함수로 계산

+ Data는 객체의 속성, 멤버 변수, 특성, 필드, 상태 등으로 불리움
> 저장 할 수 있는 Data
+ Method는 객체의 기능, 행위, 멤버함수 등으로 불리움
> 값을 계산

+ Class는 만들었다고 바로 사용할 수 없다.
> 객체화를 통하여 사용


Types of Variables
------------------
+ Variable은 실제 Data가 저장되는 메모리를 프로그램 상에서 접근하기위해 사용된다.
+ VAriable의 범위라는 것은 Variable의 활동영역 또는 생명주기와 같다.

* Member Variable
+ Field, Instance Variable이라고도 한다.
+ Class안에서 선언된 Variable
+ 생명주기는 Object의 생명주기와도 같다. => Object가 생성되는 시점에 초기화가 이루어지고 Object가 소멸되는 시점에서 사라짐.

* Local Variable
+ Automatic, Stack Variable라고도 한다.
+ Method 안에서 선언된 Variable 때문에 Method와 생명주기를 같이한다.
+ 사용하기 전에 반드시 초기화를 해주어야 한다.

* Class Variable
+ Member Variable 앞에 static이라는 예약어가 붙으면 Class Variable이된다.
+ 생명주기는 Class와 함께한다. 
+ Class가 로딩되는 시점에 초기화가 이루어진다.
+ Object의 참조 없이 Class 이름만으로 참조할 수 있다.


VO (Value Object)
-------------------
+ data중심의 Object (DTO라고 부르기도함 네트워크관련)

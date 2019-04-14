Method
============
+ Class의 포함 요소
+ Object의 행위(기능)를 나타낸다. => 프로그래머가 프로그램 상에서 특정 Object에게 기대하는 기능을 Class의 Method로 구성
+ 우리가 Method를 사용하는 가장 큰 이유는 반복적으로 사용되는 코드를 줄이기 위해서이다.
  자주 사용되는 코드를 Method로 작성해 놓고 필요한곳에서 호출만 하면 되니
  코드의 양도 줄일수 있고 코드를 한 곳에서만 관리하면 되므로 유지보수가 매우 편리하다.
+ Main Method는 프로그램 실행시 꼭 필요한 Method이며 프로그램의 시작점


Method의 선언 형식
----------------------
<pre>public void main(int n)
  int max_page =500
  {
    if (n <= max_page)
    {
    page = n;
    }
  }</pre>
> public : 접근지정자. 외부, 내부로부터의 접근제어를 나타낸다.

> void : 반환형(Return Type). Method가 종료되었을 때 Method 를 호출한 곳으로 반환하는 Data Type.

> setPage : Method Name. 관례상 소문자로 시작하고 다음구분 단어의 첫 글자 마다 대문자로 표현한다.

> (int n) : Method의 매개변수 목록(Arguments). Method가 Method를 호출한 곳으로부터 전달받는 데이터들을 나열한다.

> int max_page = 500; : Method의 몸체. 중괄호 안에 들어있는 문장들. Method의 기능을 구현하는 문장들이 들어간다.


Mehtod의 매개변수
-----------------
+ 경우에 따라서 메서드는 매개변수 값을 받아들일 필요가 있다. 이 때 괄호 안에 전달받고자하는 데이터들을 변수선언 형식으로 콤마로 구분하여 나열
+ 전달받고자하는 데이터들이 없다면 괄호안에 아무것도 선언하지 않는다.


Return Type
-------------
+ Method내에서 작업이 다이루어진 다음에 Method는 작업의 결과값을 반환할 수 있다.
+ 반환하고자 하는 데이터의 타입을 Method선언시에 반드시 명시하고 Method 몸체({})안에서 
  return이라는 키워드를 사용하여 반환할 데이터를 표현할 수 있다.
+ 선언한 데이터 타입과 return키워드 뒤에 사용하는 데이터의 타입은 반드시 일치해야한다.
+ 반환하고자 하는 값이 없을 경우 Method 선언시 void 라는 키워드를 사용하고 몸체 안에서 return키워드를 사용하지 않는다.
+ return type을 void로 선언한 Method 안에서 단독으로 return이라는 키워드를 사용할 경우 Method는 종료된다.


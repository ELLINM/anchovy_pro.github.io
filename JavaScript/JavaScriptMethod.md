+ 자바스크립트는 웹 브라우저에 내장되어 있음
  웹 브라우저 자체를 제어하는 것이 bom 이라는 웹 브라우저 객체
  html, xml 등의 마크업 언어를 제어하는 것이 dom 이라는 문서 객체
  이 세 가지를 모두 포함하는 것이 window 객체로 웹 브라우저에 내장되어 있음


![Window](https://raw.githubusercontent.com/ELLINM/coding_tutorial/master/Image/%EA%B7%B8%EB%A6%BC1.png)


Window
=======
+ 웹 브라우저의 최상위 객체
  javascript core, BOM, DOM 을 포함하고 있음
+ window 객체 하나가 하나의 브라우저

BOM (Browser Object Model)
-----------
+ 브라우저를 제어하는 객체들의 집합
+ screen, location, navigator, history, frame

+ screen : 브라우저가 아닌 운영체제 화면에 관련된 객체
> 운영체제 화면의 속성을 갖는 객체
  width : 화면의 너비
  height : 화면의 높이

+ navigator	: 브라우저와 관련된 객체(주로 브라우저 종류를 구분하기위해 사용)
+ location : 주소와 관련된 객체
+ history : 브라우저의 주소 이력과 관련된 객체

DOM (Document Object Model)
------
+ document


Global object(전역객체)
---------
+ window 객체를 뜻함, global object 모든 객체가 전역 객체에 속해있음(property라는 뜻, 상속과는 다름)
+ 객체를 명시하지 않으면 암시적으로 window 의 property 로 지정됨
Ex)
<pre>var a = 10;
alert(window.a);	// 10 이 출력됨
window.alert(window.a);	// 10 이 출력됨</pre>

Method
-------
+ open(URL, name, features, replace) : 새 창 열기
> 주소를 입력하거나 문자열을 입력

+ name
> _blank   
  _parent   
  _self

+ moveBy(x, y) : 창의 위치를 x, y 픽셀 만큼 이동
+ moveTo(x, y) : 창의 위치를 x, y 픽셀로 이동
+ resizeBy(x, y) : 창의 크기를 x, y 픽셀 만큼 변경
+ resizeTo(x, y) : 창의 크기를 x, y 픽셀로 변경
+ focus() : 창에 포커스(초점)을 맞춤
+ blur() : 창에서 포커스(초점)을 제거
+ close() : 창을 닫음
+ print() : 창의 내용을 인쇄
+ createElement(tagName) : tagName 에 해당하는 element node 를 생성
+ createTextNode(text) : element node 와 연결할 text node 를 생성
+ appendChild(node) : 문서 객체에 element node 또는 text node 를 연결
> html 태그를 객체화한 각 문서 객체를 node 라고 표현함     
  node에는 element node 와 text node 가 있음     
  element node     
  html 태그를 의미    
  text node     
  html 태그에 연결할 text 를 의미     
  
  Ex)
  ~~~
  <h1>텍스트</h1>
  ~~~
  에서 “텍스트”    

> 생성한 element node 에 속성을 추가할 경우
  노드명.속성명 = 속성값
  Ex)
  <pre>var temp = document.createElement(“input”);
	temp.type= “text”;</pre>

+ innerHTML : 특정 문서 객체가 node 정보를 문자열로 갖고 있음
+ removeChild(node) : 문서 객체가 갖는 특정 node 를 삭제
  특정 문서객체(node)를 삭제하기 위해서는 먼저, 삭제하려는 문서객체를 포함하고 있는
  부모 문서객체에 접근하여 삭제해야 함

  Ex)
  ~~~
  <form>
	  <input type=”text”>
	  <input type=”submit”>
  </form>
  ~~~
> 위 태그에서 input type text 를 삭제하기 위해서는 부모인 form 태그에 접근하여 삭제해야함


property
----------
+ opener : 현재 창을 생성한 window 객체

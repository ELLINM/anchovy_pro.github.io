+ 자바스크립트는 웹 브라우저에 내장되어 있음
  웹 브라우저 자체를 제어하는 것이 bom 이라는 웹 브라우저 객체
  html, xml 등의 마크업 언어를 제어하는 것이 dom 이라는 문서 객체
  이 세 가지를 모두 포함하는 것이 window 객체로 웹 브라우저에 내장되어 있음


Window
=======
+ 웹 브라우저의 최상위 객체
  javascript core, BOM, DOM 을 포함하고 있음
+ window 객체 하나가 하나의 브라우저

BOM (Browser Object Model)
-----------
+ screen, location, navigator, history, frame

+ screen : 브라우저가 아닌 운영체제 화면에 관련된 객체
+ navigator	: 브라우저와 관련된 객체(주로 브라우저 종류를 구분하기위해 사용)
+ location : 주소와 관련된 객체
+ history : 브라우저의 주소 이력과 관련된 객체

DOM (Document Object Model)
------
+ document


전역객체
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


property
----------
+ opener : 현재 창을 생성한 window 객체

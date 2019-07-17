JavaScript
====
+ JavaScript는 복잡한 무언가(주기적으로 내용이 갱신되는 기능이나 능동적인 지도, 변화하는 2D/3D 그래픽, 동영상 등)를 
  WebPage에 적용할 수 있게 하는 스크립트, 프로그래밍 언어
+ 동적으로 컨텐츠를 바꾸고, 멀티미디어를 다루고, 움직이는 이미지 그리고 여러가지 처리들을 할 수 있는 스크립트 언어


VAR
-----
+ 변수(Variable)를 나타냄
+ Java와 마찬가지로 변수의 종류가 존재함


Window
----
+ Window 객체는 모든 객체가 소속된 객체(DOM, BOM, JavaScriptCore)이고, 전역객체이면서, 창이나 프레임을 의미
+ Window 객체는 식별자 window를 통해서 얻을 수 있다. 또한 생략 가능
+ Window아래에는 대표적으로 screen, location, history, document 같은 객체들이 존재 메소드는 parseInt, isNaN 등

|Window Tag|Content|
|-----|-----|
|window.close()|현재 창을 종료 window는 생략 가능 -> close();작동| 
|window.open()|새 창을 띄움 -> 팝업 창,새 탭가능 첫 번째 인자로 주소 두 번째 인자로 새 탭으로 열지, 현재 탭에 열지를 설정    세 번째 인자로 새 창에 대한 각종 설정을 전달|
|window.encodeURI()    window.decodeURI()|주소에 한글이 들어가면 한글이 이상한 글자로 변환|
|window.setTimeout(함수, 밀리초)    window.setInterval(함수, 밀리초)|고의로 시간을 뒤로 미루어 실행할 때 사용하는 코드 setTimeout은 지정한 초 뒤에 실행   setInterval은 지정한 초마다 반복|
|window.getComputedStyle(태그)|Tag의 스타일을 찾는 Method 현재 적용된 CSS 속성 값을 파악|


Document
------
+ window 객체의 속성 중 하나
+ window.document 이렇게 접근해야 하지만 window는 생략 가능(전역 객체)하기 때문에 그냥 document로 접근

|Document Tag|Content|
|-----|-----|
|document.getElementById(ID)|html에서 해당 ID를 가진 Tag를 선택|
|document.getElementsByClassName(클래스)    document.getElementsByName(이름)    document.getElementsByTagName(태그)|html에서 각각 해당 클래스, 네임, 태그명을 가진 태그를 선택 여러개 선택되기 때문에 항상 배열입니다. 메소드 이름도 Elements|
|document.querySelector(선택자)    document.querySelectorAll(선택자)|css 선택자로 선택 id는 #, 클래스는 .(점)입니다. 태그명[속성명=속성값] 같은 것도 할 수 있고, 부모 > 자식, 부모 자손 등등 css의 선택자는 대부분 사용가능
|document.createElement(태그명)|document에 새로운 태그를 만들 때 사용 변수를 통해 메모리에 저장 만든 태그를 추가가능|
|document.createTextNode(텍스트)|텍스트를 따로 생성 변수를 통해 메모리에 저장|
|document.createDocumentFragment()|가짜 document를 생성 여러 태그를 반복문을 통해 동시에 추가할 때 가짜 document를 만들어서 여기에 추가를 한 후, 한 번에 document에 추가|
|document.head, document.body|각각 html의 head와 body에 접근|
|document.anchors   document.links    document.forms    document.images    document.scripts|각각 모든 html 앵커, 링크, 폼, 이미지, 스크립트에 접근|
document.title|문서의 제목에 접근|


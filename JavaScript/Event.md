Event
======
+ Event 어떤 사건을 의미
+ Browser에서의 Event란 사용자가 클릭을 했을 '때', 스크롤을 했을 '때', 필드의 내용을 바꾸었을 '때'와 같은 것을 의미
+ 개발자는 어떤 일이 발생했을 때 실행 되어야 하는 코드를 등록 -> 브라우저는 그 일이 발생했을 때 등록된 코드를 실행 


HTML DOM Event와 Event 처리
-----
+ JavaScript는 Event 주도 프로그래밍(event-driven programming) 모델을 사용 
+ Web Browser는 HTML Event를 생성하고, HTML DOM은 자바스크립트가 HTML Event에 반응하게 함


Event Connect
---------
+ 문서 객체에 이벤트 속성과 로직을 지정
+ HTML 태그에 이벤트 속성과 로직을 지정


속성 형태의 Event Handler
-------
+ JavaScript에서 Event Handler는 HTML 속성으로 지정할 수도 있음
+ Event Handler의 값은 Java 코드로 구성된 임의 문자열
+ Event Handler가 여러 JavaScript 구문으로 구성돼 있다면 각 구문을 세미콜론으로 구분

Ex)
~~~~~
<input type="button" value="Press Me" onclick="alert('thanks');">   
 
<form action="processform.action" onsubmit="return validateForm();">

<body onload="startApp()"> 
~~~~~


프로퍼티 형태의 Event Handler
------
+ JavaScript에서는 Event Handler를 DOM 엘리먼트의 프로퍼티로 할당할 수 있음
+ 이벤트 핸들러 프로퍼티에 원하는 함수를 설정

Ex)
<pre>
document.getElementById('button1').onclick = function(){alert('thanks');};
 
function startApp(){...} 
document.onload = startApp;
</pre>


Event Handler와 this 키워드
-------
+ Event Handler를 HTML 속성으로 정의하든 JavaScript 프로퍼티로 정의하든 함수를 document 엘리먼트의 프로퍼티로 할당하는 셈
  -> document 엘리먼트에 새로운 메서드를 정의
+ Event Handler가 호출되면 Event가 발생한 엘리먼트의 메서드로서 해당 Event Handler가 호출 -> this 키워드는 대상 엘리먼트를 가리킴


Event Attribute
------
+ onfocus	: 포커스가 맞춰졌을 경우
+ oninput	: 값이 입력되었을 경우
+ onkeyup	: 키보드 키를 눌렀다 뗐을 경우
+ onmouseover	: 마우스 커서를 올렸을 경우
+ onchange	: 값이 변경되었을 경우

Event Type
------
+ 자바스크립트에서 특정 HTML 이벤트가 발생하면 브라우저에서는 자바스크립트 함수나 코드 조각에 해당하는 Event Handler를 호출
  
+ onabort: 이미지 로딩이 중단될 경우 실행된다.
+ onblur: 엘리먼트가 입력 포커스를 잃어버릴 경우 실행된다.
+ onchange: 폼 엘리먼트가 포커스를 잃고 값이 변경될 경우 실행된다.
+ onclick: 마우스 버튼이 눌렸다 떼어질 때 실행된다. mouseup 이벤트가 이어서 발생한다. 기본 동작 방식을 취소하려면 false를 반환한다.
+ ondblclick: 마우스가 더블클릭될 때 실행된다.
+ onerror: 이미지 로딩 오류가 일어날 경우 실행된다.
+ onfocus: 엘리먼트가 입력 포커스를 얻을 경우 실행된다.
+ onkeydown: 키가 눌렸을 때 실행된다. 취소하려면 false를 반환한다.
+ onkeypress: 키가 눌렸을 때 실행된다. keydown 이벤트가 이어서 발생한다. 취소하려면 false를 반환한다.
+ onkeyup: 키에서 손을 뗐을 때 실행된다. keypress 이벤트가 이어서 발생한다.
+ onmousedown: 마우스 버튼이 눌렸을 때 실행된다.
+ onmousemove: 마우스가 이동할 경우 실행된다.
+ onmouseout: 마우스가 엘리먼트에서 벗어났을 때 실행된다.
+ onmouseover: 마우스가 엘리먼트 위로 이동할 때 실행된다.
+ onmouseup: 마우스 버튼에서 손을 뗐을 때 실행된다.
+ onresize: 윈도우 크기가 변경될 경우 실행된다.
+ onselect: 텍스트가 선택됐을 때 실행된다.
+ onreset: 폼 초기화가 요청됐을 때 실행된다. 초기화를 방지하려면 false를 반환한다.
+ onsubmit: 폼 제출이 요청됐을 때 실행된다. 제출을 방지하려면 false를 반환한다.
+ onload: 문서 로딩이 완료됐을 때 실행된다.
+ onunload: 문서나 프레임셋이 사라졌을 때 실행된다.


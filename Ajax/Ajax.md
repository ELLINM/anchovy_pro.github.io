AJAX
======
+ javascript 를 이용한 비동기 통신 방식, JavaScript와 XML (Asynchronous JavaScript And XML)
+ 서버와의 통신이 이루어지는 동안, 다른 작업이 가능 / 화면 전환 불필요
  통신하기 위해 XMLHttpRequest 객체를 사용
+ xml, text, json 등의 데이터를 이용하여 통신 가능
> AJAX의 강력한 특징은 페이지 전체를 리프레쉬 하지 않고서도 수행 되는 "비동기성"
  비동기성을 통해 사용자의 Event가 있으면 전체 페이지가 아닌 일부분만을 업데이트 할 수 있게 해줌


Ajax의 장점
------
+ 페이지 새로고침 없이 서버에 요청
+ 서버로부터 데이터를 받고 작업을 수행



 $.ajax() Method
-------
+ JQuery는 Ajax와 관련된 다양하고도 편리한 Method를 많이 제공
+ $.ajax() Metjod는 모든 JQuery Ajax Method의 핵심이 되는 메소드
+ $.ajax() Metjod는 HTTP 요청을 만드는 강력하고도 직관적인 방법을 제공

+ 원형
<pre>$.ajax([옵션])</pre>
+ URL 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소
+ 옵션은 HTTP 요청을 구성하는 키와 값의 쌍으로 구성되는 헤더의 집합


Tag
----
+ url : 데이터를 전송할 요청 url
+ type : 데이터 전송 방식(get / post)
+ data : 전송할 데이터(javascript 의 Object 타입)
+ success : 통신 전송 후, 호출될 함수
+ error : 통신에 실패할 경우, 호출될 함수
+ dataType : 서버로부터 반환받는 데이터 타입(text, html, xml, json 등)



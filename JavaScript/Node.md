Node
=====
+ text node
+ element node


text()
------
+ 특정 문서객체의 text node 를 반환 / 설정
+ text()     
  문서 객체의 text node 를 반환
+ text(문자열)     
  문서 객체에 문자열로 text node 를 설정
+ text(function(index, node) { return 문자열})     
  node 는 문서 객체의 text node     
  반환된 문자열이 문서 객체의 text node 로 설정됨


html()
------
+ 특정 문서객체의 element node 를 반환 / 설정
+ html()     
  문서 객체의 element node 를 반환     
  html(문자열)     
  문서 객체에 문자열로 element node 를 설정     
  html(function(index, node) { return 문자열})     
  node 는 문서 객체의 element node     
  반환된 문자열이 문서 객체의 element node 로 설정됨


문서객체 추가
------
+ 문서객체 추가 메서드
+ append(문자열)     
  문서객체 내부의 뒤에 추가
+ prepend(문자열)     
  문서객체 내부의 앞에 추가
+ after(문자열)     
  문서객체 앞에 추가
+ before(문자열)     
  문서객체 뒤에 추가


문서객체 삭제
------
+ 문서객체 삭제 메서드 
+ empty()     
  문서객체 내부를 삭제
+ remove()     
  문서객체를 삭제


event
-----
+ event 연결 메서드
+ on(문자열, function() { })  
  문서객체에 문자열과 일치하는 event 를 연결   
  event 발생시, function 호출
+ click(function() {} ) / keyup(function() {} ) / focus(function() {} ) / …   
  event 연결을 쉽게 하기 위한 메서드


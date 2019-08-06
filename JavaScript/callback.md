CallBack
=====
+ JavaScript에서는, function은 일급 객체
+ function는 Object 타입이며 다른 일급객체와 똑같이 사용(String, Array, Number, 등등..)
+ function 자체가 객체이므로 변수안에 담을 수 도 있고 인수로서 다른 function에 전달 해 줄수도있고, function에서 만들어질수도있고 반환
+ Callback function은, 특정 function에 매개변수로서 전달된 function을 지칭
+ Callback function은 그 function을 전달받은 function 안에서 호출됨
+ Callback function를 사용하여 프로그램의 흐름을 끊지 않음으로서, Non-Blocking 코드를 사용하는 서버는 Blocking 코드를 사용하는 서버보다
  더 많은 양의 요청을 빠르게 처리 할 수 있게됨
+ 일반적인 function은 paremeter를 받아 function 내부로 진입하고 결과값을 돌려줄 때는 return키워드를 사용해 호출자에게 값을 돌려 주는 구조
+ 또는 parameter 자체를 Call by reference로 전달(포인터 전달)해 호출자가 참조하는 값 자체를 function 내부에서 변경 
  리턴값은 없거나 에러 여부를 전달하는 데 쓰임
+ Callback function은 function로써 다른 function에 전달되며, 이는 외부 function 내에서 일종의 루틴 또는 동작을 완성하기 위해 호출
+ 사용자는 호출된 function만 설정을 하고 시스템이 호출해야 하는 타이밍에 설정된 function를 호출


Callback function의 특징
-------
+ 변수나 데이터 구조안에 담을 수 있음
+ parameter로 전달 할 수 있음
+ 반환값(return value)으로 사용할 수 있음
+ 할당에 사용된 이름과 관계없이 고유한 구별이 가능
+ 동적으로 프로퍼티 할당이 가능


addClass()
-------
+ 문서 객체에 class 속성을 추가
+ addClass(문자열)     
  class 속성값으로 문자열을 추가
+ addClass(function(index) { return 문자열 })     
  function 로직 실행 후, 반환되는 문자열로 class 속성값 추가
  index 는 문서 객체의 수 만큼 증가


removeClass()
----------
+ 문서객체의 class 속성을 삭제
+ removeClass(문자열)     
  문자열과 일치하는 class 속성값을 삭제
+ removeClass(function(index, item) { return 문자열 })
  function 로직 실행 후, 반환되는 문자열과 일치하는 class 속성값 삭제    
  index 는 문서 객체의 수 만큼 증가    
  item 은 각 문서 객체에 설정된 class 속성값
+ removeClass()    
  문서 객체에 설정된 모든 class 속성값을 삭제


toggleClass()
------
+ 문서객체의 class 속성을 추가/삭제
+ toggleClass(문자열)    
  문서객체에 문자열과 일치하는 class 속성값이 존재하지 않을 경우 추가    
  문서객체에 문자열과 일치하는 class 속성값이 존재할 경우 삭제    
+ removeClass()    
  문서 객체에 class 속성값이 설정된 경우 삭제    
  삭제 후, 재호출시 삭제했던 class 속성값을 추가


attr()
------
+ 문서객체의 특정 속성값을 확인 / 특정 속성값을 설정
+ attr(속성)    
  문서 객체에서 속성의 값을 반환
+ attr(속성, 값)     
  문서 객체에 속성과 값을 설정
+ attr({속성: 값, 속성: 값, ...})      
  object 타입으로 전달된 속성과 값들을 설정
+ attr(name, function(index, attr) {return 문자열} )      
  return 값으로 전달된 문자열을 name의 속성값으로 설정     
  attr 은 각 문서객체의  name 에 해당하는 속성의 값


removeAttr
------
+ 문서 객체의 속성을 삭제
+ removeAttr(속성명)    
  문서 객체에서 속성명과 일치하는 속성과 그 값을 삭제


css()
-------
+ 문서객체의 특정 스타일 속성값을 확인 / 특정 스타일 속성값을 설정
+ css(속성)    
  문서 객체에서 스타일 속성 값을 반환
+ css(속성, 값)     
  문서 객체에 스타일 속성과 값을 설정
+ css({속성: 값, 속성: 값, ...})     
  object 타입으로 전달된 스타일 속성과 값들을 설정
+ css(name, function(index, css) {return 문자열} )      
  return 값으로 전달된 문자열을 name의 속성값으로 설정     
  css 는 각 문서 객체의 name 에 해당하는 속성의 값


val()
------
+ 문서객체의 value 속성값을 반환 / 설정
+ val()     
  문서 객체의 value 속성 값을 반환
+ val(속성값)     
  문서 객체의 value 속성 값을 설정
+ val(function(index, value) {return 문자열} )       
  return 값으로 전달된 문자열을 value 속성값으로 설정     
  value 는 각 문서 객체의 value



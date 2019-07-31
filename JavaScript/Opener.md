Window.open()
========
+ Window.open()는 지정한 URL을 새 창 혹은 현재 창에 불러오고 해당 Window 객체를 반환
+ Window.open()sms 4개의 선택적 인자를 소유

+ window.open( URL, name [ , specs ] [ , replace ] )
> URL : 웹 문서 URL이다. 이 인자를 생략하거나 빈 문자열이면 about:blank라는 특별한 빈 페이지 URL이 사용된다.
  
  name : 창의 이름을 가리키는 문자열 이름이 이미 사용되고 있고 접근도 허용된다면 해당 창을 사용
  그렇지 않다면 지정한 이름을 사용하여 새로운 창을 생성, 이 인자가 생략되면 "_blank"가 사용되고 이름 붙지 않은 새 창을 염
  스크립트는 창 이름을 추측하거나 다른 웹 애플리케이션상의 창을 사용할 수 없음 오직 이미 존재하고 '접근이 허용된' 창에서만 이것이 가능
  대략적으로는 동일 출처 정책상 문서를 포함한 창 혹은 스크립트로 생성한 창이 이미 이름을 가지고 있을 때만 조작 가능 
  창 이름(두번째 인자) open() 메서드로 이미 존재하는 창을 가리키도록 할 수 있고, <a>와 <form>요소가 문서를 연결(혹은 form 전송결과) 
  내용을 표시할 창을 가리킬 HTML target 속성의 값으로도 활용가능, 
  이 요소들의 target 속성은 새창(_blank), 부모 창(_parent)이나 프레임, 최상위 창(_top)과 문서를 연결하기 위해 사용

  _blank: 연결된 문서를 읽어 새로운 빈 윈도우에 표시 윈도우 이름은 없음    
  _media: 연결된 문서를 읽어 미디어바의 HTML 내용부분에 표시 IE6부터 적용    
  _parent: 연결된 문서를 읽어 바로 상위 모체창에 표시    
  _search: 연결된 문서를 읽어 브라우저의 검색창에 표시 IE5부터 적용    
  _self: 디폴트이며, 연결된 문서를 읽어 현재창에 표시    
  _top: 연결된 문서를 읽어 최상위 윈도우에 표시    

  specs : 새로 열릴 창의 크기와 기능 속성의 목록을 콤마로 구분한 문자열
  생략하면 새 창은 기본 크기에 메뉴바, 상태표시줄, 도구 바 그리고 이외의 모든 UI 구성요소를 포함 

  fullscreen = 전체 창. (yes/no)(default : no)    
  location = 주소창이 활성화. (yes/no)(default : yes)    
  menubar = 메뉴바 visible. (yes/no)(default : yes)    
  titlebar = 타이틀바. (yes/no)(default : yes)    
  toolbar = 툴바. (yes/no)(default : yes)    
  resizable = 창 사이즈 변경. (yes/no)(default : yes)    
  scrollbars = 스크롤바. (yes/no)(default : yes)    
  width = 창 가로 크기    
  height = 창 세로 크기    

  replace : true일 땐 새 문서가 이전의 문서와 교체 false이거나 지정되지 않으면 새 문서는 창의 브라우징 히스토리에 새 항목으로 추가

Ex)
<pre>function openWin(){  
    window.open("http://www.naver.net", "네이버새창", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
}</pre>


> 부모 창에서 자식 창의 문서에 접근할 땐 window.open() 함수가 반환하는 객체를 이용 
  <pre>var winObj = window.open();</pre>
  만약 부모 창과 데이터를 주고 받을 자식 창이 여러 페이지에서 공통으로 사용되는 경우(공통팝업)
  자식 창에서 부모창을 직접 조작하는 것보다 부모창의 함수를 호출하여 파라미터로 던져주는 방식
  또는 부모의 함수명을 콜백으로 전달하는 방식


Window.opener()
-----------
+ Window.open()으로 원도우 객체가 생성될 때 자바스크립트는 window.opener 프로퍼티에 윈도우를 연 객체(부모)를 저장
+ 이를 이용하면 자식 창에서 부모 창을 컨트롤하거나 서로간 데이터를 주고받는게 가능


Window.close()
---------
+ Window 창을 닫음
+ Window객체의 close()메서드와 Document 객체의 close()를 구분하기 위해 명시적으로 window식별자를 사용
  이벤트 핸들러에서 close()메서드를 호출할 때 중요

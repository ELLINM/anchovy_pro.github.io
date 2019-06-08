Servlet(서블릿)
============
+ Servlet is..
  웹프로그래밍에서 클라이언트의 요청을 처리하고 그 결과를 다시 클라이언트에게 
  전송하는 Servlet 클래스의 구현 규칙을 지킨 자바 프로그래밍 기술

> Servlet이란 Java를 사용하여 웹을 만들기 위해 필요한 기술
  클라이언트가 어떠한 요청을 하면 그에 대한 결과를 다시 전송필요 -> 해당 역할을 하는 Java 프로그램 
  
+ Servlet은 Java로 구현 된 CGI

![Servlet](https://t1.daumcdn.net/cfile/tistory/21142C39562743FD2C)


+ Servlet 기본 구조
  Servlet으로 변환되기 위해서는 기본적으로 다음의 구조를 만족
  Tomcat에서 만들어 놓은 HttpServlet 클래스를 상속
  HTTP 요청 메서드인 Get방식과 Post방식을 처리하기 위해 doGet()과 doPost()를 오버라이딩
  매개변수로는 HttpServletReqeust, HttpServletResponse 클래스를 정의

> Servlet 작성 순서
  Project Folfer 생성
  -> Java Resources 폴더 우클릭 
  -> new -> Servlet
  -> 클래스 이름 작성
  

Servlet 특징
------------
+ 클라이언트의 요청에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
  html을 사용하여 요청에 응답, Java Thread를 이용하여 동작, MVC 패턴에서 Controller로 이용,
  HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속 UDP보다 속도가 느림,
  HTML 변경 시 Servlet을 재컴파일해야 하는 단점, 일반적으로 웹서버는 정적인 페이지만을 제공,
  
+ 동적인 페이지를 제공하기 위해서 웹서버는 다른 곳에 도움을 요청하여 동적인 페이지를 작성 ->
  동적인 페이지로는 임의의 이미지만을 보여주는 페이지와 같이 사용자가 요청한 시점에 페이지를 생성해서 전달해 주는 것 ->
  여기서 웹서버가 동적인 페이지를 제공할 수 있도록 도와주는 어플리케이션이 Servlet, 동적인 페이지를 생성하는 어플리케이션이 CGI


Servlet 동작 방식
--------------
+ 사용자(클라이언트)가 URL을 클릭하면 HTTP Request를 Servlet Conatiner로 전송 ->
  HTTP Request를 전송받은 Servlet Container는 HttpServletRequest, HttpServletResponse 두 객체를 생성 ->
  web.xml은 사용자가 요청한 URL을 분석하여 어느 서블릿에 대해 요청을 한 것인지 검색 ->
  해당 서블릿에서 service메소드를 호출한 후 클리아언트의 POST, GET여부에 따라 doGet() 또는 doPost()를 호출 ->
  doGet() or doPost() 메소드는 동적 페이지를 생성한 후 HttpServletResponse객체에 응답 ->
  응답이 끝나면 HttpServletRequest, HttpServletResponse 두 객체를 소멸 ->


+ CGI(Common Gateway Interface)
  CGI는 특별한 라이브러리나 도구를 의미(X) -> 별도로 제작된 웹서버와 프로그램간의 교환방식
  CGI방식은 어떠한 프로그래밍언어로도 구현 가능 
  별도로 만들어 놓은 프로그램에 HTML의 Get or Post 방법으로 클라이언트의 데이터를 환경변수로 전달
  프로그램의 표준 출력 결과를 클라이언트에게 전송하는 것

> 자바 어플리케이션 코딩을 하듯 웹 브라우저용 출력 화면을 만드는 방법


+ HTTP 프로토콜을 이용한 서버와 클라이언트의 통신 과정
  클라이언트는 정보를 얻기 위해 서버로 HTTP 요청 메세지+매개변수를 전송 ->
  서버는 이를 해석하여 정적 자원에 대한 요청일 경우 자원을 반환 ->
  그렇지 않은 경우 CGI 프로그램을 실행시켜 해당 결과를 리턴
  이때 서버는 CGI 프로그램에게 클라이언트의 요청과 매개변수를 전달하고 결과를 전달받기 위한 파이프라인을 연결 ->
  그래서 CGI 프로그램은 입력에 대한 서비스를 수행 -> 
  결과를 클라이언트에게 전달하기 위해 결과 페이지에 해당하는 MIME 타입의 컨텐츠데이터를 웹 서버와 연결된 파이프라인에 출력하여 서버에 전달 ->
  서버는 파이프라인을 통해 CGI 프로그램에서 출력한 결과 페이지의 데이터를 읽어, HTTP 응답헤더를 생성하여 데이터를 함께 반환


Servlet Container
----------------
+ Servlet을 관리해주는 Container
  Servlet을 만들었다고 해서 스스로 작동하는 것(X) -> Servlet을 관리해주는 것이 필요
  Servlet Container는 클라이언트의 요청을 받아주고 응답할 수 있게, 웹서버와 소켓을 만들어 통신 
  대표적인 예로 Tomcat이 존재 - 실제로 웹서버와 통신하여 JSP(자바 서버 페이지)와 Servlet이 작동하는 환경을 제공


+ Tomcat과 web.xml
  Tomcat은 Servlet Container, Servlet Engine으로써 Servlet을 실행하여 동작
  웹 프로젝트 폴더를 생성할 때 같이 생성한 web.xml 파일에는 URL을 요청했을 때 어떤 Servlet 파일을 실행시킬 것인지를 매핑해놓은 파일
  Tomcat은 web.xml에 매핑되어진 Java 파일을 Servlet으로 변환시키고, 그 Servlet을 실행하여 요청에 응답
  

Servlet Container 역할
--------------
+ 웹서버와의 통신 지원
  서블릿 컨테이너는 서블릿과 웹서버가 손쉽게 통신할 수 있게 해줌 : 
  일반적으로 소켓을 만들고 listen, accept 등을 해야하지만 Servlet Container는 이러한 기능을 API로 제공하여 복잡한 과정을 생략
  -> 개발자가 서블릿에 구현해야 할 비지니스 로직에 대해서만 초점 둘 수 있음


Servlet Life Cycle Manage
--------------
+ Servlet Container는 Servlet의 탄생과 죽음을 관리
  Servlet Class를 로딩하여 인스턴스화 -> 초기화 메소드를 호출 -> 요청이 들어오면 적절한 서블릿 메소드를 호출 
  Servlet이 생명을 다 한 순간에는 적절하게 Garbage Collection을 진행 편의를 제공


Multithread 지원 및 관리
----------
+ Servlet Container는 요청이 올 때 마다 새로운 Java Thread를 하나 생성 HTTP 서비스 메소드를 
  실행하고 나면, 쓰레드는 자동으로 죽음 -> 쓰레드를 관리해야 하지만 서버가 다중 쓰레드를 생성 및 운영
  
  
선언적인 보안 관리 
----------
+ Servlet Container를 사용하면 개발자는 보안에 관련된 내용을 Servlet 또는 Java Class에 구현하지 않아도 됨
  일반적으로 보안관리는 XML 배포 서술자에 다가 기록 -> 보안에 대해 수정할 일이 생겨도 Java 소스 코드를 
  수정하여 다시 컴파일 하지 않아도 보안관리가 가능


Servlet Life Cycle
------
+ 클라이언트의 요청이 들어오면 컨테이너는 해당 서블릿이 메모리에 있는지 확인
  -> 없을 경우 init()메소드를 호출하여 적재
  -> init()메소드는 처음 한번만 실행되기 때문에, 서블릿의 쓰레드에서 공통적으로 사용해야하는 것이 있다면 오버라이딩하여 구현
  -> 실행 중 서블릿이 변경될 경우, 기존 서블릿을 파괴하고 init()을 통해 새로운 내용을 다시 메모리에 적재
  -> init()이 호출된 후 클라이언트의 요청에 따라서 service()메소드를 통해 요청에 대한 응답이 doGet()가 doPost()로 분기
  -> 서블릿 컨테이너가 클라이언트의 요청이 오면 가장 먼저 처리하는 과정으로 생성된 HttpServletRequest, HttpServletResponse에 
     의해 request와 response객체가 제공
  -> Container가 Servlet에 종료 요청을 하면 destroy()메소드가 호출 : 한번만 실행 
     종료시에 처리해야하는 작업들은 destroy()메소드를 오버라이딩하여 구현


JSP(Java Server Page)
==============
+ Java Code가 들어가 있는 HTML Code
  Servlet은 Saurce Code드 속에 HTML Code가 들어가는 형태 
  JSP는 이와 반대로 HTML Saurce Code 속에 Java Saurce Code가 들어가는 구조를 갖는 웹어플리케이션 프로그래밍 기술
  
+ HTML속에서 JavaCode 
  <pre><% Saurce Code %> 또는 <%= Saurce Code =%></pre>
  Java Saurce Code로 작성된 부분은 웹 브라우저로 보내는 것이아니라 웹 서버에서 실행되는 부분
  웹 프로그래머가 소스코드를 수정 할 경우에도 디자인 부분을 제외하고 자바 소스코드만 수정
  -> 효율 증가
  컴파일과 같은 과정을 할 필요없이 JSP페이지를 작성하여웹 서버의 디렉토리에 추가만 하면 사용이 가능
  
> 서블릿 규칙은 꽤나 복집하기 때문에 JSP가 개발 
  JSP는 WAS(Web Application Server)에 의하여 서블릿 클래스로 변환하여 사용


JSP 동작 구조
------------
+ 웹 서버가 사용자로부터 Servlet에 대한 요청
  -> Servlet에 그 요청을 전송 -> 요청을 받은 Container는 HTTP Request와 HTTP Response 객체를 생성
  -> Servlet doPost()나 doGet()메소드 중 하나를 호출
  -> Servlet은 데이터의 입력, 수정 등에 대한 제어를 JSP에게 넘겨서 프레젠테이션 로직을 수행
  -> Container에 Response를 전달 
  
> 사용자가 해당 페이지를 요청하면 컴파일이 되어 자바파일을 통해 .class 파일이 생성
  -> 두 로직이 결합되어 클래스화 되는것을 확인 out객체의 println 메소드를 사용해서 구현해야하는 번거로움을 JSP가 대신 수행

> Servlet만 사용하여 사용자가 요청한 웹 페이지를 보여주려면 out 객체의 println 메소드를 사용하여 HTML 문서를 작성 해야함
  추가/수정을 어렵게 하고, 가독성도 떨어지기 때문에 JSP를 사용하여 비지니스 로직과 프레젠테이션 로직을 분리
  

Request / Response
---------------
+ doGet(), doPost() 메서드는 HTTP 요청을 처리하는 메서드
  그리고 각 메서드는 HttpServletRequest , HttpServletResponse 두 객체를 파라미터로 명시
  이 두 객체는 Tomcat에서 미리 작성해둔 Class이며, HTTP 요청과 응답에 대한 정보들을 모두 보유


+ request
  클라이언트가 요청할 때 함께 전송한 데이터들이 있습니다.
  예를 들어, URL 파라미터, form에서 전송한 데이터들이 있습니다.

+ response
  서버에서 클라이언트로 응답 할 때 필요한 데이터들이 있습니다.
  예를 들어, 응답 결과 상태 코드, 클라이언트가 요청한 HTML 문서 같은 것들이 있습니다.
  이 두 객체가 하는 일은 앞으로도 계속 나오게 되므로 API는 그 때 그 때 확인하도록 하겠습니다.


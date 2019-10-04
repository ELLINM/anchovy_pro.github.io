Make Server
=====
+ Digital Ocean 에서 서버를 생성
+ windows이기 때문에 putty를 다운받아 사용

Floating IP를 해야하는가?
일단은 강의처럼 항목이 나오지 않아 그대로 진행 해도 될것이라고 생각

putty를 사용해서 ip주소로 로그인하면 Terminal처럼 아이피주소 말고 root만 입력하면 로그인됨
비번은 메일 온것으로 하고 이후에 비번 재설정

웹 서버의 설정
-----
+ 웹 서버 구성을 처음 사용하는 경우 Apache를 설치
  Apache는 웹 페이지 방문자가 서버에 연결하고 웹 페이지 컨텐츠를 다운로드 할 수있는 HTTP 서버
  사이트에 액세스 할 때 브라우저를 통해 Apache 설치를 시작하기 위해 페이지를 본질적으로 다운로드하고 있음
  
+ 로컬 패키지 인덱스를 업데이트, 패키지 인덱스는 서버를 시작하자마자 업데이트 할 수있는 파일의 인덱스
  명령 유형을 Apt에서 실행
  apt update 입력 -> apt install apache2
  Apache 2가 설치되었으며 웹 브라우저에서 기본 Apache 페이지를 가져 와서 테스트 -> IP주소를 입력하면 Apache Default Page가 나옴
  
MySql 설정
------
+ sudo apt install mysql-server 입력
  루트 계정에 로그인 한 경우 sudo를 입력 할 필요는 없지만 약간의 시간을 절약하기 위해 명령 행을 복사하여 입력
  

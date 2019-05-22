Session
-----------
+ 인스턴스안에 있는 논리적인 실체로 현재 유저의 로그인 상태
  Shared Server mode 일때는 여러 개의 세션이 하나의 커넥션에 붙어있을 수도 있음
+ 연결이 인증된 상태


Connetion
-------------
+ 연결(커넥션)은 클라이언트 프로세스와 데이터베이스 인스턴스 간의 물리적 경로
  클라이언트와 인스턴스 간의 네트워크 커넥션
  
  
SQL&SQLPLUS
----------------
+ SQL : 축약이 불가능, ';'으로 끝나야함
> 명령어 : DQL, DML, DDL(alter), DCL, TCL
  delete와 drop ->  휴지통과 완전 삭제같은 차이
  
+SQLPLUS : 축약가능 ex) show -> sho, edit -> ed, ';'로 마무리할 필요없음

NGINX
====
+ Digital Ocean에서 nginx3라는 이름으로 프로젝트 생성
+ 목적은 교육용으로 설정 할것
+ Disribution의 Ubuntu에서 18.041.x64 설정 LTE버전
+ 나머지는 지난번 설정과 같이
+ hostname은 projectname과 같이


Floating IP
-----
+ Network로 이동 FloatingIPs
+ nginx를 클릭하고 Floating IP를 클릭하면 됨


Virtual Server
-----
+ Project 클릭 -> Name을 클릭 -> Access클릭 -> launch 클릭
+ email로 받은 유저 정보로 로그인
+ terminal로 하고 싶다면 IP를 카피하여 명령어 입력
+ ssh root@IPADDR
+ 로그인 유저 정보 입력


Install&Configure NGINX
-----
+ apt update
+ apt install nginx
+ IP를 이용해 접속할 수 있음


Install&Configure MySQL on NGINX
------
+ terminal에 apt install mysql-server-5.7입력
+ mysql_secure_installation
+ 처음 옵션 선택에서 비밀 번호 관련 요청이 나오는데 나중에 설치해야할 plugin에 방해가 되므로 no
+ anonymous users는 삭제




Jenkins
======
+ Pipeline을 사용해 거의 모든 언어의 조합과 SourceCode Repository에 대한 지속적인 통합과 지속적인 전달 환경을 구축하기 위한 간단한 방법을 제공
+ Jenkins는 다른 일상적인 개발 작업을 자동화
+ 각각의 단계에 대한 스크립트 작성의 필요성을 없애주지는 않지만, 사용자가 쉽게 구축할 수 있는 것보다    
  더 빠르고 더 강력하게 빌드(Build), 테스트, 그리고 배포(deployment) 도구 등 체인 전체를 통합할 수 있는 방법을 제공


Jenkins 자동화
-----
+ Jenkins는 온갖 종류의 개발 작업을 지원하기 위한 약 1,400가지의 Plugin을 가지고 있는 선두적인 OpenSource 자동화 Server 
+ 지속적인 통합과 지속적인 Java Code 전달, 즉 프로젝트 빌드, 테스트 실행, 정적 코드 분석 시행, 
  그리고 배포 작업은 사람들이 젠킨스를 사용해 자동화하고 있는 여러 가지 프로세스들 가운데 한가지
+ 1,400개의 Plugin은 5가지 영역을 포괄(플랫폼, UI, 관리, 소스코드 관리, 그리고 가장 많이 사용되는 빌드 관리)


Jenkins 동작 방식
------
+ 주요 운영체제용 Java8 WAR Acrhive와 설치 pakage, Homebrew pakage, Docker image, Source Code 형태로 사용
+ Source Code는 대부분 Java이며, 몇 개의 Groovy, Ruby, 그리고 ANTLR(Another Tool For Language Recognition) 파일이 들어 있음
+ WAR를 단독으로 또는 Tomcat 같은 Java Application Server에서 Serverlet으로 실행
+ 둘 가운데 어느 경우든, 웹 사용자 인터페이스(UI)를 생성하며 REST API에 대한 호출을 받아들임


Jenkins 설치
-------
1. 아래의 명령어를 실행하여 jenkins repository를 설정파일을 생성    
   -> wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
2. 그 다음 아래 명령어를 입력하여 key를 import
   -> rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
3. 젠킨스를 설치
    -> yum install jenkins
4. 기본 포트가 8080 포트이기 때문에 포트를 변경
   ->vi /etc/sysconfig/jenkins
5. 지정한 포트의 방화벽을 오픈
   -> $ firewall-cmd --permanent --add-port=변경한포트/tcp 
   -> $ firewall-cmd --reload
6. 서비스를 부팅시 가능하게 하고, 시작
   -> $ systemctl enable jenkins 
   -> $ systemctl start jenkins
7. 이제 jenkins 를 웹브라우저를 통해 접속
   -> http://서버아이피:지정한포트
8. 관리자 비밀번호를 확인
   -> /var/lib/jenkins/secrets/initialAdminPassword
   
   

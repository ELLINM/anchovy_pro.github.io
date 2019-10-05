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
  설치가 완료되면 mysql 이중 설치를 보호
  데이터베이스에 대한 보안 위험이 될 수있는 위험한 기본 설정을 제거
  
+ sudo mysql_secure_installation 입력
  + 첫 번째는 validate password 플러그인을 사용할 것인지 묻는 것 : 
    + 기본적으로 비밀번호 보안을 강화하는 데 사용
    + 암호를 설정하려고 할 때마다 암호의 특정 형식을 보안 형식으로 유지
    + mysql에 익숙하지 않으면 이것을 사용하는 것이 어려울 수 있음
    + WordPress와 같은 플러그인을 사용하거나 PHP를 설치하는 경우 특정 플러그인과 충돌 가능성이 있음
    + 강의에서는 no를 입력하고 진행
    
  + no를 입력한 후에 비밀번호 입력
    + 기본적으로 login없이 mysql을 이용할 수 있음
    + 이것은 테스트 용이며 설치를 좀 더 부드럽게하기위한 것
    + 프로덕션 환경으로 이동하기 전에 제거해야한다는 것을 제거
    + anonymous user를 제거하려면 yes를 선택
  
  
  + 라우트 로그를 원격으로 허용하지 않고 로컬 호스트 만 루트로 로그인하도록 허용
    + 보안에 대한 좋은 습관
    + 예를 선택하면 경로 로그인 허용 안 함을 선택하여 원격 사용자가 경로로 로그인 할 수 없음
  
  
  기본적으로 test database가 주어 지지만 테스트용이기 때문에 필요 없음 yes선택
  
  
  권한 테이블을 다시로드하는 것이므로 방금 변경 한 모든 내용이 즉시 적용 -> yes 선택
  
  
  마지막 항목은 mysql이 루트 사용자를 인증하는 데 사용하는 인증 방법을 변경하는 것
    + 기본 인증 방법은 추가 보안을 제공
    + PHP와 같이 나중에 설치해야하는 다른 도구와 충돌 -> 따라서 인증 방법을 밑줄 소켓에서 mysql로 전환
  
  
  sudo mysql 입력
    + mysql 사용자 계정이 인증을 위해 어떤 인증 방법을 사용하여 해당 유형을 수행하는지 확인
      + SELECT user, authentication_string,plugin,host FROM mysql.user;
        + 표시된 표는 루트 사용자가 실제로 auth 소켓에 연결하여이를 변경했음을 확인
        
    + localhost에서 라우트 인증 방법을 변경
      + ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
      
    + 비밀번호를 재설정 했지만 ERROR 1819 (HY000): Your password does not satisfy the current policy requirements
      Error 발생 -> SHOW VARIABLES LIKE 'validate_password%' 입력 비밀번호 규칙을 확인하기
       + validate_password_check_user_name은 패스워드에 user id가 들어갔는지 확인   
         -> 아이디와 패스워드가 모두 root인데 만약 on이 켜져있다면 이는 불가능   
         length는 길이 -> 8자 이상이어야 가능    
         mixed case count는 대소문자를 적어도 1회이상 사용    
         number count도 숫자를 적어도 1회 이상 사용     
         special char count는 특수문자를 적어도 1회 이상 사용     
       
       + policy정책 -> medium     
         medium은 위의 정책들이 활성화     
         정책을 끄고싶다면 이 파라메터가 low -> low로 해도 자릿수는 지켜야함     
         
       + 정책 변경 방법 SET GLOBAL validate_password_policy=LOW; <- MEDIUM     
         길이 변경 SET GLOBAL validate_password_length = <원하는 길이>;     
         
     + flush privileges 명령을 실행 -> 서버가 grant 테이블을 다시로드하고 새 변경 사항을 적용하도록 지시
       + SELECT user, authentication_string,plugin,host FROM mysql.user; 입력하면 root user의 정보가 바뀐걸 확인     
         라우트 사용자가 이제 mysql 기본 비밀번호로 인증하고 더 이상 작성자 소켓 플러그인으로 인증하지 않음을 확인    
            
    

PHP
=====
+ 웹을 제공 할 수있는 프로그래밍 언어
+ 동적이고 사용자와 상호 작용


+ mysql을 exit함

PHP 설치
------
+ PHP를 install 하기 위해 sudo apt install php libapache2-mod-php php-mysql 입력
  + 설치가 완료 되면 Apache Server를 재시작 함 -> sudo systemctl restart apache2
  
+ info.PHP라는 파일을 만들어 기본 HTML 디렉토리에 배치   
  생성 될 파일은 PHP 설정에 관한 데이터를 표시하는 기본 스크립트를 포함
  + sudo nano /var/www/html/info.php
    + nano는 텍스트 편집기로 Apache가 웹 컨텐츠를 제공하는 기본 디렉토리 HTML 디렉토리를 사용   
      여러 도메인에 대한 가상 호스트를 만들면 변경되지만 현재는 기본 디렉토리이고 info.php는 파일
      
      
+ PHP 코드 입력
  ~~~
  <?php
  phpinfo();
  ?>
  ~~~  
  + 명령은 여기 PHPinfo -> 웹 브라우저에서이 페이지를로드 할 때 서버에 PHP에 대한 정보가 표시
  + 저장 : Ctrl+x
  
+ 이렇게 하고 IP주소에 /info.php를 입력하면 PHP 버전과 PHP 구성에 대한 다른 많은 정보가 나옴   
  -> 정보 유출을 막기 위해 프로덕션 서버에서는 삭제 -> sudo rm /var/www/html/info.php 삭제 완료
  
+ 관리자로 PHP를 설치 -> PHP myadmin은 mysql 데이터베이스와 상호 작용하는 그래픽 사용자 인터페이스를 통해 사용하는 도구
  + phpMyAdmin - 웹 기반 GUI를 통한 데이터베이스 관리에 사용, 데이터베이스 관리보다 훨씬 쉬운 데이터베이스 관리 가능
  
+ PHPMyAdmin을 설치하기 전에 이전과 마찬가지로 패키지 색인을 업데이트   
  메이저를 설치하기 전에 update 명령을 실행하는 것이 좋음
  + apt update 다음 phpmyadmin command 작성
  + sudo apt install phpmyadmin php-mbstring php-gettext -> phpmyadmin 화면으로 전환 -> apache2 선택   
    고급 데이터베이스 관리자가 구성을 수동으로 수행하려는 경우 또는 데이터베이스가 이미있는 경우 설치 및 구성 되었으면 옵션을 거부   
    우리는 그렇지 않으므로 yes -> MySQL비번 입력
    
+ 설치 과정에서 화면에 표시되는 다음 디렉토리에 phpmyadmin 구성 파일이 자동으로 추가되므로 MBstring php 확장자를 활성화
  + sudo phpenmod mbstring -> 변경사항 확인을 위해 재시작 -> sudo systemctl restart apache2
  + IP주소 다음 /phpmyadmin 입력하면 로그인 화면으로 전송 -> root로 로그인




    

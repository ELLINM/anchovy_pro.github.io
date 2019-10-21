CentOS 톰캣 설치및 설정, 파일질라 설치 및 배포
=======
1. yum install tomcat
  + 다운로드(자바 OPENJDK 설치를 위해)
2. yum install wget
  + get 을 통해 tar 파일 다운로드
3. wget을 통해 다운 로드
  + cd /tmp/lib    
    wget http://archive.apache.org/dist/tomcat/tomcat-8/v8.5.27/bin/apache-tomcat-8.5.27.tar.gz
4. 압축 해제
  + tar xvfz apache-tomcat-8.5.27.tar.gz
5. 공용 폴더 이동
  + mv apache-tomcat-8.5.27/ /usr/local
    cd /usr/local
6. 방화벽 설정
  + firewall-cmd --permanent --zone=public --add-port=8080/tcp 또는 설정을 위해 8888이나 다른 포트를 연다    
    firewall-cmd --reload
7. config 안에 server.xml 설정 변경
8. 파일질라 설치 및 연결 (포트 22)
  + yum -y install epel-release   
    yum -y install filezilla
9. 파일질라를 통해 파일 이동및 webapps으로 배포


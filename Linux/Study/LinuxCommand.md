Shell
======
+ 운영체제 커널과 사용자 사이를 이어주는 역할
+ 사용자의 명령을 해석하고, 커널에 명령을 요청해주는 역할


Unix/Linux Shell 종류
------
+ Bourne-Again Shell (bash) : GNU 프로젝트의 일환으로 개발, Linux 거의 디폴트
+ Bourne Shell (sh)
+ C Shell (csh)
+ Korn Shell (ksh) : Unix에서 가장 많이 사용됨


Linux 기본 명령어
------
+ Linux 명령어는 결국 Shell이 제공하는 명령어
+ Linux 기본 Shell이 bash 이므로, bash에서 제공하는 기본 명령어를 배우는 것


Command
-----
+ whoami : 로그인한 사용자 ID를 알려줌
<pre># whoami
  root</pre>
+ passwd : 로그인한 사용자 ID의 암호 변경
<pre># passwd
Enter new UNIX password:
Retype new UNIX password:
passwd: password updated successfully</pre>
+ pwd : 현재 디렉토리 위치
<pre># pwd
/</pre>
+ cd : 디렉토리 이동
<pre># pwd
/etc
# cd ~
# pwd
/root
# cd -
# pwd
/etc</pre>
+ ls : 파일 목록 출력
<pre># ls -al
total 32
drwxr-xr-x 4 root root 4096 Oct  3 09:51 .
drwxr-xr-x 1 root root 4096 Oct  4 03:52 ..
drwxr-xr-x 2 root root 4096 Oct  3 09:47 conf.d
-rwxr-xr-x 1 root root  120 Jul 19 19:28 debian-start
-rw------- 1 root root  317 Oct  3 09:47 debian.cnf
lrwxrwxrwx 1 root root   24 Oct  3 09:47 my.cnf -> /etc/alternatives/my.cnf
-rw-r--r-- 1 root root  839 Jan 21  2017 my.cnf.fallback
-rw-r--r-- 1 root root  682 Feb  3  2017 mysql.cnf
drwxr-xr-x 2 root root 4096 Oct  3 12:47 mysql.conf.d</pre>
+ 와일드 카드
  + * 는 임의 문자열
  + ? 는 문자 하나
<pre># ls debi* -al
+ -rwxr-xr-x 1 root root 120 Jul 19 19:28 debian-start
-rw------- 1 root root 317 Oct  3 09:47 debian.cnf</pre>
+ cat : 파일 보기
<pre># cat mysql.cnf
mysql.cnf 파일 내용이 출력됨</pre>
+ head/tail : head 는 파일 시작부분, tail 은 끝 부분을 보여줌
<pre># head mysql.cnf
mysql.cnf 파일 앞부분만 출력됨 (기본적으로 출력 라인 수가 10으로 정해져 있음)
# tail mysql.cnf
mysql.cnf 파일 뒷부분만 출력됨 (기본적으로 출력 라인 수가 10으로 정해져 있음)</pre>
+ more : 파일 보기 (화면이 넘어갈 경우, 화면이 넘어가기 전까지 보여줌)
<pre># more mysql.cnf
mysql.cnf 파일 내용이 출력됨</pre>
+ rm : 파일 및 폴더 삭제
  + 주로 사용하는 명령어 형태: rm -rf
  + r 옵션: 하위 디렉토리를 포함한 모든 파일 삭제
  + f 옵션: 강제로 파일이나 디렉토리 삭제
+ man : manual이라는 의미. man rm을 입력하면 메뉴얼이 나옴



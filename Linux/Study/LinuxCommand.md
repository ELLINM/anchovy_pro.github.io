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
+ su - user1 : user 변경
<pre># su - user</pre>
+ clear : 내용 지우기
<pre># clear</pre>
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
  + -a, -al, -ar 세가지 사용가능
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
+ cat : 단순히 파일의 내용을 출력할 수도 있고, 파일 여러개를 합쳐서 하나의 파일로 만들 수도 있음
  그리고 기존 한 파일의 내용을 다른 파일에 덧붙일수도 있음, 새로운 파일을 만들때에도 사용
<pre>
$ ls
file1  file2  file3

$ cat file1
1

$ cat file2
2

$ cat file3
3

$ cat file1 file2 > file1_2
$ ls
file1  file1_2  file2  file3

$ cat file1_2
1
2

$ cat file1 >> file2
$ cat file2
2
1

$ cat > file4
hello
world
(작성이 끝나면 ctrl +d 로 파일 저장)

$ cat file4
hello
world</pre>
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
+ --help : 도움말 내가 무엇을 섞어 쓸수 있는지 확인
+ man command : command에 대한 설명을 볼 수 있음 
+ mkdir : directory생성
+ .. : 현재 위치한 폴더의 상위 폴더로 이동
+ touch : 파일 생성
+ vi : 파일 수정
+ esc -> shift+z+z : 저장 후 종료
+ mv 파일명 바꿀파일명 : 파일이름 또는 장소 변경
+ find 위치 조건 : 파일 검색
+ ip addr : IP 
+ 컴퓨터 사용자 리스트 호출
  + cat /etc/passwd
  + cut -f1 -d: /etc/passwd
+ 컴퓨터 이름 호출
  + hostname
  + cat /etc/hostname
+ arguments 다시 사용하기 (잘 활용하면 오타를 통해서 실수할 일이 안생김) :뱅 딸러(!$)
+ 네트워크 설정 파일 보기 : cat /etc/sysconfig/network-scripts/ifcfg-enp0s3
+ 해당 아규먼트 활용 : VI !$
+ 인터넷 되는가 : ping 8.8.8.8
+ 화면 지우기 : clear, 단축키 CTRL + L
+ 아이피 확인 : ip addr
+ 아이피만 나오게 하기 : hostname -i
+ yum update -y => 기존 설치 패키지 업그레이드
+ 버전정보 확인하기
  + cat /etc/*-release | uniq
  + cat /etc/*-release
+ sudo => 관리자 권한으로 명령하기(윈도우에서 ulc)
  + # sudo yum update -y
  + # sudo reboot
+ history => 썼던 명령어 전부 보여주기
+ tail => 끝에서 10줄 봄 : tail /var/log/yum.log
+ 용량 확인
  + df
  + df -h : 더 깔끔하게 나옴
+ 다른 컴퓨터 붙는거 (ssh 클라이언트, 윈도우엔 없다 window10에선 내장)
  + ssh root@10.0.2.5
  + ssh 10.0.2.5 -l adminuser -p 22
  + ssh 10.0.2.5
+ 접속 계정 바꾸가 : su [계정이름]
+ 매뉴얼 (ex)
  + man uname | grep \\-n
  + man uname | grep \\-r
  + man hostname | grep || -I
  + man hostname | grep || -i
+ restart 서비스 : 대신 재시작이니까 붙어있는것들 다 죽음
  + systemctl restart network
+ 서비스 검색 해보기 (서비스명 찾기) : systemctl list-unit-files | grep ssh
+ su => 유저변경
  + su root => 루트 계정으로 바꾸기
  + su adminuser => 또 바꾸기
  + su => 안넣어주면 default가 root다 
+ su - => 아예 다시 로그인 하기,
  + su - root
  + su - adminroot
+ whoami => 접속 유저확인
+ su - root :보통 user 계정으로 들어와서 보기만하다 su 를 통해 root 계정으로 접근하여 작업을 많이 함.(보안상)
+ 이전 경로 cd -
+ 홈 경로 cd ~
+ 루트 경로 cd /
+ grep : 글자를 찾고 그행 전체 반환
+ 히스토리를 파일로 저장하기
  + history > mycommand.list
  + vi 편집기 명령어
    + shift ZZ => 저장하고 빠져나가기
    + dd => 한줄 지우기
    + i => 입력하기
    + esc => 나가기
    + esc : w => 현재파일명으로 저장(종료는 하지 않음)
    + esc : wq => 저장후 종료
    + vi 에서 !는 강제로 수행
+ who : 지금 내 머신에 누가 접속해있냐
+ whoami : 현재 어떤 사용자냐
+ who am i : 최초로 로그인 한 사용자
+ ps : 현재 자신 세션에서만 실행한 프로세스
+ ps a : 자신의 id로 접속한 모든 터미널에서 실행중인 모든 프로세스
+ ps aux : 현재 시스템에 로그온한 모든 사용자가 실행한 전체 프로시스
+ $는 Bash를 이용하는 "일반 사용자"
+ #은 "root"
+ sudo root
+ cat /etc/group | grep wheel
  + 위와 같이 하면 휠 그룹 정보를 알고 싶다. 관리자 계정인지를 알 수 있음 (ex 다음과 같이해도, id adminuser)
+ ~의 의미
  + 로그인한 유저의 홈 디렉토리 : 그 유저만의 공간, 다른유저 사용 불가     
    root에서 ls-l ~adminuser를 치면 adminuser계정의 홈 디렉토리를 볼 수 있음
+ pwd : present working directory, print working directory, 현재디렉토리
+ !yum 
  + => 이전명령어의 yum으로 시작하는것, !p => 이전명령어의 p로 시작하는것 !을 통해 짧게 명령어 사용
+ ls -al
  + ls -l /tmp
  + man ls | grep \\-l
+ ; 세미콜론으로 명령어 구분 가능
  + 세미콜론 : two thoughts bc, 즉 다르다. 구분한다.
    + ex : who;date;ifconfig
+ 파일에 대한 권한이 있음
  + touch ismi.file
  + ls -l imsi.file
  + 소유자, 그룹, 그 외 모든것
    + -rw-r--r--.  1 root root 0
+ passwd 로그인한 사용자가 자신의 계정 비번 재설정, 또는 관리자가 다른 계정에 대해 암호 재설정
  + passwd
  + passwd adinuser
  + passwd imsiuser
+ who --help
+ Terminal 종료하기 : Ctrl + d, exit
+ System 종료하기 : shutdown [옵션] [시간] [메시지]
  + 옵션들
    +  -k : 실제로 시스템 종료하지 않고 사용자들한테 메시지만 전다.
    + -r : 종료 후 재시작
    + -h : 종료하고 halt 상태로 이동
    + -f : 빠른재시작으로 이 과정에서 fsck를 생략할 수도 있다
    + -c : 이전에 내렸던 shutdown 명령을 취소
  + 시간 : 종료할 시간 (hh:mm, +m, now)
    + 메시지 : 모든 사용자에게 보낼 메시지
    + 지금당장 시스템 종료하기 : shutdown -h now
    + 지금당장 시스템 재부팅하기 : shutdown -r now
    + 10분 후에 종료하기 : shutdown -h + 10
+ systemd, systemctl
  + systemd 명령어 사용하기
  + systemctl 명령어를 통해 systemd를 제어한다.
  + systemctl start httpd : 시작
  + systemctl enable httpd : 재부팅후에도 시작할 필요없이 됨
  + systemctl list-unit-unit-files | grep enabled
+ 다른 pc에서 접속 하려고 해보면 안됨 그럼 firewall꺼주자 (d 끝에붙임 d는 데몬을 뜻함)
  + systemctl stop firewalld
+ 꺼졌나 확인하는 다음 명령어 둘다 외우자
  + systemctl is-active firewalld
  + systemctl status firewalld
+ 서비스 명들 찾기 어려우니까 다음과 같이 찾자
  + systemctl list-unit-file | grep 서비스명 시스템 시작시 오류난 것만 확인 systemctl --failed
+ /var/log/yum.log : 설치 된 파일들 로그 볼 수 있음
+ ls 는 교재
  + ls -lt 시간순
  + ls -ltr 시간 역순
  + ls -la 전체 숨김파일까지
  + ls -lF 파일종류 표시
  + ls -ld (##pwd의 정보)
  + 컴파일시 수정시간에따라 안될 경우 touch로 수정시간 변경 하여 사용하기도 함.
    + -r : recurse 하위
    + -R : reverser 거꾸로 역순으로
+ 디렉토리 만들기 mkdir
  + ex)mkdir /lab
    mkdir /lab/data/movies
+ 안만들어짐 이때 p를 써서 없는경우 부모부터 만들기 옵션 가능 : mkdir -p /lab/data/movies
+ cat(concaternate) : 여러 파일 연결하다, 파일 내용 연속 출력하기 파일들 연결 가능
  + cat /etc/hosts /etc/hostname
+ 파일 편집하기
  1. vi yslee.list
  2. (첨가하기) cat > yslee.list -> ctrl D(저장하기)
+ 화면단위로 파일 내용 출력 : more
  + 이전 화면으로 이동 : ctrl + b
  + 다음 화면으로 이동 : ctrl + f
+ 개선된 화면단위 파일 출력 : less
  + 한줄씩 이동 j, 인줄씩 이전행 k, 화살표사용
  + find . -name "*.txt" |
  + find . -name "*.txt" | xargs touch
+ 새로 사용자 생성
  + useradd 유저명
  + CentOS 등 레드햇 계열에서는 아무 옵션을 주지 않아도 홈 디렉토리 생성되고 쉘 환경이 설정됨 
  + .으로 시작하는 파일은 숨김파일
  + 유저를 새로 만들면 /etc/skel/의 파일들을 디폴트로 홈 디렉토리로 가져옴
+ 사용자 계정 수정하기
  + 홈디렉토리를 바꾸고싶을때    
    ex)
    먼저 폴더 생성한다    
    mkdir /home/user3    
    usermod -d /lab/home/user3 user3    
+ 사용자 계정 삭제하기
  + userdel user3
  + userdel -rf user3
+ 권한주기
  + 휠 권한 주기 : usermod -aG wheel user3
  + 결과 확인 : gruops user3
+ -Yum을 이용한 Package 설치하기
  + 저장소
  + -store => 실제 저장소
  + -repository => 목록
  + -save => 메모리상에 돌고 있는걸 디스크로 저장(전원 꺼지면 이거 가지고 복구)
  + -archive => 겨울 옷 압축해서 저장하고 있는 것 같은거
+ yum install epl-release -y
+ yum list avaliable : 설치 가능한 모든 패키지 목록
+ yum list updates
+ yum list installed : 이미 설치된 패키지 목록
rpm -qc nginx
+ package 정보 검색하기
  + yum info bind
  + yum provides bind
+ package 삭제하기  : yum remove bind
+ package 업데이트
  + yum update => 전체
  + yum update bind => 특정 패키지
+ 설치된 package 목록 확인하기
  + yum list installed
  + yum list installed | grep ssh
  + rpm -qa | grep ssh
+ ps -ef | grep ssh (실행중 프로세스 찾기)
+ find / -name samba (원하는 파일 찾기)
+ gui버전 으로 설치 : "Server With GUI"
+ Yum Repository 확인 : yum repolist enabled
+ 파일 Archive
  + Tar(Tape Archive) 명령어 : 다시 시스템과 파일을 주고받거나백업을 하기 위해 여러 개의 파일이나 디렉터리를 하나의 Archive file로 만들거나 
    또는 기존의 Archive에서 파일을 추출하기 위해 사용하는 명령어
    + 파일 Archive 하기
      + tar cvf file.tar dir1
      + C : create
      + V : 처리중인 파일의 이름을 화면에 상세히 출력
      + F : archive 파일을 사용
      + 이걸 가장 많이 사용함 tar cvzf lab.tar.gz /lab
+ Archive 파일 내용 보기 tar tvf lab.tar
+ 원상복구 하기 tar xvzf /lab.tar.gz /tmp


standard stream
=====
+ command 로 실행되는 process 는 세 가지 스트림을 가지고 있음
  + 표준 입력 스트림 (standard input stream)
  + 표준 출력 스트림 (standard output stream)
  + 오류 출력 스트림 (standard error stream)
+ 모든 스트림은 일반적인 plain text로 console 에 출력하도록 되어 있음


표준입력(STDIN)
------
+ STDIN이란 프로그램 안으로 stream data가 들어가는 것, 별도의 리다이렉션이 없으면 키보드를 통해 STDIN을 받음
<pre>$ ls -al</pre>


표준출력(STDOUT)
-----
+ 표준 출력이란 프로그램을 실행시켰을 경우 터미널로 나오는 결과(data)
<pre>$ ls -al
total 32
drwxr-xr-x  19 zion437  staff    646  4 16 20:45 .
drwx------+ 19 zion437  staff    646  4  2 17:52 ..
-rw-r--r--@  1 zion437  staff  10245  9 20  2015 .DS_Store
drwxr-xr-x   6 zion437  staff    204  1 17  2015 Angular
drwxr-xr-x   8 zion437  staff    272  4  6  2015 Cool
drwxr-xr-x  13 zion437  staff    442  1 10 12:07 TS
drwxr-xr-x  16 zion437  staff    544  9 22  2015 editor
drwxr-xr-x  10 zion437  staff    340  3 20 15:12 electron
drwxr-xr-x  25 zion437  staff    850  9 21  2014 jQeury
drwxr-xr-x   6 zion437  staff    204  8  9  2014 layout
drwxr-xr-x   9 zion437  staff    306  5 24  2015 project_moni
drwxr-xr-x   4 zion437  staff    136  9 30  2015 seotory-java
drwxr-xr-x  26 zion437  staff    884  4 16 19:28 seotory.github.com
drwxr-xr-x  13 zion437  staff    442  1 16 17:29 seotoryjs
drwxr-xr-x   7 zion437  staff    238  4 19  2015 skin
drwxr-xr-x  44 zion437  staff   1496  4 12  2015 spring
drwxr-xr-x  12 zion437  staff    408  9 22  2015 tBlog
-rw-r--r--   1 zion437  staff   1094  4 16 20:45 test.txt
drwxr-xr-x   7 zion437  staff    238  4 19  2015 youthgroup</pre>


오류출력 스트림(STDERR)
-------
+ 표준에러란 프로그램이 실행시에 발생하는 에러에 해당
<pre>$ ls -al test.txt test.test
ls: test.test: No such file or directory
-rw-r--r--  1 zion437  staff  53  4 16 21:00 test.txt</pre>



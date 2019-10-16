Redirection
======
+ 스트림 흐름을 바꿔주는 것으로 > 또는 < 을 사용함   
Ex)
<pre>ls > files.txt</pre>
+ ls 로 출력되는 표준 출력 스트림의 방향을 files.txt 로 바꿔줌   
(files.txt 에 ls 로 출력되는 결과가 저장됨)
<pre>head < files.txt</pre>
+ files.txt 의 파일 내용이 head 라는 파일의 처음부터 10 라인까지 출력해주는 명령으로 넣어짐   
(files.txt 의 앞 10 라인이 출력됨)
<pre>head < files.txt > files2.txt</pre>
+ files.txt 의 파일 내용이 head 로 들어가서, files.txt 의 앞 10 라인을 출력   
  head 의 출력 스트림은 다시 files2.txt 로 들어감   
  head 는 files.txt 내용을 출력하지 않고, 해당 출력 내용이 다시 files2.txt 에 저장됨   
  (결과적으로 files.txt 의 앞 10 라인이 files2.txt에 저장됨)
  기존 파일에 추가는 >> 또는 << 사용
<pre>ls >> files.txt</pre>
+ 기존에 있는 files.txt 파일 끝에, ls 출력 결과를 추가해줌


Pipe
=====
+ 두 프로세스 사이에서 한 프로세스의 출력 스트림이 또다른 프로세스의 입력 스트림으로 사용될 때 쓰임
<pre>ls | grep files.txt</pre>
+ ls 명령을 통한 출력 내용이 grep 명령의 입력 스트림으로 들어감   
  grep files.txt 는 grep 명령의 입력 스트림을 검색해서 files.txt 가 들어 있는 입력 내용만 출력해줌   
  따라서, ls 명령으로 해당 디렉토리/파일 중에 files.txt 파일이 있는지를 출력해줌
+ grep : 검색 명령
<pre>grep [-option] [pattern] [file or directory name]</pre>
   
+ option   
|command|contents|    
|----|----|    
| i | 영문의 대소문자를 구별하지 않음 |   
| v | pattern을 포함하지 않는 라인을 출력 |    
| n | 검색 결과의 각 행의 선두에 행 번호를 넣음(first line is 1) |    
| l | 파일명만 출력 |    
| c | 패턴과 일치하는 라인의 개수만 출력 |    
| r | 하위 디렉토리까지 검색 |

+ grep python files.txt -> files.txt 라는 파일에서 python 라는 문구가 들어간 모든 행을 출력
+ grep -n python files.txt -> files.txt 라는 파일에서 python 라는 문구가 들어간 모든 행을 라인까지 출력
+ grep -r python foldername -> foldername 라는 폴더내의 모든 파일 중 python 라는 문구가 들어간 행을 출력
+ grep -i python files.txt -> files.txt 라는 파일에서 python 라는 문구를 대,소문자 구분 없이 검색해서 출력
+ grep -E "go|java|python" files.txt -> files.txt 라는 파일에서 go, java, 또는 python 이 있는 모든 행을 출력


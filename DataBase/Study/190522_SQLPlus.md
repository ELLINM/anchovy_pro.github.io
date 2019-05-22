SQL*Plus
========
+ SQL 문을 대화식으로 실행하기 위해서 사용자가 데이터베이스에 입력하고 SQL 문을 처리하여 그 결과를 받을 수 있도록 만들 툴
+ 한 줄 실행 : 종결문자 불필요 : 연결문자(-) 필요 : 키워드 단축 가능 : 버퍼 저장 안함


SQL*Plus 명령어
---------
+ List : 버퍼에 저장된 SQL 문의 편집 명령
+ RUN, @, / : SQL 문 또는 PL/SQL을 실행하는 명령
+ SAVE, GET, EDIT, SPOOL : 스크립트 파일을 저장하는 명령
+ HOST, EXIT : 데이터베이스 접속 및 종료
+ LINE, PAGE : 검색 결과에 대한 보고서 형태의 출력 형식 결정


SQL*Plus 편집 및 실행
----------
명령어
+ LIST(L) : 버퍼에 저장된 모든 SQL 문 또는 검색한 라인의 SQL 문을 나타낸다. 
+ / : SQL 문을 보여주지 않고 바로 실행한다.
+ RUN(R) : 버퍼에 저장된 SQL 문을 보여주고 실행한다.

+L[IST]
> 버퍼에 저장된 내용을 출력하기 위해 사용되는 명령어 약어 => L

+ SQL*Plus 실행 명령
> 버퍼에 저장된 쿼리문을 실행 시키기 위해서"/"을 입력 -> 실행 후 결과 값만 출력

+ HOST
> DOS 환경으로 나가는 명령어


SQL*Plus 파일조작 명령어
--------------
명령어
+ EDi[IT] filename : 파일의 내용을 메모장으로 읽어 편집할 수 있도록 한다.
+ SAV[E] filename : SQL 버퍼 내의 현재 내용을 파일에 저장한다.
+ @filename : SQL 파일에 저장된 내용을 실행한다.
+ SPO[OL][filename | OFF] : 오라클 화면을 갈무리하여 파일로 저장한다.
+ GET filename : 파일의 내용을 SQL 버퍼로 읽어 들인다.

+ ED[IT]
> 파일의 내용을 메모장에서 읽어와 쉽게 편집할 수 있도록 하는 명령어
<pre>EDIT filename</pre>

+ SAV[E]
> 쿼리문을 파일에 저장해 둘 때 사용
<pre>SAVE filename[.ext][APPEND|REPLACE]</pre>
> APPEND 혹은 REPLACE를 옵션으로 사용할 수 있음
  APPEND : 기존의 파일에 마지막으로 실행한 명령어를 추가
  REPLACE : 기존의 파일에 새로운 내용을 덮어쓰길 원할때 사용

+ @
> 저장된 여러 쿼리문을 일괄로 실행 시킬 수 있음
<pre>filename</pre>

+ SPOOL
> SQL문과 실행된 쿼리 결과를 파일로 기록하는 명령어
  화면에 보이는 내용 전체를 갈무리해서 하나의 파일로 만듦
<pre>SPOOL filename</pre>
<pre>SPOOL OFF</pre>

SQL*Plus 형식 명령어
------------
+ COLUMN FORMAT : 칼럼 데이터에 대한 출력 형식을 다양하게 지정하기 위한 명령어

+ LINESIZE (LIN)n : SELECT 명령어를 수행한 후 결과를 출력할 때 한 라인에 출력할 최대문자(Character) 수를 결정한다.
  디폴트 값은 80 => 출력할 문자 수가 80 이상이면 다음과 같이 설정 <pre>SET LINESIZE 100</pre>
  
+ PAGESIZE (PAGES)n : SELECT 명령어를 수행한 후 결과를 출력할 때 한 페이지에출력할 최대 라인 수를 결정한다.
  디폴트 값은 14 => 페이지당 출력할 라인 수를 10으로 조절하려면 다음과 같이 설정 <pre>SET PAGESIZE 10</pre>
  
+ HEADING (HEA) on|off : SELECT 명령어를 수행한 후 실행 결과가 출력될 때 칼럼의 제목을 출력할 것인지의 여부를 제어
  디폴트 값은 ON이므로 칼럼 제목이 출력 => 칼럼 제목이 출력되지 않도록 하려면 다음과 같이 설정 <pre>SET HEADING OFF</pre>

+ COLUMN
> 칼럼 데이터에 대한 출력 형식을 다양하게 지정
> An : 문자 형식 칼럼의 출력 크기를 설정
> 9 : 숫자 형식 칼럼의 출력 길이를 조정
> 0 : 지정된 길이 만큼 숫자 앞에 0을 추가
> $ : 숫자 앞에 달러 기호 삽입
> L : 숫자 앞에 지역 화폐 단위 삽입
> . : 소수점 위치 지정
> . : 1000자리마다 '.' 구분자 

+ LINESIZE
> 한 라인에 출력될 수 있는 문자의 개수를 

+ PAGESIZE
> SQL문의 실행 결과에 대해서 출력될 수 있는 페이지의 크기를 

SQL(Structured Query Language)
=====
+ 테이블을 저장 단위로 생각하는 관계형 데이터베이스(Relational DataBase:RDB)를 처리하기 위해 미국표준협회(ANSI)에서 표준으로 채택한 언어
+ 여러 줄 실행 : 종결문자(;) 필요 : 연결문자 불필요 : 키워드 단축 불가 : 버퍼에 마지막 명령문 저장


Ex
---------
+ 최근 사용한 쿼리문을 다시 한 번 나타내기
<pre>select ename, salary*12+nvl(commission,0)
from employee;
L</pre>

+ 최근 사용한 쿼리문 실행 시키기
<pre>/</pre>

+ 최근 사용한 쿼리문 실행 시키기
<pre>R</pre>

+ DOS 환경으로 나가기
<pre>HOST</pre>

+ SQL*Plus로 돌아가기
<pre>EXIT</pre>

+ 최근 사용한 쿼리문 메모장으로 불러오기
<pre>select ename, salary*12
from employee;
ed</pre>

+ 메모장에서 수정할 내용
<pre>select ename, salary*12+nvl(commission, 0)
from employee;
/</pre>

+최근 사용한 쿼리문을 실행시키기
<pre>R</pre>

+ 최근 사용한 쿼리문 저장하기
<pre>select ename, salary*12
from employee;
save sample</pre>

+ DOS에서 파일 확인하기
<pre>host
dir</pre>

+ SQL*Plus로 돌아가기
<pre>exit</pre>

+ 파일 내용 확인하기
<pre>ed sample</pre>

+ 기존 sql 파일을 재사용 했을 때 에러
<pre>select * from department;
save sample</pre>

+ 기존 sql 파일 재사용하기
<pre>select * from department;
save sample REPLACE</pre>

+ 파일 내용 확인하기
<pre>ed sample</pre>

+ 파일 내용 변경한 후 저장하기
<pre>select enmae, salary*12+nvl(commission, 0)as 연봉
from employee
/</pre>

+ 변경된 파일 내용 확인하기
<pre>ed sample</pre>

+ 부서 정보 출력하기
<pre>select * from department;
save sample append</pre>

+ 추가된 파일 내용 확인하기
<pre>ed sample</pre>

+ sql 파일 실행하기
<pre>@sample</pre>

+ SPOOL명령어로 화면 갈무리하기
<pre>spool test
select ename, salary*12
from employee;
select*
from department;</pre>

+ LST 파일 내용 확인하기
<pre>exit
ed test.lst</pre>

+ 부서 테이블의 데이터 타입 보기
<pre>desc department</pre>

+ 부서 테이블 내용 보기
<pre>select *
from department;</pre>

+ 문자 형식의 칼럼 출력 길이를 변경한 후 부서 테이블 내용 보기
<pre>column dname format a40
select *
from department;</pre>

+ 사원 테이블 내용 보기
<pre>select *
from employee;</pre>

+ 칼럼의 출력 형식을 변경한 후 사원 테이블 내용 보기
<pre>column commission format 9,999,999
column salary format 0,000,000
select *
from employee;</pre>

+ 사원 정보 출력하기
<pre>select *
from employee;</pre>

+ 라인 당 출력될 문자 수 변경하기
<pre>set linesize 130</pre>

+ 사원 테이블 출력하기
<pre>select *
from employee;</pre>

+ 페이지당 출력될 라인 수 변경하기
<pre>SET PAGESIZE 10
select *
from employee;</pre>


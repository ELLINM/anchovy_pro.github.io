Function
==========

문자 함수
-------
+ 대소문자 변환 함수
> UPPER : 대문자로 변환한다.
> LOWER : 소문자로 변환한다.
> INITCAP : 첫 글자만 대문자로, 나머지 글자는 소문자로 변환한다.


+ 문자 길이를 반환하는 함수
> LENGTH : 문자의 길이를 반환한다.(한글 1Byte)
> LENGTHB : 문자의 길이를 반환한다.(한글 2Byte)


+ 문자 조작 함수
> CONCAT : 문자의 값을 연결한다. 
> SUBSTR : 문자를 잘라 추출한다.(한글 1Byte)
> SUBSTRB : 문자를 잘라 추출한다.(한글 2Byte)
> INSTR : 특정 문자의 위치 값을 반환한다.(한글 1Byte)
> INSTRB : 특정 문자의 위치값을 반환한다.(한글 2Byte)
> LPAD, RPAD : 입력 받은 문자열과 시호를 정렬하여 특정 길이의 문자열로 반환한다.
> TRIM : 잘라내고 남은 문자를 표시한다.

Ex
---------
+ 대소문자 변환 함수 사용하기
<pre>select'Orcle mania',
UPPER('Orcle mania'),
LOWER('Orcle mania'),
INITCAP('Orcle mania')
from dual;</pre>

+ 대소문자 변환 함수를 칼럼에 사용하기
<pre>select ename, lower(ename), job, initcap(job)
from employee;</pre>

+ scott 사원 검색하기
<pre>select eno, ename,dno
from employee
where ename='scott';</pre>

+ scott 사원 검색하기
<pre>select eno, ename, dno
from employee
where lower(ename)='scott';</pre>

+ Scott 사원 검색하기
<pre>select eno, ename, dno
from employee
where INITCAO(ename)='Scott';</pre>

+ 영문과 함글의 길이 구하기
<pre>select length('OracleMania'), length('오라클매니아')
from dual;</pre>

+ 영문과 한들의 바이트 수 구하기
<pre>select lengthb('OracleMAnia'), lengrhb('오라클매니아')
from dual;</pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>

+ 
<pre></pre>



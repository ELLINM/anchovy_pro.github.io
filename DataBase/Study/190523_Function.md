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
> SUBSTR : 문자를 잘라 추출한다.(한글 1Byte) <pre>SUBSTR(대상, 시작위치, 추출할 )</pre>
> SUBSTRB : 문자를 잘라 추출한다.(한글 2Byte)
> INSTR : 특정 문자의 위치 값을 반환한다.(한글 1Byte) <pre>INSTR(대상, 찾은 글자, 시작 위치, 몇 번째 )</pre>
> INSTRB : 특정 문자의 위치값을 반환한다.(한글 2Byte)
> LPAD, RPAD : 입력 받은 문자열과 시호를 정렬하여 특정 길이의 문자열로 반환한다.
> TRIM : 잘라내고 남은 문자를 표시한다.


숫자함수
---------
+ ROUND : 특정 자릿수에서 반올림 한다. <pre>ROUND(대상, )</pre>
+ TRUNC : 특정 자릿수에서 잘라낸다.(버림)
+ MOD : 입력 받은 수를 나눈 나머지 값을 반환한다.


날짜함수
------------
+ SYSDATE : 시스템에 저장된 현재 날짜를 반환한다.
+ MONTH_BETWEEN : 두 날짜 사이가 몇 개월인지를 반환한다. <pre>MONTHS_BETWEEN(date1, date2)</pre>
+ ADD_MONTH : 특정 날짜에 개월 수를 더한다. <pre>ADD_MONTH (date, n)</pre>
+ NEXT_DAY : 특정 날짜에서 최초로 도래하는 인자로 받은 요일의 날짜를 반환한다. <pre>NEXT_DAY(date, '요일')</pre>
+ LAST_DAY : 해당 달의 마지막 날짜를 반환한다.
+ ROUND : 인자로 받은 날짜를 특정 기준으로 반올림 한다.<pre>ROUND (date, format)</pre>
> CC, SCC : 4자리 연도의 끝 두 글자를 기준으로 반올림
> SYYY, YYYY, YEAR, SYEAR, YYY, YY, Y : 년(7월 1일 부터 반올림)
> DDD, D, J : 일을 기준
> HH, HH12, HH24 : 시를 기준
> Q : 한분기의 두 번째 달에 16일을 기준으로 반올림
> MONTH, MON, MM, RM : 월(16일을 기준으로 반올림)
> DAY, DY, D : 한주가 시작되는 날짜
> MI : 분을 기준
+ TRUNC : 인자로 받은 날짜를 특정 기준으로 버린다.<pre>TRUNC (date, format)</pre>

+ DATE & NUMBER
> date + number : 결과값 - 날짜, 날짜에 일수를 더하여 날짜 계산
> date - number : 결과값 - 날짜, 날짜에 일수를 빼서 날짜를 계산
> date - date : 결과값 - 일수, 날짜와 날짜를 빼서 일수를 계산
> date + number/24 : 결과값 - 날짜, 날짜에 시간을 더하여 날짜 계산


형 변환 함수
----
+ TO_CHAR : 날짜형 혹은 숫자형을 문자형으로 변환한다. <pre>TO_CHAR(number|date,'format')</pre>
> 날짜
  YYYY : 연도 표현(4)
  YY : 연도 표현(2자리)
  MM : 월을 숫자로 표현
  MON : 월을 알파벳으로 표현
  DAY : 요일 표현
  DY : 요일을 약어로 표현
> 시간
  AM or PM : 오전(AM), 오후(PM) 시각 표시
  A.M or P.M : 오전(A.M), 오후(P.M) 시각표시
  HH or HH12 : 시간 (1~12) 표시
  HH24 : 24시간으로 표현(0~23)
  MI : 분 표현
  SS : 초 표현
> 숫자
  0 : 자릿수를 나타내며 자릿수가 맞지않을 경우 0으로 채운다.
  9 : 자릿수를 나타내며 자릿수가 맞지않아도 채우지 않는다.
  L : 각 지역별 통화 기호를 앞에 표시
  . : 소수점 표시
  , : 천 단위 자리 구분을 표시
  
+ TO_DATE : 문자형을 날짜형으로 변환한다. <pre>TO_DATE('char', 'format')</pre>

+ TO_NUMBER : 문자형을 숫자형으로 변환한다.


일반 함수
--------
+ NVL : NULL을 0 또는 다른 값으로 변환하기 위해서 사용 <pre>NVL(expr1, expr2)</pre>
> NULL을 실제값으로 변환하기 위해서 사용하며 데이터의 유형은 날짜, 문자, 숫자
  expr1에는 NULL을 포함하는 칼럼 또는 표현식을, expr2에는 NULL을 대체하는 값을 기술
  expr1과 expr2는 반드시 데이터 타입이 

+ NVL : expr1을 검사하여 그 결과가 NULL이면 expr2를 반환하고 NULL이 아니면 expr3을 반환
<pre>NVL2(expr1, expr2, expr3)</pre>

+NULLIF : 두 표현식을 비교하여 동일한 경우에는 NULL을 반환하고 동일하지 않으면 첫 번째 표현식을 반환
<pre>NULLIF(expr1, expr2)</pre>

+ COALESCE : 인수 중에서 NULL이 아닌 첫 번째 인수를 반환하는 함수
<pre>COALESCE(expr-1, expr-2,..., expr-n)</pre>

+ DECODE : 조건에 따라 다양한 선택이 가능하도록 함
> 표현식 또는 칼럼의 값이 조건1과 일치하면 결과1을 반환하고, 조건2와 일치하면 결과2를 반환
  일치하는 값이 없거나 NULL인 경우에는 기본 결과를 반환
  기본 결과가 명시되지 않았을 경우에는 NULL을 반환
<pre>DECODE(표현식, 조건1, 결과1,
            조건2, 결과2,
            조건3, 결과3,
            기본결과n
       )</pre>

+ CASE : 프로그래밍 언어의 if else와 같은 사용
> expr이 조건1과 일치하면 결과1을 반환하고, 조건2와 일치하면 결과2를 반환
<pre>CASE expr
      WHEN 조건1 THEN 결과1
      WHEN 조건2 THEN 결과2
      WHEN 조건3 THEN 결과3
      ELSE 결과 n
END</pre>



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

+ 문자 결합하기
<pre>select 'Oracle', 'mania', contact('Oracle', 'mania')
from dual;</pre>

+ 문자열의 일부만 추출하기
<pre>select substr('Oracle mania', 4, 3),
      substr('Oracle mania', -4, 3)
from dual</pre>

+ 이름이 N으로 끝나는 사원 표시하기
<pre>select *
from employee
where substr(ename, -1, 1)='N';</pre>

+ 87년도에 입사한 사원 표시하기
<pre>select * 
from employee
where substr(hiredate, 1, 2)='87';</pre>

+ SUBSTRB 함수로 영문 추출하기
<pre>select substr('Oracle mania', 4, 3),
      substr('Oracle mania', 4, 3)
from dual;</pre>

+ SUBSTRB 함수로 한글 추출하기
<pre>select substr('오라클매니아', 3, 4),
      substr('오라클매니아', 3, 4)
from dual;</pre>

+ 문자 위치 찾기
<pre>select INSTR('Oracle mania', 'a')
from dual;</pre>

+ 특정 위치 이후의 문자 위치찾기
<pre>select INSTR('Oracel mania', 'a', 5 ,2)
from dual;</pre>

+ INSTRB 함수로 위치 찾기
<pre>select INSTR('오라클매니아', '라')
      INSTRB('오라클매니아', '라')
from dual;</pre>

+ 사원 검색하기
<pre>select *
from employee
where instr(ename, 'R', 3, 1)=3;</pre>

+ 왼쪽 자리를 특정 기호로 채우기
<pre>select LPAD(salary, 10,'*')
from employee;</pre>

+ 오른쪽 자리를 특정 기호로 채우기
<pre>select RPAD(salary, 10, '*')
from employee;</pre>

+ 한쪽 공백 제거하기
<pre>select 'Orecle mania',
        LTRIM(' Oracle mania '),
        RTRIM(' Oracle mania ')
from dual;</pre>

+ 특정 문자 제거하기
<pre>select 'Oracle mania',
        TRIM('O'FROM 'Oracle mania')
from dual;</pre>

+ 앞뒤 공백 제거하기
<pre>select TRIM(' Oracle mania ')
from dual;</pre>

+ 반올림하기
<pre>select 98.7654,
        ROUND(98.7654),
        ROUND(98.7654, 2),
        ROUND(98.7654, -1)
from dual;</pre>

+ 잘라내기
<pre>select 98.7654,
        TRUNC(98.7654),
        TRUNC(98.7654, 2),
        TRUNC(98.7654, -1)
from dual;</pre>

+ 나머지 반환하기
<pre>select MOD (31, 2),
        MOD(31, 5),
        MOD(31, 8)
from dual;</pre>

+ 나머지 구하기
<pre>select ename, salary, MOD(salary, 500)
from employee;</pre>

+ 현재 날짜 표시하시
<pre>select sysdate
from dual;</pre>

+ 근무일수 계산하기
<pre>select ROUND(SYSDATE-HIREDATE)근무일수
from employee;</pre>

+ 특정 날짜(DATE)에서 월(MOMTH)을 기준으로 버림한 날짜 구하기
<pre>select hiredate,
        TRUNC(HIREDATE, 'MONTH')
from employee;</pre>

+ 각 사원들이 근무한 개월 수 구하기
<pre>select ename, sysdate, hiredate,
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))
from employee;</pre>

+ 입사한지 6개월 지난 날짜 구하기
<pre>select ename, hiredate,
        ADD_MONTHS(HIREDATE, 6)
from employee;</pre>

+ 오늘을 기준으로 최초로 도래하는 토요일 구하기
<pre>select SYSDATE,
      NEXT_DAY(SYSDATE, '토요일')
from dual;</pre>

+ 입사한 달의 마지막 날 구하기
<pre>select ename, hiredate,
        LAST_DAY(HIREDATE)
from employee;</pre>

+ 날짜 함수 사용하기
<pre>select ename, hiredate,
        TO_CHAR(HIREDATE, 'YY-MM;),
        TO_CHAR(HIREDATE, 'YYYY/MM/DD DAY')
from employee;</pre>

+ 현재 날짜와 시간 출력하기
<pre>select TO_CHAR(SYSDATE,'YYYY/MM/DD, HH24:MI:SS')</pre>

+ 급여를 출력하면서 통화 기호 덧붙이기
<pre>select ename, TO_CHAR(salary, 'L999,999')
from employee;</pre>

+ 1981년 2월 20일에 입사한 사원 검색하기
<pre>select ename, hiredate
from employee
where hiredate=19810220</pre>

+ 날짜형으로 변환하기
<pre>sekect ename, hiredate
from employee
where hiredate=TO_DATE(19810220.'YYYYMMDD');</pre>

+ 숫자 형태의 문자 빼기
<pre>select '100,000'-'50,000'
from dual;</pre>

+ 수치 형태로 변환한 후 빼기
<pre>select TO_NUMBER('100,000', '999,999')
        -TO_NUMBER('50,000', '999,999')
from dual;</pre>

+ NULL값 처리
<pre>NVL(commission,0)
NVL(hiredate,'2011/5/10')
NVL(job,'MANAGER')</pre>

+ NVL로 NULL값 처리하기
<pre>select ename, salary, commission,
        NVL(commission, 0),
        salary*12+NVL(commission,0)
from employee
order by job;</pre>

+ NVL2로 NULL값 처리하기
<pre>select ename, salary, commission,
      NVL2()commission, salary*12+commission, salary*12)
from employee
order by job;</pre>

+ NULLIF로 NULL값 처리하기
<pre>NULLIF로 NULL값 처리하기</pre>

+ COALESCE로 NULL값 처리하기
<pre>select ename, salary, commission,
      COALESCE(commission, salary, 0)
from employee
order by job;</pre>

+ DECODE로 부서이름 출력하기
<pre>select ename, dno,
    DECODE(dno, 10, 'ACCOUNTING',
            20, 'RESEARCH',
            30, 'SALES',
            40, 'OPERATIONS',
            'DEFAULT') AS DNAME
from employee
order by dno;</pre>

+ CASE로 부서이름 출력하기
<pre>select ename, dno,
    CASE WHEN dno=10 THEN 'ACCOUNTING'
        WHEN dno=20 THEN 'RESEARCH'
        WHEN dno=30 THEN 'SALES'
        WHEN dno=40 THEN 'OPERATIONS'
        ELSE 'DEFAULT'
    ELSE AS DNAME
from employee
order by dno;</pre>

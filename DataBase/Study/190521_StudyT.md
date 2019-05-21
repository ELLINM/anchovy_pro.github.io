조건문 SELECT
=========


예시
-------
+ SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES
  WHERE SALARY > 7000 ;
> 단순한 SELECT문을 작성 -> WHERE 절을 추가
  WHERE 이후에는 테이블내 데이터의 범위를 지정 
  여기에는 등호(=) 또는 부등호(>,<)등으로 서로 비교가 가능 한 값을 대입 
  SALARY>7000 => 해석 하자면, ‘봉급이 7000달러 초과인 사람의 이름과 성을 EMPLOYEES 테이블에서 가져와라‘ 

+ 데이터에는 프로그래밍 언어처럼 데이터 타입이 존재 
> 예시 -> EMPLOYEES 테이블의 FIRST_NAME과 LAST_NAME은 VARCHAR2라는 문자열 데이터타입
  문자열이기 때문에 숫자와 비교 불가
  
> SELECT EMAIL FROM EMPLOYEES WHERE LAST_NAME=123;
  123이라는 NUMBER타입과 LAST_NAME이라는 VARCHAR2 타입을 비교
  이것은 잘못 조건절을 비교한 경우 문자열 조건에 숫자 비교 불가


주의
---------
+ 예시
> SELECT LAST_NAME, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE FIRST_NAME='WILLIAM';
  다음을 검색하면 아무 ROW도 나오지 않음 하지만
  SELECT LAST_NAME, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE FIRST_NAME='William';
  검색가능
  조건문 안의 문자열은 대소문자를 가린다
  
AND 조건 연산자
-----------
+ 예시
> SELECT EMAIL,PHONE_NUMBER FROM EMPLOYEES WHERE SALARY>7000 AND EMAIL='SKING'
  SELECT 조건절 중간에 AND 연산 => 두 가지 조건(봉급이 7000을 초과, 이메일이 'SKING') 모두 참일 때만 SELECT
  AND 연산은 계속 사용가능

<pre>
==================================================
SELECT 
	EMAIL,PHONE_NUMBER 
FROM 
	EMPLOYEES 
WHERE 
	SALARY>7000 
     AND 
        EMAIL='SKING'
     AND
	FIRST_NAME='Steven';
===================================================
</pre>

> AND를 2번 사용, 조건 총 3개 => 3개의 조건 모두 ‘참‘일 때만 SELECT


OR 조건 연산자
--------------
+ SELECT SALARY, FIRST_NAME FROM EMPLOYEES WHERE SALARY>7000 OR SALARY<3000
> EMPLOYEES 테이블에서 급여가 7000달러 초과 이거나 3000달러 미만인 사람의 급여와 이름을 SELECT
  OR 연산의 경우는 조건중 하나라도 ‘참’이면 SELECT
  SELECT * FROM EMPLOYEES WHERE 참 OR 거짓
  둘 중 하나가 거짓이어도 SELECT 하게 됩니다.
  
+ 주의
-------
> SELECT * FROM EMPLOYEES SALARY>7000 AND EMAIL='SKING' OR FIRST_NAME='Steven';
  AND 와 OR 연산의 순서는 같습니다.
  SALARY>7000 이면서 EMAIL='SKING' 인 사람은 한명 FIRST_NAME='Steven'인 사람은 2명이 존재
  OR연산이므로 결국 SELECT 했을 때 2개의 정보가 나오게 됨 
  

예제
-----------
1) FIRST_NAME(이름)이 'David'인 사람의 성(LAST_NAME), 이름(FRIST_NAME), 이메일(EMAIL)
   을 EMPLOYEES 테이블에서 SELECT 해보기.
2) SALARY(급여)가 10000달러 초과 하면서, JOB_ID(직업번호)가 'SA_REP' 인 사람의 EMAIL, LAST_NAME, PHONE_NUMBER를 EMPLOYEES 테이블에서 SELECT 해보기.
3) SALARY(급여)가 3000달러 미만이거나, 14000달러를 초과하는 사람의 EMPLOYEE_ID를 SELECT해보기.
4) 커미션(COMMISSION_PCT)을 받는 사람들의 이름과 이메일을 SELECT해보기.
5) 이름(FIRST_NAME)이 'Peter'인 사람중에 급여가 제일 높은 사람의 이름과 성은?
6) 이메일이 'KGEE'인 사람의 풀네임은?

정답:
1)
SELECT LAST_NAME, FIRST_NAME, EMAIL FROM EMPLOYEES WHERE FIRST_NAME='David';
2)
SELECT EMAIL, LAST_NAME, PHONE_NUMBER FROM EMPLOYEES WHERE SALARY > 10000;
3)
SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE SALARY > 14000 OR SALARY<3000 ;
4)
SELECT FIRST_NAME, EMAIL FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL
NULL의 경우 등호나 부등호를 사용하지 않고, IS 또는 IS NOT을 사용하여 NULL값의 여부를 비교합니다.
5) Peter Tucker
6) 
SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE EMAIL='KGEE'

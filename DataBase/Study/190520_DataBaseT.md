오라클DB를 배우면 좋은점
================
+ 관계형 데이터베이스의 문법이 오라클 sql의 문법과 비슷한 DB가 많이 있음 
  따라서 오라클을 배우시면 다른 DB의 문법도 쉽게 적응 하실 수 있음


SELECT
----------------
+ SELECT문이란 DB의 데이터들을 검색, 열람 할 때 사용하는 키워드
+ SELECT를 공부하는 이유는 데이터는 어떠한 형태로 들어가는지, 또는 구조가 어떻게 되는지 등을 먼저 파악하기 위함
+ 기본 구조
> SELECT * FROM EMPLOYEES;
+ SQL은 모두 대문자가 되어 실행 모든 SQL은 CMD 상에서는 반드시 세미콜론(;)으로 마무리

SQL문법
-----------
+ SELECT - 열람 합니다/검색합니다.
+ *  - 모두(성, 이름, 이메일, 전화번호, 부서번호 등등등..)
+ FROM - 어디에서 
+ EMPLOYEES - 테이블명 (위 그림 참조 EMPLOYEES테이블)
> 해석하자면,  " EMPLOYEES 라는 테이블에서 모든 정보를 검색하겠습니다 "
+ EMPLOYEES 테이블의 정보는 위와 같이
> EMPLOYEE_ID (사원번호) FIRST_NAME (이름) LAST_NAME (성) EMAIL (이메일)
  PHONE_NUMBER (전화번호) HIRE_DATE (입사일) JOB_ID (직업번호) SALARY (봉급)
  COMMISSION_PCT (커미션율 (특징 - 없는 사원도 있음) ) MANAGER_ID (직속상사 사원번호 (특징 - 상사의 사원번호 임, SELF-JOIN 중임) )
  DEPARTMENT_ID (부서번호)
+ 예문
> 모든 사원의 이름과 성 을 검색 해보자
  SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES;
  모돈 사원의 봉급과 이름을 검색해 보자
  SELECT SALARY, FIRST_NAME FROM EMPLOYEES;
+ 별칭(ALIAS-알리아스)
> 예시 SELECT LAST_NAME 성, FIRST_NAME 이름 FROM EMPLOYEES;
  SELECT LAST_NAME AS 성, FIRST_NAME AS 이름 FROM EMPLOYEES;
  검색될때의 컬럼명이 내가 AS이후에 준 문자나 한 칸 띄고 입력한 내용으로 바뀜
  
![ex_HR](http://www.shareshard.com/resources/images/-LfIp1WhRvbB-8I73u3B0/cncpt292.gif)

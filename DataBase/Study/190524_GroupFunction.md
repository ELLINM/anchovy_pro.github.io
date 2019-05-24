그룹함수
=========

그룹함수
----
+ 그룹함수는 테이블 전체 데이터에서 통계적인 결과를 구하기 위해서 행 집합에 적용하여 하나의 결과를 생산

+ SUM : 그룹의 누적 합계를 반환

+ AVG : 그룹의 평균을 반환

+ COUNT : 그룹의 총 개수를 반환 <pre>COUNT({*|[DISTINCT|ALL]expr})</pre>
> COUNT(*)은 NULL을 포함한 모든 행 개수를 구함 cOUNT(expr)은 expr로 식별되는 열에서 NULL이 아닌 행의 개수를 구함 

+ MAX : 그룹의 최대값을 반환

+ MIN : 그룹의 최소값을 반환


GROUP BY
------------
+ 특정 칼럼을 기준으로 그룹별로 나눌 필요가 있을 때 사용
<pre>SELECT 칼럼명, 그룹함수
FROM 테이블명
WHERE 조건(연산자)
GROUP BY칼럼명;</pre>



HAVING
----------
+ 표시할 그룹을 지정하여 집계정보를 기준으로 그룹결과를 제한
+ 결과 갑중 HAVING절 다음에 지정한 조건에 true입 그룹으로 결과를 


Ex
--------
+ 사원들의 급여 총액, 평균액, 최고액, 최소액 출력하기
<pre>select sun(salary) as"급여총액",
        avg(salary) as"급여평균",
        max(salary) as"최대급여",
        min(salary) as"최소급여"
from employee;</pre>

+ 최근에 입사한 사원과 가장 오래전에 입사한 사원의 입사일 출력하기
<pre>select max(hiredate),
          min(hiredate)
from employee;</pre>

+ 사원들의 커미션 총액 출력하기
<pre>select sum(commission) as"커미션 총액"
from employee;</pre>

+ 전체 사원의 수 구하기
<pre>select count(*) as"사원의 수"
from employee;</pre>

+ 커미션을 받는 사원의 수 구하기
<pre>select count(commission) as "커미션 받는 사원 수"
from employee
where commission is not null;</pre>

+ 직업 종류의 개수 출력하기
<pre>select count(distinct job) as"직업 종류의 개수"
from employee;</pre>

+ 그룹함수를 사용하는 경우 SELECT절에 그룹함수가 아닌 것을 포함시킨 잘못된 예
<pre>select ename, max(salary)
from employee;</pre>

+ 소속 부서별 평균 급여를 부서번호와 함께 출력하기
<pre>select dno as"부서 번호", avg(salary) as"급여 평균"
from employee
group by dno;</pre>

+ 소속 부서별 평균 급여 구하기
<pre>select avg(salary) as "급여평균"
from employee
group by dno;</pre>

+ 그룹함수내 잘못된 질의 예
<pre>select dno, ename, avg(salary)
from employee
group by dno;</pre>

+ 다중 칼럼을 이용하여 그룹별로 검색하기
<pre>select dno, job, count(*), sum(salary)
from employee
group by dno, job
order by dno, job;</pre>

+ 부서별 급여 총액이 3000이상인 부서의 번호와 부서별 급여 총액 구하기
<pre>select dno, max(salary)
from employee
group by dno
having max(salary) >= 3000;</pre>

+ MANAGER를 제외하고 급여 총액이 5000이상인 직급별 급여 총액 구하기
<pre>select job, count(*), sum(salary)
from employee
where job not like '%MANAGER%'
group by job
having sum(salary) >=5000
order by sum(salary);</pre>

+ 최고 급여 출력하기
<pre>select max(avg(salary))
from employee
group by dno;</pre>

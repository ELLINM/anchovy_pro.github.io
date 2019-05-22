ORDER BY
==========
+ 데이터를 정령해야할 경우 ORDER BY 사용
<pre>SELECT * [colunm1, colunm2,..,columnn]
FROM table_name
WHERE 조건절
ORDER BY column_name sorting</pre>


Ex
---------
+ 오름차순으로 정렬하기
<pre>select * from employee
oreder by salary asc;</pre>

+ 정렬 방식 생략하기
<pre>select * from employee
order by salary;</pre>

+ 내림차순 정렬하기
<pre>select * from employee
order by salary desc;</pre>

+ 문자 데이터로 오름차순 정렬하기
<pre>select * from employee
order by ename;</pre>

+ 날짜 데이터로 내림차순 정렬하기
<pre>select * from employee
order by hiredate desc;</pre>

+ 여러 개의 칼럼에 대해서 정렬 순서 정하기
<pre>select * from employee
order by salary desc, ename asc;</pre>


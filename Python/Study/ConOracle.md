Oracle 연동
======
<pre>
import cx_Oracle
# oracle과 연결(mysql은 pymysql)
</pre>

<pre>
db = cx_Oracle.connect("hr/hr@localhost:XXXX/XX")
#연결하고자 하는 DB와 연결
</pre>

<pre>
curs = db.cursor()
#cursor객체를 통해 접근
</pre>

+ 이후sql문을 통해 

Cursor
-----
+ SQL 질의문의 수행으로 만들어진 결과 집합에 접근할 때 사용
+ 파일의 포인터와 같음, 질의 결과에 직접 접근할 수 있음
+ moveToFirst(), moveToNext(), isAfterLast()등의 Method제공

DataBase
===========
+ 조직화된 정보의 집합
+ Data Base Server
+ DBMS
+ Charles William Bachman
> Network DataBase 개발
+ Edgar.F.Codd
> Relation Model 제안 (RDB) => Join, Select중요
+ Peter Chen
> ERD Model


File System
------------
+ 장점
> 속도가 빠름
> 별도 구입비용이 없음

+단점
> 유지보수 비용이 큼(프로그램과 데이터간의 독립성이 없음)
> 동일한 데이터가 많은 파일에 중복저장될 가능성이 큼
> 보안조치가 미흡하며 무결성 유지가 어려움


OOBD,ORDB
--------------
+ Data Type 종류의 증가


Data Type
--------
+ CHAR(size)
> size 크기의 고정길이 문자 Data Type
> 최대크기 : 2,000byte
> 최소크기 : 1byte

+ VARCHAR2(size)
> size 크기의 가변 길이 문자 Data Type
> 최대크기 : 2,000byte
> 최소크기 : 1byte

+ NVARCHAR2(size)
> 국가별 문자 집합에 따른 size
> 크기의 문자 또는 바이트의 가변 길이 문자 Data Type
> 최대크기 : 4,000byte
> 최소크기 : 1 byte

+NUMBER(p,s)
> 정밀도(p)와 스케일(s)로 표현되는 숫자 Data Type
> p : 1 ~ 38
> s : -84 ~ 127

+ DATE
> 날짜 형식을 저장하기 위한 Data Type

+ ROWID
> 테이블 내 행의 고유 주소를 가지는 64진수 문자 타입
> 해당 6byte(제한된 ROWID) 또는 10byte(확장된 ROWID)

+ BLOB
> 대용량의 바이너리 데이터를 저장하기 위한 Data Type
> 최대크기 : 4GB

+ CLOB
> 대용량의 텍스트 데이터를 저장하기 위한 Data Type
> 최대크기 : 4GB

+ BFILE
> 대용량의 바이너리 데이터를 파일 형태로 저장하기 위한 Data Type
> 최대크기 : 4GB

+ TIMESTAMO(n)
> DATE 데이터 타입의 확장된 형태
> n은 milli second 자리수로 최대 9자리 까지 표현 가능

+ INTERVAL YEAR TO MONTH
> 년과 월을 이용하여 기간을 저장

+ INTERVAL DAY TO SECOND
> 일, 시, 분, 초를 이용하여 기간을 저장
> 두 날짜값의 정확한 차이를 표현하는데 유용

LAMP
------
+ Linux
+ Appache
+ MySQL
+ PHP


SQL
--------
+ IOS 인증으로 꾸준히 사용되는 언어

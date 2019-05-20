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


Data Integrity
--------
+ NOT NULL 제약 조건
> NULL : 아직 할당 받지 않은 값, 아직 무엇인지 모르는 값
  테이블의 지역명(LOC)칼럼에 정해지지않은 값을 의미하는 NULL값을 할당
  테이블 내에 반드시 입력해야 하는 필수 입력 칼럼에 NULL값을 저장하지 못하도록 NOT NULL제약 조건이 필요
  NOT NULL조건이 된 칼럼은 NULL값이 아닌 확실한 정보가 저장되어야 하기 때문에 필수적으로 입력되어야 하는 칼럼이 됩니다.

+ 기본 키 제약 조건
> 한 테이블 내에서 칼럼이 동일한 값을 가질 수 없게 제약 조건을 지정하는것

+ 외래 키 제약 조건
> 서로 다른 테이블을 연결하여 사용할때 필요한 정보를 추가, 수정할 때 필요한 키를 참조 하도록 제약을 걸어 두는 것


SQL
--------
+ 질의어 (DQL : Data Query Language), SELECT(데이터 검색)

+ 데이터 조작어 (DML : Data Manipulation Language) ,INSERT(데이터 입력), UPDATE(데이터 수정), DELETE(데이터 삭제)

+ 데이터 정의어 (DDL : Data Definition Language), CREATE(데이터베이스 객체 생성), ALTER(데이터베이스 객체 변경), 
  DROP(데이터베이스 객체 삭제), RENAME(데이터베이스 객체 이름 변경), TRUNCATE(데이터 및 저장 공간 삭제)
  
+ 트랜잭션 처리어 (TCL : Transaction Control Language), COMMIT(트랜잭션의 정상적인 종료 처리), 
  ROLLBACK(트랜잭션 취소), SAVEPOINT(트랜잭션 내에 임시 저장점 설정)

+ 데이터 제어어 (DCL : Data Control Language), GRANT(데이터배이스 객체에 대한 접근 권한 부여), REVOKE(데이터베이스 객체에 대한 접근 권한 )

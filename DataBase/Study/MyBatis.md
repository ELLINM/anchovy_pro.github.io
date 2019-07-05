Mybatis
=========
+ Java Persistence Framework
+ DB연결, 자원 반납과 같은 반복작업을 줄여줌
+ SQL 명령어를 XML 파일에서 관리

MyBatis 설정
----------
+ pom.xml 에 아래 항목들을 추가
> ojdbc / mybatis / spring-jdbc / mybatis-spring

+ DB 작업
> TEST TABLE 생성
<pre>CREATE TABLE test (
	a 	VARCHAR2(100) NOT NULL,
	b   	VARCHAR2(100) NOT NULL
);</pre>

> META-INF 안에 db.properties생성
<pre>driver=oracle.jdbc.driver.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:XE
user=hr
password=hr</pre>

> dao안에 Mapper Interface생성
<pre>package com.sesoc.dao;

import com.sesoc.vo.TestVO;

public interface TestMapper {
	public int testInsert(TestVO vo);
	//method의 이름인 testInsert와 testMapper.xml에 있는 입력값이 같아야한다.
}</pre>

> src/main/resources안에 mybatis-config.xml 생성
<pre><?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<typeAliases>
		<typeAlias type="com.sesoc.vo.TestVO" alias="TestVO" />
	</typeAliases>
	<mappers>
		<mapper resource="mapper/testMapper.xml" />
	</mappers>
</configuration></pre>   

> root-context에 sqlSession 입력
<pre><bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" name="sqlSessionFactory" ref="sqlSessionFactory" />
	</bean></pre>
  
> DAO안에 sql명령문 입력

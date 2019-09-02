<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.sesoc.moneybook.dao.MemberMapper">
	<insert id="insertMember" parameterType="MemberVO">
		insert into moneybook_member
		values (#{userid}, #{userpwd})
	</insert>
	
	<select id="selectMember" parameterType="MemberVO" resultType="MemberVO">
		select * from moneybook_member
		where userid=#{userid} and userpwd=#{userpwd}
	</select>
	
</mapper>


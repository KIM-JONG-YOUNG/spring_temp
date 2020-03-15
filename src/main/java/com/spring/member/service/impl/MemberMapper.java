package com.spring.member.service.impl;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	Map<String, Object> selectMemberOne(String username) throws Exception;

}

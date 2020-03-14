package com.spring.home.service.impl;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {

	public Map<String, Object> selectVersion() throws Exception;
}

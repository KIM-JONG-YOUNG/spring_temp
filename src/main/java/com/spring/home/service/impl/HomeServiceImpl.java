package com.spring.home.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.home.service.HomeService;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Resource(name = "homeMapper")
	private HomeMapper homeMapper;

	@Override
	public void selectVersion() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(homeMapper.selectVersion());
	}

}

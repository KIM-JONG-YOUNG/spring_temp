package com.spring.member.web;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Resource(name = "passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "loginForm.do")
	public String loginForm() throws Exception {
		return "member/loginForm.tiles";
	}
}

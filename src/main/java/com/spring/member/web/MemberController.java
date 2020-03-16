package com.spring.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.member.service.MemberService;
import com.spring.member.service.MemberVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Resource(name = "gson")
	private Gson gson;

	@Resource(name = "passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;

	@Resource(name = "memberService")
	private MemberService memberService;
	
	@RequestMapping(value = "/loginForm.do")
	public String loginForm() throws Exception {
		return "member/loginForm.tiles";
	}

	@RequestMapping(value = "/joinForm.do")
	public String joinForm() throws Exception {
		return "member/joinForm.tiles";
	}
	
	@RequestMapping(value = "/checkDuplication.do")
	@ResponseBody
	public String checkDuplication(@RequestParam String memberId) throws Exception {
		Map<String, Object> memberMap = memberService.selectMemberOne(memberId);

		if (memberMap == null || memberMap.isEmpty()) {
			memberMap = new HashMap<String, Object>();
			memberMap.put("available", "YES");
		} else {
			memberMap.clear();
			memberMap.put("available", "NO");
		}
		
		return gson.toJson(memberMap);
	}
}

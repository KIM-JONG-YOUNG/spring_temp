package com.spring.member.service.impl;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.member.service.MemberVO;

public class MemberAuthenticationProvider implements AuthenticationProvider {

	@Resource(name = "passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;

	@Resource(name = "memberService")
	private UserDetailsService memberService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String memberId = authentication.getName();
		String memberPw = (String) authentication.getCredentials();
		UsernamePasswordAuthenticationToken result = null;
		try {
			MemberVO memberVO = (MemberVO) memberService.loadUserByUsername(memberId);
			
			if (passwordEncoder.matches(memberPw, memberVO.getPassword())) {
				//권한 부여
				memberVO.getAuth().add(new SimpleGrantedAuthority("ROLE_USER"));
				result = new UsernamePasswordAuthenticationToken(memberVO, null, memberVO.getAuth());
			} else {
				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}

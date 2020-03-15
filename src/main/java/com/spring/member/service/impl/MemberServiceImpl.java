package com.spring.member.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Resource(name = "memberMapper")
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MemberVO memverVO = null;
		try {
			Map<String, Object> memberMap = memberMapper.selectMemberOne(username);
			if (memberMap == null || memberMap.isEmpty()) {
				throw new UsernameNotFoundException("�������� �ʴ� ȸ���Դϴ�.");
			} else {
				memverVO = new MemberVO(
						memberMap.get("memberNo").toString()
						, memberMap.get("memberId").toString()
						, memberMap.get("memberPw").toString()
						, memberMap.get("memberName").toString()
						, memberMap.get("memberGender").toString()
						, memberMap.get("useYn").toString() );
			}
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			throw new RuntimeException("�ý��� ���� ������ �߻��߽��ϴ�.");
		}
		return memverVO;
	}

}

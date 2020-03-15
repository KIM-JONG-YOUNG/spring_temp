package com.spring.member.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

public class MemberVO implements UserDetails {
	private String memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String useYn;
	private Set<SimpleGrantedAuthority> auth;
	//추후에 시스템 상에서 정보의 저장의 필요할 경우에 사용하기 위함
	private Map<String, Object> dataMap;		
	
	public MemberVO(String memberNo, String memberId, String memberPw, String memberName, String memberGender, String useYn) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.useYn = useYn;
		this.auth = new HashSet<SimpleGrantedAuthority>();
		this.dataMap = new HashMap<String, Object>();
	}

	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", useYn=" + useYn + ", auth=" + auth + ", dataMap=" + dataMap
				+ "]";
	}

	public String getMemberNo() {
		return memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public String getUseYn() {
		return useYn;
	}

	public Set<SimpleGrantedAuthority> getAuth() {
		return auth;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getAuth();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getMemberPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getMemberNo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		if (getUseYn().trim().equals("Y") || getUseYn().trim().equals("y")) {
			return true;
		} else {
			return false;
		}
	}

}

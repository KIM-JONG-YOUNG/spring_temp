package com.spring.member.service;

import java.util.Map;

public interface MemberService {

	Map<String, Object> selectMemberOne(String memberId) throws Exception;

}

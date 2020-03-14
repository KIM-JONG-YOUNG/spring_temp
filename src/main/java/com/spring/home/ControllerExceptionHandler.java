package com.spring.home;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.javassist.bytecode.SignatureAttribute.ClassType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.bind.annotation.ResponseBody;

public class ControllerExceptionHandler {

	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		//컨트롤러에서 @ResponseBody를 사용했을 경우도 String 리턴
		System.out.println("AOP Strart");
		String result = null;
		try {
			result = (String) joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "cmmn/error";
		}
		System.out.println("AOP End");
		return result;
	}
}

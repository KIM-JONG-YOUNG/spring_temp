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
		String result = null;

		try {
			result = (String) joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "cmmn/error";
		}
		
		return result;
	}
}

package com.zaliczenie.aspects;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConfigureAspect {
	
	@Autowired
	private Validator validator;

	@Pointcut("execution(* com.zaliczenie.service..save(..))")
	public void aaa() {
	}
	
	//@Before("com.zaliczenie.service.ManufacturerService.save()")
	public void bbb(){
		System.out.println("....................BEFORE...............................");
	}
	
	@Around("com.zaliczenie.aspects.ConfigureAspect.aaa()")
	public Object ddd(ProceedingJoinPoint pjp) throws Throwable{
		Set<ConstraintViolation<Object>> bledy = validator.validate(pjp.getArgs()[0]);
		if (bledy.isEmpty())
		{ 
			pjp.proceed();
		}
		return bledy;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	

}

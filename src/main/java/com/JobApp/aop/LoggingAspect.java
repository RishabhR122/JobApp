package com.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class); 
	
	
	//execution(returntype class.method(arguments))    for taking everything use *
	
	@Before("execution(* com.JobApp.services.JobService.*(..))")
	public void logMethodCall(JoinPoint jp) {
		logger.info("Logger Method Called "+jp.getSignature().getName());
	}
	
	@After("execution(* com.JobApp.services.JobService.*(..))")
	public void logMethodExcecuted(JoinPoint jp) {
		logger.info("Logger Method excecuted "+jp.getSignature().getName());
	}
	
	@Around("execution(* com.JobApp.services.JobService.*(..)) && args(id)")
	public Object logMethodExcecuted(ProceedingJoinPoint jp, int id) throws Throwable {
		
		long start=System.currentTimeMillis();
		
		if(id<0) {
			logger.info("id is -ve changing it "+jp.getSignature().getName());
			id=-id;
			logger.info("new id "+id);
		}
		Object obj=jp.proceed(new Object[]{id});
		long end=System.currentTimeMillis();
		logger.info("time taken= "+(end-start)+" ms");
		return obj;
	}

}

package com.exam.track_time.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {


    @Around("@annotation(com.exam.track_time.advice.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("pjp = " + pjp);
        // pjp = execution(List com.exam.track_time.services.ProductService.getProducts())
        System.out.println("Method name "+pjp.getSignature()+" time taken to execute : "+ (endTime - startTime));
        // Method name List com.exam.track_time.services.ProductService.getProducts() time taken to execute : 7
       return obj;
    }
}

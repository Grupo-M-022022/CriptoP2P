package ar.edu.unq.criptop2p.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAdvice {

    Logger log = LoggerFactory.getLogger(LogginAdvice.class);

    @Pointcut("execution(* ar.edu.unq.criptop2p.service.*.*.*(..))")
    public void myPointCut(){

    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] array = joinPoint.getArgs();
        log.info("/////// AROUND START  ar.edu.unq.criptop2p.webservice //////");
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        if (object == null){
            object = "";
        }
        long executionTime = System.currentTimeMillis() - start;
        log.info("/////// " + joinPoint.getSignature() + " executed in " + executionTime + "ms " + object.toString());
        log.info("/////// AROUND FINISH  ar.edu.unq.criptop2p.webservice ///////");
        return object;
    }
}

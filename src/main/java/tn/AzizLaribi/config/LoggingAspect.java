package tn.AzizLaribi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* tn.AzizLaribi.services.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("[AOP - BEFORE] Méthode : " + jp.getSignature());
    }

    @After("serviceMethods()")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("[AOP - AFTER] Méthode terminée : " + jp.getSignature());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningAdvice(JoinPoint jp, Object result) {
        System.out.println("[AOP - AFTER RETURNING] Résultat : " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint jp, Throwable ex) {
        System.out.println("[AOP - AFTER THROWING] Exception : " + ex.getMessage());
    }

    @Around("serviceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AOP - AROUND] Avant : " + pjp.getSignature());

        Object result = pjp.proceed();

        System.out.println("[AOP - AROUND] Après : " + pjp.getSignature());
        return result;
    }
}

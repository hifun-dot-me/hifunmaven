package com.hifun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hifun.bean.TimeEnum;
import com.hifun.util.DateUtil;

@Component
@Aspect
public class AOPAspectTest {

    public AOPAspectTest() {

    }

    @Pointcut("execution(* com.hifun.service.IHeadService.*(..))")
    private void aspectpoint() {
    }

    /**
     * 前置通知
     * @param jp
     */
    @Before("aspectpoint()")
    public void doBefore(JoinPoint jp) {
        // 获取方法名称
        System.out.println("method:" + jp.getSignature().getName() + "   time:"
                + DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()));
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     * @param jp
     */
    @AfterReturning("aspectpoint()")
    public void doAfter(JoinPoint jp) {
        System.out.println("后置通知");
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("aspectpoint()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知 start..");
        try {
            Object obj = pjp.proceed();
            System.out.println("环绕通知 end");
            return obj;
        } catch (Throwable ex) {
            System.out.println("error in 环绕通知");
            throw ex;
        }
    }

    /**
     * 异常通知
     * @param jp
     * @param error
     */
    @AfterThrowing(pointcut = "aspectpoint()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("error:" + error);
    }

}

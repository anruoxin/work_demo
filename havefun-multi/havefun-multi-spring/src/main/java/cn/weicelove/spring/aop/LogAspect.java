package cn.weicelove.spring.aop;

import cn.weicelove.spring.aop.operation.AddMethod;
import cn.weicelove.spring.aop.operation.AddMethodImpl;
import com.alibaba.fastjson.JSON;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

/**
 * @author QIU PANWEI Create in 2019/11/23 15:50
 */
@Aspect
@Component
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(cn.weicelove.spring.aop.Log)")
    public void pointcut() {

    }

    // 声明切点
    @Pointcut("execution(* cn.weicelove.spring.aop.operation..*(..))")
    public void log() {

    }

    // 声明带参
    @Pointcut("execution(* cn.weicelove.spring.aop.operation..*(String)) && args(opt)")
    public void logWithPara(String opt) {

    }

    // 操作之前的日志
    @Before(value = "pointcut() && @annotation(log)")
    public void beforeOptWithAnnotation(JoinPoint point, Log log){
        // 打印当前操作的时间
        logger.info("beforeOptWithAnnotation = {}, Log value= {}, data = {}", System.currentTimeMillis(), log.value(),
                point.getArgs());
    }

    // 带参操作之前
    @Before("logWithPara(opt)")
    public void beforeOptWithPara(String opt) {
        // 打印当前操作的时间
        logger.info("para = {}, beforeOpt = {}", opt, System.currentTimeMillis());
    }

    // 操作之前的日志
    @Before("log()")
    public void beforeOpt(){
        // 打印当前操作的时间
        logger.info("beforeOpt = {}", System.currentTimeMillis());
    }
    // 操作之后的日志
    @AfterReturning("log()")
    public void afterReturningOpt(){
        // 打印当前操作的时间
        logger.info("beforeOpt = {}", System.currentTimeMillis());
    }
    // 操作抛出异常
    @AfterThrowing("log()")
    public void failure(){
        logger.debug("opt failed!!!");
    }

    // 通知环绕
    @Around("log()")
    public Object aroundOpt(ProceedingJoinPoint proceedingJoinPoint){
        try {
            logger.info("before around = {}", System.currentTimeMillis());
            Object proceed = proceedingJoinPoint.proceed();
            logger.info("after around = {}", System.currentTimeMillis());
            return proceed;
        } catch (Throwable throwable) {
            logger.error("invoke failed", throwable);
        }
        return null;
    }

    /**
     *
     * 处理方法上的注解
     * @param point 切点
     * @return void
     * @author QIU PANWEI
     */
    private void dealJoinPoint(ProceedingJoinPoint point) {
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        Method method = methodSignature.getMethod();
        // 获取参数名称
//        new LocalVariableTableParameterNameDiscoverer();
        Log annotation = method.getAnnotation(Log.class);
    }

    // 通过AOP 给特定类添加新的方法
    @DeclareParents(value = "cn.weicelove.spring.aop.operation.AopTest", defaultImpl = AddMethodImpl.class)
    private AddMethod addMethod;
}

package com.phoenixhell.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 *
 * AOP：【动态代理】
 *  		指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式；
 *
 * 定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知Calculator.div运行到哪里然后执行；
 *
 * 通知方法：
 *  	    前置通知(@Before)：logStart：在目标方法(div)运行之前运行
 *  	    后置通知(@After)：logEnd：在目标方法(div)运行结束之后运行（无论方法正常结束还是异常结束）
 *       	返回通知(@AfterReturning)：logReturn：在目标方法(div)正常返回之后运行
 *  		异常通知(@AfterThrowing)：logException：在目标方法(div)出现异常以后运行
 *  		环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.proceed()）
 *
 *  切面类LogAspect 与被切面类 Calculator都需要在容器中
 *  @Aspect   告诉spring容器这是一个切面类
 */

@Aspect
@Component
public class LogAspect {


    /**
     * 抽取公共的切入表达式
     *  1:当前类下引用 ==> @Before("pointCut()")
     *  2:其他的切面类引用 ==> com.phoenixhell.annotation.aop.LogAspect.pointCut()
     *
     * Calculator.div(int,int)    区分参数类型
     * Calculator.div(..)    不区分参数类型
     * Calculator.*(..) 任意参数任意类型
     *
     * 返回值类型 Integer
     * execution(public Integer com.phoenixhell.annotation.aop.Calculator.div(..))
     *
     * 任意返回值类型,任意方法,任意参数
     * execution(* com.phoenixhell.annotation.aop.Calculator.*(..))
     */
    @Pointcut(value="execution(* com.phoenixhell.annotation.aop.Calculator.*(..))")
    public void pointCut(){
    }


    @Before("pointCut()")
    public void  logStart(JoinPoint joinPoint){
        System.out.println("除法开始 参数列表是");
    }

    @After(value = "pointCut()")
    public void logend(JoinPoint joinPoint){
        System.out.println("除法结束 参数列表是:");

    }

    @AfterReturning(value = "pointCut()")
    public void logReturn(){
        System.out.println("正常返回  结果是");
    }

    /**
     * 目标方法 MathCalculator div() 运行之前执行
     * JoinPoint 一定要在参数表的第一位
     */
    /*@Before(value = "point()")
    public void  logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("除法"+name+"开始 参数列表是"+ Arrays.asList(args));
    }

    @AfterReturning(value = "point()",returning ="result")
    public void logReturn(Object result){
        System.out.println("返回 结果是"+result);
    }

    @After(value = "point()")
    public void logend(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("除法"+name+"结束 参数列表是:"+ Arrays.asList(args));

    }
    @AfterThrowing(value = "point()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.print("除法"+name+"异常 参数列表是P:"+ Arrays.asList(args)+" ");
        System.out.println("异常报告:"+exception);
    }*/
}

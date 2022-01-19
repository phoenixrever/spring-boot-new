package com.phoenixhell.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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


    /**
     * @param joinPoint 拿到被代理类的各项信息 (方法名字,参数等)
     */
    @Before("pointCut()")
    public void  logStart(JoinPoint joinPoint){
        //方法名字 div
        String name = joinPoint.getSignature().getName();
        //参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("方法名字:"+name+"  除法开始@Before 参数列表是: "+Arrays.asList(args));
    }

    /**
     * @param joinPoint 拿到被代理类的各项信息 (方法名字,参数等)
     *                  且必须作为第一个参数
     * @param result 封装返回值
     */
    @AfterReturning(value = "pointCut()",returning ="result" )
    public void logReturn(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("方法名:"+name+"除法正常返回@AfterReturning  结果是: "+result);
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("除法@After"+joinPoint.getSignature().getName()+"最终结束");

    }

    /**
     * @param exception  封装返回异常
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法抛出异常:"+exception);
    }
}

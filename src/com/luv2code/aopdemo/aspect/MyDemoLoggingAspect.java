package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDAOPackageNoGeterSetter()") // give fully qualified name if
																						// you want to access pointcut
																						// present in different class
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n==========>>> Executing @Before Advice on addAccount()");

		// display the method signature
		MethodSignature methodsig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodsig);
		// display the method arguments
		// get the arguments
		for (Object arg : theJoinPoint.getArgs()) {
			System.out.println("Argument is: " + arg);

			if (arg instanceof Account) {

				//downcast and print the actual stuff
				
				Account account = (Account) arg;
				
				System.out.println("Account Name is: " + account.getName());
				System.out.println("Account Level is: " + account.getLevel());
			}
		}
	}

}

package org.bmsource.logging;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.hibernate.LazyInitializationException;

@Loggable
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		try {
			System.out.println("before " + ctx.getMethod().getName());
			Object result = ctx.proceed();
			System.out.println("after " + ctx.getMethod().getName());
			return result;
		} catch (LazyInitializationException e) {
			System.out.println("lazy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

package org.bmsource.logging;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor // need to be specified in beans.xml
public class LoggingInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("before " + this.getClass() + " " + ctx.getMethod().getName());
		Object result = ctx.proceed();
		System.out.println("after " + this.getClass() + " " + ctx.getMethod().getName());
		return result;
	}

}

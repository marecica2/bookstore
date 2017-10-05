package org.bmsource.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@RestResource
@Interceptor
// Optional: @Priority(Interceptor.Priority.APPLICATION)
public class RestResourceInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("before " + RestResourceInterceptor.class + " " + ctx.getMethod().getName());
		Object result = ctx.proceed();
		System.out.println("after " + RestResourceInterceptor.class + " " + ctx.getMethod().getName());
		return result;
	}
}

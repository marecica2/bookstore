package org.bmsource.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.hibernate.LazyInitializationException;

@RestResource
@Interceptor
// Optional: @Priority(Interceptor.Priority.APPLICATION)
public class RestResourceInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		try {
			System.out.println("before " + RestResourceInterceptor.class + " " + ctx.getMethod().getName());
			Object result = ctx.proceed();
			System.out.println("after " + RestResourceInterceptor.class + " " + ctx.getMethod().getName());
			return result;
		} catch (LazyInitializationException e) {
			System.out.println("lazy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

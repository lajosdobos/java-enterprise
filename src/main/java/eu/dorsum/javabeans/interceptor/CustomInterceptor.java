package eu.dorsum.javabeans.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import eu.dorsum.javabeans.reflection.Address;

public class CustomInterceptor {
	
	private static final  Logger LOGGER = Logger.getLogger(CustomInterceptor.class.getName());
	
	@PostConstruct
	public Object postConstruct(InvocationContext context) throws Exception {
		LOGGER.setLevel(Level.WARNING);
		Address address = null;
		LOGGER.info("Address: " + address.getCity());
		System.out.println("POSTCONSTRUCT " + context.getMethod() + ", " + context.getTarget().toString());
		return context.proceed();
	}
	
	@AroundInvoke
	public Object logCall(InvocationContext context) throws Exception {
		System.out.println("AROUND INVOKE " + context.getMethod() + ", " + context.getTarget().toString());
		return context.proceed();
	}
	
	@PreDestroy
	public Object preDestroy(InvocationContext context) throws Exception {
		System.out.println("PREDESTROY " + context.getMethod() + ", " + context.getTarget().toString());
		return context.proceed();
	}	
	
}

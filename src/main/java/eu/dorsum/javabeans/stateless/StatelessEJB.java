package eu.dorsum.javabeans.stateless;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import eu.dorsum.javabeans.interceptor.CustomInterceptor;

@Interceptors(CustomInterceptor.class)
@Stateless
public class StatelessEJB {

	public String name;

}


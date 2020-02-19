package eu.dorsum.javabeans.stateful;

import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import eu.dorsum.javabeans.interceptor.CustomInterceptor;

@Interceptors(CustomInterceptor.class)
@Stateful
public class StatefulEJB {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StatefulEJB [name=" + name + "]";
	}

}

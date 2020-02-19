package eu.dorsum.javabeans.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;

import eu.dorsum.javabeans.interceptor.CustomInterceptor;

@Interceptors(CustomInterceptor.class)
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CountryStateContainerManagedBean  {
    
	Map<String, List<String>> countryStatesMap;
	
	@PostConstruct
	public void initialize() {
	 
		countryStatesMap = new HashMap<>();
		
	    List<String> states = new ArrayList<>();
	    states.add("Texas");
	    states.add("Alabama");
	    states.add("Alaska");
	    states.add("Arizona");
	    states.add("Arkansas");
	 
	    countryStatesMap.put("UnitedStates", states);
	}

	@Lock(LockType.READ)
	public List<String> getStates(String country) {
		return countryStatesMap.get(country);
	}

	@Lock(LockType.WRITE)
	public synchronized void setStates(String country, List<String> states) {
	    countryStatesMap.put(country, states);
	}
	
}


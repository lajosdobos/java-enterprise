package eu.dorsum.javabeans.singleton;

import javax.ejb.EJB;

public class SingletonEJBClient {

	@EJB
	public CountryStateContainerManagedBean countryStateContainerManagedBean;

}

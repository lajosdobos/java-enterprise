package eu.dorsum.javabeans.singleton;


import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SingletonEJBTest {

	@Inject
	private SingletonEJBClient singletonEJBClient;
	
	@Test
	public void whenCallGetStatesFromContainerManagedBean_ReturnsStatesForCountry() throws Exception {
		
		String country = "UnitedStates";
		String[] expectedStates = {"Texas", "Alabama", "Alaska", "Arizona", "Arkansas"};
		List<String> actualStates = singletonEJBClient.countryStateContainerManagedBean.getStates(country);
		Assert.assertNotNull(actualStates);
		Assert.assertArrayEquals(actualStates.toArray(), expectedStates);
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(CountryStateContainerManagedBean.class)
				.addClass(SingletonEJBClient.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
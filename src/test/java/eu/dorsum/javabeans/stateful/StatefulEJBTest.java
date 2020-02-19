package eu.dorsum.javabeans.stateful;

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
public class StatefulEJBTest {

	@Inject
	private EJBClient1 ejbClient1;

	@Inject
	private EJBClient2 ejbClient2;

	@Test
	public void givenOneStatefulBean_whenTwoClientsSetValueOnBean_thenClientStateIsMaintained() {

		ejbClient1.statefulEJB.setName("Client 1");
		ejbClient2.statefulEJB.setName("Client 2");
		Assert.assertNotEquals(ejbClient1.statefulEJB.getName(), ejbClient2.statefulEJB.getName());
		Assert.assertEquals("Client 1", ejbClient1.statefulEJB.getName());
		Assert.assertEquals("Client 2", ejbClient2.statefulEJB.getName());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(StatefulEJB.class).addClass(EJBClient1.class)
				.addClass(EJBClient2.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
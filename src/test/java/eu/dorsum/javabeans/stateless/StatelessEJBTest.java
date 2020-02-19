package eu.dorsum.javabeans.stateless;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class StatelessEJBTest {

	private static final  Logger LOGGER = Logger.getLogger(StatelessEJBTest.class.getName());
	
	@Inject
	private EJBClient1 ejbClient1;

	@Inject
	private EJBClient2 ejbClient2;

	@BeforeClass
	public static void start() {
		LOGGER.info("starting junit tests...");
	}
	
	@AfterClass
	public static void finish() {
		LOGGER.info("finishing junit tests.");
	}
	
	@Test
	public void givenOneStatelessBean_whenStateIsSetInOneBean_secondBeanShouldHaveSameState() {
		// act
		ejbClient1.statelessEJB.name = "Client 1";

		// assert
		Assert.assertEquals("Client 1", ejbClient1.statelessEJB.name);
		Assert.assertEquals("Client 1", ejbClient2.statelessEJB.name);
	}

	@Test
	public void givenOneStatelessBean_whenStateIsSetInBothBeans_secondBeanShouldHaveSecondBeanState() {

		// act
		ejbClient1.statelessEJB.name = "Client 1";
		ejbClient2.statelessEJB.name = "Client 2";

		// assert
		Assert.assertEquals("Testing ejbClient1 stateless ejb name", "Client 2", ejbClient1.statelessEJB.name);
		Assert.assertEquals("Testing ejbClient2 stateless ejb name", "Client 2", ejbClient2.statelessEJB.name);

	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(StatelessEJB.class).addClass(EJBClient1.class)
				.addClass(EJBClient2.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
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

import eu.dorsum.javabeans.stateful.Bank;
import eu.dorsum.javabeans.stateful.BankClient1;
import eu.dorsum.javabeans.stateful.BankClient2;

@RunWith(Arquillian.class)
public class StatefulBankEJBTest {

	@Inject
	private BankClient1 bankClient1;

	@Inject
	private BankClient2 bankClient2;

	@Test
	public void givenOneStatefulBean_() {

		bankClient1.bank.deposit(10000);
		bankClient1.bank.withdraw(5000);
		Assert.assertEquals(5000, bankClient1.bank.getBalance());
		Assert.assertEquals(0, bankClient2.bank.getBalance());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Bank.class).addClass(BankClient1.class)
				.addClass(BankClient2.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
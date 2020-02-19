package eu.dorsum.javabeans.stateful;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Local
@Remote
@Stateful
public class Bank {
	
	private int amount = 0;

	public boolean withdraw(int amount) {
		if (amount <= this.amount) {
			this.amount -= amount;
			return true;
		} else {
			return false;
		}
	}

	public void deposit(int amount) {
		this.amount += amount;
	}

	public int getBalance() {
		return amount;
	}
	
}

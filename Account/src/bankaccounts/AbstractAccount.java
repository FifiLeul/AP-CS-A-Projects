/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

public abstract class AbstractAccount implements Account{

	protected double balance;
	
	public AbstractAccount(double balance)
	{
		this.balance = Math.round(balance*100.0)/100.0;
	}
	
	public AbstractAccount()
	{
		this(0);
	}

	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}

	
	public final double getBalance() {
		return Math.round(balance*100.0)/100.0;
		
	}
}


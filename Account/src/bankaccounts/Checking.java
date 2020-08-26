/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

public class Checking extends AbstractAccount
{
	
	public Checking(double balance)
	{
            super(balance);
	}
	
	@Override
	public String toString()
	{
            return "*****************************\n Checking \n*****************************\nTotal Balance: " + getBalance();
	}
}



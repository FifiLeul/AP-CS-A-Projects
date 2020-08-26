/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

public class Credit extends AbstractAccount 
{
	private double creditLine;
	private double annualRate;
	private int numBillingDays;
	
	public Credit(double creditLine, double annualRate)
	{
            this.creditLine = creditLine;
            this.annualRate = annualRate;
	}
	
	public void setCreditLine(double creditLine)
	{
		this.creditLine = creditLine;
	}
	
	public String getCreditLine()
	{
		return String.format("%.2f", creditLine);
	}
	
	@Override
	public void deposit(double deposit)
	{
            //balance is positive, but printed as negative because you owe
		this.balance -= deposit;
	}
	
	@Override
	public void withdraw(double withdraw)
	{
		this.balance += withdraw;
                // makes sure you can't go beyond credLine
		if(balance > creditLine)
                    balance -= withdraw;		
	}
        
	public void nextMonth()
	{
                //makes sure you are in debt, point of credit account
		if(balance != 0)
		{
			for(int i = 0; i < numBillingDays; i++)
			{
				balance += annualRate/365 * balance;
			}

		}
	}

	public void nextMonths(int months)
	{
		nextMonth();
		int numBillingDays0 = numBillingDays;
		numBillingDays = 30;

		for(int i = 1; i <= months - 1; i++)
		{
			nextMonth();
		}
		
		numBillingDays = numBillingDays0;

		
	}
	
	
	public void setNumBillingDays(int days)
	{
		numBillingDays = days;
	}
	

	@Override
	public String toString()
	{
		return "*****************************\n Credit \n*****************************\nTotal Balance (money owed): " + -1* getBalance() + "\nTotal Credit Line:"
                        + ": " + getCreditLine();
	}

}


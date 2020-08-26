/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

/**
 *
 * @author mercyougothis
 */
public class Savings extends AbstractAccount
{
    private double rate;
	private int numsCompoundedYearly;
	private int year = 0;
	private double intEarned = 0;
	private double[] balanceRecord = new double[1000];
	private double[] interestRecord = new double[1000];
	
	public Savings(double balance, double rate, int numsCompoundedYearly)
	{
		super(balance);
		this.rate = rate;
		this.numsCompoundedYearly = numsCompoundedYearly;
		balanceRecord[0] = balance;
		interestRecord[0] = 0;
	}
	
	public Savings(double balance, double rate)
	{
		super(balance);
		this.rate = rate;
		this.numsCompoundedYearly = 1;
		balanceRecord[0] = balance;
		interestRecord[0] = 0;
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public double getYear()
	{
		return year;
	}
	
	public int getNumsCompoundedYearly()
	{
		return numsCompoundedYearly;
	}
	
	public double nextYear()
	{
		double increase = 1 + rate/(numsCompoundedYearly*100);
		
		double principalYearly = balance; // balance at the start of the year
		balance *= Math.pow(increase, numsCompoundedYearly)/*raises it to the pwoer of the rate/times*/;
		intEarned += balance - principalYearly;
		
		balanceRecord[year + 1] = this.getBalance(); // saving term + 1 because initial balance was [0] in constructor
		interestRecord[year] = this.getIntEarned();
		return this.getBalance();
	}
	
	public String intEarned()
	{
		return String.format("%.2f", intEarned);
	}
        public double getIntEarned()
        {
            return Double.parseDouble(intEarned());
        }
	
	public String getInterestPlan()
	{
                String header = String.format("%12s%12s%20s\n", "Year", "Balance", "Interest Raised");
		String str = "";
		for(int i = 0; i <= year; i++)
		{
			
			str +=  String.format("%12s%15.2f%10.2s\n", i+1, balanceRecord[i], intEarned());
		}
		
		return header + str;
	}
	
	@Override
	public String toString()
	{
		return "*****************************\n Savings \n*****************************\nTotal Balance: " + getBalance() + "\nTotal Interest Raised"
                        + ": " + intEarned();
	}

	
}

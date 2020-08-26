/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author mercyougothis
 */
public class CreditAccount extends BankAccount
{
    protected double rate;
    protected double credLine = -1;
    protected InterestTransaction InterestTransaction;
    protected double budget;
    public CreditAccount(double rate)
    {
        super();
        this.rate = rate;        
    }
     public CreditAccount(double principal, double rate, int years, int compoundedNumsYearly)
    {
        this(rate);
        this.InterestTransaction = new InterestTransaction(principal, rate, years, compoundedNumsYearly);
        this.credLine = InterestTransaction.getTotalOwed();
        budget = credLine;
    }
    public double getIntRate()
    {
        return rate;
    }
    public double getCredLine()
    {
         return credLine;
    }
    public String getTransactionDetails()
    {
        return InterestTransaction.toString();
    }
    @Override
    public void withdraw(double amount)
    {
        if(budget > 0)
            budget -= amount; 
    }
    @Override
    public double getBalance()
    {
        return (-1 * getOwed());
    }
    public double getOwed()
    {
        return InterestTransaction.getOwedNow();
    }
    public double getTotalOwed()
    {
        return InterestTransaction.getTotalOwed();
    }
    //setters
    public void setIntRate(double intRate)
    {
        this.rate = intRate;
    }
    public void setCredLine(double credLine)
    {
        this.credLine = credLine;
    }
     public double getCredLine(double credLine)
    {
        return credLine;
    }

    public String toString()
    {
        return "\n---------------------------------\nCredit Account: \n---------------------------------\n" + "Credit Line: $" + String.format("%.2f", getCredLine())+ "\n"+InterestTransaction.toString();
    }
    
}

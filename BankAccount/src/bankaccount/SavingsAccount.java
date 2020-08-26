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
public class SavingsAccount extends BankAccount
{
   private double rate;
   private double savings;
   private InterestTransaction InterestTransaction;
   
   public SavingsAccount(double rate)
   {
       super();
       this.rate = rate;
   }
   public SavingsAccount(double principal, double rate, int years, int compoundedNumsYearly)
   {
       this(rate);
       this.InterestTransaction = new InterestTransaction(principal, rate, years, compoundedNumsYearly);
       savings = totalProfit();
   }
   
   @Override
    public double getBalance()
    {
        return (amountMade());
    }
    public double amountMade()
    {
        return InterestTransaction.getOwedNow();
    }
    public double totalProfit()
    {
        return InterestTransaction.getTotalOwed();
    }
   @Override
    public void withdraw(double amount)
    {
        if(amount <= savings)
        {
            savings -= amount;
        }
        else
            throw new IllegalArgumentException("You can't spend more than you have");
    }
   @Override
    public void deposit(double amount)
    {
        savings += amount;
    }
   @Override
    public String toString()
    {
        return "\n---------------------------------\nSavings Account: \n---------------------------------\n" +InterestTransaction.toString();
    }
}

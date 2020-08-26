/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.util.*;

/**
 *
 * @author mercyougothis
 */
public class CheckingAccount extends BankAccount
{
    private double savings;
    private String deposited;
    private String withdrawn;
    
    public CheckingAccount()
    {
        this(0);
        deposited = "";
        withdrawn = " ";
    }
    public CheckingAccount(double savings)
    {
        this.savings = savings;
    }
    public double getSavings()
    {
        return savings;
    }
    @Override
    public void withdraw(double amount)
    {
        if(amount <= savings && amount > 0)
        {
            savings -= amount;
            withdrawn += "$" + amount + ", ";
        }
        else
            throw new IllegalArgumentException("You can't spend more than you have, and you can't withdraw - dollars");
    }
    @Override
    public void deposit(double amount)
    {
        savings += amount;
        deposited += "$" + amount + ", ";
    }

    public String getWithdrawals()
    {
        return withdrawn.replace("null", "");
    }
    public String getDeposits()
    {
        return deposited.replace("null", "");
    }
    
    @Override
    public String toString()
    {
        return "\n---------------------------------\nCredit Account: \n---------------------------------\n" +
                "Savings: "+ getSavings() + "\nWithdrawals: " + getWithdrawals() + "\nDeposits: " + getDeposits();
    }
}

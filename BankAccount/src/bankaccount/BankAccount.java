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
public abstract class BankAccount implements Account
{  
    private double balance;
    public void deposit(double deposit)
    {
        balance += deposit;
    }
    public void withdraw(double withdrawal)
    {
        balance -= withdrawal;
    }
    public double getBalance()
    {
        return balance;
    }
}

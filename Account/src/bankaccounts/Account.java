/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

public interface Account 
{	
    public void deposit(double depositAmount);
    public void withdraw(double withdrawAmount);
    public double getBalance();
    public abstract String toString();
}


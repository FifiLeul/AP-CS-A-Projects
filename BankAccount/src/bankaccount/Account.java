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
public interface Account
{
    public void deposit(double deposit);
    public void withdraw(double withdrawal);
    public double getBalance();
}

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
public class Tester 
{
    public static void main(String[] args)
    {
        CheckingAccount checking = new CheckingAccount(100);
        
        checking.withdraw(20);
        checking.withdraw(50);
        System.out.println("Withdrawals: " + checking.getWithdrawals());
        checking.deposit(20);
        checking.deposit(50);
        System.out.println("Deposits: " + checking.getDeposits());
        System.out.println(checking.toString());
        
        CreditAccount credit = new CreditAccount(5000, .05, 10,12);        
        System.out.println(credit.toString());
        
        SavingsAccount savings = new SavingsAccount(5000, .05, 10,12);
        System.out.println(savings.toString());
        
    }
}
